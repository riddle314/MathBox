package com.dimitriskatsikas.mathtools;


import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.dimitriskatsikas.mathtools.data.AboutContentProvider;
import com.dimitriskatsikas.mathtools.data.ContentDB;

public class AboutActivity extends ActionBarActivity implements LoaderManager.LoaderCallbacks<Cursor> {

	private static final int AboutContents = 0;
	private SimpleCursorAdapter adapter;
    private ListView mListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);

		TextView link1 = (TextView) findViewById(R.id.textView2);
	    String createdByLink1 = getString(R.string.createdby)+" <a href='http://www.linkedin.com/in/dimitriskatsikas'>Dimitris Katsikas</a>";
	    link1.setText(Html.fromHtml(createdByLink1));
	    link1.setMovementMethod(LinkMovementMethod.getInstance());
        TextView link2 = (TextView) findViewById(R.id.businessView);
        String createdByLink2 = " <a href='http://www.yellowden.com'>Yellowden.com</a>";
        link2.setText(Html.fromHtml(createdByLink2));
        link2.setMovementMethod(LinkMovementMethod.getInstance());

        mListView= (ListView) findViewById(R.id.listView);

		String[] uiBindFrom = new String[] { ContentDB.KEY_DATA };
		int[] uiBindTo = new int[] { R.id.textView};

		getLoaderManager().initLoader(AboutContents, null, this);

        adapter = new SimpleCursorAdapter(
				this, R.layout.list_item_about,
				null, uiBindFrom,
				uiBindTo, 0);

        mListView.setAdapter(adapter);
		mListView.setFocusable(false);
        mListView.setSelector(android.R.color.transparent);

    }

	@Override
	public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {

		return new CursorLoader(AboutActivity.this,
				AboutContentProvider.CONTENT_URI,
                null,
				null,
				null,
				null);
	}

	@Override
	public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
		adapter.swapCursor(cursor);

	}

	@Override
	public void onLoaderReset(Loader<Cursor> cursorLoader){adapter.swapCursor(null);
	}

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.about, menu);
		return true;
	}*/

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()) {
	    // Respond to the action bar's Up/Home button
	    case android.R.id.home:
	    	onBackPressed();
	        return true;
	
	    default:
	return super.onOptionsItemSelected(item);}
	}
}

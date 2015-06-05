package com.dimitriskatsikas.mathtools;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;

public class VolumesSurfaces extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_volumes_surfaces);
	}
	
	public void TwoDimensionalClick(View v){
		Intent i= new Intent(VolumesSurfaces.this,TwoDimensionalShapesActivity.class);
	    startActivity(i);}
	
	public void ThreeDimensionalClick(View v){
		Intent i= new Intent(VolumesSurfaces.this,ThreeDimensionalShapesActivity.class);
	    startActivity(i);}

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.volumes_surfaces, menu);
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

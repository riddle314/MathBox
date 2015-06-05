package com.dimitriskatsikas.mathtools;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;

import com.i4da.easylvl.EasyLicenseChecker;


public class MainActivity extends ActionBarActivity {

    private EasyLicenseChecker mLicenseChecker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar ab = getSupportActionBar();
        ab.setHomeButtonEnabled(true);
        ab.setDisplayShowHomeEnabled(true);
        ab.setDisplayUseLogoEnabled(true);
        ab.setLogo(R.drawable.logo);
        ab.setDisplayShowTitleEnabled(false);
        //mLicenseChecker = new EasyLicenseChecker(this, new Handler());
        //mLicenseChecker.start();
        
    }

   // @Override
    //protected void onDestroy() {
     //   super.onDestroy();
      //  if (mLicenseChecker != null) mLicenseChecker.finish();
    //}

    public void FactorialClick(View v){
		Intent i= new Intent(MainActivity.this,FactorialsCombinationsActivity.class);
	    startActivity(i);}
    public void VolumeClick(View v){
		Intent i= new Intent(MainActivity.this,VolumesSurfaces.class);
	    startActivity(i);}
    public void NumbersClick(View v){
		Intent i= new Intent(MainActivity.this,NumbersActivity.class);
	    startActivity(i);}
    public void AboutClick(View v){
		Intent i= new Intent(MainActivity.this,AboutActivity.class);
	    startActivity(i);}


    //@Override
    /*public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
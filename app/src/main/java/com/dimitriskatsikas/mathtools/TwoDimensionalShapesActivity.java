package com.dimitriskatsikas.mathtools;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;

public class TwoDimensionalShapesActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two_dimensional_shapes);
	}


	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.two_dimensional_shapes, menu);
		return true;
	}*/
	
   String shareBody1="";
	
	public void calculate1 (View v){
	EditText rRead=(EditText)findViewById(R.id.editCircle1);
	TextView writeResult=(TextView)findViewById(R.id.textCircle5);
	if( !rRead.getText().toString().equals("")){
	 
	BigDecimal r=new BigDecimal(rRead.getText().toString());
	BigDecimal pi=new BigDecimal(Math.PI);
	BigDecimal num2=new BigDecimal(2);
	BigDecimal k=r.multiply(pi); 
	BigDecimal circumference= k.multiply(num2);
	BigDecimal area=k.multiply(r);
	String l="Circumference = "+circumference+"\n\nArea = "+area;
	writeResult.setText(l);
	shareBody1=l;
	 
	 } 
    else{
		writeResult.setText("");
		shareBody1="";
	}
	}
	
	public void share1(View v){
        TextView writeResult=(TextView)findViewById(R.id.textCircle5);
        if((!writeResult.getText().toString().equals(""))&&(shareBody1.equals(""))){
            shareBody1=writeResult.getText().toString();
        }
    	Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND); 
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Circle:");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody1);
    startActivity(Intent.createChooser(sharingIntent, "Share these numbers..."));	
    }

    String shareBody2="";
	
	public void calculate2 (View v){
	EditText uRead=(EditText)findViewById(R.id.editSector1);
	EditText rRead=(EditText)findViewById(R.id.editSector2);
	TextView writeResult=(TextView)findViewById(R.id.textSector5);
	if( !uRead.getText().toString().equals("")&& !rRead.getText().toString().equals(""))
	{
	BigDecimal u=new BigDecimal(uRead.getText().toString());
	BigDecimal r=new BigDecimal(rRead.getText().toString());
	BigDecimal half=new BigDecimal(0.5);
	BigDecimal length=u.multiply(r); 
	BigDecimal area= length.multiply(r);
	area= area.multiply(half);
	String l="Arc length = "+length+"\n\nArea = "+area;
	writeResult.setText(l);
	shareBody2=l;
	 } 
    else{
		writeResult.setText("");
		shareBody2="";
	}
	}
	
	public void share2(View v){
        TextView writeResult=(TextView)findViewById(R.id.textSector5);
        if((!writeResult.getText().toString().equals(""))&&(shareBody2.equals(""))){
            shareBody2=writeResult.getText().toString();
        }
    	Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND); 
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Sector:");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody2);
    startActivity(Intent.createChooser(sharingIntent, "Share this number..."));	
    }
	
String shareBody3="";
	
	public void calculate3 (View v){
	EditText aRead=(EditText)findViewById(R.id.editEllipse1);
	EditText bRead=(EditText)findViewById(R.id.editEllipse2);
	TextView writeResult=(TextView)findViewById(R.id.textEllipse5);
	if( !aRead.getText().toString().equals("")&& !bRead.getText().toString().equals(""))
	{
	BigDecimal a=new BigDecimal(aRead.getText().toString());
	BigDecimal b=new BigDecimal(bRead.getText().toString());
	BigDecimal pi=new BigDecimal(Math.PI);
	BigDecimal area=a.multiply(b); 
	area= area.multiply(pi);
	String l="Area = "+area;
	writeResult.setText(l);
	shareBody3=l;
	 } 
    else{
		writeResult.setText("");
		shareBody3="";
	}
	}
	
	public void share3(View v){
        TextView writeResult=(TextView)findViewById(R.id.textEllipse5);
        if((!writeResult.getText().toString().equals(""))&&(shareBody3.equals(""))){
            shareBody3=writeResult.getText().toString();
        }
    	Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND); 
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Ellipse:");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody3);
    startActivity(Intent.createChooser(sharingIntent, "Share this number..."));	
    }
	
String shareBody4="";
	
	public void calculate4 (View v){
	EditText bRead=(EditText)findViewById(R.id.editTriangle1);
	EditText hRead=(EditText)findViewById(R.id.editTriangle2);
	TextView writeResult=(TextView)findViewById(R.id.textTriangle4);
	if( !bRead.getText().toString().equals("") && !hRead.getText().toString().equals(""))
	{
	BigDecimal b=new BigDecimal(bRead.getText().toString());
	BigDecimal h=new BigDecimal(hRead.getText().toString());
	BigDecimal half=new BigDecimal(0.5);
	BigDecimal area=b.multiply(h); 
	area= area.multiply(half);
	String l="Area = "+area;
	writeResult.setText(l);
	shareBody4=l;
	 } 
    else{
		writeResult.setText("");
		shareBody4="";
	}
	}
	
	public void share4(View v){
        TextView writeResult=(TextView)findViewById(R.id.textTriangle4);
        if((!writeResult.getText().toString().equals(""))&&(shareBody4.equals(""))){
            shareBody4=writeResult.getText().toString();
        }
    	Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND); 
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Triangle:");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody4);
    startActivity(Intent.createChooser(sharingIntent, "Share this number..."));	
    }
	
String shareBody5="";
	
	public void calculate5 (View v){
	EditText aRead=(EditText)findViewById(R.id.editSquare1);
	TextView writeResult=(TextView)findViewById(R.id.textSquare4);
	if( !aRead.getText().toString().equals(""))
	{
	BigDecimal a=new BigDecimal(aRead.getText().toString());
	BigDecimal area=a.multiply(a); 
	String l="Area = "+area;
	writeResult.setText(l);
	shareBody5=l;
	 } 
    else{
		writeResult.setText("");
		shareBody5="";
	}
	}
	
	public void share5(View v){
        TextView writeResult=(TextView)findViewById(R.id.textSquare4);
        if((!writeResult.getText().toString().equals(""))&&(shareBody5.equals(""))){
            shareBody5=writeResult.getText().toString();
        }
    	Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND); 
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Square:");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody5);
    startActivity(Intent.createChooser(sharingIntent, "Share this number..."));	
    }
	
String shareBody6="";
	
	public void calculate6 (View v){
	EditText wRead=(EditText)findViewById(R.id.editRectangle1);
	EditText hRead=(EditText)findViewById(R.id.editRectangle2);
	TextView writeResult=(TextView)findViewById(R.id.textRectangle4);
	if( !wRead.getText().toString().equals("") && !hRead.getText().toString().equals(""))
	{
	BigDecimal w=new BigDecimal(wRead.getText().toString());
	BigDecimal h=new BigDecimal(hRead.getText().toString());
	BigDecimal area=w.multiply(h); 
	String l="Area = "+area;
	writeResult.setText(l);
	shareBody6=l;
	 } 
    else{
		writeResult.setText("");
		shareBody6="";
	}
	}
	
	public void share6(View v){
        TextView writeResult=(TextView)findViewById(R.id.textRectangle4);
        if((!writeResult.getText().toString().equals(""))&&(shareBody6.equals(""))){
            shareBody6=writeResult.getText().toString();
        }
    	Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND); 
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Rectangle:");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody6);
    startActivity(Intent.createChooser(sharingIntent, "Share this number..."));	
    }
	
String shareBody7="";
	
	public void calculate7 (View v){
	EditText bRead=(EditText)findViewById(R.id.editParallelogram1);
	EditText hRead=(EditText)findViewById(R.id.editParallelogram2);
	TextView writeResult=(TextView)findViewById(R.id.textParallelogram4);
	if( !bRead.getText().toString().equals("") && !hRead.getText().toString().equals(""))
	{
	BigDecimal b=new BigDecimal(bRead.getText().toString());
	BigDecimal h=new BigDecimal(hRead.getText().toString());
	BigDecimal area=b.multiply(h); 
	String l="Area = "+area;
	writeResult.setText(l);
	shareBody7=l;
	 } 
    else{
		writeResult.setText("");
		shareBody7="";
	}
	}
	
	public void share7(View v){
        TextView writeResult=(TextView)findViewById(R.id.textParallelogram4);
        if((!writeResult.getText().toString().equals(""))&&(shareBody7.equals(""))){
            shareBody7=writeResult.getText().toString();
        }
    	Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND); 
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Parallelogram:");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody7);
    startActivity(Intent.createChooser(sharingIntent, "Share this number..."));	
    }
	
String shareBody8="";
	
	public void calculate8 (View v){
    EditText aRead=(EditText)findViewById(R.id.editTrapezoid1);
	EditText bRead=(EditText)findViewById(R.id.editTrapezoid2);
	EditText hRead=(EditText)findViewById(R.id.editTrapezoid3);
	TextView writeResult=(TextView)findViewById(R.id.textTrapezoid5);
	if( !aRead.getText().toString().equals("") && !bRead.getText().toString().equals("") && !hRead.getText().toString().equals(""))
	{
    BigDecimal a=new BigDecimal(aRead.getText().toString());
	BigDecimal b=new BigDecimal(bRead.getText().toString());
	BigDecimal h=new BigDecimal(hRead.getText().toString());
	BigDecimal half=new BigDecimal(0.5);
	BigDecimal area=a.add(b);
	area=area.multiply(h);
	area=area.multiply(half);
	String l="Area = "+area;
	writeResult.setText(l);
	shareBody8=l;
	 } 
    else{
		writeResult.setText("");
		shareBody8="";
	}
	}
	
	public void share8(View v){
        TextView writeResult=(TextView)findViewById(R.id.textTrapezoid5);
        if((!writeResult.getText().toString().equals(""))&&(shareBody8.equals(""))){
            shareBody8=writeResult.getText().toString();
        }
    	Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND); 
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Trapezoid:");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody8);
    startActivity(Intent.createChooser(sharingIntent, "Share this number..."));	
    }
	
String shareBody9="";
	
	public void calculate9 (View v){
	EditText uRead=(EditText)findViewById(R.id.editConvert1);
	TextView writeResult=(TextView)findViewById(R.id.resultConvert1);
	if( !uRead.getText().toString().equals(""))
	{
	BigDecimal u=new BigDecimal(uRead.getText().toString());
	double b=180/(Math.PI);
	BigDecimal n=new BigDecimal(b);
	BigDecimal degrees=n.multiply(u); 
	String l=u+" radians = "+degrees+" degrees";
	writeResult.setText(l);
	shareBody9=l;
	 } 
    else{
		writeResult.setText("");
		shareBody9="";
	}
	}
	
	public void share9(View v){
        TextView writeResult=(TextView)findViewById(R.id.resultConvert1);
        if((!writeResult.getText().toString().equals(""))&&(shareBody9.equals(""))){
            shareBody9=writeResult.getText().toString();
        }
    	Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND); 
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Radians to Degrees:");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody9);
    startActivity(Intent.createChooser(sharingIntent, "Share this number..."));	
    }
	
String shareBody10="";
	
	public void calculate10 (View v){
	EditText uRead=(EditText)findViewById(R.id.editConvert2);
	TextView writeResult=(TextView)findViewById(R.id.resultConvert2);
	if( !uRead.getText().toString().equals(""))
	{
	BigDecimal u=new BigDecimal(uRead.getText().toString());
	double b=(Math.PI)/180;
	BigDecimal n=new BigDecimal(b);
	BigDecimal radians=n.multiply(u); 
	String l=u+" degrees = "+radians+" radians";
	writeResult.setText(l);
	shareBody10=l;
	 } 
    else{
		writeResult.setText("");
		shareBody10="";
	}
	}
	
	public void share10(View v){
        TextView writeResult=(TextView)findViewById(R.id.resultConvert2);
        if((!writeResult.getText().toString().equals(""))&&(shareBody10.equals(""))){
            shareBody10=writeResult.getText().toString();
        }
    	Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND); 
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Degrees to Radians:");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody10);
    startActivity(Intent.createChooser(sharingIntent, "Share this number..."));	
    }

    public void moreButtonClick1(View v){
        String url = "http://en.wikipedia.org/wiki/Circle";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);}

    public void moreButtonClick2(View v){
        String url = "http://en.wikipedia.org/wiki/Angle";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);}

    public void moreButtonClick3(View v){
        String url = "http://en.wikipedia.org/wiki/Circular_sector";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);}

    public void moreButtonClick4(View v){
        String url = "http://en.wikipedia.org/wiki/Ellipse";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);}

    public void moreButtonClick5(View v){
        String url = "http://en.wikipedia.org/wiki/Triangle";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);}

    public void moreButtonClick6(View v){
        String url = "http://en.wikipedia.org/wiki/Square";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);}

    public void moreButtonClick7(View v){
        String url = "http://en.wikipedia.org/wiki/Rectangle";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);}

    public void moreButtonClick8(View v){
        String url = "http://en.wikipedia.org/wiki/Parallelogram";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);}

    public void moreButtonClick9(View v){
        String url = "http://en.wikipedia.org/wiki/Trapezoid";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);}
	
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
	//int id = item.getItemId();
	//if (id == R.id.action_settings) {
	//	return true;
	    default:
	return super.onOptionsItemSelected(item);}
	}
}

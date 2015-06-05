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

public class ThreeDimensionalShapesActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_three_dimensional_shapes);
	}


    String shareBody1="";
    public void calculate1 (View v){
        EditText rRead=(EditText)findViewById(R.id.editSphere1);
        TextView writeResult=(TextView)findViewById(R.id.textSphere5);
        if( !rRead.getText().toString().equals("")){

            BigDecimal r=new BigDecimal(rRead.getText().toString());
            BigDecimal pi=new BigDecimal(Math.PI);
            BigDecimal num4=new BigDecimal(4);
            BigDecimal k=new BigDecimal(4.0/3.0);
            BigDecimal x=r.multiply(pi);
            x= x.multiply(r);
            BigDecimal surface=x.multiply(num4);
            BigDecimal volume=x.multiply(r);
            volume = volume.multiply(k);
            String l="Surface Area = "+surface+"\n\nVolume = "+volume;
            writeResult.setText(l);
            shareBody1=l;

        }
        else{
            writeResult.setText("");
            shareBody1="";
        }
    }

    public void share1(View v){
        TextView writeResult=(TextView)findViewById(R.id.textSphere5);
        if((!writeResult.getText().toString().equals(""))&&(shareBody1.equals(""))){
            shareBody1=writeResult.getText().toString();
        }
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Sphere:");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody1);
        startActivity(Intent.createChooser(sharingIntent, "Share these numbers..."));
    }

    String shareBody2="";
    public void calculate2 (View v){
        EditText rRead=(EditText)findViewById(R.id.editTorus1);
        EditText r2Read=(EditText)findViewById(R.id.editTorus2);
        TextView writeResult=(TextView)findViewById(R.id.textTorus6);
        if( !rRead.getText().toString().equals("") && !r2Read.getText().toString().equals("")){

            BigDecimal r=new BigDecimal(rRead.getText().toString());
            BigDecimal r2=new BigDecimal(r2Read.getText().toString());
            BigDecimal pi=new BigDecimal(Math.PI);
            BigDecimal num4=new BigDecimal(4);
            BigDecimal num2=new BigDecimal(2);
            BigDecimal x=pi.multiply(pi);
            x= x.multiply(r);
            x= x.multiply(r2);
            BigDecimal surface=x.multiply(num4);
            BigDecimal volume=x.multiply(r2);
            volume = volume.multiply(num2);
            String l="Surface Area = "+surface+"\n\nVolume = "+volume;
            writeResult.setText(l);
            shareBody2=l;

        }
        else{
            writeResult.setText("");
            shareBody2="";
        }
    }

    public void share2(View v){
        TextView writeResult=(TextView)findViewById(R.id.textTorus6);
        if((!writeResult.getText().toString().equals(""))&&(shareBody2.equals(""))){
            shareBody2=writeResult.getText().toString();
        }
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Torus:");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody2);
        startActivity(Intent.createChooser(sharingIntent, "Share these numbers..."));
    }

    String shareBody3="";
    public void calculate3 (View v){
        EditText rRead=(EditText)findViewById(R.id.editCylinder1);
        EditText hRead=(EditText)findViewById(R.id.editCylinder2);
        TextView writeResult=(TextView)findViewById(R.id.textCylinder6);
        if( !rRead.getText().toString().equals("") && !hRead.getText().toString().equals("")){

            BigDecimal r=new BigDecimal(rRead.getText().toString());
            BigDecimal h=new BigDecimal(hRead.getText().toString());
            BigDecimal pi=new BigDecimal(Math.PI);
            BigDecimal num2=new BigDecimal(2);
            BigDecimal x=pi.multiply(r);
            BigDecimal volume=x.multiply(r);
            volume = volume.multiply(h);
            BigDecimal surface=r.add(h);
            surface= surface.multiply(x);
            surface= surface.multiply(num2);
            String l="Surface Area = "+surface+"\n\nVolume = "+volume;
            writeResult.setText(l);
            shareBody3=l;

        }
        else{
            writeResult.setText("");
            shareBody3="";
        }
    }

    public void share3(View v){
        TextView writeResult=(TextView)findViewById(R.id.textCylinder6);
        if((!writeResult.getText().toString().equals(""))&&(shareBody3.equals(""))){
            shareBody3=writeResult.getText().toString();
        }
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Cylinder:");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody3);
        startActivity(Intent.createChooser(sharingIntent, "Share these numbers..."));
    }

    String shareBody4="";
    public void calculate4 (View v){
        EditText rRead=(EditText)findViewById(R.id.editCone1);
        EditText hRead=(EditText)findViewById(R.id.editCone2);
        TextView writeResult=(TextView)findViewById(R.id.textCone7);
        if( !rRead.getText().toString().equals("") && !hRead.getText().toString().equals("")){

            BigDecimal r=new BigDecimal(rRead.getText().toString());
            BigDecimal h=new BigDecimal(hRead.getText().toString());
            BigDecimal pi=new BigDecimal(Math.PI);
            BigDecimal κ=new BigDecimal(1.0/3.0);
            BigDecimal x=pi.multiply(r);
            x=x.multiply(r);
            BigDecimal volume = x.multiply(h);
            volume = volume.multiply(κ);
            double r1,h1,s1;
            r1=r.doubleValue();
            h1=h.doubleValue();
            s1= Math.hypot(r1, h1);
            BigDecimal s=new BigDecimal(s1);
            BigDecimal surface=s.multiply(r);
            surface=surface.multiply(pi);
            surface=surface.add(x);
            String l="Surface Area = "+surface+"\n\nVolume = "+volume;
            writeResult.setText(l);
            shareBody4=l;
        }
        else{
            writeResult.setText("");
            shareBody4="";
        }
    }

    public void share4(View v){
        TextView writeResult=(TextView)findViewById(R.id.textCone7);
        if((!writeResult.getText().toString().equals(""))&&(shareBody4.equals(""))){
            shareBody4=writeResult.getText().toString();
        }
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Cone:");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody4);
        startActivity(Intent.createChooser(sharingIntent, "Share these numbers..."));
    }

    String shareBody5="";
    public void calculate5 (View v){
        EditText aRead=(EditText)findViewById(R.id.editCube1);
        TextView writeResult=(TextView)findViewById(R.id.textCube4);
        if( !aRead.getText().toString().equals("")){

            BigDecimal a=new BigDecimal(aRead.getText().toString());
            BigDecimal num6=new BigDecimal(6);
            BigDecimal x=a.multiply(a);
            BigDecimal volume=x.multiply(a);
            BigDecimal surface=x.multiply(num6);
            String l="Surface Area = "+surface+"\n\nVolume = "+volume;
            writeResult.setText(l);
            shareBody5=l;

        }
        else{
            writeResult.setText("");
            shareBody5="";
        }
    }

    public void share5(View v){
        TextView writeResult=(TextView)findViewById(R.id.textCube4);
        if((!writeResult.getText().toString().equals(""))&&(shareBody5.equals(""))){
            shareBody5=writeResult.getText().toString();
        }
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Cube (Regular Hexahedron):");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody5);
        startActivity(Intent.createChooser(sharingIntent, "Share these numbers..."));
    }

    String shareBody6="";
    public void calculate6 (View v){
        EditText lRead=(EditText)findViewById(R.id.editParallelepiped1);
        EditText wRead=(EditText)findViewById(R.id.editParallelepiped2);
        EditText hRead=(EditText)findViewById(R.id.editParallelepiped3);
        TextView writeResult=(TextView)findViewById(R.id.textParallelepiped5);
        if( !lRead.getText().toString().equals("")&& !wRead.getText().toString().equals("")&& !hRead.getText().toString().equals("")){

            BigDecimal l=new BigDecimal(lRead.getText().toString());
            BigDecimal w=new BigDecimal(wRead.getText().toString());
            BigDecimal h=new BigDecimal(hRead.getText().toString());
            BigDecimal num2=new BigDecimal(2);
            BigDecimal x1=l.multiply(w);
            BigDecimal volume=x1.multiply(h);
            BigDecimal x2=l.multiply(h);
            BigDecimal x3=h.multiply(w);
            BigDecimal surface=x1.add(x2);
            surface=surface.add(x3);
            surface=surface.multiply(num2);
            String r="Surface Area = "+surface+"\n\nVolume = "+volume;
            writeResult.setText(r);
            shareBody6=r;

        }
        else{
            writeResult.setText("");
            shareBody6="";
        }
    }

    public void share6(View v){
        TextView writeResult=(TextView)findViewById(R.id.textParallelepiped5);
        if((!writeResult.getText().toString().equals(""))&&(shareBody6.equals(""))){
            shareBody6=writeResult.getText().toString();
        }
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Parallelepiped:");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody6);
        startActivity(Intent.createChooser(sharingIntent, "Share these numbers..."));
    }

    String shareBody7="";
    public void calculate7 (View v){
        EditText aRead=(EditText)findViewById(R.id.editTriangularPyramid1);
        TextView writeResult=(TextView)findViewById(R.id.textTriangularPyramid4);
        if( !aRead.getText().toString().equals("")){

            BigDecimal a=new BigDecimal(aRead.getText().toString());
            double x=Math.sqrt(3);
            double y=Math.sqrt(2.0)/12.0;
            BigDecimal numx=new BigDecimal(x);
            BigDecimal numy=new BigDecimal(y);
            BigDecimal x1=a.multiply(a);
            BigDecimal surface=x1.multiply(numx);
            BigDecimal volume=x1.multiply(a);
            volume=volume.multiply(numy);
            String l="Surface Area = "+surface+"\n\nVolume = "+volume;
            writeResult.setText(l);
            shareBody7=l;

        }
        else{
            writeResult.setText("");
            shareBody7="";
        }
    }

    public void share7(View v){
        TextView writeResult=(TextView)findViewById(R.id.textTriangularPyramid4);
        if((!writeResult.getText().toString().equals(""))&&(shareBody7.equals(""))){
            shareBody7=writeResult.getText().toString();
        }
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Triangular Pyramid (Regular Tetrahedron):");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody7);
        startActivity(Intent.createChooser(sharingIntent, "Share these numbers..."));
    }

    String shareBody8="";
    public void calculate8 (View v){
        EditText aRead=(EditText)findViewById(R.id.editSquarePyramid1);
        TextView writeResult=(TextView)findViewById(R.id.textSquarePyramid4);
        if( !aRead.getText().toString().equals("")){

            BigDecimal a=new BigDecimal(aRead.getText().toString());
            double x=1+Math.sqrt(3);
            double y=Math.sqrt(2.0)/12.0;
            BigDecimal numx=new BigDecimal(x);
            BigDecimal numy=new BigDecimal(y);
            BigDecimal x1=a.multiply(a);
            BigDecimal surface=x1.multiply(numx);
            BigDecimal volume=x1.multiply(a);
            volume=volume.multiply(numy);
            String l="Surface Area = "+surface+"\n\nVolume = "+volume;
            writeResult.setText(l);
            shareBody8=l;

        }
        else{
            writeResult.setText("");
            shareBody8="";
        }
    }

    public void share8(View v){
        TextView writeResult=(TextView)findViewById(R.id.textSquarePyramid4);
        if((!writeResult.getText().toString().equals(""))&&(shareBody8.equals(""))){
            shareBody8=writeResult.getText().toString();
        }
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Square Pyramid:");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody8);
        startActivity(Intent.createChooser(sharingIntent, "Share these numbers..."));
    }

    String shareBody9="";
    public void calculate9 (View v){
        EditText aRead=(EditText)findViewById(R.id.editTriangularPrism1);
        EditText hRead=(EditText)findViewById(R.id.editTriangularPrism2);
        TextView writeResult=(TextView)findViewById(R.id.textTriangularPrism5);
        if( !aRead.getText().toString().equals("") && !hRead.getText().toString().equals("")){

            BigDecimal a=new BigDecimal(aRead.getText().toString());
            BigDecimal h=new BigDecimal(hRead.getText().toString());
            double x=Math.sqrt(3.0)/2.0;
            double y=Math.sqrt(3.0)/4.0;
            BigDecimal numx=new BigDecimal(x);
            BigDecimal numy=new BigDecimal(y);
            BigDecimal num3=new BigDecimal(3);
            BigDecimal x1=a.multiply(h);
            BigDecimal surface=x1.multiply(num3);
            BigDecimal x2=a.multiply(a);
            x2=x2.multiply(numx);
            surface=surface.add(x2);
            BigDecimal volume=x1.multiply(a);
            volume=volume.multiply(numy);
            String l="Surface Area = "+surface+"\n\nVolume = "+volume;
            writeResult.setText(l);
            shareBody9=l;

        }
        else{
            writeResult.setText("");
            shareBody9="";
        }
    }

    public void share9(View v){
        TextView writeResult=(TextView)findViewById(R.id.textTriangularPrism5);
        if((!writeResult.getText().toString().equals(""))&&(shareBody9.equals(""))){
            shareBody9=writeResult.getText().toString();
        }
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Triangular Prism:");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody9);
        startActivity(Intent.createChooser(sharingIntent, "Share these numbers..."));
    }

    String shareBody10="";
    public void calculate10 (View v){
        EditText aRead=(EditText)findViewById(R.id.editPentagonalPrism1);
        EditText hRead=(EditText)findViewById(R.id.editPentagonalPrism2);
        TextView writeResult=(TextView)findViewById(R.id.textPentagonalPrism5);
        if( !aRead.getText().toString().equals("") && !hRead.getText().toString().equals("")){

            BigDecimal a=new BigDecimal(aRead.getText().toString());
            BigDecimal h=new BigDecimal(hRead.getText().toString());
            double x=Math.sqrt(5.0)*10;
            x=Math.sqrt(x+25.0);
            double x1=(1.0/2)*x;
            double x2=(1.0/4)*x;
            BigDecimal numx1=new BigDecimal(x1);
            BigDecimal numx2=new BigDecimal(x2);
            BigDecimal num5=new BigDecimal(5);
            BigDecimal y=a.multiply(h);
            BigDecimal surface=numx1.multiply(a);
            surface=surface.multiply(a);
            surface=surface.add(num5.multiply(y));
            BigDecimal volume=numx2.multiply(y);
            volume=volume.multiply(a);
            String l="Surface Area = "+surface+"\n\nVolume = "+volume;
            writeResult.setText(l);
            shareBody10=l;

        }
        else{
            writeResult.setText("");
            shareBody10="";
        }
    }

    public void share10(View v){
        TextView writeResult=(TextView)findViewById(R.id.textPentagonalPrism5);
        if((!writeResult.getText().toString().equals(""))&&(shareBody10.equals(""))){
            shareBody10=writeResult.getText().toString();
        }
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Pentagonal Prism:");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody10);
        startActivity(Intent.createChooser(sharingIntent, "Share these numbers..."));
    }

    String shareBody11="";
    public void calculate11 (View v){
        EditText aRead=(EditText)findViewById(R.id.editOctahedron1);
        TextView writeResult=(TextView)findViewById(R.id.textOctahedron4);
        if( !aRead.getText().toString().equals("")){
            BigDecimal a=new BigDecimal(aRead.getText().toString());
            double x1=Math.sqrt(3.0);
            double x2=Math.sqrt(2.0);
            BigDecimal numx1=new BigDecimal(x1);
            BigDecimal numx2=new BigDecimal(x2);
            BigDecimal num2=new BigDecimal(2);
            BigDecimal num3=new BigDecimal(1/3.0);
            BigDecimal y=a.multiply(a);
            BigDecimal surface=numx1.multiply(y);
            surface=surface.multiply(num2);
            BigDecimal volume=numx2.multiply(y);
            volume=volume.multiply(a);
            volume=volume.multiply(num3);
            String l="Surface Area = "+surface+"\n\nVolume = "+volume;
            writeResult.setText(l);
            shareBody11=l;

        }
        else{
            writeResult.setText("");
            shareBody11="";
        }
    }

    public void share11(View v){
        TextView writeResult=(TextView)findViewById(R.id.textOctahedron4);
        if((!writeResult.getText().toString().equals(""))&&(shareBody11.equals(""))){
            shareBody11=writeResult.getText().toString();
        }
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Regular Octahedron:");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody11);
        startActivity(Intent.createChooser(sharingIntent, "Share these numbers..."));
    }

    String shareBody12="";
    public void calculate12 (View v){
        EditText aRead=(EditText)findViewById(R.id.editDodecahedron1);
        TextView writeResult=(TextView)findViewById(R.id.textDodecahedron4);
        if( !aRead.getText().toString().equals("")){
            BigDecimal a=new BigDecimal(aRead.getText().toString());
            double x1=Math.sqrt(5.0)*10;
            x1=Math.sqrt(x1+25.0);
            x1=3*x1;
            BigDecimal numx1=new BigDecimal(x1);
            BigDecimal x=a.multiply(a);
            BigDecimal surface=numx1.multiply(x);
            double x2=Math.sqrt(5.0)*7;
            x2=x2+15;
            x2=x2/4.0;
            BigDecimal numx2=new BigDecimal(x2);
            BigDecimal volume=numx2.multiply(x);
            volume=volume.multiply(a);
            String l="Surface Area = "+surface+"\n\nVolume = "+volume;
            writeResult.setText(l);
            shareBody12=l;

        }
        else{
            writeResult.setText("");
            shareBody12="";
        }
    }

    public void share12(View v){
        TextView writeResult=(TextView)findViewById(R.id.textDodecahedron4);
        if((!writeResult.getText().toString().equals(""))&&(shareBody12.equals(""))){
            shareBody12=writeResult.getText().toString();
        }
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Regular Dodecahedron:");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody12);
        startActivity(Intent.createChooser(sharingIntent, "Share these numbers..."));
    }

    String shareBody13="";
    public void calculate13 (View v){
        EditText aRead=(EditText)findViewById(R.id.editIcosahedron1);
        TextView writeResult=(TextView)findViewById(R.id.textIcosahedron4);
        if( !aRead.getText().toString().equals("")){
            BigDecimal a=new BigDecimal(aRead.getText().toString());
            double x1=Math.sqrt(3.0)*5;
            BigDecimal numx1=new BigDecimal(x1);
            BigDecimal x=a.multiply(a);
            BigDecimal surface=numx1.multiply(x);
            double x2=Math.sqrt(5.0)+3;
            x2=x2*5.0/12.0;
            BigDecimal numx2=new BigDecimal(x2);
            BigDecimal volume=numx2.multiply(x);
            volume=volume.multiply(a);
            String l="Surface Area = "+surface+"\n\nVolume = "+volume;
            writeResult.setText(l);
            shareBody13=l;

        }
        else{
            writeResult.setText("");
            shareBody13="";
        }
    }

    public void share13(View v){
        TextView writeResult=(TextView)findViewById(R.id.textIcosahedron4);
        if((!writeResult.getText().toString().equals(""))&&(shareBody13.equals(""))){
            shareBody13=writeResult.getText().toString();
        }
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Regular Icosahedron:");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody13);
        startActivity(Intent.createChooser(sharingIntent, "Share these numbers..."));
    }


    public void moreButtonClick1(View v){
        String url = "http://en.wikipedia.org/wiki/Sphere";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);}

    public void moreButtonClick2(View v){
        String url = "http://en.wikipedia.org/wiki/Torus";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);}

    public void moreButtonClick3(View v){
        String url = "http://en.wikipedia.org/wiki/Cylinder_(geometry)";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);}

    public void moreButtonClick4(View v){
        String url = "http://en.wikipedia.org/wiki/Cone";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);}

    public void moreButtonClick5(View v){
        String url = "http://en.wikipedia.org/wiki/Cube";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);}

    public void moreButtonClick6(View v){
        String url = "http://en.wikipedia.org/wiki/Parallelepiped";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);}

    public void moreButtonClick7(View v){
        String url = "http://en.wikipedia.org/wiki/Tetrahedron";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);}

    public void moreButtonClick8(View v){
        String url = "http://en.wikipedia.org/wiki/Square_pyramid";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);}

    public void moreButtonClick9(View v){
        String url = "http://en.wikipedia.org/wiki/Triangular_prism";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);}

    public void moreButtonClick10(View v){
        String url = "http://en.wikipedia.org/wiki/Pentagonal_prism";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);}

    public void moreButtonClick11(View v){
        String url = "http://en.wikipedia.org/wiki/Octahedron";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);}

    public void moreButtonClick12(View v){
        String url = "http://en.wikipedia.org/wiki/Dodecahedron";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);}

    public void moreButtonClick13(View v){
        String url = "http://en.wikipedia.org/wiki/Icosahedron";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);}

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.three_dimensional_shapes, menu);
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
	//int id = item.getItemId();
	//if (id == R.id.action_settings) {
	//	return true;
	    default:
		return super.onOptionsItemSelected(item);}
	}
}

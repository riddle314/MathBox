package com.dimitriskatsikas.mathtools;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;

public class FactorialsCombinationsActivity extends ActionBarActivity {

    private calculateThread1 task=null;
    static boolean test1,test2= false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_factorials_combinations);
		/*ActionBar actionBar = getActionBar(); // or MainActivity.getInstance().getActionBar()
		actionBar.setBackgroundDrawable(new ColorDrawable(0xffff8800));
		actionBar.setDisplayShowTitleEnabled(false);  // required to force redraw, without, gray color
		actionBar.setDisplayShowTitleEnabled(true);
		getActionBar().setTitle(Html.fromHtml("<font color=@color/white>" + getString(R.string.title_activity_factorials_combinations) + "</font>"));
		*/
    }

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.factorials_combinations, menu);
		return true;
	}*/


    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);
        task=(calculateThread1)getLastCustomNonConfigurationInstance();
        if (task != null) {
            task.attach(this);
        }

    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
      if (task != null) {
            task.detach();}
        return(task);
    }



    void updateProgress(long e,String result) {
        if(e==1){
            TextView writeResult=(TextView)findViewById(R.id.textView2);
            writeResult.setText(result);}
        else if(e==2){
            TextView writeResult=(TextView)findViewById(R.id.textView4);
            writeResult.setText(result);
    }}


    static class calculateThread1 extends AsyncTask<Long, Integer, String> {
        FactorialsCombinationsActivity activity=null;

        calculateThread1(FactorialsCombinationsActivity activity) {
            attach(activity);
        }

        long n;
        long k;
        long e;
        @Override
        protected String doInBackground(Long... q) {
           n=q[0];
           k=q[1];
           e=q[2];
            BigInteger x = new BigInteger("1");
            for (long i=n; i>=n-k+1; i--)
            { publishProgress((int) (((n-i+1) / (float) k) * 100));
              BigInteger z = BigInteger.valueOf(i);
              x=x.multiply(z);}
           String l=""+x;
           return l;
        }

        protected void onProgressUpdate(Integer... progress) {
            activity.updateProgress(e, "Calculating... " + progress[0] + "%");
        }


        protected void onPostExecute(String result) {
            if(e==1){
            shareBody1=n+"! = "+result;
                activity.updateProgress(e,shareBody1);
                test1=false;
            }
            else if(e==2){
              shareBody2=n+"! ÷ ("+n+"-"+k+")! = "+result;
                activity.updateProgress(e,shareBody2);
                test2=false;
            }

        }


        void detach() {
            activity=null;
        }

        void attach(FactorialsCombinationsActivity activity) {
            this.activity=activity;
        }


    }
	public BigInteger factor(long n, long k)
    {  BigInteger x = new BigInteger("1");
       for (long i=n; i>=n-k+1; i--)
        {BigInteger z = BigInteger.valueOf(i);
    	 x=x.multiply(z);}
       return x;}
	
	static String shareBody1="";
	public void calculate1 (View v){
	EditText nRead=(EditText)findViewById(R.id.editText1);
	TextView writeResult=(TextView)findViewById(R.id.textView2);
    shareBody1="";
        test1=true;
        if(test2){
            writeResult.setText(Html.fromHtml("<font color=@color/holo_red_dark>" + "Wait until the last calculation ends..." + "</font>"));
            test1=false;
        }
        else{
	if( !nRead.getText().toString().equals("")){
     BigInteger bi1 = new BigInteger(nRead.getText().toString());
     BigInteger bi2 = new BigInteger("10000");
     int res = bi1.compareTo(bi2);
     if (res==1){
           writeResult.setText(Html.fromHtml("<font color=@color/holo_red_dark>"+"Try n ≤ 10000."+"</font>"));
         test1=false;
       }
	 else{
     writeResult.setText("Calculating...");
     long n=Long.parseLong(nRead.getText().toString());
         task=new calculateThread1(this);
         task.execute(n,n,(long)1);
     }
    }
	else{
		writeResult.setText("");
        test1=false;
	}}
	}
	
	public void share1(View v){
        TextView writeResult=(TextView)findViewById(R.id.textView2);
        if((!writeResult.getText().toString().equals(""))&&(shareBody1.equals(""))){
            shareBody1=writeResult.getText().toString();
        }
    	Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND); 
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "n!");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody1);
    startActivity(Intent.createChooser(sharingIntent, "Share this number..."));	
    }
	
	public void moreButtonClick1(View v){
	    String url = "http://en.wikipedia.org/wiki/Factorial";
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		startActivity(i);}
	
	static String shareBody2="";
	public void calculate2 (View v){
		EditText nRead=(EditText)findViewById(R.id.editText2);
		EditText kRead=(EditText)findViewById(R.id.editText3);
		TextView writeResult=(TextView)findViewById(R.id.textView4);
        shareBody2="";
        test2=true;
        if(test1){
            writeResult.setText(Html.fromHtml("<font color=@color/holo_red_dark>" + "Wait until the last calculation ends..." + "</font>"));
            test2=false;
        }
        else{

		if( !kRead.getText().toString().equals("")&& !nRead.getText().toString().equals("")){
         BigInteger bn = new BigInteger(nRead.getText().toString());
         BigInteger bk = new BigInteger(kRead.getText().toString());
         BigInteger b1 = new BigInteger("10000");
         int res1 = bn.compareTo(b1);
         int res2 = bk.compareTo(b1);
         int res3 = bk.compareTo(bn);
		 if(res1==1){
           writeResult.setText(Html.fromHtml("<font color=@color/holo_red_dark>"+"Try n ≤ 10000."+"</font>"));
             test2=false;
		 }
	     else if(res2==1){
           writeResult.setText(Html.fromHtml("<font color=@color/holo_red_dark>"+"Try k ≤ 10000."+"</font>"));
             test2=false;
	     }
         else if(res3==1){
           writeResult.setText(Html.fromHtml("<font color=@color/holo_red_dark>"+"You need k ≤ n, try again."+"</font>"));
             test2=false;
           }
		 else {
         writeResult.setText("Calculating...");
         long n=Long.parseLong(nRead.getText().toString());
         long k=Long.parseLong(kRead.getText().toString());
         task=new calculateThread1(this);
         task.execute(n,k,(long)2);
         }}
		else{
		 writeResult.setText("");
            test2=false;
		}}
		}  
	
	public void share2(View v){
        TextView writeResult=(TextView)findViewById(R.id.textView4);
        if((!writeResult.getText().toString().equals(""))&&(shareBody2.equals(""))){
            shareBody2=writeResult.getText().toString();
        }
    	Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND); 
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "n! ÷ (n-k)!");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody2);
    startActivity(Intent.createChooser(sharingIntent, "Share this number..."));	
    }

    public void moreButtonClick2(View v){
        String url = "http://en.wikipedia.org/wiki/Permutation#k-permutations_of_n";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);}
	
	String shareBody3="";
	public void calculate3 (View v){
		EditText nRead=(EditText)findViewById(R.id.editText4);
		EditText kRead=(EditText)findViewById(R.id.editText5);
		TextView writeResult=(TextView)findViewById(R.id.textView6);
        shareBody3="";
		if( !kRead.getText().toString().equals("")&& !nRead.getText().toString().equals("")){
         BigInteger bn = new BigInteger(nRead.getText().toString());
         BigInteger bk = new BigInteger(kRead.getText().toString());
         BigInteger b1 = new BigInteger("10000");
         BigInteger b2 = new BigInteger("1000");
         int res1 = bn.compareTo(b1);
         int res2 = bk.compareTo(b2);
		 if(res1==1){
           writeResult.setText(Html.fromHtml("<font color=@color/holo_red_dark>"+"Try n ≤ 10000."+"</font>"));}
	     else if(res2==1){
           writeResult.setText(Html.fromHtml("<font color=@color/holo_red_dark>"+"Try k ≤ 1000."+"</font>"));}
	     else{
             long n=Long.parseLong(nRead.getText().toString());
             int k=Integer.parseInt(kRead.getText().toString());
	    	 BigInteger l=BigInteger.valueOf(n).pow(k);
	    	 String j=n+"^"+k+" = "+l;
	    	 writeResult.setText(j);
	    	 shareBody3=j;}}
		else{
		 writeResult.setText("");
		}
		}
	
	public void share3(View v){
        TextView writeResult=(TextView)findViewById(R.id.textView6);
        if((!writeResult.getText().toString().equals(""))&&(shareBody3.equals(""))){
            shareBody3=writeResult.getText().toString();
        }
    	Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND); 
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "n^k");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody3);
    startActivity(Intent.createChooser(sharingIntent, "Share this number..."));	
    }

    public void moreButtonClick3(View v){
        String url = "http://en.wikipedia.org/wiki/Exponentiation#Combinatorial_interpretation";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);}
	
	String shareBody4="";
	public void calculate4 (View v){
		EditText nRead=(EditText)findViewById(R.id.editText6);
		EditText kRead=(EditText)findViewById(R.id.editText7);
		TextView writeResult=(TextView)findViewById(R.id.textView8);
        shareBody4="";
		if( !kRead.getText().toString().equals("")&& !nRead.getText().toString().equals("")){
            BigInteger bn = new BigInteger(nRead.getText().toString());
            BigInteger bk = new BigInteger(kRead.getText().toString());
            BigInteger b1 = new BigInteger("10000");
            int res1 = bn.compareTo(b1);
            int res2 = bk.compareTo(b1);
            int res3 = bk.compareTo(bn);
		 if(res3==1){
			 writeResult.setText(Html.fromHtml("<font color=@color/holo_red_dark>"+"You need k ≤ n, try again."+"</font>"));
		     }
		 else if(res1==1){writeResult.setText(Html.fromHtml("<font color=@color/holo_red_dark>"+"Try n ≤ 10000."+"</font>"));
		     }
	     else if(res2==1){writeResult.setText(Html.fromHtml("<font color=@color/holo_red_dark>"+"Try k ≤ 10000."+"</font>"));
	         }
		 else {
         long n=Long.parseLong(nRead.getText().toString());
         long k=Long.parseLong(kRead.getText().toString());
		 FactorialsCombinationsActivity m =new FactorialsCombinationsActivity();
		 BigInteger l=m.factor(n,k);
		 l=l.divide(m.factor(k,k));
		 String j=n+"! ÷ "+k+"!("+n+"-"+k+")! = "+l;
		 writeResult.setText(j);
		 shareBody4=j;}}
		else{
		 writeResult.setText("");
		}
		}
	
	public void share4(View v){
        TextView writeResult=(TextView)findViewById(R.id.textView8);
        if((!writeResult.getText().toString().equals(""))&&(shareBody4.equals(""))){
            shareBody4=writeResult.getText().toString();
        }
    	Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND); 
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "n! ÷ k!(n-k)!");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody4);
    startActivity(Intent.createChooser(sharingIntent, "Share number..."));	
    }

    public void moreButtonClick4(View v){
        String url = "http://en.wikipedia.org/wiki/Combination";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);}
	
	String shareBody5="";
	public void calculate5 (View v){
		EditText nRead=(EditText)findViewById(R.id.editText8);
		EditText kRead=(EditText)findViewById(R.id.editText9);
		TextView writeResult=(TextView)findViewById(R.id.textView10);
        shareBody5="";
		if( !kRead.getText().toString().equals("")&& !nRead.getText().toString().equals("")){
         BigInteger bn = new BigInteger(nRead.getText().toString());
         BigInteger bk = new BigInteger(kRead.getText().toString());
         BigInteger b1 = new BigInteger("10000");
         int res1 = bn.compareTo(b1);
         int res2 = bk.compareTo(b1);
		 if(res1==1){writeResult.setText(Html.fromHtml("<font color=@color/holo_red_dark>"+"Try n ≤ 10000."+"</font>"));
		 }
	     else if(res2==1){writeResult.setText(Html.fromHtml("<font color=@color/holo_red_dark>"+"Try k ≤ 10000."+"</font>"));
	     }
	     else{
         long n=Long.parseLong(nRead.getText().toString());
         long k=Long.parseLong(kRead.getText().toString());
         FactorialsCombinationsActivity m =new FactorialsCombinationsActivity();
		 BigInteger l=m.factor(n+k-1,k);
		 l=l.divide(m.factor(k,k));
		 String j="("+n+"+"+k+"-1)! ÷ "+k+"!("+n+"-1)! = "+l;
		 writeResult.setText(j);
		 shareBody5=j;}}
		else{
		 writeResult.setText("");
		}
		}
	
	public void share5(View v){
        TextView writeResult=(TextView)findViewById(R.id.textView10);
        if((!writeResult.getText().toString().equals(""))&&(shareBody5.equals(""))){
            shareBody5=writeResult.getText().toString();
        }
    	Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND); 
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "(n+k-1)! ÷ k!(n-1)!");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody5);
    startActivity(Intent.createChooser(sharingIntent, "Share this number..."));	
    }

    public void moreButtonClick5(View v){
        String url = "http://en.wikipedia.org/wiki/Combination";
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
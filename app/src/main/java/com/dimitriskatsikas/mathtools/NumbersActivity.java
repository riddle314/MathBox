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
import java.math.BigDecimal;
import java.math.BigInteger;

public class NumbersActivity extends ActionBarActivity{

    private PrimePartCalculation1 task1=null;
    private PrimePartCalculation2 task2=null;
    private FibonacciCalculation task3=null;

   static boolean test1,test2,test3= false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_numbers);

	}


	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.numbers, menu);
		return true;
	}*/

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);
        if(test3){
            task3=(FibonacciCalculation)getLastCustomNonConfigurationInstance();
                if (task3 != null) {
                    task3.attach(this);}
        }
        else if(test2){
            task2=(PrimePartCalculation2)getLastCustomNonConfigurationInstance();
                if (task2 != null) {
                    task2.attach(this);}
        }
        else{
            task1=(PrimePartCalculation1)getLastCustomNonConfigurationInstance();
                if (task1 != null) {
                    task1.attach(this);}
        }

    }



    @Override
    public Object onRetainCustomNonConfigurationInstance() {


        if(test3){
            if (task3 != null) {
                task3.detach();}
            return(task3);
        }
        else if(test2){
            if (task2 != null) {
                task2.detach();}
            return(task2);
        }
        else{
            if (task1 != null) {
                task1.detach();}
            return(task1);
        }

    }



    public void shareConstant1(View v){
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Archimedes' constant:");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "π = 3.141592653589793238462643383279502884197169399375105820974944...");
        startActivity(Intent.createChooser(sharingIntent, "Share this number..."));
    }

    public void shareConstant2(View v){
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Euler's number:");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "e = 2.7182818284590452353602874713526624977572470936999595...");
        startActivity(Intent.createChooser(sharingIntent, "Share this number..."));
    }

    public void shareConstant3(View v){
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Pythagoras' constant:");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "√2 = 1.414213562373095048801688724209698078569671875376948073176679...");
        startActivity(Intent.createChooser(sharingIntent, "Share this number..."));
    }

    public void shareConstant4(View v){
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "The golden ratio:");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "φ = (1 + √5)/2 = 1.618033988749894848204586834365638117720309179805762862135448...");
        startActivity(Intent.createChooser(sharingIntent, "Share this number..."));
    }



    void updateProgress1(String result) {
        TextView writeResult=(TextView)findViewById(R.id.textPrime2);
            writeResult.setText(Html.fromHtml(result));
        }

    void updateProgress2(String result) {
        TextView writeResult=(TextView)findViewById(R.id.textPrime4);
        writeResult.setText(result);
        }

    void updateProgress3(String result) {
        TextView writeResult=(TextView)findViewById(R.id.textFibonacci2);
        writeResult.setText(result);
        }

    String sharePrime1="";

    public void calculatePrime1 (View v){
        EditText pRead=(EditText)findViewById(R.id.editPrime1);
        TextView writeResult=(TextView)findViewById(R.id.textPrime2);
        test1=true;
        if(test2||test3){
            writeResult.setText(Html.fromHtml("<font color=@color/holo_red_dark>" + "Wait until the last calculation ends..." + "</font>"));
            test1=false;
        }
        else{
        if( !pRead.getText().toString().equals(""))
          {
              String l="";
              BigInteger bi1 = new BigInteger(pRead.getText().toString());
              BigInteger bi2 = new BigInteger("999999999999999");
              int res = bi1.compareTo(bi2);
                if (res==1)
                {
                    sharePrime1="";
                    writeResult.setText(Html.fromHtml("<font color=@color/holo_red_dark>" + "This number is too big, try again with a number less than 999999999999999" + "</font>"));
                    test1=false;
                }
                else{
                    long p=Long.parseLong(pRead.getText().toString());
                    if (p<=1){
                        l=p+" isn't a prime number because is less or equal of 1";
                        writeResult.setText(Html.fromHtml("<font color=@color/holo_red_dark>"+l+"</font>"));
                        sharePrime1=l;
                        test1=false;}
                    else if (p==2) {
                        l=p+" is a prime number";
                        writeResult.setText(l);
                        sharePrime1=l;
                        test1=false;
                    }
                    else if (p==3) {
                        l=p+" is a prime number";
                        writeResult.setText(l);
                        sharePrime1=l;
                        test1=false;
                    }
                    else if(p%2==0){
                        l=p+" isn't a prime number because "+p+"/"+2+"="+p/2;
                        writeResult.setText(Html.fromHtml("<font color=@color/holo_red_dark>"+l+"</font>"));
                        sharePrime1=l;
                        test1=false;}
                    else if(p%3==0){
                        l=p+" isn't a prime number because "+p+"/"+3+"="+p/3;
                        writeResult.setText(Html.fromHtml("<font color=@color/holo_red_dark>"+l+"</font>"));
                        sharePrime1=l;
                        test1=false;}
                    else
                    {
                        sharePrime1="";
                        task1= new PrimePartCalculation1(this);
                        task1.execute(p);

                    }
                }
            }


        else{
            writeResult.setText("");
            sharePrime1="";
            test1=false;
        }}
    }

    public void sharePrime1(View v){
        TextView writeResult=(TextView)findViewById(R.id.textPrime2);
        if((!writeResult.getText().toString().equals(""))&&(sharePrime1.equals(""))){
            sharePrime1=writeResult.getText().toString();
        }
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, sharePrime1);
        startActivity(Intent.createChooser(sharingIntent, "Share this number..."));
    }

    static String sharePrime2Title="";
    String sharePrime2="";

    public void calculatePrime2 (View v){
        EditText pRead=(EditText)findViewById(R.id.editPrime2);
        TextView writeResult=(TextView)findViewById(R.id.textPrime4);

        test2=true;
        if(test1||test3){
            writeResult.setText(Html.fromHtml("<font color=@color/holo_red_dark>" + "Wait until the last calculation ends..." + "</font>"));
            test2=false;
        }
        else{
        if( !pRead.getText().toString().equals(""))
        {
            BigInteger bi1 = new BigInteger(pRead.getText().toString());
            BigInteger bi2 = new BigInteger("90000");
            int res = bi1.compareTo(bi2);
            if (res==1)
            {
                sharePrime2="";
                writeResult.setText(Html.fromHtml("<font color=@color/holo_red_dark>" + "This number is too big, try again with a number equal or less than 90000" + "</font>"));
                test2=false;
            }
            else {
                sharePrime2="";
                long n = Long.parseLong(pRead.getText().toString());
                task2= new PrimePartCalculation2(this);
                task2.execute(n);


            }
        }


        else{
            writeResult.setText("");
            sharePrime2="";
            test2=false;
        }}
    }

    public void sharePrime2(View v){
        TextView writeResult=(TextView)findViewById(R.id.textPrime4);
        if((!writeResult.getText().toString().equals(""))&&(sharePrime2.equals(""))){
            sharePrime2=writeResult.getText().toString();
        }
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, sharePrime2Title);
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, sharePrime2);
        startActivity(Intent.createChooser(sharingIntent, "Share this data..."));
    }


    static String shareFibonacciTitle="";
    String shareFibonacci="";

    public void calculateFibonacci (View v){
        EditText pRead=(EditText)findViewById(R.id.editFibonacci1);
        TextView writeResult=(TextView)findViewById(R.id.textFibonacci2);

        test3=true;
        if(test1||test2){
            writeResult.setText(Html.fromHtml("<font color=@color/holo_red_dark>" + "Wait until the last calculation ends..." + "</font>"));
            test3=false;
        }
        else{
        if( !pRead.getText().toString().equals(""))
        {
            BigInteger bi1 = new BigInteger(pRead.getText().toString());
            BigInteger bi2 = new BigInteger("2000");
            int res = bi1.compareTo(bi2);
            if (res==1)
            {
                shareFibonacci="";
                writeResult.setText(Html.fromHtml("<font color=@color/holo_red_dark>" + "This number is too big, try again with a number equal or less than 2000" + "</font>"));
                test3=false;
            }
            else {
                shareFibonacci="";
                long n = Long.parseLong(pRead.getText().toString());
                task3= new FibonacciCalculation(this);
                task3.execute(n);


            }
        }


        else{
            writeResult.setText("");
            shareFibonacci="";
            test3=false;
        }}
    }

    public void shareFibonacci(View v){
        TextView writeResult=(TextView)findViewById(R.id.textFibonacci2);
        if((!writeResult.getText().toString().equals(""))&&(shareFibonacci.equals(""))){
            shareFibonacci=writeResult.getText().toString();
        }
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareFibonacciTitle);
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareFibonacci);
        startActivity(Intent.createChooser(sharingIntent, "Share this data..."));
    }


    String shareBody8="";

    public void calculateConvert1 (View v){
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
            shareBody8=l;
        }
        else{
            writeResult.setText("");
            shareBody8="";
        }
    }

    public void shareConvert1(View v){
        TextView writeResult=(TextView)findViewById(R.id.resultConvert1);
        if((!writeResult.getText().toString().equals(""))&&(shareBody8.equals(""))){
            shareBody8=writeResult.getText().toString();
        }
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Radians to Degrees:");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody8);
        startActivity(Intent.createChooser(sharingIntent, "Share this number..."));
    }

    String shareBody9="";

    public void calculateConvert2 (View v){
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
            shareBody9=l;
        }
        else{
            writeResult.setText("");
            shareBody9="";
        }
    }

    public void shareConvert2(View v){
        TextView writeResult=(TextView)findViewById(R.id.resultConvert2);
        if((!writeResult.getText().toString().equals(""))&&(shareBody9.equals(""))){
            shareBody9=writeResult.getText().toString();
        }
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Degrees to Radians:");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody9);
        startActivity(Intent.createChooser(sharingIntent, "Share this number..."));
    }
	
	public void moreButtonClick1(View v){
	    String url = "http://en.wikipedia.org/wiki/Mathematical_constant";
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		startActivity(i);}
	
	public void moreButtonClick2(View v){
	    String url = "http://en.wikipedia.org/wiki/Prime_number";
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		startActivity(i);}
	
	public void moreButtonClick3(View v){
	    String url = "http://en.wikipedia.org/wiki/Fibonacci_number";
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		startActivity(i);}

    public void moreButtonClick4(View v){
        String url = "http://en.wikipedia.org/wiki/Angle";
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
	
	    default:
	return super.onOptionsItemSelected(item);}
	}


  class PrimePartCalculation1 extends AsyncTask<Long, Integer, String> {

      NumbersActivity activity=null;

      PrimePartCalculation1(NumbersActivity activity) {

          attach(activity);
      }

      void detach() {

          activity=null;
      }

      void attach(NumbersActivity activity) {

          this.activity=activity;
      }

    boolean z=true;
    @Override
    protected String doInBackground(Long... q) {
            long p=q[0];
            String l="";
            long limit = (long)Math.sqrt(p)+1;
            for (long b=1; (3*b+1)<=limit; b++)
            {publishProgress((int) ((b / (double) ((limit-1)/3.0)) * 100));
                if(b%2==0)
            {
                if (p%(3*b+1)==0)
                {long k=3*b+1;
                    l=p+" isn't a prime number because "+p+"/"+k+"="+p/k;
                    z = false;
                    break;
                }
            }
            else if(p%(3*b+2)==0)
            {long k=3*b+2;
                l=p+" isn't a prime number because "+p+"/"+k+"="+p/k;
                z = false;
                break;
            }
            }
            if (z==true)
            {   l=p+" is a prime number";
            }

       return l;
    }

      protected void onProgressUpdate(Integer... progress) {
          activity.updateProgress1("Calculating... "+progress[0]+"%");
      }

        protected void onPostExecute(String result) {
            sharePrime1=result;
            if(z==true){
                activity.updateProgress1(result);}
            else{
                activity.updateProgress1("<font color=@color/holo_red_dark>" + result + "</font>");}
            test1=false;

    }
  }

    class PrimePartCalculation2 extends AsyncTask<Long, Integer, String> {

        NumbersActivity activity=null;

        PrimePartCalculation2(NumbersActivity activity) {

            attach(activity);
        }

        void detach() {

            activity=null;
        }

        void attach(NumbersActivity activity) {

            this.activity=activity;
        }

        long v;

        @Override
        protected String doInBackground(Long... q) {
            long n=q[0];
            v=n;
            String l="";
            for (long p = 2; p <= n; p++) {
                publishProgress((int) ((p / (float) n) * 100));
                if (p == 2) {
                    l = l + p + " , ";
                } else if (p == 3) {
                    l = l + p + " , ";
                } else if (p % 2 == 0) {
                } else if (p % 3 == 0) {
                } else {
                    boolean z=true;
                    long limit = (long) Math.sqrt(p) + 1;
                    for (long b = 1; (3 * b + 1) <= limit; b++) {

                        if (b % 2 == 0) {
                            if (p % (3 * b + 1) == 0) {
                                z = false;
                                break;
                            }
                        } else if (p % (3 * b + 2) == 0) {
                            z = false;
                            break;
                        }
                    }
                    if (z == true) {
                        l = l+p + " , ";
                    }
                }
            }

            return l;
        }

        protected void onProgressUpdate(Integer... progress) {
            activity.updateProgress2("Calculating... " + progress[0] + "%");
        }

        protected void onPostExecute(String result) {
            sharePrime2Title="All the prime numbers up to the number "+v+" are:";
            if (result.length() > 0) {
                result = result.substring(0, result.length()-2);
            }
            sharePrime2=result;
            activity.updateProgress2(sharePrime2Title + "\n" + sharePrime2);
            test2=false;

        }
    }

    class FibonacciCalculation extends AsyncTask<Long, Integer, String> {

        NumbersActivity activity=null;

        FibonacciCalculation(NumbersActivity activity) {

            attach(activity);
        }

        void detach() {

            activity=null;
        }

        void attach(NumbersActivity activity) {

            this.activity=activity;
        }

        long v;

        @Override
        protected String doInBackground(Long... q) {
            long n=q[0];
            v=n;
            String l="";
            BigInteger x1 = new BigInteger("0");
            BigInteger x2 = new BigInteger("1");
            BigInteger y;
            if(n==0)
            {return l;}
            else if(n==1)
            { l=x1+"";
              return l;}
            else if(n==2)
            { l=x1+" , "+x2;
                return l;}
            else{
              l=x1+" , "+x2;
              for (long p = 3; p <= n; p++) {
                publishProgress((int) ((p / (float) n) * 100));
                y=x1.add(x2);
                x1=x2;
                x2=y;
                l=l+" , "+y;
              }
                return l;
            }

        }

        protected void onProgressUpdate(Integer... progress) {
            activity.updateProgress3("Calculating... " + progress[0] + "%");
        }

        protected void onPostExecute(String result) {
            shareFibonacciTitle="The first "+v+" Fibonacci numbers are:";
            shareFibonacci=result;
            activity.updateProgress3(shareFibonacciTitle+"\n"+shareFibonacci);
            test3=false;
        }
    }

}
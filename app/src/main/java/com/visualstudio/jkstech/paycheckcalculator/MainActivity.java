package com.visualstudio.jkstech.paycheckcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	
	// find the elements
			Button reset;
			Button calc;
			EditText hrs;
			EditText pay;
			TextView totPay;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		reset=(Button)findViewById(R.id.reset);
        calc=(Button)findViewById(R.id.calculate);
        hrs=(EditText)findViewById(R.id.hrsWrkd);
        pay=(EditText)findViewById(R.id.payRate);
        totPay=(TextView)findViewById(R.id.totPay);
        
     // reset button clears all fields and brings hours worked input into focus
        
        reset.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				hrs.setText("");
	        	pay.setText("");
	        	totPay.setText("");
	        	hrs.requestFocus();
				
			}
		});
        
     // formula for overtime included 
        calc.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				double num1 = 0;
	    	    double num2 = 0;
	    	    	   
	    	    
	    	    if (TextUtils.isEmpty(hrs.getText().toString())
	    		        || TextUtils.isEmpty(pay.getText().toString())) {
	    		      return;
	    		    }
	    	    
	    	    num1 = Double.parseDouble(hrs.getText().toString());
	    	    num2 = Double.parseDouble(pay.getText().toString());
	    	      	   
	    	    	    
				if (num1 > 40) {
	    	    	
					totPay.setText(String.valueOf (((num1 - 40) * (num2 * 1.5)) + (40 * num2)));
	    		} else if (num1 <= 40) {
					
					totPay.setText(String.valueOf (num1 * num2));
				}
				
			}
		});
        
        	
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

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

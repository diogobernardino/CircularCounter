package com.db.circularmeterdemo;

import com.db.circularcounter.CircularCounter;
import com.db.circularcounterdemo.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;


public class MainActivity extends Activity {

	private CircularCounter meter;
	
	private String[] colors;

	private Handler handler;

	private Runnable r;
    
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		colors = getResources().getStringArray(R.array.colors);
		
		meter = (CircularCounter) findViewById(R.id.meter);
		
		meter.setFirstWidth(getResources().getDimension(R.dimen.first))
			.setFirstColor(Color.parseColor(colors[0]))
	
			.setSecondWidth(getResources().getDimension(R.dimen.second))
			.setSecondColor(Color.parseColor(colors[1]))
		
			.setThirdWidth(getResources().getDimension(R.dimen.third))
			.setThirdColor(Color.parseColor(colors[2]))
			
			.setBackgroundColor(-14606047);

		
		
		handler = new Handler();
		r = new Runnable(){
			int currV = 0;
			boolean go = true;
	        public void run(){
	        	if(currV == 60 && go)
	        		go = false;
	        	else if(currV == -60 && !go)
	        		go = true;
	        	
	        	if(go)
	        		currV++;
	        	else
	        		currV--;
	        	
	        	meter.setValues(currV, currV*2, currV*3);
	            handler.postDelayed(this, 50);
	        }
	    };
	    
	    
	}

	@Override
	protected void onResume(){
		super.onResume();
		handler.postDelayed(r, 500);
	}
	
	@Override
	protected void onPause(){
		super.onPause();
		handler.removeCallbacks(r);
	}

}

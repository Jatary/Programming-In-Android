package com.example.calculatethird;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.ColorFilter;
import android.view.Menu;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button one,two,three,four,five,six,seven,eight,nine,
	ten,eleven,twelve,thirteen,fourteen,fifteen,sixteen,seventeen,eighteen,nineteen;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		one=(Button)findViewById(R.id.one);
		two=(Button)findViewById(R.id.two);
		three=(Button)findViewById(R.id.three);
		four=(Button)findViewById(R.id.four);
		five=(Button)findViewById(R.id.five);
		six=(Button)findViewById(R.id.six);
		seven=(Button)findViewById(R.id.seven);
		eight=(Button)findViewById(R.id.eight);
		nine=(Button)findViewById(R.id.nine);
		ten=(Button)findViewById(R.id.ten);
		eleven=(Button)findViewById(R.id.eleven);
		twelve=(Button)findViewById(R.id.twelve);
		thirteen=(Button)findViewById(R.id.thirteen);
		fourteen=(Button)findViewById(R.id.fourteen);
		fifteen=(Button)findViewById(R.id.fifteen);
		sixteen=(Button)findViewById(R.id.sixteen);
		seventeen=(Button)findViewById(R.id.seventeen);
		eighteen=(Button)findViewById(R.id.eighteen);
		nineteen=(Button)findViewById(R.id.nineteen);
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

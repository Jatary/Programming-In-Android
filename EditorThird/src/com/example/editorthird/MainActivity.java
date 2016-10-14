package com.example.editorthird;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Button red,green,blue;
	private TextView testText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		testText=(TextView)findViewById(R.id.textView3);
		red=(Button)findViewById(R.id.red);
		green=(Button)findViewById(R.id.green);
		blue=(Button)findViewById(R.id.blue);
		ColorListner myColorListner=new ColorListner();
		red.setOnClickListener(myColorListner);
		green.setOnClickListener(myColorListner);
		blue.setOnClickListener(myColorListner);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	private class ColorListner implements OnClickListener{
		public void onClick(View v){
			switch(v.getId()){
			case R.id.red:
				testText.setTextColor(Color.RED);break;
			case R.id.blue:
				testText.setTextColor(Color.BLUE);break;
			case R.id.green:
				testText.setTextColor(Color.GREEN);break;
			   default:break;
			}
		}

	
		}
	}



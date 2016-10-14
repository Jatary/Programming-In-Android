package com.example.registertest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class ResultActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		TextView resultName=(TextView)findViewById(R.id.name);
		TextView resultPsd=(TextView)findViewById(R.id.psd);
		TextView resultGender=(TextView)findViewById(R.id.male);
		TextView resultCity=(TextView)findViewById(R.id.city);
		Intent intent=getIntent();
		resultName.setText(intent.getStringExtra("name"));
		resultPsd.setText(intent.getStringExtra("psd"));
		resultGender.setText(intent.getStringExtra("gender"));
		resultCity.setText(intent.getStringExtra("city"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
		return true;
	}

}

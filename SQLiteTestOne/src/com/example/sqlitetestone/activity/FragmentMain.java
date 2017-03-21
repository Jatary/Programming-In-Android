package com.example.sqlitetestone.activity;

import com.example.sqlitetestone.R;
import com.example.sqlitetestone.R.layout;
import com.example.sqlitetestone.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class FragmentMain extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fragment_main, menu);
		return true;
	}

}

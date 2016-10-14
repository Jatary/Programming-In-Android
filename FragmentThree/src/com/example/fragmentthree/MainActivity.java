package com.example.fragmentthree;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	Button btn1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		FragmentOne fo=new FragmentOne();
		final FragmentManager fm=getFragmentManager();
		FragmentTransaction a=fm.beginTransaction();
		a.add(R.id.fg1, fo);
		a.commit();
		btn1=(Button) this.findViewById(R.id.btn1);
		btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentTwo ft=new FragmentTwo();
				FragmentTransaction b=fm.beginTransaction();
				b.replace(R.id.fg1, ft);
				b.addToBackStack(null);
				b.commit();
				
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

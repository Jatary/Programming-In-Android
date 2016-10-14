package com.example.serviceplay.activity;

import com.example.serviceplay.R;
import com.example.serviceplay.R.layout;
import com.example.serviceplay.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private static String actionControl="com.example.serviceplaytwo.service.doService";
	Button btnplay,btnnext,btngo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnplay=(Button) this.findViewById(R.id.btnplay);
		btnplay.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setAction(actionControl);
				intent.putExtra("postMsg","播放");
				startService(intent);
				
						
			}
		});
		
		btnnext=(Button) this.findViewById(R.id.btnnext);
        btnnext.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("++++++++++++++");
				Intent intent=new Intent();
				intent.setAction(actionControl);
				intent.putExtra("postMsg","下一首");
				startService(intent);
				
						
			}
		});
		
		btngo=(Button) this.findViewById(R.id.btngo);
		btngo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this,LoginActivity.class);
				startActivity(intent);
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

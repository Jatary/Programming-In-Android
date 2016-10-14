package com.example.serviceplaytwo.activity;

import com.example.serviceplaytwo.R;
import com.example.serviceplaytwo.R.layout;
import com.example.serviceplaytwo.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends Activity {
	private static final String actionTransferUpdate="com.example.serviceplaytwo.service.transferUpdate";
	Button back;
    TextView change;
    LoginActivityReceiver lar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		
		back=(Button) this.findViewById(R.id.back);
		back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent();
				intent.setClass(LoginActivity.this,MainActivity.class);
				startActivity(intent);
				// TODO Auto-generated method stub
				
			}
		});
		change=(TextView) this.findViewById(R.id.change);
		lar=new LoginActivityReceiver();
		IntentFilter a=new IntentFilter();
	
		a.addAction(actionTransferUpdate);
		registerReceiver(lar,a);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
	public class LoginActivityReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			change.setText(intent.getStringExtra("postMsg"));
			
		}
		
	}

}

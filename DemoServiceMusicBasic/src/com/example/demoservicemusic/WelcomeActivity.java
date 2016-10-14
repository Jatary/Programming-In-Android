package com.example.demoservicemusic;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class WelcomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		
		doChangeActivity();
	}
	

	/**
	 * 这种方式下访问者与Service之间没有关联，该Service将一直在后台执行，即使调用startService的进程结束了。
	 * Service无法与访问者进行通信、数据交换，适用于执行单一操作，并且没有返回结果。
	 */
	private void doServiceMethodOne(){
		final Intent intent=new Intent();
		intent.setAction("com.example.demoservicemusic.doService");
		startService(intent);
		
		//停止Service
		//stopService(intent);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome, menu);
		return true;
	}

	private void doChangeActivity(){
		Intent intent=new Intent(WelcomeActivity.this,MainActivity.class);
		this.startActivity(intent);
	}
}

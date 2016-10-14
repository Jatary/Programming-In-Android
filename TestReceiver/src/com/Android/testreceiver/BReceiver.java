package com.Android.testreceiver;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BReceiver extends Activity {

	public static final String ACTION="com.Android.testreceiver.myreceiver";
	Button zhuce;
	Button send;
	Button quxiao;
	MyReceiver myre;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		
		zhuce=(Button) findViewById(R.id.button1);
		send=(Button) findViewById(R.id.button2);
		quxiao=(Button) findViewById(R.id.button3);
		
		zhuce.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				// 通过代码进行广播注册
				myre=new MyReceiver();
				IntentFilter filter=new IntentFilter(ACTION);
				//
				registerReceiver(myre, filter);
			}
		});
		
		send.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				// 发送广播
				Intent intent=new Intent();
				intent.setAction(ACTION);
				sendBroadcast(intent);				
			}
		});
		
		quxiao.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// 取消广播的注册
				unregisterReceiver(myre);
			}
		});
	}
}

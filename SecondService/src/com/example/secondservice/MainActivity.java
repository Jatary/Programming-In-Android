package com.example.secondservice;

import com.example.secondservice.MyService.MyBinder;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	public static String TAG="MainActivity";
	Button start,stop,btn;
	Button bind,unbind;
	Button getData;
	protected MyBinder myBinder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bind=(Button)findViewById(R.id.bind);
		btn=(Button)findViewById(R.id.btn);
		unbind=(Button)findViewById(R.id.unbind);
		getData=(Button)findViewById(R.id.getData);
		start=(Button)findViewById(R.id.start);
		stop=(Button)findViewById(R.id.stop);
		final Intent intent=new Intent();
		intent.setAction("cn.jxufe.iet.MY_SERVICE");
		btn.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				Intent intent=new Intent(MainActivity.this,AIDLClient.class);
				startActivity(intent);
				Toast.makeText(MainActivity.this,"欢迎跳转到AIDLClient界面",Toast.LENGTH_LONG).show();
			}
		});
		start.setOnClickListener(new View.OnClickListener(){
			public void onClick(View arg0){
				startService(intent);
			}
		});
		stop.setOnClickListener(new View.OnClickListener(){
			public void onClick(View arg0){
				stopService(intent);
			}
		});
		bind.setOnClickListener(new View.OnClickListener(){
			public void onClick(View arg0){
				bindService(intent,conn,Service.BIND_AUTO_CREATE);
			}
		});
		unbind.setOnClickListener(new View.OnClickListener(){
			public void onClick(View arg0){
				unbindService(conn);
			}
		});
		getData.setOnClickListener(new View.OnClickListener(){
			
			
			public void onClick(View v) {
				Toast.makeText(MainActivity.this,"Count="+myBinder.getCount(),300).show();
				// TODO Auto-generated method stub
				
			}
		});
		
	
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	private ServiceConnection conn=new ServiceConnection(){
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.i(TAG,"MainActivity onServiceDisconnected invoked!");
			// TODO Auto-generated method stub
			
		}
		public void onServiceConnected(ComponentName name,IBinder service){
			Log.i(TAG,"MainActivity onServiceConnected invoked!");
			myBinder=(MyBinder)service;
		}
		};
		public void onServiceDisconnected(ComponentName name) {
			Log.i(TAG,"MainActivity onServiceDisconnected invoked!");
			// TODO Auto-generated method stub
			
		}
	};




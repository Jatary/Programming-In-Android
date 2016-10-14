package com.example.adilservice;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private Button getData;
	private EditText name,author;
	private Song songBinder;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getData=(Button)findViewById(R.id.getData);
		name=(EditText)findViewById(R.id.name);
		author=(EditText)findViewById(R.id.author);
		final Intent intent=new Intent();
		intent.setAction("iet.jxufe.cn.android.AIDLServer");
		bindService(intent,conn,Service.BIND_AUTO_CREATE);
		getData.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				try{
					name.setText(songBinder.getName());
					author.setText(songBinder.getAuthor());
					
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}

		});
	}
	private ServiceConnection conn=new ServiceConnection(){
		@Override
		public void onServiceDisconnected(ComponentName name) {
			songBinder=null;
			// TODO Auto-generated method stub
			
		}
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			songBinder=Song.Stub.asInterface(service);
			// TODO Auto-generated method stub
			
		}
	};
	protected void onDestroy(){
		super.onDestroy();
		unbindService(conn);
	};



}

package com.example.secondservice;

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
import android.widget.TextView;

public class AIDLClient extends Activity {
	private Button getData1;
	private EditText et1,et2;
	private Song songBinder;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aidlclient);
		getData1=(Button)findViewById(R.id.getData1);
		et1=(EditText)findViewById(R.id.et1);
		et2=(EditText)findViewById(R.id.et2);
		final Intent intent=new Intent();
		intent.setAction("iet.jxufe.cn.android.AIDLServer");
		bindService(intent,conn,Service.BIND_AUTO_CREATE);
		getData1.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				try{
					et1.setText(songBinder.getName());
					et2.setText(songBinder.getAuthor());
					
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

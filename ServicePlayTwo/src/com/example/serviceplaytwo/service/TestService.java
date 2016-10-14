package com.example.serviceplaytwo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class TestService extends Service {
	private static final String actionTransferUpdate="com.example.serviceplaytwo.service.transferUpdate";

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		System.out.println("import£º"+intent.getStringExtra("postMsg"));
		final Intent postIntent=new Intent();
		final String transferData=intent.getStringExtra("postMsg");
		new Thread(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					try {
						Thread.sleep(300);
						Intent postIntent=new Intent();
						postIntent.setAction(actionTransferUpdate);
						postIntent.putExtra("postMsg",transferData);
						sendBroadcast(postIntent);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}.start();
		
		super.onStart(intent, startId);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}

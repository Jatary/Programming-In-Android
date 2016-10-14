package com.example.secondservice;


import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;

public class MyService extends Service {
	private static final String TAG="MyService";
	private int count=0;
	private boolean quit=false;
	private MyBinder myBinder=new MyBinder();                                             
	public class MyBinder extends Binder{
		public MyBinder(){
			Log.i(TAG,"MyBinder Constructure invoked!");
		}
		public int getCount(){
			return count; 
		}
	}
	public IBinder onBind(Intent arg0){
		Log.i(TAG,"MyService onBind invoked!");
		return myBinder;
	
	
	
	}
	@Override
	public void onCreate() {
		Log.i(TAG,"MyService onCreate invoked!");
		// TODO Auto-generated method stub
		super.onCreate();
		new Thread(){
			public void run(){
				while(true){
					try{
						Thread.sleep(10);
						count++;
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
	@Override
	public void onRebind(Intent intent) {
		Log.i(TAG,"MyService onRebind invoked!");
		// TODO Auto-generated method stub
		super.onRebind(intent);
	}
	@Override
	public boolean onUnbind(Intent intent) {
		Log.i(TAG,"MyService onUnbind invoked!");
		// TODO Auto-generated method stub
		return super.onUnbind(intent);
	}
	@Override
	public void onDestroy() {
		Log.i(TAG,"MyService onDestroy invoked!");
		// TODO Auto-generated method stub
		super.onDestroy();
		quit=true;
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i(TAG,"MyService onStartCommand invoked!");
		// TODO Auto-generated method stub
		return super.onStartCommand(intent, flags, startId);
	}
	
	}



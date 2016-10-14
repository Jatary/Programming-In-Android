package com.example.testtwo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
  Handler Handler;
	TextView tvShowinfo;
	Button btnClick;

	boolean flag=false;
	
	protected TextView myText;
	public Handler hand=new Handler(){
		public void handleMessage(Message msg){
			
				if(msg.what==1){
					int randNum=(int)(Math.random()*100)+1;
					tvShowinfo.setText(String.valueOf(randNum));
					
			}else if(msg.what==2){
		}
				super.handleMessage(msg);
	}};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tvShowinfo=(TextView)this.findViewById(R.id.tvShowinfo);
		btnClick=(Button)this.findViewById(R.id.btnClick);
		btnClick.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				if(flag==false){
					flag=true;
				
				}else{
					flag=false;
				}
			
		
			
	  
		
		new Thread(new Runnable(){
		public void run(){
			try{
				while(true){
					Thread.sleep(30);
					Message msg=new Message();
		
					if(flag){

					msg.what=1;}
					else{
						msg.what=2;
					}
					hand.sendMessage(msg);
				}
				}catch(Exception e){
					e.printStackTrace();
				}
		}
			;
		}).start();
			
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



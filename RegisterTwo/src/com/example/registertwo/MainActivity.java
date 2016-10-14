package com.example.registertwo;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends Activity {
   Button registerBtn,cityBtn;


TextView name,psd,psd1,city;
RadioButton male;


private OnClickListener myOnClickListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		registerBtn.setOnClickListener(myOnClickListener);
		cityBtn.setOnClickListener(myOnClickListener);
	}
	
		public void onClick1(View v){
			String checkResult=checkInfo();
			if(checkResult!=null){
				Builder builder=new AlertDialog.Builder(MainActivity.this);
				builder.setTitle("������ʾ");
				builder.setMessage(checkResult);
				builder.setPositiveButton("ȷ��",new DialogInterface.OnClickListener(){
					public void onClick(DialogInterface dialog,int which){
						
						psd.setText("");
						
						psd1.setText("");
					}
				});
				builder.create().show();
			}else{
				Intent intent=new Intent(MainActivity.this,ResultActivity.class);
				
				
				intent.putExtra("name",name.getText().toString());
				intent.putExtra("psd",psd.getText().toString());
			
				String gender=male.isChecked()?"��":"Ů";
				intent.putExtra("gender",gender);
				
				intent.putExtra("city",city.getText().toString());
				startActivity(intent);
			}
		}

	
	
	

		private String checkInfo() {

			if(name.getText().toString()==null||name.getText().toString().equals("")){
				return"�û�������Ϊ��";
			}
		
			if(psd.getText().toString().trim().length()<6||psd.getText().toString().trim().length()>15){
				return"����λ��Ӧ����6~15֮��";
			}
		
			if(!psd.getText().toString().equals(psd1.getText().toString())){
				return"������������벻һ��";
			}
			// TODO Auto-generated method stub
			return null;
		}
		public void onClick(View v){
			Intent intent=new Intent(MainActivity.this,ChooseCityActivity.class);
			startActivityForResult(intent,0);
		};
		public void onActivityResult(int requestaCode,int resultCode,Intent intent){
			int requestCode = 0;
			if(requestCode==0&&resultCode==0){
				Bundle data=intent.getExtras();
				String resultCity=data.getString("city");
				city.setText(resultCity);
			}
		}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;}
}

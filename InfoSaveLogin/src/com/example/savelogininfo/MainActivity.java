package com.example.savelogininfo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button login;
	EditText name,psd;
    SharedPreferences accessPreferences,loginPreferences;
    Editor loginEditor,accessEditor;
    String userName,userPsd;
    boolean isSavePsd,isAutoLogin;
    TextView userInfo;
    CheckBox rememberPsd,autoLogin;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		loginPreferences = getSharedPreferences("login",Context.MODE_PRIVATE);
		accessPreferences = getSharedPreferences("access",Context.MODE_WORLD_READABLE);
	    int count=accessPreferences.getInt("count",1);
	    Toast.makeText(MainActivity.this,"欢迎您，这是第"+count+"次访问！",Toast.LENGTH_LONG).show();
	    loginEditor = loginPreferences.edit();
	    accessEditor = ((SharedPreferences) accessPreferences).edit();
	    accessEditor.putInt("count",++count);
	    accessEditor.commit();
	    userName = loginPreferences.getString("name",null);
	    userPsd = loginPreferences.getString("psd",null);
	    isSavePsd = loginPreferences.getBoolean("isSavePsd",false);
	    isAutoLogin = loginPreferences.getBoolean("isAutoLogin",false);
	    if(isAutoLogin){
	    	this.setContentView(R.layout.activity_welcome);
	    	userInfo= (TextView) this.findViewById(R.id.userInfo);
	    	userInfo.setText("欢迎您："+userName+",登陆成功！");
	    }else{
	    	loadActivity();
	    }
	}

	public void loadActivity() {
		// TODO Auto-generated method stub
		this.setContentView(R.layout.activity_main);
		login = (Button) this.findViewById(R.id.login);
		rememberPsd = (CheckBox) this.findViewById(R.id.rememberPsd);
		autoLogin = (CheckBox) this.findViewById(R.id.autoLogin);
		name = (EditText) this.findViewById(R.id.name);
		psd = (EditText) this.findViewById(R.id.psd);
		
		if(isSavePsd){
			psd.setText(userPsd);
			name.setText(userName);
			rememberPsd.setChecked(true);
		}
		login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				loginEditor.putString("name",name.getText().toString());
				loginEditor.putString("psd",psd.getText().toString());
				loginEditor.putBoolean("isSavePsd",rememberPsd.isChecked());
				loginEditor.putBoolean("isAutoLogin",autoLogin.isChecked());
				loginEditor.commit();
				MainActivity.this.setContentView(R.layout.activity_welcome);
				userInfo=(TextView)findViewById(R.id.userInfo);
				userInfo.setText("欢迎您："+name.getText().toString()+",登陆成功！");
				
				
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

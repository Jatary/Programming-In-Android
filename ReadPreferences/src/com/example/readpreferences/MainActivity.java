package com.example.readpreferences;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	TextView name;
	int count;
	SharedPreferences accessPreferences,loginPreferences;
    Editor accessEditor,loginEditor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SharedPreferences accessPreferences,loginPreferences = null;
		Context appContext=null;
		try{
			appContext=createPackageContext("iet.jxufe.cn.android",Context.CONTEXT_IGNORE_SECURITY);
		}catch(Exception e){
			e.printStackTrace();
		}
		accessPreferences=appContext.getSharedPreferences("access",Context.MODE_WORLD_READABLE);
	    count=accessPreferences.getInt("name",1);
		Toast.makeText(this,"你好,"+name+",SaveLoginInfo应用程序已经被使用了"+count+"次！",Toast.LENGTH_LONG).show();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

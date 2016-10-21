package activity;

import java.util.ArrayList;

import sqlite.DBManager;
import sqlite.sqlite;

import com.example.sqlitetestone.R;
import entity.userlogin;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private sqlite dbHelper;
	private SQLiteDatabase db;
	private Button Login,Reset;
	private EditText etUsername,etPassword;
	private DBManager dbm;
	btnOnclickListener btnjt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		dbm=new DBManager(this);
		dbHelper=new sqlite(this,"sqlTest.db", 1);
		initWidget();
		addClickListener();
	    initDbdata();
		
	}
	private void initDbdata(){
		ArrayList<userlogin>userloginArr=new ArrayList<userlogin>();
		userlogin p1=new userlogin("zz","123","0","");
		userloginArr.add(p1);
		userloginArr.add(new userlogin("zzz","123","0",""));
		dbm.add(userloginArr);
		
	}
	private void initWidget(){
		Login=(Button) this.findViewById(R.id.Login);
		Reset=(Button) this.findViewById(R.id.Reset);
		etUsername=(EditText) this.findViewById(R.id.etUsername);
		etPassword=(EditText) this.findViewById(R.id.etPassword);
	}
	private void addClickListener(){
		//对内部类监听进行实例化
		btnOnclickListener btnjt=new btnOnclickListener();
		Login.setOnClickListener(btnjt);
		Reset.setOnClickListener(btnjt);
	}
	
	private class btnOnclickListener implements OnClickListener{

	
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.Login:
				String strUsername=etUsername.getText().toString().trim();
				String strPassword=etPassword.getText().toString().trim();
				String sql="select *from userlogin where username=?";
				db=dbHelper.getReadableDatabase();
				db.execSQL(sql);
				Cursor c=db.rawQuery(sql,new String[]{strUsername});
				while(c.moveToNext()){
					String password=c.getString(c.getColumnIndex("password"));
					if(password==strPassword){
						System.out.println("登陆成功......");
						break;
					}
				}
				c.close();
				break;
			case R.id.Reset:
				etUsername.setText("");
				etPassword.setText("");
				break;
				default:
					break;
			}
			
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}

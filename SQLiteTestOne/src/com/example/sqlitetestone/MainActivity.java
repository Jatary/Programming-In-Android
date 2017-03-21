package com.example.sqlitetestone;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.example.sqlitetestone.common.ConstApp;
import com.example.sqlitetestone.dbSqlite.DBManager;
import com.example.sqlitetestone.dbSqlite.DBSQLiteHelper;
import com.example.sqlitetestone.entity.userlogin;
import com.example.sqlitetestone.network.HttpCommon;
import com.google.gson.Gson;

import android.app.Activity;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private DBManager dbm;

	private SQLiteDatabase db;
	private DBSQLiteHelper dbHelper;

	private Button btnLogin, btnReset;
	private EditText etUsername, etPassword;

	SharedPreferences sp;
	SharedPreferences.Editor spEditor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// SharedPreferences缓存文件ulogin
		sp = getSharedPreferences("ulogin", MODE_WORLD_WRITEABLE);

		// 调用DBManager类：数据库管理的常用方法
		dbm = new DBManager(this);

		// SQLite数据库的创建与初始化
		// dbHelper=new DBSQLiteHelper(this,"sqlTest.db",1);
		// db=dbHelper.getReadableDatabase();

		initDbData();

		// 控件的声明与注册
		initWidget();
		// 调用事件监听器
		addClickListener();

	}

	// 数据库：初始化数据
	private void initDbData() {
		// db=dbHelper.getReadableDatabase();
		/*
		 * String strName="u1"; String strPwd="123456"; String strNum="0";
		 * String strDatetime=""; String
		 * sql="insert into userlogin(username,password,loginNum,loginDatetime) values('"
		 * +strName+"','"+strPwd+"','"+strNum+"','"+strDatetime+"')";
		 * db.execSQL(sql);
		 */

		ArrayList<userlogin> uloginArr = new ArrayList<userlogin>();
		userlogin u1 = new userlogin("u1", "123456", 0, "");
		uloginArr.add(u1);
		uloginArr.add(new userlogin("u2", "123456", 0, ""));

		dbm.add(uloginArr);
	}

	// 控件的注册
	private void initWidget() {
		btnLogin = (Button) this.findViewById(R.id.btnLogin);
		btnReset = (Button) this.findViewById(R.id.btnReset);

		etUsername = (EditText) this.findViewById(R.id.etUsername);
		etPassword = (EditText) this.findViewById(R.id.etPassword);

	}

	// 监听器：监听所有事件的相关操作
	private void addClickListener() {
		// 对内部类监听进行实例化
		btnOnClickListener btncol = new btnOnClickListener();

		// 给按钮控件绑定事件
		btnLogin.setOnClickListener(btncol);
		btnReset.setOnClickListener(btncol);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if (db != null && db.isOpen()) {
			db.close();
		}
	}

	// 内部类
	private class btnOnClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.btnLogin:

				String strUname = etUsername.getText().toString().trim();
				String strPwd = etPassword.getText().toString().trim();

				SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
				Date curDate = new Date(System.currentTimeMillis());// 获取系统当前时间
				// Date currentDate=new Date();
				String strDate = formatter.format(curDate);

				String getStrUsername = sp.getString("uname", "");
				final userlogin inputUser = new userlogin();
				inputUser.setUsername(strUname);
				inputUser.setPassword(strPwd);

				if ((getStrUsername == null) || (getStrUsername.equals(""))) {
					// 从SQLite数据库访问中进行登录验证

					if (dbm.checkLogin(inputUser)) {
						System.out.println("---------------------------------");
						inputUser.setLoginDatetime(strDate);
						userlogin returnUdata = dbm.updateUserloginLog(inputUser);

						// 登录成功之后，把数据写入到SharedPreferences缓存文件ulogin中
						spEditor = sp.edit();// 开启写入功能

						spEditor.putString("uname", strUname);
						spEditor.putString("upwd", strPwd);
						spEditor.putInt("loginNum", returnUdata.getLoginNUm());
						spEditor.putString("loginDatetime", strDate);

						spEditor.commit();// 提交数据

					} else {
						System.out.println("============================");
						// 请求访问网络--服务器
						new Thread() {
							public void run() {
								Gson postJson = new Gson();
								String strJson = postJson.toJson(inputUser);
								String returnData = HttpCommon
										.HttpInternet(ConstApp.HttpServerUrl + "/UserLoginCheckForAndroid", strJson);

								System.out.println("从服务器获取数据：" + returnData);
							}
						}.start();
					}
				} else {

					// 从SharedPreferences缓存文件ulogin中进行登录验证
					String getStrPassword = sp.getString("upwd", null);
					if (getStrUsername.equals(strUname) && getStrPassword.equals(strPwd)) {
						Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
					} else {
						// 请求访问网络--服务器
						new Thread() {
							public void run() {
								Gson postJson = new Gson();
								String strJson = postJson.toJson(inputUser);
								String returnData = HttpCommon
										.HttpInternet(ConstApp.HttpServerUrl + "/UserLoginCheckForAndroid", strJson);

								System.out.println("从服务器获取数据：" + returnData);
							}
						}.start();
					}
				}

				// String sql="select * from userlogin where
				// username='"+strUname+"' and password='"+strPwd+"'";
				/*
				 * String
				 * sql="select * from userlogin where username=? and password=?"
				 * ; Cursor c=db.rawQuery(sql, new String[]{strUname,strPwd});
				 * if(c.moveToNext()){ System.out.println("登录成功。。。"); }else{
				 * System.out.println("登录失败。。。"); } c.close();
				 */

				// db=dbHelper.getReadableDatabase();
				/*
				 * String sql="select * from userlogin where username=?"; Cursor
				 * c=db.rawQuery(sql, new String[]{strUname});
				 * while(c.moveToNext()){ String pwd=
				 * c.getString(c.getColumnIndex("password"));
				 * if(pwd.equals(strPwd)){ System.out.println("登录成功。。。"); break;
				 * }else{ System.out.println(pwd+"==="+strPwd); } }
				 */

				break;
			case R.id.btnReset:
				// 数据初始化：输入框数据清空
				etUsername.setText("");
				etPassword.setText("");
				break;
			default:
				break;
			}

		}

	}
}

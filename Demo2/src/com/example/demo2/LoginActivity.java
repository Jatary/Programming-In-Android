package com.example.demo2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends Activity {
	Button btnLogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
	
	//ע���¼��ť�ؼ�
	btnLogin=(Button) this.findViewById(R.id.btnlogin);
	//������¼��ť�ؼ�
	btnLogin.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//��Ϣ��������˾
			Toast.makeText(LoginActivity.this,"��ӭ�㣡", Toast.LENGTH_LONG).show();
			
			//Activity֮����л�
			Intent inten =new Intent(LoginActivity.this,MainActivity.class);
			startActivity(inten);
			
		}
	});
}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}

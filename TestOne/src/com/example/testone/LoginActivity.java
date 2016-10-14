package com.example.testone;



import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	Button login;
	EditText et_psd,et_name;
	InputMethodManager imm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
		et_psd=(EditText)findViewById(R.id.et_psd);
		et_name=(EditText)findViewById(R.id.et_name);
		login=(Button)findViewById(R.id.login);
		login.setOnClickListener(new View.OnClickListener(){
		
				

			@Override
			public void onClick(View v) {
				imm.hideSoftInputFromWindow(et_name.getWindowToken(), 0);
				imm.hideSoftInputFromWindow(et_psd.getWindowToken(), 0);
				
				String inputet_name=et_name.getText().toString();
				String inputet_psd=et_psd.getText().toString();
				if((inputet_name.trim().equals("name"))&&(inputet_psd.trim().equals("psd")))
				{
			
			Toast.makeText(LoginActivity.this, "登陆成功！欢迎使用MusicPlay！", Toast.LENGTH_LONG).show();
			Intent intent=new Intent(LoginActivity.this,MusicPlayActivity.class);
			intent.putExtra("act", "login");
			Bundle bundle=new Bundle();
			bundle.putString("et_name", inputet_name);
			bundle.putString("et_psd", inputet_psd);
			intent.putExtra("bundle", bundle);
			startActivity(intent);
			finish();
			
			
		}				
			}
	
});


}
			protected void killProcessActivity() {
		// TODO Auto-generated method stub
		
	}
		

			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}

			
		
		;
		


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}

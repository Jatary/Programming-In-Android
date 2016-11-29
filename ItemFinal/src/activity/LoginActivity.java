package activity;

import com.example.mainactivity.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	Button btnlogin;
	EditText etpassword,etnumber;
	InputMethodManager imm;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
		etpassword=(EditText)findViewById(R.id.etpassword);
		etnumber=(EditText)findViewById(R.id.etnumber);
		btnlogin=(Button)findViewById(R.id.btnlogin);
		btnlogin.setOnClickListener(new View.OnClickListener(){
		
				

			@Override
			public void onClick(View v) {
				imm.hideSoftInputFromWindow(etnumber.getWindowToken(), 0);
				imm.hideSoftInputFromWindow(etpassword.getWindowToken(), 0);
				
				String inputet_name=etnumber.getText().toString();
				String inputet_psd=etpassword.getText().toString();
				if((inputet_name.trim().equals("1467005034"))&&(inputet_psd.trim().equals("1467005034")))
				{
			
			Toast.makeText(LoginActivity.this, "登陆成功！欢迎使用校园信息发布平台！", Toast.LENGTH_LONG).show();
			Intent intent=new Intent(LoginActivity.this,MainActivity.class);
			intent.putExtra("act", "login");
			Bundle bundle=new Bundle();
			bundle.putString("etnumber", inputet_name);
			bundle.putString("etpassword", inputet_psd);
			intent.putExtra("bundle", bundle);
			startActivity(intent);
			finish();
			
			
		}				
			}
	
});
		AssetManager mgr=getAssets();//得到AssetManager
		Typeface tf=Typeface.createFromAsset(mgr, "fonts/YGYXSZITI2.0.TTF");//根据路径得到Typeface
		btnlogin.setTypeface(tf);


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
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

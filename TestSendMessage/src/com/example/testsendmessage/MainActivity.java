package com.example.testsendmessage;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	EditText et_number,et_text;
	Button btn1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et_number=(EditText) this.findViewById(R.id.et_number);
		et_text=(EditText) this.findViewById(R.id.et_text);
		btn1=(Button) this.findViewById(R.id.btn1);
		btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String mobile=et_number.getText().toString();
				String content=et_text.getText().toString();
				Intent intent=new Intent();
				intent.setData(Uri.parse("smsto:"+mobile));
				intent.putExtra("sms_body",content);
				startActivity(intent);
				// TODO Auto-generated method stub
				
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

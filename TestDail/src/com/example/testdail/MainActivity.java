package com.example.testdail;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	EditText et_number;
	Button str_call;
   


	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et_number=(EditText) this.findViewById(R.id.et_number);
		str_call=(Button) this.findViewById(R.id.str_call);
		str_call.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				Uri uri=Uri.parse("tel:"+et_number.getText().toString());
				Intent intent=new Intent(Intent.ACTION_CALL,uri);
				MainActivity.this.startActivity(intent);
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

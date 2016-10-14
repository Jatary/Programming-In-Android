package com.example.editorsecond;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button red,green,blue;
	private TextView testText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView html=(TextView)findViewById(R.id.textView1);
		html.setText(Html.fromHtml("欢迎参加<font color=green>"+"手机软件设计赛</font>"));
		testText=(TextView)findViewById(R.id.textView3);
		red=(Button)findViewById(R.id.red);
		green=(Button)findViewById(R.id.green);
		blue=(Button)findViewById(R.id.blue);
		ColorListner myColorListner =new ColorListner();
		red.setOnClickListener(myColorListner);
		green.setOnClickListener(myColorListner);
		blue.setOnClickListener(myColorListner);
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public class ColorListner implements OnClickListener{
		public void onClick(View v){
			switch(v.getId()){
			case R.id.red:
				testText.setTextColor(Color.RED);
				Toast.makeText(MainActivity.this, "变红色", 
						Toast.LENGTH_SHORT).show();
				break;
			case R.id.blue:
				testText.setTextColor(Color.BLUE);
				Toast.makeText(MainActivity.this, "变蓝色", 
						Toast.LENGTH_SHORT).show();break;
			case R.id.green:
				testText.setTextColor(Color.GREEN);
				Toast.makeText(MainActivity.this, "变绿色", 
						Toast.LENGTH_SHORT).show();break;
				
				default : break;
			}
		}
	}
	


}

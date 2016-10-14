package com.example.editor;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private Button red,green,blue;
	public TextView testText;
	private Button big,small;
	public float size;
	private Button bold,italic,moren;
	
	public int flag=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		testText=(TextView)findViewById(R.id.testText);
		red=(Button)findViewById(R.id.red);
		green=(Button)findViewById(R.id.green);
		blue=(Button)findViewById(R.id.blue);
		ColorListner myColorListner =new ColorListner();
		red.setOnClickListener(myColorListner);
		green.setOnClickListener(myColorListner);
		blue.setOnClickListener(myColorListner);
		big=(Button)findViewById(R.id.bigger);
		small=(Button)findViewById(R.id.smaller);
		SizeListener mySizeListner=new SizeListener(testText);
		big.setOnClickListener(mySizeListner);
		small.setOnClickListener(mySizeListner);
		testText.setTypeface(Typeface.DEFAULT);
		bold=(Button)findViewById(R.id.bold);
		italic=(Button)findViewById(R.id.italic);
		moren=(Button)findViewById(R.id.moren);
		italic.setOnClickListener(this);
		bold.setOnClickListener(this);
		moren.setOnClickListener(this);
		}
		public void onClick(View v){
			switch(v.getId()){
			case R.id.bold:
				if(flag==2||flag==3){
					testText.setTypeface(Typeface.MONOSPACE,Typeface.BOLD_ITALIC);
					flag=3;
				}else{
					testText.setTypeface(Typeface.MONOSPACE,Typeface.ITALIC);
					flag=1;
				}break;
			case R.id.italic:
				if(flag==1||flag==3){
					testText.setTypeface(Typeface.MONOSPACE,Typeface.BOLD_ITALIC);
					flag=3;
				}else{
					testText.setTypeface(Typeface.MONOSPACE,Typeface.BOLD);
					flag=2;
				}break;
			case R.id.moren:
				testText.setTypeface(Typeface.MONOSPACE,Typeface.NORMAL);
				flag=0;
				break;
				default:break;
			}
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


	

		



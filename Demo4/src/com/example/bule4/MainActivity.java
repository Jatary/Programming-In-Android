package com.example.bule4;


import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button btn_clear,btn_back,btn_chu,btn_cheng,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,
	btn_8,btn_9,btn_point,btn_0,btn_kuahao,btn_equal;
	EditText etResult;
	String TAG="MainActivity";
	Boolean flag=false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		registerControl();
		addClickListener();
	}
	
	public void registerControl(){
		btn_clear=(Button)findViewById(R.id.btn_clear);
		btn_back=(Button)findViewById(R.id.btn_back);
		btn_chu=(Button)findViewById(R.id.btn_chu);
		btn_cheng=(Button)findViewById(R.id.btn_cheng);
		btn_1=(Button)findViewById(R.id.btn_1);
		btn_2=(Button)findViewById(R.id.btn_2);
		btn_3=(Button)findViewById(R.id.btn_3);
		btn_4=(Button)findViewById(R.id.btn_4);
		btn_5=(Button)findViewById(R.id.btn_5);
		btn_6=(Button)findViewById(R.id.btn_6);
		btn_7=(Button)findViewById(R.id.btn_7);
		btn_8=(Button)findViewById(R.id.btn_8);
		btn_9=(Button)findViewById(R.id.btn_9);
		btn_0=(Button)findViewById(R.id.btn_0);
		btn_point=(Button)findViewById(R.id.btn_point);
		btn_kuahao=(Button)findViewById(R.id.btn_kuahao);
		btn_equal=(Button)findViewById(R.id.btn_equal);
		etResult=(EditText)findViewById(R.id.etResult);
	}
	public void addClickListener(){
		ClickListener myClickListener=new ClickListener(); 
		btn_clear.setOnClickListener(myClickListener);
		btn_back.setOnClickListener(myClickListener);
		btn_chu.setOnClickListener(myClickListener);
		btn_cheng.setOnClickListener(myClickListener);
		btn_1.setOnClickListener(myClickListener);
		btn_2.setOnClickListener(myClickListener);
		btn_3.setOnClickListener(myClickListener);
		btn_4.setOnClickListener(myClickListener);
		btn_5.setOnClickListener(myClickListener);
		btn_6.setOnClickListener(myClickListener);
		btn_7.setOnClickListener(myClickListener);
		btn_8.setOnClickListener(myClickListener);
		btn_9.setOnClickListener(myClickListener);
		btn_0.setOnClickListener(myClickListener);
		btn_point.setOnClickListener(myClickListener);
		btn_kuahao.setOnClickListener(myClickListener);
		btn_equal.setOnClickListener(myClickListener);
	}
	
	private class ClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
		switch (v.getId()){
		case R.id.btn_1:
			Log.i(TAG,"value: 1");
			Toast.makeText(MainActivity.this, "欢迎您！", 
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.btn_2:
			Log.i(TAG,"value: 2");
			gengerateBDS("2");
			break;
		case R.id.btn_3:
			Log.i(TAG,"value: 3");
			gengerateBDS("3");
			break;
		case R.id.btn_4:
			Log.i(TAG,"value: 4");
			gengerateBDS("4");
			break;
		case R.id.btn_5:
			Log.i(TAG,"value: 5");
			gengerateBDS("5");
			break;
		case R.id.btn_6:
			Log.i(TAG,"value: 6");
			gengerateBDS("6");
			break;
		case R.id.btn_7:
			Log.i(TAG,"value: 7");
			gengerateBDS("7");
			break;
		case R.id.btn_8:
			Log.i(TAG,"value: 8");
			gengerateBDS("8");
			break;
		case R.id.btn_9:
			Log.i(TAG,"value: 9");
			gengerateBDS("9");
			break;
		case R.id.btn_0:
			Log.i(TAG,"value: 0");
			gengerateBDS("0");
			break;
		case R.id.btn_jia:
			Log.i(TAG,"value: +");
			//calBDS("+");
			break;
		case R.id.btn_jian:
			Log.i(TAG,"value: -");
			//calBDS("-");
			break;
		case R.id.btn_cheng:
			Log.i(TAG,"value: *");
			//calBDS("*");
			break;
		case R.id.btn_chu:
			Log.i(TAG,"value: /");
			//calBDS("/");
			break;
		case R.id.btn_point:
			Log.i(TAG,"value: .");
			break;
		case R.id.btn_clear:
			etResult.setText("");
			break;
		case R.id.btn_equal:
			String result=Caculator.caculateFromString(etResult.getText().toString());
			Toast.makeText(getApplication(),result , Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
		}
	}	

	

	private void gengerateBDS(String str){
		String oldStr="";
		oldStr=etResult.getText().toString();
		if(oldStr.equals("")||oldStr=="" || oldStr.length()==0 ){
			etResult.setText(str);
		}else if(oldStr.equals("0")){
			etResult.setText(str);
		}else{
			etResult.setText(oldStr+str);
		}
	}
	
	// 响应运算符的事件操作
	private void calBDS(String str){
		String oldStr="";// null
		oldStr=etResult.getText().toString();
		boolean flag = false;
		if(flag){
			// 防止运算符叠加
		}else{
			if(str.equals("×")||str.equals("÷")){
				etResult.setText("("+oldStr+")"+str);
			}else{
				etResult.setText(oldStr+str);
			}
			flag=true;
		}		
	}
	
	

			
	
	
	// 响应运算符的事件操作
	

		
		
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

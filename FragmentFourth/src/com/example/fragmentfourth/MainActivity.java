package com.example.fragmentfourth;
import fragment.FragmentFirst;
import fragment.FragmentSecond;
import fragment.FragmentSecond.ITF;
import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements ITF {
	Button Click1,Click2,Click3,Click4;
	TextView fragmentfirst,main;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Click1=(Button) this.findViewById(R.id.Click1);
		Click2=(Button) this.findViewById(R.id.Click2);
		Click3=(Button) this.findViewById(R.id.Click3);
		Click4=(Button) this.findViewById(R.id.Click4);
		FragmentFirst ff=new FragmentFirst();
		
	    final FragmentManager fm = getFragmentManager();
	    FragmentTransaction ffft=fm.beginTransaction();
	    
	    Bundle arg1=new Bundle();
	    arg1.putString("ff","例子");
	    ff.setArguments(arg1);
	    
	   
	    
	    ffft.add(R.id.fragment, ff,"first");
	    ffft.addToBackStack(null);
	    ffft.commit();
	    Click1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentSecond fs=new FragmentSecond();
				FragmentTransaction fsft=fm.beginTransaction();
				
				 Bundle file=new Bundle();
					file.putString("fs","传递");
					fs.setArguments(file);
				
				fsft.add(R.id.fragment,fs);
				fsft.addToBackStack(null);
				fsft.commit();
				
			}
		});
	    Click2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentFirst ff=(FragmentFirst) fm.findFragmentByTag("first");
				fragmentfirst=(TextView) fm.findFragmentByTag("first").getView().findViewById(R.id.fragmentfirst);
				fragmentfirst.setText("书上例子");
				
				
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void changActivity(String data) {
		// TODO Auto-generated method stub
		main=(TextView) this.findViewById(R.id.main);
		main.setText(data);
		
	}

}

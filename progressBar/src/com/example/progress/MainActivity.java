package com.example.progress;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	private ProgressBar progress;
	private Button add,reduce,reset;
	private TextView text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		add=(Button) findViewById(R.id.add);
		reduce=(Button) findViewById(R.id.reduce);
		reset=(Button) findViewById(R.id.reset);
		text=(TextView) findViewById(R.id.text);
		progress=(ProgressBar) findViewById(R.id.chang);
		int first=progress.getProgress();
		int second=progress.getSecondaryProgress();
		int max=progress.getMax();
		text.setText("第一进度百分比："+(int)(first/(float)max*100)+"% 第二进度百分比："+(int)(second/(float)max*100)+"%");
		add.setOnClickListener(this);
		reduce.setOnClickListener(this);
		reset.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.add:{
			progress.incrementProgressBy(10);
			progress.incrementSecondaryProgressBy(10);
			break;
		}
		case R.id.reduce:{
			progress.incrementProgressBy(-10);
			progress.incrementSecondaryProgressBy(-10);
			break;
		}
		case R.id.reset:{
			progress.setProgress(0);
			progress.setSecondaryProgress(0);
			break;
		}
		
		}
		text.setText("第一进度百分比："+(int)(progress.getProgress()/(float)progress.getMax()*100)+"% 第二进度百分比："+(int)(progress.getSecondaryProgress()/(float)progress.getMax()*100)+"%");
	}
	

}

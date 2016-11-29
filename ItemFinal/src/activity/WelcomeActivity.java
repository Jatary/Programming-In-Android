package activity;

import com.example.mainactivity.R;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends Activity {
	private Button btngo,btnpass;
	private TextView tvwelcome;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome1);
		//设置字体样式
		   
		 //
		btngo=(Button) this.findViewById(R.id.btngo);
		btnpass=(Button) this.findViewById(R.id.btnpass);
		btngo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(WelcomeActivity.this,LoginActivity.class);
				startActivity(intent);
				
			}
		});
		btnpass.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(WelcomeActivity.this,MainActivity.class);
				startActivity(intent);
				
			}
		});
		tvwelcome=(TextView) this.findViewById(R.id.tvwelcome);
		AssetManager mgr=getAssets();//得到AssetManager
		Typeface tf=Typeface.createFromAsset(mgr, "fonts/YGYXSZITI2.0.TTF");//根据路径得到Typeface
		tvwelcome.setTypeface(tf);
		btngo.setTypeface(tf);
		btnpass.setTypeface(tf);//设置字体

		
	}

}

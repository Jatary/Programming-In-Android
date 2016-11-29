package activity;

import com.example.mainactivity.R;

import fragment.FragmentShetuan;
import fragment.FragmentXuexi;
import fragment.FragmentZixun;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
	private FragmentZixun ZixunFragment;
	private FragmentShetuan ShetuanFragment;
	private View ZixunFragmentLayout;
	private View ShetuanFragmentLayout;
	

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initviews();
	}

	private void initviews() {
		// TODO Auto-generated method stub
		ZixunFragmentLayout=this.findViewById(R.id.layout_zixun);
		ZixunFragmentLayout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			FragmentZixun fz=new FragmentZixun();
		    FragmentManager fm=getSupportFragmentManager();//getSupportFragmentManager()
			FragmentTransaction fzft=fm.beginTransaction();
			fzft.add(R.id.fMain,fz);
			fzft.addToBackStack(null);
			fzft.commit();
			
				//Intent intent=new Intent();
				//intent.setClass(MainActivity.this,FragmentZixun.class);
				//startActivity(intent);
			}
			
			
		});
		
		ShetuanFragmentLayout=this.findViewById(R.id.layout_shetuan);
		ShetuanFragmentLayout.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentZixun fz=new FragmentZixun();
				FragmentShetuan fs=new FragmentShetuan();
			    FragmentManager fm=getSupportFragmentManager();//getSupportFragmentManager()
				FragmentTransaction fzft=fm.beginTransaction();
				fzft.add(R.id.fMain,fs);
				fzft.addToBackStack(null);
				fzft.commit();
				
			}
		
		});
		
	       ImageView sousuo=(ImageView) findViewById(R.id.sousuo);
	       sousuo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Intent intent=new Intent(MainActivity.this,SouSuoActivity.class);
			startActivity(intent);
				
			}
		});
	       ImageView imageshida=(ImageView) this.findViewById(R.id.imageshida);
	       imageshida.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this,WelcomeActivity.class);
				startActivity(intent);
				
			}
		});
			
		
		return;
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

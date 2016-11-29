package activity;

import com.example.mainactivity.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class SouSuoActivity extends Activity {
	AutoCompleteTextView Auto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sousuo);
		String[]books=new String[]{"Android开发平台之旅","Android开发案例驱动教程","Android揭秘","x肖鑫平是傻逼","x肖鑫平爱吃翔粑粑","x小心使得万年船"};
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,books);
		Auto=(AutoCompleteTextView) findViewById(R.id.Auto);
		Auto.setAdapter(adapter);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


}

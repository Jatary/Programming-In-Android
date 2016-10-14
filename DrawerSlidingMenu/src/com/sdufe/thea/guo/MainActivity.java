package com.sdufe.thea.guo;

import java.util.ArrayList;
import java.util.List;

import com.sdufe.thea.guo.adapter.MenuAdapter;
import com.sdufe.thea.guo.model.Menu;

import android.os.Bundle;
import android.widget.ListView;
import android.app.Activity;

public class MainActivity extends Activity {
	
	List<Menu> list;
	MenuAdapter adapter;
	ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initData();
		adapter=new MenuAdapter(list, this);
		listView=(ListView) findViewById(R.id.listview);
		listView.setAdapter(adapter);
	}

	private void initData() {
		list=new ArrayList<Menu>();
		list.add(new Menu(R.drawable.medicalcheck2, "����"));
		list.add(new Menu(R.drawable.mypatient_selected, "����"));
		list.add(new Menu(R.drawable.mywork_selected, "ͼƬ"));
		list.add(new Menu(R.drawable.nurse_evaluate2, "��Ƶ"));
		list.add(new Menu(R.drawable.nurse_visit2, "����"));
		list.add(new Menu(R.drawable.nursingcareplan2, "ͶƱ"));
	}


}

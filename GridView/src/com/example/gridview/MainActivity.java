package com.example.gridview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener{
	private GridView gridView;
	private SimpleAdapter adapter;
	private List<Map<String,Object>>list;
	private int[]icon={R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5,R.drawable.p6,R.drawable.p7,
			R.drawable.p8,R.drawable.p9};
	private String[]text={"风景1","风景2","风景3","风景4","风景5","风景6","风景7","风景8","风景9",};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		gridView=(GridView) findViewById(R.id.gridView);
		list=new ArrayList<Map<String,Object>>();
		adapter=new SimpleAdapter(this, data(), R.layout.item,new String[]{"image","text"}, new int[]{R.id.image,R.id.text});
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(this);
	}

	private List<Map<String,Object>> data(){
		// TODO Auto-generated method stub
		for(int i=0;i<text.length;i++){
		Map<String,Object>map=new HashMap<String, Object>();
		map.put("image", icon[i]);
		map.put("text", text[i]);
		list.add(map);
		}
		return list;
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Toast.makeText(this,"我是"+text[arg2],Toast.LENGTH_SHORT).show();
		setTitle("我是"+text[arg2]);
		
	}

}

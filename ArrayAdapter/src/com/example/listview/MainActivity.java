package com.example.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class MainActivity extends Activity {
	private ListView listView;
	private ArrayAdapter arr_adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		listView=(ListView) findViewById(R.id.listView);
		String[] data={"ѧϰ��һ��","ѧϰ��һ��","ѧϰ��һ��","ѧϰ��һ��"};
		arr_adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,data);
		//ArrayAdapter ��һ��������this��:������
		//�ڶ����������Դ���listview�Ĳ��ָ�ʽ
		//����������������Դ
		listView.setAdapter(arr_adapter);
		//listview��������
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

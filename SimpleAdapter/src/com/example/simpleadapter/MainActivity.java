package com.example.simpleadapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener,OnScrollListener{
	private SimpleAdapter simpleadapter;
	private ListView listView;
	private List<Map<String,Object>>list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		listView=(ListView) findViewById(R.id.listView);
		list=new ArrayList<Map<String,Object>>();
		simpleadapter=new SimpleAdapter(this,data(),R.layout.item,new String[]{"pic","study"}, new int[]{R.id.pic,R.id.study});
		//simpleadapter ��һ��������������
		//�ڶ�������������Դ
		//��������������Ӧ�Ĳ����ļ�
		//���ĸ����������������������Ӧ
		//����������������е�ID
		listView.setAdapter(simpleadapter);
		listView.setOnItemClickListener(this);
		listView.setOnScrollListener(this);
	}
	private List<Map<String,Object>> data(){
		for(int i=0;i<20;i++){
			Map<String,Object>map=new HashMap<String,Object>();
			map.put("pic",R.drawable.ic_launcher);
			map.put("study", "ѧϰ��һ��"+i);
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
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// TODO Auto-generated method stub
		switch(scrollState){
		case SCROLL_STATE_FLING:
			Log.i("text","��ָ���뿪��Ļ֮ǰ��������һ�£���ͼ���ڹ��Լ�������");
			Map<String,Object>map=new HashMap<String, Object>();
			map.put("pic", R.drawable.ic_launcher);
			map.put("study", "�»���������");
			list.add(map);
			simpleadapter.notifyDataSetChanged();
			//֪ͨUI�߳�ͬʱ�ı�
			break;
		case SCROLL_STATE_IDLE:
			Log.i("text","��ͼֹͣ����");
			break;
		case SCROLL_STATE_TOUCH_SCROLL:
			Log.i("text","��ָû���뿪��Ļ����ͼ���ڻ���");
			break;
		}
		
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int i, long arg3) {
		// TODO Auto-generated method stub
		String text=listView.getItemAtPosition(i)+"";
		Toast.makeText(this, "����ɹ�"+i+"text"+text,Toast.LENGTH_SHORT).show();
		
		
	}

}

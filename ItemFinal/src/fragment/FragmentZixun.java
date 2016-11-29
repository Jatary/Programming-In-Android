package fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.mainactivity.R;

import entity.news;

import activity.MainActivity;
import adapter.newslistAdapter;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class FragmentZixun extends Fragment {
	private List<news> data = new ArrayList<news>();
	private ListView newsList;
	
	private newslistAdapter mlAdapter;
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
  View view=inflater.inflate(R.layout.fragment_zixun,container, false);
		
		return view;
	}

	
	

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initData();
		
		initView();
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
	}

	private void initData() {

		for (int i = 0; i < 30; i++) {
			news msg = null;
			msg = new news(R.drawable.xijinping,"ϰ��ƽ�����ݽ�", "Ф��ƽɵ��ϲ���������Σ�", "����10:20");
			//msg.setIcon_id(R.drawable.wechat_icon);

			data.add(msg);
		}
	}
	
	private void initView(){
		newsList=(ListView) getActivity().findViewById(R.id.listview_zixun);
		mlAdapter=new newslistAdapter(getActivity(),data);
		newsList.setAdapter(mlAdapter);
		
		newsList.setOnItemClickListener(new OnItemClickListener(){

			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				
				System.out.println("test..........");
				
				//ʵ��������Fragment  
                FragmentNewsShow detailFragment = new FragmentNewsShow();
                                
				//��ѡ�е�item�����ݷŵ�Bundle�����У�Ȼ��ŵ�Ҫ��ʾ��Ϣ�����Fragment�Ĳ�������
				//Object item = mAdapter.getItem(position);
                
                //���б�ҳ��ѡ�У�Ȼ�󴫵���Ҫ�Ĳ���������ҳ��
				Bundle args = new Bundle();
				args.putString("itemMessageTitle",data.get(position).getTitle());
				args.putString("itemMessageContent",data.get(position).getMsg());
				detailFragment.setArguments(args);
				
				FragmentManager fm = getFragmentManager(); 
				FragmentTransaction ftx = fm.beginTransaction();
				ftx.replace(R.id.fMain, detailFragment, "NewsToShow");  
		        ftx.addToBackStack(null);  
		        ftx.commit();
		        ftx.hide(detailFragment);
			}
		});
		
			
		}
	
		
	}



package com.example.registertest;

import android.os.Bundle;
import android.app.Activity;
import android.app.ExpandableListActivity;
import android.content.Intent;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChooseCityActivity extends ExpandableListActivity {
	private String[]provinces=new String[]{"江西","江苏","浙江"};
	private String[][]cities=new String[][]{{"南昌","九江","赣州","吉安",},
			{"南京","苏州","无锡","扬州"},{"杭州","温州","台州","金华"}};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
			ExpandableListAdapter adapter=new BaseExpandableListAdapter(){
				public Object getChild(int groupPosition,int childPosition){
					return cities[groupPosition][childPosition];										
				}
				public long getChildId1(int groupPosition,int childPosition){
					return childPosition;
				}
				public int getChildrenCount1(int groupPosition){
					return cities[groupPosition].length;
				}
				private TextView getTextView(){
					AbsListView.LayoutParams lp=new AbsListView.LayoutParams(
							ViewGroup.LayoutParams.MATCH_PARENT,64);
					TextView textView=new TextView(ChooseCityActivity.this);
					textView.setLayoutParams(lp);
					textView.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
					textView.setPadding(36,0,0,0);
					textView.setTextSize(20);
					return textView;
				}
				public View getChildView1(int groupPosition,int childPosition,
						boolean isLastChild,View converView,ViewGroup parent){
					TextView textView=getTextView();
					textView.setText(getChild(groupPosition,childPosition).toString());
					return textView;
				}
				public Object getGroup1(int groupPosition){
					return provinces[groupPosition];
				}
				 public int getGroupCount1(){
					return provinces.length;
				}
				public long getGroupId1(int groupPosition){
					return groupPosition;
				}
				public View getGroupView1(int groupPosition,boolean isExpanded,View convertView,ViewGroup parent){
					LinearLayout ll=new LinearLayout(ChooseCityActivity.this);
					ll.setOrientation(LinearLayout.VERTICAL);
					ImageView logo=new ImageView(ChooseCityActivity.this);
					ll.addView(logo);
					TextView textView=getTextView();
					textView.setText(getGroup(groupPosition).toString());
					ll.addView(textView);
					return ll;
				}
				public boolean isChildSelectable1(int groupPosition,int childPosition){
					return true;
				}
				@Override
				public long getChildId(int groupPosition, int childPosition) {
					// TODO Auto-generated method stub
					return 0;
				}
				@Override
				public View getChildView(int groupPosition, int childPosition,
						boolean isLastChild, View convertView, ViewGroup parent) {
					// TODO Auto-generated method stub
					return null;
				}
				@Override
				public int getChildrenCount(int groupPosition) {
					// TODO Auto-generated method stub
					return 0;
				}
				@Override
				public Object getGroup(int groupPosition) {
					// TODO Auto-generated method stub
					return null;
				}
				@Override
				public int getGroupCount() {
					// TODO Auto-generated method stub
					return 0;
				}
				@Override
				public long getGroupId(int groupPosition) {
					// TODO Auto-generated method stub
					return 0;
				}
				@Override
				public View getGroupView(int groupPosition, boolean isExpanded,
						View convertView, ViewGroup parent) {
					// TODO Auto-generated method stub
					return null;
				}
				@Override
				public boolean hasStableIds() {
					// TODO Auto-generated method stub
					return false;
				}
				@Override
				public boolean isChildSelectable(int groupPosition,
						int childPosition) {
					// TODO Auto-generated method stub
					return false;
				}
			};
			setListAdapter(adapter);
			getExpandableListView().setOnChildClickListener(
					new OnChildClickListener(){
						public boolean onChildClick(ExpandableListView parent,View source,
								int groupPosition,int childPosition,long id){
							Intent intent=getIntent();
							Bundle data=new Bundle();
							data.putString("city",cities[groupPosition][childPosition]);
							intent.putExtras(data);
							ChooseCityActivity.this.setResult(0,intent);
							ChooseCityActivity.this.finish();
							return false;
						}
					});
	}
	

				public long getChildId(int groupPosition, int childPosition) {
					// TODO Auto-generated method stub
					return 0;
				}

				public View getChildView(int groupPosition, int childPosition,
						boolean isLastChild, View convertView, ViewGroup parent) {
					// TODO Auto-generated method stub
					return null;
				}

				public int getChildrenCount(int groupPosition) {
					// TODO Auto-generated method stub
					return 0;
				}

				public Object getGroup(int groupPosition) {
					// TODO Auto-generated method stub
					return null;
				}

				public int getGroupCount() {
					// TODO Auto-generated method stub
					return 0;
				}

				public long getGroupId(int groupPosition) {
					// TODO Auto-generated method stub
					return 0;
				}

				public View getGroupView(int groupPosition, boolean isExpanded,
						View convertView, ViewGroup parent) {
					// TODO Auto-generated method stub
					return null;
				}

				public boolean hasStableIds() {
					// TODO Auto-generated method stub
					return false;
				}

				public boolean isChildSelectable(int groupPosition,
						int childPosition) {
					// TODO Auto-generated method stub
					return false;
				};
			
		
		
	

	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.choose_city, menu);
		return true;
	}

}

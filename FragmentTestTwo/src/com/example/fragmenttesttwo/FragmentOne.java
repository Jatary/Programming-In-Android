package com.example.fragmenttesttwo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentOne extends Fragment {
    
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.fragment_one, container, false);
		TextView tvFragmentShow1=(TextView) view.findViewById(R.id.tvFragmentShow1);
		Bundle bundle1 = getArguments();
		tvFragmentShow1.setText(bundle1.getString("frgOne"));
		
		Button btnFragment1=(Button) view.findViewById(R.id.btnFragment1);
		btnFragment1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				FragmentTwo frgTwo=new FragmentTwo();
				FragmentManager fm=getFragmentManager();
				FragmentTransaction tx = fm.beginTransaction();
				
				tx.replace(R.id.flContent,frgTwo,"Threee");
				tx.addToBackStack(null);
				tx.commit();
			}
		});
		
		return view;
	}

	
}

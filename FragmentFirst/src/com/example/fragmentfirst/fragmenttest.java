package com.example.fragmentfirst;

import java.util.zip.Inflater;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class fragmenttest extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		FragmentManager fragmentManager=getFragmentManager();
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.fragment_test, container);
	}

}

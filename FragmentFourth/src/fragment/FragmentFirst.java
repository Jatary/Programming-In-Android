package fragment;

import com.example.fragmentfourth.R;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import fragment.FragmentSecond;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentFirst extends Fragment {
	TextView fragmentfirst;
	Button Click3;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.fragment_first, container, false);
		fragmentfirst=(TextView) view.findViewById(R.id.fragmentfirst);
		Bundle bundle=getArguments();
		fragmentfirst.setText(bundle.getString("ff"));
		
		Click3=(Button) view.findViewById(R.id.Click3);
		Click3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentSecond fs=new FragmentSecond();
				FragmentManager fm=getFragmentManager();
				FragmentTransaction fsft=fm.beginTransaction();
				
				 Bundle file=new Bundle();
					file.putString("fs","´«µÝ");
					fs.setArguments(file);

			    fsft.add(R.id.fragment, fs);
			   fsft.addToBackStack(null);
			    fsft.commit();
			}
		});
		return view;
	}

	
	
}

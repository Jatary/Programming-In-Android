package fragment;
import com.example.fragmentfourth.R;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentSecond extends Fragment {
	TextView fragmentsecond;

	private ITF itf;
	
	public interface ITF{
		public void changActivity(String data);
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		itf=(ITF) activity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.fragment_second, container, false);
		fragmentsecond=(TextView) view.findViewById(R.id.fragmentsecond);
		Bundle bundle=getArguments();
		fragmentsecond.setText(bundle.getString("fs"));
		
		Button Click4=(Button) view.findViewById(R.id.Click4);
		Click4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				itf.changActivity("Ñþºþ");
			}
		});
		return view;
	}

	
}

package adapter;

import java.util.List;

import com.example.mainactivity.R;

import entity.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class newslistAdapter extends BaseAdapter {

	private Context mContext = null;
	private List<news> data;
	
	
	public newslistAdapter(Context mContext, List<news> data) {
		super();
		this.mContext = mContext;
		this.data = data;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
        if (convertView == null) {
            //convertView = LayoutInflater.from(mContext).inflate(R.layout.news_list, parent, false);
            
        	//获得布局加载器
			LayoutInflater inflater = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			//通过布局加载器得到显示每一条数据的布局
			convertView = inflater.inflate(
					R.layout.news_list, null);
			
            holder = new ViewHolder();
            
            holder.iv_icon = (ImageView) convertView.findViewById(R.id.iv_icon);
            holder.tv_title = (TextView)convertView.findViewById(R.id.tv_title);
            holder.tv_msg = (TextView)convertView.findViewById(R.id.tv_msg);
            holder.tv_time = (TextView)convertView.findViewById(R.id.tv_time);
            
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        
        news msg = data.get(position);
        
        holder.tv_title.setText(msg.getTitle());
        holder.tv_msg.setText(msg.getMsg());
        holder.tv_time.setText(msg.getTime());
        
        holder.iv_icon.setImageResource(msg.getIcon_id());
        
		return convertView;
	}
	
    static class ViewHolder {

        TextView tv_title;
        TextView tv_msg;
        TextView tv_time;
        ImageView iv_icon;
    }

}

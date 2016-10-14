package com.Android.testreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// 处理广播时间，始终都在监听，一旦事件发生，执行下面的代码：震动，声音，弹出屏幕等等
		Log.i("TAG","接受到广播，并已经处理！。。。。。");
		//Toast.makeText(context, "接受到广播，并已经处理！。。。。。", Toast.LENGTH_LONG).show();

	}

	//BroadcastReceiver的生命周期很短，不能有异步操作及耗时操作
}

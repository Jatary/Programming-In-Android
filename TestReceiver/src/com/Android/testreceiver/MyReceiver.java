package com.Android.testreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// ����㲥ʱ�䣬ʼ�ն��ڼ�����һ���¼�������ִ������Ĵ��룺�𶯣�������������Ļ�ȵ�
		Log.i("TAG","���ܵ��㲥�����Ѿ���������������");
		//Toast.makeText(context, "���ܵ��㲥�����Ѿ���������������", Toast.LENGTH_LONG).show();

	}

	//BroadcastReceiver���������ں̣ܶ��������첽��������ʱ����
}

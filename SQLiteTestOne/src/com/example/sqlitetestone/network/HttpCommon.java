package com.example.sqlitetestone.network;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class HttpCommon {

	//����������磬����������Map�����װ���ͳ�ȥ��ͬʱ�������ݾͷ������ݡ�
	public static String HttpInternet(String stringUrl,Map<String, String> data) {
			Set<String> keySet = data.keySet();
			String stringData = new String();
			for (String string : keySet) {
				stringData += string + "=" + data.get(string)+"&";
			}
			  
			//��URL�����ƴ��  
			HttpGet getMethod = new HttpGet(stringUrl + "?" + stringData);  
			HttpClient httpClient = new DefaultHttpClient();  
			try {  
			    HttpResponse response = httpClient.execute(getMethod); //����GET����  
			    
			    //Log.i("", "resCode = " + response.getStatusLine().getStatusCode()); //��ȡ��Ӧ��  
			    //Log.i("", "result = " + EntityUtils.toString(response.getEntity(), "utf-8"));//��ȡ��������Ӧ����  
			    return EntityUtils.toString(response.getEntity(), "utf-8");
			} catch (ClientProtocolException e) {  
			    e.printStackTrace();  
			} catch (IOException e) {  
			    e.printStackTrace();  
			}  
			
			return null;
		}
		
		//����������磬����������JSON��ʽ��װ���ͳ�ȥ��ͬʱ�������ݾͷ������ݡ�
	    public static String HttpInternet(String stringUrl,String data) {
	    	
			//��URL�����ƴ��  
			//HttpGet getMethod = new HttpGet(stringUrl + "?" + "json%3D"+"{'userName':'abc','password':'123','id':4}");
	    	//HttpGet getMethod = new HttpGet(stringUrl + "?" + "gson%3D" + data);
	    	//data=URLEncoder.encode(data);    	
			//Log.i("","data="+data);

	    	System.out.println("��������������ݣ�"+data);
	    	
	    	HttpPost getMethod=new HttpPost(stringUrl);
	    	List<BasicNameValuePair> sendData = new ArrayList<BasicNameValuePair>();
	    	sendData.add(new BasicNameValuePair("gson", data));
	    	try {
				getMethod.setEntity(new UrlEncodedFormEntity(sendData, 
						HTTP.UTF_8));
				//System.out.println(EntityUtils.toString(getMethod.getEntity()));
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	
	    	HttpClient httpClient = new DefaultHttpClient();  
			try {  
			    HttpResponse response = httpClient.execute(getMethod); //����GET����  
			    
			    //Log.i("", "resCode = " + response.getStatusLine().getStatusCode()); //��ȡ��Ӧ��  
			    //Log.i("", "result = " + EntityUtils.toString(response.getEntity(), "utf-8"));//��ȡ��������Ӧ����  
			    return EntityUtils.toString(response.getEntity(), "utf-8");
			} catch (ClientProtocolException e) {  
			    e.printStackTrace();  
			} catch (IOException e) {  
			    e.printStackTrace();  
			}  
			
			return null;
		}
}

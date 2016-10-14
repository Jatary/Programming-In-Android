package com.example.demoservicemusic.utils;

public class ConstUtil {
	//MusicService接收器所能响应的Action
	public static final String MusicServiceDoAction="com.example.demoservicemusic.doService";
	
	//服务要发送的一些Action
	
	//定义音乐的播放状态
	//0x10代表播放
	public static final int statusPlay=0x10;
	//0x11代表没有播放
	public static final int statusNoPlay=0x11;
	//0x12代表正在播放
	public static final int statusPlaying=0x12;
	//0x13代表暂停
	public static final int statusPausePlay=0x13;
	//0x14代表停止播放
	public static final int statusStopPlay=0x14;
	//0x15代表继续
	public static final int statusContinuePlay=0x15;
	//0x16代表下一首
	public static final int statusNext=0x16;
	//0x17代表上一首
	public static final int statusPrivious=0x17;
	//0x18代表进度改变
	public static final int statusProgressChange=0x18;
	
	public ConstUtil() {
		super();
		// TODO Auto-generated constructor stub
	}

}

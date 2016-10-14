package com.example.texteditor;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.Toast;

  public class MyButton extends Button{
	   private Context context;
	   public MyButton(Context context,AttributeSet attrs){
		   super(context,attrs);
		   this.context=context;
		   }
   public boolean onTouchEvent(MotionEvent event){
	   Toast.makeText(context,"MyButton 中触摸事件触发了！",Toast.LENGTH_SHORT).show();
	   return true;
	   
   }
  }
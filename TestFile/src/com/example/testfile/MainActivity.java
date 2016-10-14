package com.example.testfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	File destFile;
	Button read,write;
	EditText readText,writeText;
	private String fileName="content.txt";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		read=(Button) this.findViewById(R.id.read);
		write=(Button) this.findViewById(R.id.write);
		readText=(EditText) this.findViewById(R.id.readText);
		writeText=(EditText) this.findViewById(R.id.writeText);
		read.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				readText.setText(read());
				
			}
		});
write.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				write(writeText.getText().toString());
				
			}
		});
	}
   public void write(String content){
	   try{
		   FileOutputStream fos=openFileOutput(fileName,Context.MODE_APPEND);
		   PrintStream ps=new PrintStream(fos);
		   ps.print(content);
		   ps.close();
		   fos.close();
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	}
   public String read(){
	   StringBuilder sbBuilder=new StringBuilder("");
	   try{
		   FileInputStream is=openFileInput(fileName);
		   byte[]buffer=new byte[64];
		   int hasRead;
		   while((hasRead=is.read(buffer))!=-1){
			   sbBuilder.append(new String(buffer,0,hasRead));
		   }
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   return sbBuilder.toString();
	   
   }
   public void write11(String content){
		try{
			if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
				File sdCardDir=Environment.getExternalStorageDirectory();
		
				File destFile=new File(sdCardDir.getCanonicalPath()+File.separator+fileName);
				RandomAccessFile raf=new RandomAccessFile(destFile,"rw");
				raf.seek(destFile.length());
				raf.write(content.getBytes());
				raf.close();
			}
		}catch(Exception e){
		e.printStackTrace();
	}
}


public String read11(){
	StringBuilder sbBuilder=new StringBuilder("");
	try{
		if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
			File sdCard=Environment.getExternalStorageDirectory();
			File desFile=new File(sdCard.getCanonicalPath()+File.separator+fileName);
			
			FileInputStream fis=new FileInputStream(destFile);
			byte[]buffer=new byte[64];
			
			int hasRead;
			while((hasRead=fis.read(buffer))!=-1){
				sbBuilder.append(new String(buffer,0,hasRead));
			}
			return sbBuilder.toString();
		}
	}catch(Exception e){
		e.printStackTrace();
			}
	return null;
		}
	



	protected void write1(String string) {
		// TODO Auto-generated method stub
		
	}

	protected CharSequence read1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

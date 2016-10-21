package sqlite;

import java.util.ArrayList;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import entity.userlogin;

public class DBManager {
	private sqlite dbHelper;
	private SQLiteDatabase db;
	public DBManager(Context context){
		dbHelper=new sqlite(context, "sqlite.db", 1);
		db=dbHelper.getWritableDatabase();
	}
	

	public boolean add(ArrayList<userlogin> userloginArr) {
		// TODO Auto-generated method stub
		db.beginTransaction();
		
	try{
		for(userlogin p1:userloginArr){
			db.execSQL("insert into userlogin values(?,?,?,?)",new Object[]{null,p1.getName(),p1.getPassword(),p1.getLoginnum(),p1.getLogindatatime()});
			db.setTransactionSuccessful();
			return true;
		}
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			db.endTransaction();
		}
	return false;
		
	}
}

package sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class sqlite extends SQLiteOpenHelper {

	public sqlite(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, null, version);
		// TODO Auto-generated constructor stub
	}
	public sqlite(Context context, String name, 
			int version) {
		super(context, name,null, version);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		System.out.println("创建数据库中......");
		String CreateTableSql="Create table userlogin("
				+"id integer primary key autoincrement,"
				+"username varchar,"
				+"password varchar,"
				+"loginnum integer,"+"logindatetime text)";
		db.execSQL(CreateTableSql);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}

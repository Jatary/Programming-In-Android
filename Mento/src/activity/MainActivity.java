package activity;

import java.util.Calendar;

import splite.MyDatabaseHelper;

import com.example.mento.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button chooseDate,query,add;
	EditText subject,body,date;
	ListView result;
	LinearLayout title;
	SQLiteOpenHelper mydbHelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		chooseDate=(Button) this.findViewById(R.id.chooseDate);
		query=(Button) this.findViewById(R.id.query);
		add=(Button) this.findViewById(R.id.add);
		subject=(EditText) this.findViewById(R.id.subject);
		body=(EditText) this.findViewById(R.id.body);
		date=(EditText) this.findViewById(R.id.date);
		result = (ListView) findViewById(R.id.result);
		title=(LinearLayout)findViewById(R.id.title);
		title.setVisibility(View.INVISIBLE);
		chooseDate.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Calendar c=Calendar.getInstance();
				new DatePickerDialog(MainActivity.this,new DatePickerDialog.OnDateSetListener() {
					
					public void onDateSet(DatePicker view, int year, int month,
							int day) {
						// TODO Auto-generated method stub
						date.setText(year+"-"+(month+1)+"-"+day);
						
					}
				}, c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show();
				
			}
		});
		MyOnClickListener myOnClickListerner = new MyOnClickListener();
		add.setOnClickListener(myOnClickListerner);
		query.setOnClickListener(myOnClickListerner);
	}
	private class MyOnClickListener implements OnClickListener{
		MyDatabaseHelper mydbHelper;
		EditText title;
		ListView result;
		EditText subject,body,date;
		public void onClick(View v){
		 mydbHelper = new MyDatabaseHelper(MainActivity.this,"mememto.db",null,1);
		 SQLiteDatabase db=mydbHelper.getReadableDatabase();
		 String subStr=subject.getText().toString();
		 String bodyStr=body.getText().toString();
		 String dateStr=date.getText().toString();
		 switch(v.getId()){
		 case R.id.add:
			 title.setVisibility(View.INVISIBLE);
			 addMemento(db,subStr,bodyStr,dateStr);
			 Toast.makeText(MainActivity.this,"添加备忘录成功！",1000).show();
			 result.setAdapter(null);
			 break;
		 case R.id.query:
				title.setVisibility(View.VISIBLE);
				Cursor cursor = queryMemento(db, subStr, bodyStr, dateStr);
				SimpleCursorAdapter resultAdapter = new SimpleCursorAdapter(
						MainActivity.this, R.layout.activity_main, cursor,
						new String[] { "_id", "subject", "body", "date" },
						new int[] {R.id.subject,
								R.id.body, R.id.date });
				result.setAdapter(resultAdapter);
				break;
			default:
				break;
			}
		}
		public void addMemento(SQLiteDatabase db, String subject, String body,
				String date) {
			db.execSQL("insert into memento_tb values(null,?,?,?)", new String[] {
					subject, body, date });
			this.subject.setText("");
			 this.body.setText("");
			 this.date.setText("");
		}

		public Cursor queryMemento(SQLiteDatabase db, String subject, String body,
				String date) {
			Cursor cursor = db.rawQuery(
							"select * from memento_tb where subject like ? and body like ? and date like ?",
							new String[] { "%" + subject + "%", "%" + body + "%",
									"%" + date + "%" });
			return cursor;
		}
		
	}
	protected void onDestroy() {
		
		if(mydbHelper!=null){
			mydbHelper.close();
		}
	}
		 
		
		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

package testcase.T_sdcardWrite_getWriteDB;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;

public class MainActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		dataBase();
	}

	private void dataBase() {
		DatabaseHelper dbHelper = new DatabaseHelper(this,"/storage/sdcard0/test/dbHelper", 2);
		// 得到一个可写的SQLiteDatabase对象
		SQLiteDatabase sqliteDatabase = dbHelper.getWritableDatabase();
		String sql = "CREATE  TABLE test (_id INTEGER PRIMARY KEY , filename VARCHAR, data TEXT)";
		sqliteDatabase.execSQL(sql);
	}
} 
 
package testcase.T_sdcardRead_getReadDB_I;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

public class MainActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		dataBase();
	}

	private void dataBase() {
		try {
			DatabaseHelper dbHelper = new DatabaseHelper(this, "/mnt/sdcard/test/dbHelper", 2);
			// 得到一个可写的SQLiteDatabase对象
			SQLiteDatabase sqliteDatabase = dbHelper.getReadableDatabase();
			String sql = "select * from tablename";
			String result = "";
			Cursor mCursor = sqliteDatabase.rawQuery(sql, null);
			mCursor.moveToFirst();
			while (!mCursor.isAfterLast()) {
				result += "id: " + mCursor.getInt(0) + "   " + "filename: " + mCursor.getString(1)
						+ "\n";
				mCursor.moveToNext();
			}
			Log.e("testcastLog", result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

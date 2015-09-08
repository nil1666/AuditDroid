package testcase.T_sdcardRead_openOrCreateDB_I;

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
			String dirPath = Environment.getExternalStorageDirectory().getPath() + "/test/";
			SQLiteDatabase db = this.openOrCreateDatabase(dirPath + "contextWrapper", 3, null);
			String sql = "select * from test";
			String result = "";
			Cursor mCursor = db.rawQuery(sql, null);
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

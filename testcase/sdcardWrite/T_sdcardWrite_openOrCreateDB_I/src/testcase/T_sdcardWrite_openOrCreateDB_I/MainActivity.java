package testcase.T_sdcardWrite_openOrCreateDB_I;

import android.app.Activity;
import android.content.ContentValues;
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
		try {
			String dirPath = Environment.getExternalStorageDirectory().getPath() + "/test/";
			SQLiteDatabase db = this.openOrCreateDatabase(dirPath + "contextWrapper", 3, null);
			String sql = "CREATE  TABLE test (_id INTEGER PRIMARY KEY , filename VARCHAR, data TEXT)";
			db.execSQL(sql);
			ContentValues cv = new ContentValues();
			cv.put("_id", 1);
			cv.put("filename", "testfilename");  
			cv.put("data", " 测试我的数据库");  
			db.insert("test", null, cv); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
}

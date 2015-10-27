package testcase.T_openOrCreateDB_02;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class openDatabaseActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		String packageName=getPackageName();
		SQLiteDatabase mDatabase = openOrCreateDatabase(packageName+".db", Context.MODE_WORLD_READABLE, null);
		try {
			mDatabase.execSQL("create table  users ( _id integer primary key autoincrement, user varchar(10) not null,password varchar(10) not null);");
			mDatabase.execSQL("insert into users values('1','root','123456'),('2','root','111111'),('3','admin','123456')");
		} catch (Exception e) {
			Log.e("testcaseLog", "创建数据库失败，可能原因：已存在");
		}
		mDatabase.close();
	}
}
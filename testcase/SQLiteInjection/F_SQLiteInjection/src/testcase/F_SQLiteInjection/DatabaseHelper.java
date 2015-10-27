package testcase.F_SQLiteInjection;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	public static final String TB_NAME = "usertable";

	public static final String ID = "_id";

	public static final String USERNAME = "username";

	public static final String PASSWORD = "password";

	public DatabaseHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE IF NOT EXISTS " + TB_NAME + " (" + ID + " INTEGER PRIMARY KEY," + USERNAME
				+ " VARCHAR," + PASSWORD + " VARCHAR )");

		db.execSQL("INSERT INTO " + TB_NAME + "(" + USERNAME + "," + PASSWORD + ") VALUES"
				+ "('admin','admintest')");
		db.execSQL("INSERT INTO " + TB_NAME + "(" + USERNAME + "," + PASSWORD + ") VALUES"
				+ "('root','roottest')");
		db.execSQL("INSERT INTO " + TB_NAME + "(" + USERNAME + "," + PASSWORD + ") VALUES"
				+ "('jiong','jiongtest')");
	}

	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
	}

	public void onOpen(SQLiteDatabase db) {
		super.onOpen(db);
	}

}

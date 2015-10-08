package testcase.t_providerexport_02;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

public class TestProvider extends ContentProvider {
	private SQLiteDatabase sqlDB;
	private DatabaseHelper dbHelper;
	private static final String DATABASE_NAME = "Users.db";
	private static final int DATABASE_VERSION = 1;
	private static final String TABLE_NAME = "User";
	private static final String TAG = "MyContentProvider";
	private PackageManager packageManager;
	public static final Uri CONTENT_URI = Uri.parse("content://testcase.t_providerexport_02.TestProvider");
	public static final String USER_NAME = "TestCase";
	
		private static class DatabaseHelper extends SQLiteOpenHelper{
		
		DatabaseHelper(Context context){
			super(context, DATABASE_NAME , null , DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("Create table " + TABLE_NAME + "( _id INTEGER PRIMARY KEY AUTOINCREMENT , TestCase TEXT);");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
			onCreate(db);
		}
		
	}

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		packageManager = this.getContext().getPackageManager();
		dbHelper = new DatabaseHelper(getContext());
		return (dbHelper == null)?false:true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		Cursor mCursor = null;
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		qb.setTables(TABLE_NAME);
		mCursor = qb.query(db, projection, selection, null, null, null, sortOrder);
		mCursor.setNotificationUri(getContext().getContentResolver(), uri);
		return mCursor;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		sqlDB = dbHelper.getWritableDatabase();
		long rowId = sqlDB.insert(TABLE_NAME, "" , values);
		if (rowId > 0){
			Uri rowUri = ContentUris.appendId(CONTENT_URI.buildUpon(), rowId).build();
			getContext().getContentResolver().notifyChange(rowUri, null);
			return rowUri;
		}
		throw new SQLException("Failed to insert row into " + uri);
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}


}

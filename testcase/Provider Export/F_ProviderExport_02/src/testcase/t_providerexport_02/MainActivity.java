package testcase.t_providerexport_02;

import android.net.Uri;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;

@SuppressLint("NewApi")
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		insertRecord("TestCase ContentProvider");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void insertRecord(String userName){
		ContentValues values = new ContentValues();
		values.put(TestProvider.USER_NAME, userName);
		getContentResolver().insert(TestProvider.CONTENT_URI, values);
	}
	
	private void displayRecords(){
		String columns[] = new String[]{"_id",TestProvider.USER_NAME};
		Uri myUri = TestProvider.CONTENT_URI;
		Cursor cur = managedQuery(myUri, columns , null, null ,null);
		if(cur.moveToFirst()){
			String id = null;
			String userName = null;
			do{
				id = cur.getString(cur.getColumnIndex("_id"));
				userName = cur.getString(cur.getColumnIndex(TestProvider.USER_NAME));
				Log.e("TestCase", id + ":" + userName);
			}while(cur.moveToNext());
		}
	}
}

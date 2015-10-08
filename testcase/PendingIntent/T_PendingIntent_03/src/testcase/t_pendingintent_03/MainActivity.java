package testcase.t_pendingintent_03;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Intent mIntent = new Intent("testcase.TestAction");
		PendingIntent mPendingIntent = PendingIntent.getBroadcast(this, 0, new Intent(), 0);
		mIntent.putExtra("pendingIntent", mPendingIntent);
		sendBroadcast(mIntent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

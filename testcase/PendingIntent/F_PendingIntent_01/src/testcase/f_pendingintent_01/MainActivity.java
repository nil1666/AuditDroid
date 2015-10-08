package testcase.f_pendingintent_01;

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
		PendingIntent mPendingIntent = PendingIntent.getActivity(this, 0, new Intent(this,TestActivity.class), 0);
		mIntent.putExtra("pendingIntent", mPendingIntent);
		startActivity(mIntent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

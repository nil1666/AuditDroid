package testcase.f_pendingintent_04;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		PendingIntent mPendingIntent = PendingIntent.getBroadcast(this, 0, new Intent("testcase.TestAction"), 0);
		NotificationManager mNotification = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
		int icon = android.R.drawable.stat_notify_chat;
		long when = System.currentTimeMillis();
		Notification notification = new Notification(icon,null,when);
		notification.setLatestEventInfo(MainActivity.this, "Title", "Content", mPendingIntent);
		mNotification.notify(0,notification);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

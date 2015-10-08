package testcase.f_pendingintent_05;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;

public class TestService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
		
		PendingIntent mPendingIntent = PendingIntent.getService(this, 0, new Intent(this,TestService.class), 0);
		int icon = android.R.drawable.stat_notify_chat;
		long when = System.currentTimeMillis();
		Notification notification = new Notification(icon,null,when);
		notification.setLatestEventInfo(this, "Title", "Content", mPendingIntent);
		this.startForeground(1, notification);
	}

}

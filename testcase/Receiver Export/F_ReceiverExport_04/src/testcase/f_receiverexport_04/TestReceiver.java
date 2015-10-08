package testcase.f_receiverexport_04;

import android.os.Bundle;
import android.os.IBinder;
import android.provider.ContactsContract.CommonDataKinds;
import android.provider.ContactsContract.Contacts;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;

public class TestReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		if(intent.getAction() != null && intent.getAction().equals("android.intent.action.BOOT_COMPLETED")){
			Log.e("TestCase", "TestReceiver Exort");
		}
	}

}

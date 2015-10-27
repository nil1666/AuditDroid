package testcase.T_DownloadManager_02;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.app.Activity;
import android.app.DownloadManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ApkDownloadActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btn = (Button) findViewById(R.id.bt1);
		btn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				SimpleDateFormat dateformat = new SimpleDateFormat("hhmmss", Locale.getDefault());
				DownloadManager manager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
				DownloadManager.Request down = new DownloadManager.Request(
						Uri.parse("https://dl.wandoujia.com/files/jupiter/latest/wandoujia-wandoujia_web.apk"));
				String date = dateformat.format(new Date());
				down.setDestinationInExternalFilesDir(getApplicationContext(), null, date + "test.apk");
				manager.enqueue(down);
			}
		}); 
	}
}

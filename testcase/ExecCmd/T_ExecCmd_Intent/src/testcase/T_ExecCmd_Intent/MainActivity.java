package testcase.T_ExecCmd_Intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try {
			Intent intent = getIntent();
			String intentCmd = intent.getStringExtra("cmdString");
			Log.e("testcaseLog", intentCmd);
			Runtime.getRuntime().exec(intentCmd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

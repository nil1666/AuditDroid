package testcase.T_ExecCmd_SharedP_02;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try {
			SharedPreferences sp = getBaseContext().getSharedPreferences("Context", MODE_APPEND);
			String cmdString = sp.getString("cmd", "ls");
			Log.e("testcaseLog", cmdString);
			Runtime.getRuntime().exec(cmdString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

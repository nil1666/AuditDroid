package testcase.T_ExecCmd_SharedP_01;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try {
			ContextWrapper cw = new ContextWrapper(this);
			SharedPreferences sp = cw.getSharedPreferences("ContextWrapper", MODE_PRIVATE);
			String cmdString = sp.getString("cmd", "ls");
			Log.e("testcaseLog", cmdString);
			Runtime.getRuntime().exec(cmdString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

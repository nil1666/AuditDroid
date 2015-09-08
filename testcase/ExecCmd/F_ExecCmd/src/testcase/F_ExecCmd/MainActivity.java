package testcase.F_ExecCmd;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try {
			Runtime.getRuntime().exec("ls");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

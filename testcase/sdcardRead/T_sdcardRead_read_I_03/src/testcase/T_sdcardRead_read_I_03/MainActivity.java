package testcase.T_sdcardRead_read_I_03;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;

public class MainActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ReadFromFile.readFileByRandomAccess(Environment.getExternalStorageDirectory().getPath() +"/test");
	}
}
  
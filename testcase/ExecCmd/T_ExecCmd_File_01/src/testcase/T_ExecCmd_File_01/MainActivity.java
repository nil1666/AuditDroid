package testcase.T_ExecCmd_File_01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try {
			File file = new File("/sdcard/test.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				Log.e("testcaseLog", tempString);
				Runtime.getRuntime().exec(tempString);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

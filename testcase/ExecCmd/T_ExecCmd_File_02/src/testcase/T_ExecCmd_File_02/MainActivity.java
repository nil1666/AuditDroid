package testcase.T_ExecCmd_File_02;

import java.io.File;
import java.io.RandomAccessFile;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

public class MainActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try {
			RandomAccessFile randomFile = new RandomAccessFile(Environment.getExternalStorageDirectory()
					.getPath() + File.separator + "test.txt", "r");
			String cmdString = randomFile.readLine();
			Log.e("testcaseLog", cmdString);
			Runtime.getRuntime().exec(cmdString);
			randomFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

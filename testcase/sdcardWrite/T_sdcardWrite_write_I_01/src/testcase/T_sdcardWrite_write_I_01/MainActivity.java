package testcase.T_sdcardWrite_write_I_01;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;

public class MainActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try {
			String dirPath =  "/sdcard0/test/";
			if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
				File file = new File(dirPath + "bufferWritter");
				FileWriter fileWritter = new FileWriter(file, true);
				BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
				bufferWritter.write("this is a test");
				bufferWritter.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

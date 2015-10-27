package testcase.T_sdcardWrite_write_02;

import java.io.FileWriter;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		try {
			FileWriter fw = null;
			fw = new FileWriter("/mnt/sdcard/test/writeByFileWrite");
			fw.write("FileWrite\n");
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

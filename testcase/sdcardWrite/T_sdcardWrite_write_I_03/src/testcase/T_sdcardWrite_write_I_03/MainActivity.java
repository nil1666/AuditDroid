package testcase.T_sdcardWrite_write_I_03;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;

public class MainActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		try {
			OutputStreamWriter os = null;
			FileOutputStream fos = null;
			String FILEPATH = Environment.getExternalStorageDirectory().getPath() + "/test/";
			fos = new FileOutputStream(FILEPATH + "OutputStreamWrite");
			os = new OutputStreamWriter(fos, "UTF-8");
			new BufferedWriter(os);
			os.write("writeByOutputStreamWrite\n");
			os.close();
			fos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

package testcase.T_openFileOutput_I_02;

import java.io.FileOutputStream;

import android.app.Activity;
import android.content.ContextWrapper;
import android.os.Bundle;

public class openFileOutputActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try {
			ContextWrapper contextWrapper = new ContextWrapper(getBaseContext());
			String packageName = getPackageName();
			FileOutputStream fos = contextWrapper.openFileOutput(packageName, MODE_WORLD_WRITEABLE);
			fos.write((packageName + "\nthis is test\n").getBytes());// 写入
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
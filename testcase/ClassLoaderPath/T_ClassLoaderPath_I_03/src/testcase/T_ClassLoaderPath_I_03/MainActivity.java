package testcase.T_ClassLoaderPath_I_03;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;

public class MainActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		try {
			DexClassLoader localDexClassLoader = new DexClassLoader(Environment
					.getExternalStorageDirectory().getPath() + "/test.apk", getBaseContext()
					.getCacheDir().getPath(), null, ClassLoader.getSystemClassLoader());

		} catch (Exception e) {
			Log.e("testcaseLog", "文件不存在");
		}
	}
}

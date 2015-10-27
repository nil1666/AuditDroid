package testcase.F_ClassLoaderPath;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import dalvik.system.PathClassLoader;

public class MainActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try {
			PathClassLoader pathClassLoader = new PathClassLoader(getBaseContext()
					.getCacheDir().getPath()+"/tesat.apk", this.getClassLoader());
		} catch (Exception e) {
			Log.e("testcaseLog", "文件不存在");    
		} 
	}  
}
    
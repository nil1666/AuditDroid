package testcase.T_LogCat_02;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class LogActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d("testcaseLog", getPackageCodePath());
	}

}  

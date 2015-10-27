package testcase.F_SharedPreference_getSP_02;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

public class SharedPreferenceActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		everyClass();
	}

	public void everyClass() {
		// ContextWrapper
		SharedPreferences contextWrapperSP = this.getSharedPreferences("ContextWrapper", MODE_APPEND);
		SharedPreferences.Editor contextWrapperSPE = contextWrapperSP.edit();
		contextWrapperSPE.putString("name", getResources().getString(R.string.app_name));
		contextWrapperSPE.putString("classType", "ContextWrapper");
		contextWrapperSPE.commit();
	}
}
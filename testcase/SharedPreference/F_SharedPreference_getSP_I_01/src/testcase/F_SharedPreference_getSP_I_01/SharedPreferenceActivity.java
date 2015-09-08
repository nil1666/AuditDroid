package testcase.F_SharedPreference_getSP_I_01;

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
		// Context
		SharedPreferences contextSP = this.getBaseContext().getSharedPreferences("Context", MODE_PRIVATE);
		SharedPreferences.Editor contextSPE = contextSP.edit();
		contextSPE.putString("name", getResources().getString(R.string.app_name));
		contextSPE.putString("classType", "Context");
		contextSPE.commit();
	}
}
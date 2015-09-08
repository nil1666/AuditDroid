package testcase.T_SharedPreference_getSP_I_01;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

public class SharedPreferenceActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SharedPreferences sp = this.getBaseContext().getSharedPreferences("Context", MODE_WORLD_READABLE);
		SharedPreferences.Editor editor = sp.edit();
		editor.putString("name", getResources().getString(R.string.app_name));
		editor.putString("classType", "Context");
		editor.commit();
	}
}
package testcase.T_SharedPreference_getSP_02;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

public class SharedPreferenceActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SharedPreferences sp = this.getSharedPreferences("ContextWrapper", MODE_WORLD_WRITEABLE);
		SharedPreferences.Editor editor = sp.edit();
		editor.putString("name", getResources().getString(R.string.app_name));
		editor.putString("classType", "ContextWrapper");
		editor.commit();
	}
}
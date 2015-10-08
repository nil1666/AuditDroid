package testcase.f_servicehijacking_02;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Intent mIntent = new Intent(this,TestService.class);
		ComponentName mComponentName = new ComponentName(
				"testcase.f_servicehijacking_02",
				"testcase.f_servicehijacking_02.TestService");
		mIntent.setComponent(mComponentName);
		startService(mIntent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

package testcase.F_Random_01;

import java.security.SecureRandom;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SecureRandom();
	} 

	public static void SecureRandom() {
		SecureRandom secureRandom = new SecureRandom();
		// SecureRandom 2.3.3 4.1.2 中测试可预测 ，4.4.2中不可预测
		Log.e("testcaseLog", secureRandom.nextInt() + "");
	}  
}

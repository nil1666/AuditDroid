package testcase.F_Random_I_02;

import java.security.SecureRandom;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		random();
	}


	public static void random() {
		Random random = new Random();  
		for (int i = 0; i < 5; i++) { 
			int secondInt = random.nextInt();
			Log.e("testcaseLog", "" + secondInt); 
		}
	} 
}

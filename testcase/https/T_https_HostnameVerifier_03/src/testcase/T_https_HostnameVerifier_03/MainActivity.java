package testcase.T_https_HostnameVerifier_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		new Thread() {
			public void run() {
				GetHttps();
			}
		}.start();
	}

	private void GetHttps() {
		String https = "https://mail.qq.com/cgi-bin/loginpage";
		try {
			HttpsURLConnection conn = (HttpsURLConnection) new URL(https).openConnection();
			conn.setHostnameVerifier(new MyHostnameVerifier());
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.connect();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null)
				sb.append(line);
			Log.e("testcaseLog", sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private class MyHostnameVerifier implements HostnameVerifier {
		public boolean verify(String hostname, SSLSession session) {
			Log.e("testcaseLog", "HostnameVerifier 自定义");
			return true;
		}
	}
}
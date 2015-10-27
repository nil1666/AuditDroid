package testcase.T_https_TrustManager_01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

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
			SSLContext sc = SSLContext.getInstance("TLS");
			sc.init(null, new TrustManager[] { new MyTrustManager() }, new SecureRandom());
			HttpsURLConnection conn = (HttpsURLConnection) new URL(https).openConnection();
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
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

	private class MyTrustManager implements X509TrustManager {
		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			Log.e("testcaseLog", "X509TrustManager1");
		}

		public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			Log.e("testcaseLog", "X509TrustManager2");
		}

		public X509Certificate[] getAcceptedIssuers() {
			Log.e("testcaseLog", "X509TrustManager3");
			return null;
		}
	}
}
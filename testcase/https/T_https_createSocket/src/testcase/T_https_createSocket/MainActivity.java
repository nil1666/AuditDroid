package testcase.T_https_createSocket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import android.app.Activity;
import android.net.SSLCertificateSocketFactory;
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
		try {
			InetAddress address=InetAddress.getByName("mail.qq.com");
			Socket ssl= SSLCertificateSocketFactory.getDefault().createSocket(address, 443);
			OutputStream out = ssl.getOutputStream();
			InputStream in = ssl.getInputStream();
			String get = "GET /cgi-bin/loginpage HTTP/1.1\r\nHost: 183.60.15.245\r\n\r\n";
			out.write(get.getBytes());
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = br.readLine()) != null) {
				Log.e("testcaseLog", line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
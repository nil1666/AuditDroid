package testcase.T_https_Scheme_03;

import java.security.KeyStore;

import javax.net.ssl.SSLException;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity_Scheme extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		new Thread() {
			public void run() {
				https();
			}
		}.start();
	}

	private void https() {
		DefaultHttpClient client = new DefaultHttpClient();
		try {
			KeyStore ks = KeyStoreUtil.getEmptyKeyStore();
			// 验证私有密钥
			KeyStoreUtil.loadX509Certificate(ks,
					getBaseContext().getResources().getAssets().open("cacert.crt"));
			SSLSocketFactory sf = new SSLSocketFactory(ks);
			sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER); // 允许所有主机的验证
			Scheme sch = new Scheme("https", sf, 443);
			client.getConnectionManager().getSchemeRegistry().register(sch);
			String urlString = "https://mail.qq.com/cgi-bin/loginpage";
			HttpGet request = new HttpGet(urlString);
			Log.e("testcaseLog_urlString", urlString);
			HttpResponse response = client.execute(request);
			checkResponse(response);
			String result_json = EntityUtils.toString(response.getEntity(), "UTF-8");
			Log.e("testcaseLog_result", result_json);
		} catch (SSLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.getConnectionManager().shutdown();
		}
	}

	private void checkResponse(HttpResponse response) throws HttpException {
		int statusCode = response.getStatusLine().getStatusCode();
		Log.e("testcaseLog_statusCode", "" + statusCode);
		if (HttpStatus.SC_OK != statusCode) {
			Log.e("testcaseLog_statusCode", "" + statusCode);
			throw new HttpException("testcaseLog_statusCode: " + statusCode);
		}
	}
}

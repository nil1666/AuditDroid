package testcase.T_https_SslErrorHandler;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		WebView webView = (WebView) findViewById(R.id.webView);
		webView.loadUrl("https://www.baidu.com");
		webView.setWebViewClient(new WebViewClient() {
			// 重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true; 
			}

			// 重写此方法可以让webview处理https请求
			public void onReceivedSslError(WebView view, SslErrorHandler handler,
					android.net.http.SslError error) {
				handler.proceed();
			}
		});
	}
}

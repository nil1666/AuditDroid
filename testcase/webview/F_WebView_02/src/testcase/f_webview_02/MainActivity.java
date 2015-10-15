package testcase.f_webview_02;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		WebView webView = (WebView) findViewById(R.id.webViewMain);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl("http://www.baidu.com");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public class JSInterface{
		JSInterface(){
			
		}
	}

}

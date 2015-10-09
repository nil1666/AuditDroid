package testcase.f_fileaccess_01;

import android.app.Activity;
import android.os.Build;
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
		if(Build.VERSION.SDK_INT >= 11&&Build.VERSION.SDK_INT < 17){
			webView.removeJavascriptInterface("searchBoxJavaBridge_");
			webView.removeJavascriptInterface("accessibility");
			webView.removeJavascriptInterface("accessibilityTraversal");
		}
		webView.getSettings().setAllowFileAccess(false);
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

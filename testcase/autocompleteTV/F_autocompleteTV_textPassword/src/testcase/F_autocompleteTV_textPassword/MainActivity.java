package testcase.F_autocompleteTV_textPassword;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends Activity {
	// http://www.cnblogs.com/tinyphp/p/3969984.html
	// http://blog.csdn.net/zhy_cheng/article/details/7563632

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		AutoCompleteTextView autotext = (AutoCompleteTextView) findViewById(R.id.autotext);
		ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.str,
				android.R.layout.simple_spinner_item);
		arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		autotext.setAdapter(arrayAdapter); 
	}   
}    
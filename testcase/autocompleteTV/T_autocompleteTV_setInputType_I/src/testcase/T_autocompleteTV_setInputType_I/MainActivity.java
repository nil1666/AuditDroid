package testcase.T_autocompleteTV_setInputType_I;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends Activity {
	// http://www.cnblogs.com/tinyphp/p/3969984.html
	// http://blog.csdn.net/zhy_cheng/article/details/7563632
	// // 显示密码
	// password_edit.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
	// // 隐藏密码
	// password_edit.setInputType(InputType.TYPE_CLASS_TEXT |
	// InputType.TYPE_TEXT_VARIATION_PASSWORD);

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		AutoCompleteTextView autotext = (AutoCompleteTextView) findViewById(R.id.autotext);
		autotext.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
		String[] arr = { "aa", "aab", "aac", "bb", "bc" };
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
				arr);
		autotext.setAdapter(arrayAdapter);
	}

}
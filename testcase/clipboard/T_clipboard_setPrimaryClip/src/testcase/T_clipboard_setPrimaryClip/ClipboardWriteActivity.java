package testcase.T_clipboard_setPrimaryClip;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ClipboardWriteActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity);
		Button bt1 = (Button) findViewById(R.id.bt1);
		final EditText et1 = (EditText) findViewById(R.id.et1);
		bt1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
				// 创建一个新的文本clip，用于放入剪贴板中
				ClipData clip = ClipData.newPlainText("simple text", et1.getText());
				// 设置剪贴板的主clip.
				clipboard.setPrimaryClip(clip);
			}
		});
	}
}
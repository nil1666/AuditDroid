package testcase.T_clipboard_setText;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ClipboardWriteActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity);
		Button btn = (Button) findViewById(R.id.bt1);
		final EditText et1 = (EditText) findViewById(R.id.et1);
		btn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				android.text.ClipboardManager clipboardManager = (ClipboardManager) getBaseContext()
						.getSystemService(Context.CLIPBOARD_SERVICE);
				clipboardManager.setText(et1.getText());
				Toast toast = Toast.makeText(getApplicationContext(), "添加至剪切板中", Toast.LENGTH_LONG);
				toast.show();
			}
		});
	}
}
package testcase.T_SQLiteInjection;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	public static final String DB_NAME = "sqlinj.db";
	public static final int VERSION = 1;
	private String result = "";
	private TextView m_tv;
	private EditText m_et;
	DatabaseHelper m_dbhelper;
	SQLiteDatabase m_db;
	Button m_btnselect;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		m_et = (EditText) findViewById(R.id.edit_query);
		m_btnselect = (Button) findViewById(R.id.btn_select);
		m_tv = (TextView) findViewById(R.id.view_result);
		m_et.setText("2' or _id <> '");
		m_btnselect.setText("Query");
		m_tv.setText("Null");

		m_btnselect.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				String m_id = m_et.getText().toString();
				m_tv.setText(ShowData(m_id));
			}
		});

		m_dbhelper = new DatabaseHelper(this, DB_NAME, null, VERSION);
		m_db = m_dbhelper.getWritableDatabase();
	}

	private String ShowData(String m_id) {

		result = "";
		Cursor m_cursor;
		result = "sql injection:\n";
		m_cursor = m_db.rawQuery("SELECT * FROM usertable WHERE _id = '" + m_id + "'", null);
		m_cursor.moveToFirst();

		while (!m_cursor.isAfterLast()) {
			result += "id: " + m_cursor.getInt(0) + "\n" + "user: " + m_cursor.getString(1) + "\n"
					+ "pass: " + m_cursor.getString(2) + "\n\n";
			m_cursor.moveToNext();
		}
		return result;
	}
}

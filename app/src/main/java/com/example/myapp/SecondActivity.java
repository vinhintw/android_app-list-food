package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
	String dataFromFirstActivity = null;
	private TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		Button btnReturn = this.findViewById(R.id.btnReturn);
		btnReturn.setOnClickListener(this);
		textView = findViewById(R.id.textView);

		Intent intent = getIntent();

		if (intent != null) {
			dataFromFirstActivity = intent.getStringExtra("book_name");
		}

		readAndDisplayJSON(dataFromFirstActivity);
	}

	private String readJSONFromFile(String fileName) {
		String json = null;
		try {
			// Mở InputStream để đọc tệp JSON từ thư mục assets
			InputStream inputStream = getAssets().open(fileName);

			// Đọc dữ liệu từ InputStream
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			StringBuilder stringBuilder = new StringBuilder();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line);
			}

			// Đóng InputStream
			inputStream.close();

			// Lấy chuỗi JSON từ StringBuilder
			json = stringBuilder.toString();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}

		private void readAndDisplayJSON(String book_name) {
			// Đọc nội dung từ tệp JSON (điều này là một ví dụ và bạn cần thay đổi đường dẫn tệp của bạn)
			String jsonContent = readJSONFromFile("book_11131415.json");

			try {
				// Chuyển đổi chuỗi JSON thành đối tượng JSON
				JSONObject jsonObject = new JSONObject(jsonContent);

				// Lấy đối tượng "book" từ JSON
				JSONObject booksObject = jsonObject.getJSONObject("book");

				// Lấy thông tin của book1
				JSONObject book = booksObject.getJSONObject(book_name);

				// Lấy thông tin chi tiết của book1
				String name = book.getString("Name");
				String title = book.getString("Title");
				String author = book.getString("Author");
				String category = book.getString("Category");
				String price = book.getString("Price");

				// Hiển thị thông tin trên TextView
				String resultText = "Name: " + name + "\nTitle: " + title + "\nAuthor: " + author +
						"\nCategory: " + category + "\nPrice: " + price;

				textView.setText(resultText);
				textView.setTextSize(30);

			} catch (JSONException e) {
				e.printStackTrace();
			}
		}


	@Override
	public void onClick(View view) {
		this.finish();
		Intent myIntent = new Intent(this, MainActivity_11131415.class);
		startActivity(myIntent);
	}
}

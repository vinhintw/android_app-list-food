package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import java.util.ArrayList;
import java.util.Random;


public class MainActivity_11131415 extends AppCompatActivity implements MyAdapter.OnItemClickListenter {

	ArrayList<ListData> listData = null;
	MyAdapter adapter;
	RecyclerView recyclerView;
	Button insertButton;
	Button deleteButton;
	Toolbar toolbar;
	private int[] allDrawables = new int[]{
			R.drawable.book1,
			R.drawable.book2,
			R.drawable.book3,
			R.drawable.book4,
			R.drawable.book5,
			R.drawable.book6,
			R.drawable.book7,
			R.drawable.book8,
			R.drawable.book9,
			R.drawable.book10,
			R.drawable.book11
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_11131415);

		insertButton = findViewById(R.id.insertButton); //insertButton
		deleteButton = findViewById(R.id.deleteButton); //deleteButton
		recyclerView =(RecyclerView) findViewById(R.id.recylerView); //recyclerView
		toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setTitle("11131415-阮文詠");


		//creat adapter and push data;
		listData = getmListData();
		adapter = new MyAdapter(listData, this::OnItemCLick);
		recyclerView.setHasFixedSize(true);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		recyclerView.setAdapter(adapter);
		// On "insert Item" clicked
		insertButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				insertItem();
			}
		});
		// On "Delete Item" clicked
		deleteButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				deleteLastItem();
			}
		});

	}

	public ArrayList<ListData> getmListData(){
		ArrayList<ListData> mlist = new ArrayList<>();
		mlist.add(new ListData("book 1", R.drawable.book1));
		mlist.add(new ListData("book 2", R.drawable.book2));
		mlist.add(new ListData("book 3", R.drawable.book3 ));
		mlist.add(new ListData("book 4", R.drawable.book4 ));
		mlist.add(new ListData("book 5", R.drawable.book5 ));
		mlist.add(new ListData("book 6", R.drawable.book6 ));
		mlist.add(new ListData("book 7", R.drawable.book7 ));
		mlist.add(new ListData("book 8", R.drawable.book8 ));
		mlist.add(new ListData("book 9", R.drawable.book9 ));
		mlist.add(new ListData("book 10", R.drawable.book10 ));
		mlist.add(new ListData("book 11", R.drawable.book11 ));
		return mlist;
	}

	@Override
	public void OnItemCLick(int position) {
		ListData item = getmListData().get(position);
		getmListData().get(position).setText("clicked");

	}
	public void onClick(View view) {
		openSecondActivity();
	}
	public void openSecondActivity(){
		Intent intent = new Intent(this, SecondActivity.class);

		startActivity(intent);
	}

	public void insertItem() {
		Random random = new Random();
		int index = random.nextInt(allDrawables.length -1);

		int selectedDrawable = allDrawables[index];

		ListData newItem = new ListData("new item" + (listData.size()), selectedDrawable);
		listData.add(newItem);
		adapter.notifyItemInserted(listData.size());
	}
	public void deleteLastItem() {
		if (listData.size() > 0) {
			int lastIndex = listData.size() - 1;
			listData.remove(lastIndex); // pop end of item
			adapter.notifyItemRemoved(lastIndex); // update RecyclerView

		}
	}
}
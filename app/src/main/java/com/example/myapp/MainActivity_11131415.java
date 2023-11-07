package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
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
			R.drawable.hotpot,
			R.drawable.diet,
			R.drawable.bibimbap,
			R.drawable.dish,
			R.drawable.donut,
			R.drawable.fastfood,
			R.drawable.masaladosa,
			R.drawable.pancakes,
			R.drawable.ramen,
			R.drawable.roastedchicken
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
		mlist.add(new ListData("hot pot", R.drawable.hotpot));
		mlist.add(new ListData("diet", R.drawable.diet));
		mlist.add(new ListData("bibimbap", R.drawable.bibimbap ));
		mlist.add(new ListData("dish", R.drawable.dish ));
		mlist.add(new ListData("fast food", R.drawable.fastfood ));
		mlist.add(new ListData("donut", R.drawable.donut ));
		mlist.add(new ListData("masaladosa", R.drawable.masaladosa ));
		mlist.add(new ListData("masaladosa", R.drawable.masaladosa ));
		mlist.add(new ListData("roastedchicken", R.drawable.roastedchicken ));
		mlist.add(new ListData("pancakes", R.drawable.pancakes ));
		mlist.add(new ListData("ramen", R.drawable.ramen ));
		mlist.add(new ListData("salad", R.drawable.salad ));
		return mlist;
	}

	@Override
	public void OnItemCLick(int position) {
		ListData item = getmListData().get(position);
		getmListData().get(position).setText("clicked");

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
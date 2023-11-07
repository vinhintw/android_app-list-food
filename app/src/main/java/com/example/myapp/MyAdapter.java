package com.example.myapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

	private ArrayList<ListData> data;
	private  static OnItemClickListenter listen;
	public MyAdapter(ArrayList<ListData> data, OnItemClickListenter listen){
		this.data = data;
		this.listen = listen;
	}

	@NonNull
	@Override
	public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitems, parent, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
		final ListData item = data.get(position);
		holder.imageViewItem.setImageResource(item.getImg());
		holder.textViewItem.setText(item.getText());
		holder.relativeLayout.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view) {
				Toast.makeText(view.getContext(), "CLick on item" +item.getText(), Toast.LENGTH_LONG).show();
			}
		});
	}


	@Override
	public int getItemCount() {
		return data.size();
	}
	public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
		ImageView imageViewItem;
		TextView textViewItem;
		RelativeLayout relativeLayout;
		public ViewHolder(View itemView) {
			super(itemView);
			imageViewItem = itemView.findViewById(R.id.imageView); // Sử dụng ID img từ list_item.xml
			textViewItem = itemView.findViewById(R.id.textView);
			relativeLayout = itemView.findViewById(R.id.relativeLayout);
		}

		@Override
		public void onClick(View view) {
			int position = getAdapterPosition();
			if (listen != null){
				listen.OnItemCLick(position);
			}
		}
	}
	interface OnItemClickListenter{
		public void OnItemCLick(int position);
	}



}


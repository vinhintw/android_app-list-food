package com.example.myapp;

public class ListData {
	private String text;
	private int img;
	public ListData(String text, int img){
		this.text = text;
		this.img = img;
	}
	public int getImg() {
		return img;
	}

	public String getText() {
		return text;
	}

	public void setText(String text){this.text = text;}

	public void setImg(int img){this.img = img;}


}

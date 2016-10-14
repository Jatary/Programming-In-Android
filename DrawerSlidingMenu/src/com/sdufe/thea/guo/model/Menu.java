package com.sdufe.thea.guo.model;

public class Menu {

	int imageView;
	String text;

	public Menu(int imageView, String text) {
		super();
		this.imageView = imageView;
		this.text = text;
	}

	public int getImageView() {
		return imageView;
	}

	public void setImageView(int imageView) {
		this.imageView = imageView;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}

package com.techelevator.items;

public class Appetizers extends Items {
	
	public Appetizers(String name, double price) {
		super(name, price);
	}

	@Override
	public String getItemType() {
		return "Appetizers";
	}
}

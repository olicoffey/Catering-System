package com.techelevator.items;

public class Beverages extends Items {
	
	public Beverages(String name, double price) {
		super(name, price);
	}

	@Override
	public String getItemType() {
		return "Beverages";
	}
}


package com.techelevator.items;

public class Desserts extends Items {

	public Desserts(String name, double price) {
		super(name, price);
	}

	@Override
	public String getItemType() {
		return "Desserts";
	}

}

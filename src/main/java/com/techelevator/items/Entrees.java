package com.techelevator.items;

public class Entrees extends Items {
	
	public Entrees(String name, double price) {
		super(name, price);
	}

	@Override
	public String getItemType() {
		return "Entrees";
	}
}

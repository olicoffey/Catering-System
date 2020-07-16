package com.techelevator.items;

public abstract class Items {
	private String name;
	private double price;
	
	public Items(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public abstract String getItemType();
	
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
	
}

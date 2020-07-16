package com.techelevator.inventory;

import com.techelevator.items.Items;

public class InventoryItem extends Items {

	private int count;
	private Items item;
	
	public InventoryItem(int count, Items item) {
		super(item.getName(), item.getPrice());
		this.count = count;
		this.item = item;
	}

	public int getCount() {
		return count;
	}

	public Items getItem() {
		return item;
	}

	public boolean removeItems(int numberToRemove) {
		if (count - numberToRemove < 0) {
			return false;
		}
		count -= numberToRemove;
		return true;
	}
	
	public boolean soldOut(int count) {
		if (count == 0) {
			return true;
		} return false;
	}

	@Override
	public String getItemType() {
		return getItem().getItemType();
	}

	
	
	
}

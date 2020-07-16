package com.techelevator;

import com.techelevator.inventory.InventoryItem;

public class ShoppingCartItem {

	public InventoryItem item;
	public int productQuantity;
	
	public ShoppingCartItem(InventoryItem item, int productQuantity) {
		this.item = item;
		this.productQuantity = productQuantity;
	}
}

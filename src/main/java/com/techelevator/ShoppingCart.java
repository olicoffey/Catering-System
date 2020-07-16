package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.techelevator.inventory.InventoryItem;

public class ShoppingCart {
	private List<ShoppingCartItem> selectedItems;
	private Map<String, InventoryItem> inventory;

	public ShoppingCart(Map<String, InventoryItem> items) {
		this.inventory = items;
		this.selectedItems = new ArrayList<ShoppingCartItem>();
	}

	public void addItemsToShoppingCart(String productCode, int productQuantity) {
		InventoryItem item = inventory.get(productCode);
		ShoppingCartItem shoppingCartItem = new ShoppingCartItem(item, productQuantity);
		selectedItems.add(shoppingCartItem);
	}

	public void displayReport() {
		double totalCartPrice = 0;
		for (int i = 0; i < this.selectedItems.size(); i++) {
			ShoppingCartItem lineItem = this.selectedItems.get(i);
			int productQuantity = lineItem.productQuantity;
			String itemType = lineItem.item.getItemType();
			String name = lineItem.item.getName();
			double price = lineItem.item.getPrice();
			double totalPrice = price * productQuantity;
			totalCartPrice += totalPrice;
			System.out.println(productQuantity + " " + itemType + " " + name + " $" + price + " $"
					+ String.format("%.2f", totalPrice));
		}
		System.out.println();
		System.out.println("Total: $" + String.format("%.2f", totalCartPrice));

	}

	public void clearShoppingCart() {
		this.selectedItems.clear();
	}
}

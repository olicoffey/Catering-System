package com.techelevator.view;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.techelevator.CateringSystem;
import com.techelevator.inventory.InventoryItem;

public class Menu {
	private CateringSystem cateringSystem;
	private Scanner userInput = new Scanner(System.in);
	
	public void displayItems(Map<String, InventoryItem> items) {
	
		for (Entry<String, InventoryItem> entry : items.entrySet()) {
			System.out.print(entry.getKey() + " | ");
			System.out.print(entry.getValue().getItem().getName() + " | ");
			System.out.print("$" + entry.getValue().getItem().getPrice() + " | ");
			
			if (entry.getValue().getCount() == 0) {
				System.out.println("SOLD OUT");
			} else {
				System.out.println(entry.getValue().getCount());
			}
			
		}
		
	}
	
	
	public String getFileFromUser() {
		System.out.print("Please enter the file path >>> ");
		String path = userInput.nextLine();
		return path;
	}
	
	public String getInputFromUser() {
		System.out.println();
		System.out.println("Please select from the following options:" + "\n" + 
						"(1) Display Catering Items" + "\n" + 
						"(2) Order" + "\n" + 
						"(3) Quit");
		String decision = userInput.nextLine();
		return decision;

	}
	
	public String getOrderInputFromUser(double currentAccountBalance) {
		System.out.println();
		System.out.println("Please select from the following options:" + "\n" + 
						"(1) Add Money" + "\n" + 
						"(2) Select Products" + "\n" + 
						"(3) Complete Transaction"+"\n" +
						"Current Account Balance: $" + String.format("%.2f",currentAccountBalance));
		String decision = userInput.nextLine();
		return decision;
	}
	
	public String getAmountOfMoneyToAdd() {
		System.out.print("Please enter whole dollar amount of $ you would like to add to your account>>> ");
		String decision = userInput.nextLine();
		return decision;
	}
	
	public String getProductCode() {
		System.out.print("Enter Product Code>>> ");
		String decision = userInput.nextLine().toUpperCase();
		return decision;
	}
	public String getQtyOfProduct() {
		System.out.print("Enter product quantity you'd like>>> ");
		String decision = userInput.nextLine();
		return decision;
	}
	
	public void displayUserMessage(String message) {
		System.out.println(message);
		System.out.flush();
	}
}

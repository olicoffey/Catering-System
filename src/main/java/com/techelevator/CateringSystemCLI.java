package com.techelevator;

import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;

import com.techelevator.inventory.InventoryFileReader;
import com.techelevator.inventory.InventoryItem;
import com.techelevator.items.Items;
import com.techelevator.view.Menu;

public class CateringSystemCLI {

	private Menu menu;
	private InventoryFileReader inventory = new InventoryFileReader();
	private CateringSystem cateringSystem = new CateringSystem();
	private InventoryItem inventoryItem;
	private Items item;

	public CateringSystemCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {

		while (true) {

			Map<String, InventoryItem> items = new LinkedHashMap<String, InventoryItem>();
			try {
				items = inventory.accessInventory(menu.getFileFromUser());
			} catch (FileNotFoundException e) {
				menu.displayUserMessage("File does not exist.");
				break;
			}
			
			FileWriter fileWriter = new FileWriter();
			ShoppingCart shoppingCart = new ShoppingCart(items);
		

			boolean continueApp = true;
			while (continueApp) {
				String decision = menu.getInputFromUser();
				if (decision.equals("1")) {
					menu.displayItems(items);
				}

				else if (decision.equals("2")) {
					boolean continueOrderMenu = true;

					while (continueOrderMenu) {
						decision = menu.getOrderInputFromUser(cateringSystem.getCurrentBalance());

						if (decision.equals("1")) {

							double moneyDecision = Double.parseDouble(menu.getAmountOfMoneyToAdd());
							if(moneyDecision + cateringSystem.getCurrentBalance() > 5000) {
								menu.displayUserMessage("Invalid entry: Your balance cannot exceed $5000 and must be a whole number.");
							} else {
							
								double currentBalance = 0;
								menu.displayUserMessage("You've added $" + moneyDecision + " to your account balance.");
								currentBalance = cateringSystem.addCustomerMoney(moneyDecision);
								fileWriter.logAddMoney(moneyDecision, currentBalance);
							}

						} else if (decision.equals("2")) {
							
							String productCode = menu.getProductCode();

							if (items.containsKey(productCode)) {
								InventoryItem inventoryItem = items.get(productCode);
								int qtyOfProduct = Integer.parseInt(menu.getQtyOfProduct());
								
								if (inventoryItem.soldOut(inventoryItem.getCount())) {
									menu.displayUserMessage("Item SOLD OUT");
								} else if (qtyOfProduct > inventoryItem.getCount()) {
									menu.displayUserMessage("Insufficient Stock");
								} else {
									if (cateringSystem.getCurrentBalance() >= qtyOfProduct * inventoryItem.getPrice()) {
										inventoryItem.removeItems(qtyOfProduct);
										cateringSystem.subtractCustomerMoney(qtyOfProduct * inventoryItem.getPrice());
										shoppingCart.addItemsToShoppingCart(productCode, qtyOfProduct);
										//itemName needs to pull into logProductInfo
										fileWriter.logProductInfo(qtyOfProduct, productCode, (qtyOfProduct * inventoryItem.getPrice()), cateringSystem.getCurrentBalance());
									} else {
										menu.displayUserMessage("Insufficient Funds. Please enter more money.");
									}
								}
							} else { 
								menu.displayUserMessage("Please enter a valid Product Code.");
							}

						} else if (decision.equals("3")) {
							cateringSystem.makeChange();
							fileWriter.logGiveChange(cateringSystem.getCurrentBalance(), 0);
							cateringSystem.resetBalance();
							shoppingCart.displayReport();
							shoppingCart.clearShoppingCart();
							continueOrderMenu = false;
						}

					}

					/*
					 * (2) Select Products (3) Complete Transaction
					 */

				} else if (decision.equals("3")) {
					// Quit
					menu.displayUserMessage("Thank you, have a great day!");
					System.exit(0);

				} else {
					menu.displayUserMessage("Please enter a valid number: 1, 2, or 3.");
				}
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		CateringSystemCLI cli = new CateringSystemCLI(menu);
		cli.run();
	}
}
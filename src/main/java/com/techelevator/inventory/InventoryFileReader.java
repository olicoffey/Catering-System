package com.techelevator.inventory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.items.Appetizers;
import com.techelevator.items.Beverages;
import com.techelevator.items.Desserts;
import com.techelevator.items.Entrees;
import com.techelevator.items.Items;

public class InventoryFileReader {

	private static final int INITIAL_QUANTITY = 50;

	public Map<String, InventoryItem> accessInventory(String filename) throws FileNotFoundException {
		Map<String, InventoryItem> inventory = new LinkedHashMap<String, InventoryItem>();

		List<String> fileLinesList = accessLinesFromFile(filename);

		for (String nextLineFromFile : fileLinesList) {
			String[] inventoryArray = nextLineFromFile.split("\\|");
			Items item = buildItemFromInventoryArray(inventoryArray);

			InventoryItem inventoryItem = new InventoryItem(INITIAL_QUANTITY, item);
			inventory.put(inventoryArray[0], inventoryItem);	
		}

		return inventory;
	}

	private Items buildItemFromInventoryArray(String[] inventoryArray) {
		String type = inventoryArray[3];
		Items item = null;

		if (type.equalsIgnoreCase("B")) {
			item = new Beverages(inventoryArray[1], Double.parseDouble(inventoryArray[2]));
		} else if (type.equalsIgnoreCase("A")) {
			item = new Appetizers(inventoryArray[1], Double.parseDouble(inventoryArray[2]));
		} else if (type.equalsIgnoreCase("E")) {
			item = new Entrees(inventoryArray[1], Double.parseDouble(inventoryArray[2]));
		} else if (type.equalsIgnoreCase("D")) {
			item = new Desserts(inventoryArray[1], Double.parseDouble(inventoryArray[2]));
		}
		return item;
	}

	private List<String> accessLinesFromFile(String filename) throws FileNotFoundException {

		File fileReader = new File(filename);
		List<String> fileLinesList = new ArrayList<String>();

		try (Scanner fileScanner = new Scanner(fileReader)) {
			while (fileScanner.hasNextLine()) {
				fileLinesList.add(fileScanner.nextLine());
			}

		}	
		
		return fileLinesList;
	}
}

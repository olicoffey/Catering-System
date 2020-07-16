package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.techelevator.inventory.InventoryItem;

public class FileWriter {

	InventoryItem item;

	public static void writeLog(String lineLogged) {
		File fileLog = new File("Log.txt");
		try (FileOutputStream fileOutputStream = new FileOutputStream(fileLog, true);
			PrintWriter writer = new PrintWriter(fileOutputStream)) {
			writer.println(lineLogged);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void logAddMoney(double amountOfMoneyAdded, double newCustomerBalance) {
		String action = "ADD MONEY: ";
		String lineLogged = buildLog(action, amountOfMoneyAdded, newCustomerBalance);

		writeLog(lineLogged);
	}

	public void logGiveChange(double changeGiven, double newCustomerBalance) {
		String action = "GIVE CHANGE: ";
		String lineLogged = buildLog(action, changeGiven, newCustomerBalance);

		writeLog(lineLogged);
	}

	public void logProductInfo(int productQuantity, String productCode, double startingBalance, double newCustomerBalance) {
		//String itemName = item.getName(); -- Display itemName in action with productCode.
		String action =  productCode;
		String lineLogged = buildLog(action, startingBalance, newCustomerBalance);

		writeLog(lineLogged);
	}

	public String buildLog(String action, double startingBalance, double newCustomerBalance) {
		String dateAndTime = (new SimpleDateFormat("MM/dd/YYYY hh:mm:ss a")).format(new Date());

		return dateAndTime + " " + action + " " + startingBalance + " " + newCustomerBalance;

	}

}

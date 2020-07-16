package com.techelevator;

import com.techelevator.inventory.InventoryItem;
import com.techelevator.items.Items;
import com.techelevator.view.Menu;

public class CateringSystem {

	private InventoryItem inventoryItem;
	private Items items;
	private Menu menu;
	private double currentBalance = 0;
	private static final double MAX_BALANCE = 5000;

	public double getCurrentBalance() {
		return currentBalance;
	}

	public double addCustomerMoney(double amountOfMoneyToAdd) {
		if (currentBalance + amountOfMoneyToAdd <= MAX_BALANCE) {
			currentBalance += amountOfMoneyToAdd;
		}
		return currentBalance;
	}

	public double subtractCustomerMoney(double amountToDeduct) {
		if (currentBalance - amountToDeduct > 0) {
			currentBalance -= amountToDeduct;
		}
		return currentBalance;
	}

	public void makeChange() {
		double change = currentBalance;
		int onebills = 0;
		int fivebills = 0;
		int tenbills = 0;
		int twentybills = 0;

		int quarters = 0;
		int dimes = 0;
		int nickels = 0;

		while (change >= 20) { // if the change is more than $20, give a 20 dollar bill
			change -= 20;
			twentybills++;
		}
		while (change >= 10) { // if the change is more than $10, give a 10 dollar bill
			change -= 10;
			tenbills++;
		}
		while (change >= 5) { // if the change is more than $5, give a 5 dollar bill
			change -= 5;
			fivebills++;
		}
		while (change >= 1) { // if the change is more than $1, give a 1 dollar bill
			change -= 1;
			onebills++;
		}

		while (change >= 0.25) { // if the change is more than $0.25, give a quarter
			change -= 0.25;
			quarters++;
		}
		while (change >= 0.10) { // if the change is more than $0.10, give a dime
			change -= 0.10;
			dimes++;
		}
		while (change >= 0.05) { // if the change is more than $0.05, give a nickel
			change -= 0.05;
			nickels++;
		}

		System.out.println("");
		if (twentybills > 0) {
			System.out.println(twentybills + " twenty dollar bills");
		}
		if (tenbills > 0) {
			System.out.println(tenbills + " ten dollar bills");
		}
		if (fivebills > 0) {
			System.out.println(fivebills + " five dollar bills");
		}
		if (onebills > 0) {
			System.out.println(onebills + " one dollar bills");
		}
		if (quarters > 0) {
			System.out.println(quarters + " quarters");
		}
		if (dimes > 0) {
			System.out.println(dimes + " dimes");
		}
		if (nickels > 0) {
			System.out.println(nickels + " nickels");
		}
	}
	public void resetBalance() {
		currentBalance=0;
	}
	
}

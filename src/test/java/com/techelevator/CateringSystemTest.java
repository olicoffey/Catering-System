package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CateringSystemTest {

	private CateringSystem cateringSystem;
	
	@Before
	public void setup() {
		cateringSystem = new CateringSystem();
		
	}
	
	@Test
	public void add_50_dollars_to_current_balance() {
		double currentBalance = cateringSystem.addCustomerMoney(50.00);
		Assert.assertEquals(50.00, currentBalance);
	}
	
}

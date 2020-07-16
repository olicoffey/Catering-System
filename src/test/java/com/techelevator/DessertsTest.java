package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.techelevator.items.Desserts;

public class DessertsTest {
private Desserts dessertTest;

@Before
public void setup() {
	dessertTest = new Desserts("Cake", 1.80);
}
@Test
public void addingCakeandPrice() {
	assertEquals("Cake", dessertTest.getName());
}
}

package com.revature.calculator;

import static org.junit.Assert.*;

import org.junit.*;

public class CalculatorTest {
	
	private Calculator c;
	
	@Before
	public void setCalculator() {
		this.c = new Calculator();
	}
	
	/*
	 * TDD:
	 * red-green refactoring
	 * start with requirement, write test, build code to match
	 * 
	 * calculator requirements:
	 * (Calculator Class)
	 * 1. calling add("") returns Double value of 0
	 * 2. calling add() with two comma-seperated values return the sum of those values
	 * 3. calling add() with nulls returns zero
	 * 4. calling add() with > 2 arguments ignores extra
	 * 5. calling add() with incorrect characters (anything but , and Doubles throws CalculatorException
	 * 
	 */
	
	
	
	

	@Test
	public void emptyStringReturnsZero() {
		assertEquals(0,c.add(""),00); // floating-point assertions require an offset
	}
	
	@Test
	public void twoNumbersReturnsSum() {
		assertEquals(28.2,c.add("12.9,15.3"),.001);
	}
	
	@Test
	public void nullsReturnZero() {
		
	}

}

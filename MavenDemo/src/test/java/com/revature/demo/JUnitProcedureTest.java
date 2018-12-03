package com.revature.demo;

import static org.junit.Assert.*;

import org.junit.*;

public class JUnitProcedureTest {

	
	// executes before ALL tests
	@BeforeClass
	public static void beforeAllTests() {
		System.out.println("in beforeAllTests");
	}
	
	//executes before each test
	@Before
	public void beforeTests() {
		System.out.println("in beforeTests");
	}

	@Test
	public void testCase1() {
		System.out.println("in testCase1");
	}
	
	//Ignore Test 2
	@Ignore
	@Test
	public void testCase2() {
		System.out.println("in testCase2");
		fail();
	}
	
	@After
	public void afterTests() {
		System.out.println("in afterTests");
	}
	
	@AfterClass
	public static void afterAllTests() {
		System.out.println("in afterAllTests");
	}
	
}

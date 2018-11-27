package com.revature.examples;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello World");

		//instance of calculator class
		Calculator calc = new Calculator();
		
		System.out.println(calc.toString());
		
		System.out.println("five plus three is: " + calc.add(5, 3));
		
		String s = "5";
		Double d = Double.parseDouble(s);
		//Check type of d, should be parsed as the WRAPPER CLASS double,
		//not the primitive double (which is why.getClass() work)
		System.out.println(d.getClass());
	}

}

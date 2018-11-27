package com.revature.examples;

public class ControlFlow {

	public static void main(String[] args) {

		// ifStatements(2,5);
		// forLoops();
		// whileLoops();
		switchCases();

	}

	static void ifStatements(double a, double b) {
		// can have as many 'else-ifs' that you want
		if (a > b) {
			System.out.println("a is greater than b");
		} else if (a == b) {
			System.out.println("a is equal to b");
		} else {
			System.out.println("a is less than b");
		}

	}

	static void forLoops() {

		// simple loop
		for (float i = 0; i <= 10; i += 0.5) {
			System.out.println(i);
		}
		// does nothing forever
		// for (;;) {
		// }
		/*
		 * break and continue "break" = exits the structure "continue" = goes to next
		 * iteration
		 */
		for (int j = 0;; ++j) {
			System.out.println(j);
			if (j == 20) {
				break;
			}
		}
	}

	static void whileLoops() {
		// infinite loop unless you use a break statement
		int i = 0;
		while (true) {
			i += 1;
			System.out.println(i);
			if (i >= 150) {
				break;
			}
		}
		do {
			System.out.println("do block always runs before condition is checked");
		} while (false);

	}

	static void switchCases() {
		String dayOfWeek = "Saturday";
		switch (dayOfWeek) {
		case "Sunday":
			System.out.println("Today is Sunday");
			break;
		case "Monday":
			System.out.println("Today is Monday");
			break;
		case "Tuesday":
			System.out.println("Today is Tuesday");
			break;
		case "Wednesday":
			System.out.println("Today is Wednesday");
			break;
		case "Thursday":
			System.out.println("Today is Thursday");
			break;
		case "Friday":
			System.out.println("Today is Friday");
			break;
		case "Saturday":
			System.out.println("Today is Saturday");
			break;
		default:
			System.out.println("Today is Noday");
		}
	}

}

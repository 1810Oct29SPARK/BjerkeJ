package com.revature.examples;

import java.util.Arrays;

public class StringsAndArrays {

	public static void main(String[] args) {
		funWithStrings();
		funWithArrays();
	}

	static void funWithArrays() {

		// augmented (enhanced) for loops - moving through an array or iterable

		String[] arr1 = { "this", "is", "an", "array" };
		String[] arr2 = new String[4];
		for (int i = 0; i < arr2.length; ++i) {
			arr2[i] = "element " + (i + 1);
		}

		System.out.println(arr2.toString()); // using toString from Array
		System.out.println(Arrays.toString(arr2)); // using toString from Arrays

		int[][] arr3 = new int[4][3];
		arr3[0][0] = 7;
		arr3[0][2] = 8;
		arr3[3][0] = 9;
		arr3[3][2] = 10;

		for (int[] a : arr3) {
			System.out.println(Arrays.toString(a));
		}

	}

	static void funWithStrings() {

		// String Literal
		String a = "hello";
		String b = new String("hello");

		// .equals() is inherited from Object
		// most reference types override to define "equality"
		// (usually by fields)
		// String has it overridden to check the string literal
		System.out.println("string a is equal to string b: " + a.equals(b));

		// == is good for comparing primitives
		// or checking whether two objects are the same object
		// (compare the REFERENCE)
		System.out.println("string a is the same object as string b: " + (a == b));

		// a and b are two different objects pointing to the same literal in the string
		// pool

	}

}

package com.revature.examples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class IteratorDemo {

	public static void main(String[] args) {
		
		ArrayList<Integer> exampleList = new ArrayList<Integer>();
		exampleList.add(6);
		exampleList.add(15);
		exampleList.add(49);
		exampleList.add(61);
		exampleList.add(62);
		exampleList.add(90);
		System.out.println(exampleList);
		
		Iterator<Integer> iterator1 = exampleList.iterator();
		
		/*
		while (iterator1.hasNext()) {
			if(iterator1.next() % 2 != 0) {
				iterator1.remove();
			}
		}
			
		*/
		Vector<String> v = new Vector<String>(3,2);
		
		v.addElement("red");
		v.addElement("green");
		v.addElement("blue");
		v.addElement("orange");
		
		Iterator<String> iterator2 = v.iterator();
		
		while(iterator1.hasNext() && iterator2.hasNext()) {
			System.out.println("next value in arrayList: " + iterator1.next());
			System.out.println("next value in Vector c: "+ iterator2.next());
		}
		
		/*
		 * && vs &, || vs |
		 * doubles are short-circuit operators - second operand is not checked
		 * if ... 
		 * for &&, if first operand is false
		 * for ||, if first operand is true
		 * singles are 'bitwise' operators
		 * preference is short-circuit (&&, ||)
		 */
	}

}

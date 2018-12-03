package com.revature.examples;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {

	public static void main(String[] args) {
		HashSet <Integer> myHash = new HashSet <Integer>();
		for(int i = 0; i < 100; ++i) {
			myHash.add(new Integer(i));
		}
		
		myHash.add(new Integer(-31));
		
		 Iterator<Integer> myIter = myHash.iterator();
		 System.out.println(myIter.next());
		 System.out.println(myIter.next());
		

	}

}

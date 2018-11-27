package com.revature.transport;

//abstract class can not be instantiated
//if there is ONE (or more) abstract method(s), the class MUST be ABSTRACT 
//(note: opposite of ABSTRACT is CONCRETE which is default)
public abstract class Vehicle {

	public Vehicle() {
		super();// calls Object()
		System.out.println("Vehicle constructor completed");
	}

	// I will have to implement this method in the first concrete subclass
	public abstract void move();

}

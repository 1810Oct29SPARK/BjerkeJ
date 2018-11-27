package com.revature.examples;

//Brain Teaser Example
class Bird {
	{
		System.out.println("b1");
	}

	Bird() {
		System.out.println("b2");
	}

	static {
		System.out.println("b3");
	}
}

class Raptor extends Bird {
	static {
		System.out.println("r1");
	}

	public Raptor() {
		super();
		System.out.println("r2");
	}

	{
		System.out.println("r2");
	}
	static {
		System.out.println("r3");
	}
}

public class Hawk extends Raptor {

	public static void main(String[] args) {
		System.out.println("init");
		new Hawk();
		System.out.println("hawk");
	}
}

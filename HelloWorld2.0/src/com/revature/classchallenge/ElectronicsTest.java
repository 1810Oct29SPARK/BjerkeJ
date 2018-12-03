package com.revature.classchallenge;

public class ElectronicsTest {

	public static void main(String[] args) {
		PersonalComputer myComputer = new PersonalComputer("Inspirion", "i7", "Dell", 1200, "Laptop", "Windows");
		System.out.println(myComputer);
		myComputer.displayOn();
		myComputer.turnOn();
		Electronics[] inHome = { new PersonalComputer("Vaio", "i7", "Sony", 1300, "Laptop", "Windows"),
				new Television("MN35152JD", "intel", "Samsung", 100, 55, "QLED", 16, "Surround"),
				new SmartPhone("iPhone 6SE", "A11", "Apple", 1000, 6.0, "Smart Phone", "Lighting"),
				new Refridgerator("RF53214NH", "518", "LG", 9, "French", "28.6 cu.ft", true, true),
				new Microwave("EM9532143", "4M", "Toshiba", 19, 1200, true, "Button") };
		for (int i = 0; i < inHome.length; ++i) {
			System.out.println(inHome[i]);
			inHome[i].turnOn();
			inHome[i].turnOff();
			System.out.println(inHome[i].model.length());
			System.out.println(inHome[i].make.toUpperCase());
			System.out.println(inHome[i].model.toLowerCase());
		}
		System.out.println(inHome[3].model.substring(3, 8));
		System.out.println(inHome[4].model.concat(inHome[2].model));
		System.out.println(inHome[1].make.replaceAll("Sam", "Shmam"));
		System.out.println(inHome[1].model.getBytes());
		String[] mySplit = inHome[1].processor.split("");
		for (String str : mySplit) {
			System.out.print(str + ", ");
		}
	}
}

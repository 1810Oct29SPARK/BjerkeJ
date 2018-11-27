package com.revature.transport;

public class Car extends Vehicle implements Steerable{

	public Car(int yearMan, String model, String make, double milesSinceOil) {
		super();
		this.yearMan = yearMan;
		this.model = model;
		this.make = make;
		this.milesSinceOil = milesSinceOil;
		System.out.println("Car constructor completed");
	}

	// super references the constructor of the parent class
	public Car() {
		super(); // calls Vehicle()
		System.out.println("Car NO-args constructor completed");
	}

	public static final int milesbtwOil = 5000;

	private int yearMan;
	private String model;
	private String make;
	private double milesSinceOil;

	@Override
	public void move() {
		System.out.println("Car is moving");
	}

	public int getYearMan() {
		return yearMan;
	}

	public void setYearMan(int yearMan) {
		this.yearMan = yearMan;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public double getMilesSinceOil() {
		return milesSinceOil;
	}

	public void setMilesSinceOil(double milesSinceOil) {
		this.milesSinceOil = milesSinceOil;
	}

	@Override
	public String toString() {
		return "Car [Year Manufactured = " + yearMan + ", Model = " + model + ", Make = " + make
				+ ", Miles since last Oil Change = " + milesSinceOil + "]";
	}

	@Override
	public void turnRight() {
		System.out.println("Turn wheel clockwise");
	}

	@Override
	public void turnLeft() {
		System.out.println("Turn wheel counter-clockwise");
	}
}

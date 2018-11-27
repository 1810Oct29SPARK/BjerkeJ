package com.revature.classchallenge;

public class PersonalComputer extends Electronics implements Displayable, Connectable {

	public PersonalComputer(String model, String processor, String make, int numChips, String compType,
			String opSystem) {
		super(model, processor, make, numChips);
		this.compType = compType;
		this.opSystem = opSystem;
	}

	private String compType;
	private String opSystem;

	public PersonalComputer() {
		super();
	}

	@Override
	public void accessInternet() {
		System.out.println("Computer accesses internet.");

	}

	@Override
	public void disconnectInternet() {
		System.out.println("Computer disconnects from internet.");

	}

	@Override
	public void displayOn() {
		System.out.println("The monitor is now on.");

	}

	@Override
	public void displayOff() {
		System.out.println("The monitor is now off.");

	}

	@Override
	public void refresh() {
		System.out.println("The computer refreshed.");

	}

	@Override
	public void turnOn() {
		System.out.println("The computer is now on.");

	}

	@Override
	public void turnOff() {
		System.out.println("The computer is now off.");

	}

	public String getCompType() {
		return compType;
	}

	public void setCompType(String compType) {
		this.compType = compType;
	}

	public String getOpSystem() {
		return opSystem;
	}

	public void setOpSystem(String opSystem) {
		this.opSystem = opSystem;
	}

	@Override
	public String toString() {
		return "PersonalComputer [compType=" + compType + ", opSystem=" + opSystem + ", model=" + model + ", processor="
				+ processor + ", make=" + make + ", numChips=" + numChips + "]";
	}

}

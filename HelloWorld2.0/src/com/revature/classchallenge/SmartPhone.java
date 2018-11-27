package com.revature.classchallenge;

public class SmartPhone extends Electronics implements Connectable, Displayable {

	public SmartPhone(String model, String processor, String make, int numChips, double dataLimit, String phoneType,
			String portType) {
		super(model, processor, make, numChips);
		this.dataLimit = dataLimit;
		this.phoneType = phoneType;
		this.portType = portType;
	}

	public SmartPhone() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SmartPhone(String model, String processor, String make, int numChips) {
		super(model, processor, make, numChips);
		// TODO Auto-generated constructor stub
	}

	private double dataLimit;
	private String phoneType;
	private String portType;

	@Override
	public void accessInternet() {
		System.out.println("Phone accesses internet.");

	}

	@Override
	public void disconnectInternet() {
		System.out.println("Phone disconnects from internet.");

	}

	@Override
	public void displayOn() {
		System.out.println("The screen is now on.");

	}

	@Override
	public void displayOff() {
		System.out.println("The screen is now off.");

	}

	@Override
	public void refresh() {
		System.out.println("The Phone refreshed.");

	}

	@Override
	public void turnOn() {
		System.out.println("The Phone is now on.");

	}

	@Override
	public void turnOff() {
		System.out.println("The Phone is now off.");

	}

	public double getDataLimit() {
		return dataLimit;
	}

	public void setDataLimit(double dataLimit) {
		this.dataLimit = dataLimit;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getPortType() {
		return portType;
	}

	public void setPortType(String portType) {
		this.portType = portType;
	}

	@Override
	public String toString() {
		return "SmartPhone [dataLimit=" + dataLimit + ", phoneType=" + phoneType + ", portType=" + portType + ", model="
				+ model + ", processor=" + processor + ", make=" + make + ", numChips=" + numChips + "]";
	}

}

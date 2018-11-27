package com.revature.classchallenge;

public class Microwave extends Electronics implements Connectable, NoDisplay {

	public Microwave(String model, String processor, String make, int numChips, float wattage, boolean autoDefrost,
			String openType) {
		super(model, processor, make, numChips);
		this.wattage = wattage;
		this.autoDefrost = autoDefrost;
		this.openType = openType;
	}

	public Microwave() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Microwave(String model, String processor, String make, int numChips) {
		super(model, processor, make, numChips);
		// TODO Auto-generated constructor stub
	}

	private float wattage;
	private boolean autoDefrost;
	private String openType;

	@Override
	public void accessInternet() {
		System.out.println("Microwave accessed internet.");

	}

	@Override
	public void disconnectInternet() {
		System.out.println("Microwave disconnected from internet.");

	}

	@Override
	public void turnOn() {
		System.out.println("The Microwave is plugged in.");

	}

	@Override
	public void turnOff() {
		System.out.println("The Microwave is unplugged.");

	}

	public float getWattage() {
		return wattage;
	}

	public void setWattage(float wattage) {
		this.wattage = wattage;
	}

	public boolean isAutoDefrost() {
		return autoDefrost;
	}

	public void setAutoDefrost(boolean autoDefrost) {
		this.autoDefrost = autoDefrost;
	}

	public String getOpenType() {
		return openType;
	}

	public void setOpenType(String openType) {
		this.openType = openType;
	}

}

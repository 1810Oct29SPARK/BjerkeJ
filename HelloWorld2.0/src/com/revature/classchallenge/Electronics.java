package com.revature.classchallenge;

public abstract class Electronics {

	public Electronics(String model, String processor, String make, int numChips) {
		super();
		this.model = model;
		this.processor = processor;
		this.make = make;
		this.numChips = numChips;
	}

	public Electronics() {
		super();
	}

	protected String model;
	protected String processor;
	protected String make;
	protected int numChips;

	public abstract void turnOn();

	public abstract void turnOff();

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public int getNumChips() {
		return numChips;
	}

	public void setNumChips(int numChips) {
		this.numChips = numChips;
	}

	@Override
	public String toString() {
		return "Electronics [model=" + model + ", processor=" + processor + ", make=" + make + ", numChips=" + numChips
				+ "]";
	}

}

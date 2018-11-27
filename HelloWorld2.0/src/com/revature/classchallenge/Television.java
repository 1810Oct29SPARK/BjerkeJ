package com.revature.classchallenge;

public class Television extends Electronics implements Connectable, Displayable {

	public Television(String model, String processor, String make, int numChips, float screenSize, String displayType,
			int currentVolume, String soundOutput) {
		super(model, processor, make, numChips);
		this.screenSize = screenSize;
		this.displayType = displayType;
		this.currentVolume = currentVolume;
		this.soundOutput = soundOutput;
	}

	public Television() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Television(String model, String processor, String make, int numChips) {
		super(model, processor, make, numChips);
		// TODO Auto-generated constructor stub
	}

	private float screenSize;
	private String displayType;
	private int currentVolume;
	private String soundOutput;

	@Override
	public void accessInternet() {
		System.out.println("Television accesses internet.");

	}

	@Override
	public void disconnectInternet() {
		System.out.println("Television disconnects from internet.");

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
		System.out.println("The Televsion refreshed.");

	}

	@Override
	public void turnOn() {
		System.out.println("The Television is now on.");

	}

	@Override
	public void turnOff() {
		System.out.println("The Television is now off.");

	}

	public float getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(float screenSize) {
		this.screenSize = screenSize;
	}

	public String getDisplayType() {
		return displayType;
	}

	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}

	public int getCurrentVolume() {
		return currentVolume;
	}

	public void setCurrentVolume(int currentVolume) {
		this.currentVolume = currentVolume;
	}

	public String getSoundOutput() {
		return soundOutput;
	}

	public void setSoundOutput(String soundOutput) {
		this.soundOutput = soundOutput;
	}

	@Override
	public String toString() {
		return "Television [screenSize=" + screenSize + ", displayType=" + displayType + ", currentVolume="
				+ currentVolume + ", soundOutput=" + soundOutput + ", model=" + model + ", processor=" + processor
				+ ", make=" + make + ", numChips=" + numChips + "]";
	}

}

package com.revature.classchallenge;

public class Refridgerator extends Electronics implements Connectable, NoDisplay {

	public Refridgerator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Refridgerator(String model, String processor, String make, int numChips, String doorType,
			String storageSpace, boolean iceMaker, boolean freezer) {
		super(model, processor, make, numChips);
		this.doorType = doorType;
		this.storageSpace = storageSpace;
		this.iceMaker = iceMaker;
		this.freezer = freezer;
	}

	private String doorType;
	private String storageSpace;
	private boolean iceMaker;
	private boolean freezer;

	@Override
	public void accessInternet() {
		System.out.println("Refridgerator accessed internet.");

	}

	@Override
	public void disconnectInternet() {
		System.out.println("Refridgerator disconnected from internet.");

	}

	@Override
	public void turnOn() {
		System.out.println("The Refridgerator is plugged in.");

	}

	@Override
	public void turnOff() {
		System.out.println("The Refridgerator is unplugged.");

	}

	public String getDoorType() {
		return doorType;
	}

	public void setDoorType(String doorType) {
		this.doorType = doorType;
	}

	public String getStorageSpace() {
		return storageSpace;
	}

	public void setStorageSpace(String storageSpace) {
		this.storageSpace = storageSpace;
	}

	public boolean isIceMaker() {
		return iceMaker;
	}

	public void setIceMaker(boolean iceMaker) {
		this.iceMaker = iceMaker;
	}

	public boolean isFreezer() {
		return freezer;
	}

	public void setFreezer(boolean freezer) {
		this.freezer = freezer;
	}

	@Override
	public String toString() {
		return "Refridgerator [doorType=" + doorType + ", storageSpace=" + storageSpace + ", iceMaker=" + iceMaker
				+ ", freezer=" + freezer + ", model=" + model + ", processor=" + processor + ", make=" + make
				+ ", numChips=" + numChips + "]";
	}

}

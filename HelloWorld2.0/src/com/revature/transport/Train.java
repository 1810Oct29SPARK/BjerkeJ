package com.revature.transport;

import com.revature.transport.*;

public class Train extends Vehicle {
	
	public Train() {
		super();
	}

	public Train(double maxSpeed, int carLength) {
		super();
		this.maxSpeed = maxSpeed;
		this.carLength = carLength;
	}

	protected double maxSpeed;
	protected int carLength;
	protected boolean onRails;
	
	@Override
	public void move() throws MaintenanceException{
		if(!this.onRails) {
			throw new MaintenanceException("Train is derailed");
		}
		System.out.println("The train is moving");

	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getCarLength() {
		return carLength;
	}

	public void setCarLength(int carLength) {
		this.carLength = carLength;
	}

	@Override
	public String toString() {
		return "Train [Max Speed=" + maxSpeed + ", Car Length=" + carLength + "]";
	}


}

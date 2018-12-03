package com.revature.transport;

import com.revature.transport.*;

public class Boat extends Vehicle implements Steerable {

	public Boat(String color, double hullLength) {
		super();
		this.color = color;
		this.hullLength = hullLength;
		System.out.println("Boat constructor completed");
	}

	public Boat() {
		super();
		System.out.println("Boat NO-args constructor completed");
	}

	protected String color;
	protected double hullLength;
	protected boolean hasHole;

	@Override
	public void move() throws MaintenanceException{
		if(this.hasHole) {
			throw new MaintenanceException("unseaworthy");
		}
		System.out.println("Boat is moving");
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getHullLength() {
		return hullLength;
	}

	public void setHullLength(double hullLength) {
		this.hullLength = hullLength;
	}

	@Override
	public String toString() {
		return "Boat [Color = " + color + ", Hull Length = " + hullLength + "]";
	}

	@Override
	public void turnRight() {
		System.out.println("Turn wheel clockwise");
		
	}

	@Override
	public void turnLeft() {
		System.out.println("Turn wheel counter-clockwise");
		
	}

	public boolean isHasHole() {
		return hasHole;
	}

	public void setHasHole(boolean hasHole) {
		this.hasHole = hasHole;
	}

}

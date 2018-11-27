package com.revature.transport;

public class Kayak extends Boat {

	public Kayak(String color, double hullLength, int numSeats, double paddleLength) {
		super(color, hullLength);
		this.numSeats = numSeats;
		this.paddleLength = paddleLength;
		System.out.println("Kayak constructor completed");
	}

	public Kayak() {
		super();
		System.out.println("Kayak NO-argsconstructor completed");
	}

	private int numSeats;
	private double paddleLength;

	@Override
	public void move() {
		System.out.println("The Kayak is moving");
	}

	public int getNumSeats() {
		return numSeats;
	}

	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}

	public double getPaddleLength() {
		return paddleLength;
	}

	public void setPaddleLength(double paddleLength) {
		this.paddleLength = paddleLength;
	}

	@Override
	public String toString() {
		return "Kayak [Number of Seats = " + numSeats + ", Paddle Length = " + paddleLength + ", Color = " + color
				+ ", Hull Length = " + hullLength + "]";
	}
	
	@Override
	public void turnRight() {
		System.out.println("Paddle right");
	}

	@Override
	public void turnLeft() {
		System.out.println("Paddle left");
	}

}

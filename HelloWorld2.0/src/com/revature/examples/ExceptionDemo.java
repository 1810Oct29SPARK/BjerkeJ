package com.revature.examples;

import com.revature.transport.*;

public class ExceptionDemo {

	public static void main(String[] args) throws MaintenanceException {

		// create a new car object
		Car myCar = new Car(2005, "Focus", "Ford", 1200);

		// in Car, change overridden move() from vehicle so that a MaintenanceException
		// can be thrown if oil has not been changed

		try {
			myCar.move();
		} catch (MaintenanceException m) {
			m.printStackTrace();
		}
		myCar.setMilesSinceOil(5600);
		try {
			myCar.move();
		} catch (MaintenanceException d) {
			d.printStackTrace();
		}

	}

}

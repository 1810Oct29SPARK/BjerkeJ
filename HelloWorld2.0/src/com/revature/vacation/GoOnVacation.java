package com.revature.vacation;

//imports all classes from the package
import com.revature.transport.*;

//to get a specific class, use import package.classname;

//static imports within a class(ONE CLASS)
import static com.revature.transport.Car.milesbtwOil;

public class GoOnVacation {

	public static void main(String[] args) {
		System.out.println("Let's go to Miami");
		System.out.println("We need a car");

		// using fully qualified classname of Car (package.classname)
		// com.revature.transport.Car c = new com.revature.transport.Car();
		// or we could use imports to save typing
		Car c = new Car(2021, "Spaceship", "Tesla", 835.1);
		// c.setMake("Tesla");
		// c.setYearMan(2021);
		// c.setModel("Spaceship");
		// c.setMilesSinceOil(50);
		System.out.println(c);
		System.out.println(c.toString()); // prints out whatever the toString is.
		System.out.println("Do we need to change the oil first?");
		System.out.println("Recommended miles between oil changes: " + Car.milesbtwOil);
		if (c.getMilesSinceOil() >= Car.milesbtwOil) {
			System.out.println("Stop! Change your oil!");
		} else {
			System.out.println("Good to go!");
		}
		Kayak b = new Kayak("Red", 3.5, 2, 2);
		Kayak a = new Kayak();
		// system.out.println(k.getColor()); //inherited from Superclass
		System.out.println(b);
		Vehicle[] vehicles = { new Train(100, 43), new Kayak("Blue", 3, 2, 1.75),
				new Car(2009, "Toyota", "Camry", 3289), new Boat("Silver", 12) };
		System.out.println(chooseAVehicle(vehicles));
		System.out.println(v);
	}

	static Vehicle chooseAVehicle(Vehicle[] garage) {
		Vehicle chosenVehicle = null;

		for (int i = 0; i < garage.length; ++i) {
			Vehicle v = vehicles[i];
			if (v instanceof Steerable && !(v instanceof Boat)) {
				chosenVehicle = v;
				return chosenVehicle; // as soon as i find one, return that vehicle
			}
		}

	}

}

package objectOrientedProgramming.inheritance;

/**
 * Inheritance is a way to create a new class that is a modified version of an
 * existing class. It promotes code re-usability.
 */
public class Inheritance {

}

class Car extends VehicleClass {
	// Additional property specific to Car
	boolean convertible;

	// Constructor for Car
	public Car(String color, int wheels, boolean convertible) {
		super(color, wheels); // Call the constructor of the superclass (Vehicle)
		this.convertible = convertible;
	}

	// Additional method specific to Car
	public void putTopDown() {
		if (convertible) {
			System.out.println("Putting the top down.");
		} else {
			System.out.println("This car is not convertible.");
		}
	}
}

//https://www.geeksforgeeks.org/inheritance-in-java/?ref=lbp

/**
 * There are 5 different types of inheritance in java as follows:
 * 
 * Single Inheritance: Class B inherits Class A using extends keyword 
 * 
 * Multilevel Inheritance: Class C inherits class B and B inherits class A using extends keyword
 *  
 * Hierarchy Inheritance: Class B and C inherits class A in hierarchy order using extends keyword 
 * 
 * Multiple Inheritance: Class C inherits Class A and B. Here A and B both are superclass and C is only one child class. 
 * Java is not supporting Multiple Inheritance, but we can implement using
 * Interfaces. 
 * 
 * Hybrid Inheritance: Class D inherits class B and class C. Class B
 * and C inherits A. Here same again Class D inherits two superclass, so Java is
 * not supporting Hybrid Inheritance as well. Example:
 */

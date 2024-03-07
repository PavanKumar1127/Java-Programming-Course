package objectOrientedProgramming;

/**
 * A class is like a blueprint that describes how to create an object. It
 * defines the properties (attributes) and behaviors (methods) that the object
 * will have.
 */
public class VehicleClass {

	// Properties
	String color;
	int wheels;

	// Constructor
	public VehicleClass(String color, int wheels) {
		this.color = color;
		this.wheels = wheels;
	}

	// Method: A method is a collection of statements that perform some specific
	// task and return the result to the caller.
	public void start() {
		System.out.println("The vehicle is starting.");
	}
}

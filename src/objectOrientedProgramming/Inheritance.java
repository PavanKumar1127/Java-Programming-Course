package objectOrientedProgramming;

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

package objectOrientedProgramming;

/**
 * Polymorphism allows a single entity (like a method) to take on various forms.
 * It can be achieved through method overloading or overriding.
 */
public class Polymorphism {

	public static void main(String[] args) {
        // Polymorphism through method overriding
        VehicleClass car = new Car("Blue", 4, true);
        car.start(); // This will call the start() method in the Car class
    }
}

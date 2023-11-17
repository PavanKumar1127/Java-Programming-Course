package objectOrientedProgramming;

/**
 * An object is an instance of a class. It's like a real-world thing created
 * based on the blueprint provided by the class.
 */
public class Object {

    public static void main(String[] args) {
        // Creating an object of the Vehicle class
        VehicleClass car = new VehicleClass("Red", 4);

        // Accessing properties and methods of the object
        System.out.println("Color: " + car.color);
        System.out.println("Wheels: " + car.wheels);
        car.start();
    }
}

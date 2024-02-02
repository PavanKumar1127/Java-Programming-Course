package objectOrientedProgramming.abstraction;

/**
 * Abstraction is the concept of hiding the complex reality while exposing only
 * the essential parts. Abstract classes and interfaces are used for
 * abstraction.
 */
public class Abstraction {

}

/**
 * There are two ways to achieve abstraction in Java
 * 
 * Abstract class (0 to 100%) 
 * Interface (100%)
 */

//Abstract class
/**
 * The class should be abstract if a class has one or many abstract methods
 * An abstract class can have constructors, concrete methods, static method, and final method
 *Abstract class can’t be instantiated directly with the new operator. It can be possible as shown in pre tag below:
 */
abstract class Vehicle {
 // Abstract method (no implementation in the superclass)
 public abstract void start();
}

class Car1 extends Vehicle {

	@Override
	public void start() {

		/**
		 * Since B inherits from A, you can call methods declared in A on the object
		 * referred to by b. However, if B overrides any methods declared in A, the
		 * overridden version in B will be called at runtime.
		 */
	}
    // ...concrete subclass definition...
	
	public static void main(String[] args) {
		Vehicle car = new Car1();
		//Vehicle car1 = new Vehicle(); // new A() is not allowed
		//cannot directly create an instance of an abstract class using the new operator
		
	}
}


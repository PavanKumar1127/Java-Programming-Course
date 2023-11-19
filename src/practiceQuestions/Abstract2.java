package practiceQuestions;

/**
 * an abstract class can contain constructors in Java. And a constructor of an
 * abstract class is called when an instance of an inherited class is created.
 * It is as shown in the program below as follows:
 */

//Java Program to Illustrate Abstract Class 
//Can contain Constructors

//Class 1
//Abstract class
abstract class Base {

	// Constructor of class 1
	Base() {
		// Print statement
		System.out.println("Base Constructor Called");
	}

	// Abstract method inside class1
	abstract void fun();
}

//Class 2
class Derived extends Base {

	// Constructor of class2
	Derived() {
		System.out.println("Derived Constructor Called");
	}

	// Method of class2
	void fun() {
		System.out.println("Derived fun() called");
	}
}

//Class 3
//Main class
class GFG {

	// Main driver method
	public static void main(String args[]) {
		// Creating object of class 2
		// inside main() method
		Derived d = new Derived();
		d.fun();
	}
}

public class Abstract2 {

}

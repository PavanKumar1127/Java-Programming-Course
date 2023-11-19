package objectOrientedProgramming;


/**
 * an interface can have methods and variables, but the methods declared in the
 * interface are by default abstract (only method signature, nobody).
 * It is the blueprint of the class.
 */
public class Interface {

}

//Java program to demonstrate
//working of interface.

//A simple interface
interface Interface1 {
	// public, static and final
	final int a = 10;

	// public and abstract
	void display();
}

//A class that implements the interface.
class testClass implements Interface1 {

	// Implementing the capabilities of
	// interface.
	public void display() { System.out.println("Geek"); }

	// Driver Code
	public static void main(String[] args)
	{
		testClass t = new testClass();
		t.display();
		System.out.println(a);
	}
}
package javaLearningBasics.keywords;

// Allows members (fields and methods) of a class to be used without qualifying them with the class name.
import static java.lang.Math.PI;

/**
 * The static keyword in Java is used to define class-level elements (fields,
 * methods, and nested classes) rather than instance-level elements.
 */
public class Static_Keyword {

	// xecuted when the class is loaded into memory. Useful for initializing static
	// fields or performing one-time setup tasks.
	static {
		System.out.println("This is a static block");
	}

	// Declares a class-level variable shared among all instances of the class.
	static int staticVariable = 10;

	// Declares a method that belongs to the class rather than an instance. It can
	// be called using the class name without creating an instance.
	public static int add(int a, int b) {
		return a + b;
	}

	public double calculateArea(double radius) {
		return PI * radius * radius;
	}

	// Declares a local variable as static within a method, preserving its value
	// between method calls.
	public void countCalls() {
		static int count = 0;// The count variable retains its value between calls to the countCalls method.
		count++;
		System.out.println("Method called " + count + " times");
	}

	// Static can be placed inside non-static but nonstatic cannot be put inside
	// static method
	static void greeting() {
		fun();
		 // but the function you are using it in does not depend on instances

        // you cannot access non static stuff without referencing their instances in
        // a static context
		
		 // hence, here I am referencing it
		Static_Keyword obj = new Static_Keyword();
        obj.fun();
        
		System.out.println("Greetings");
	}

	//// we know that something which is not static, belongs to an object
	private void fun() {
		greeting();
		
	}
}

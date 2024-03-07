package objectOrientedProgramming.interfaceAndAbstractClass;

/**
 * An abstract class in Java is a class that cannot be instantiated and is meant
 * to be subclassed by other classes. It may contain abstract methods (methods
 * without a body) that must be implemented by its subclasses. Abstract classes
 * can have constructors, instance variables, non-abstract methods (with a
 * body), and final methods.
 */
abstract class AbstractExample {
	// Abstract methods
	public abstract void abstractMethod1();

	public abstract void abstractMethod2();

	// Static methods
	public static void staticMethod1() {
		System.out.println("Static Method 1");
	}

	public static void staticMethod2() {
		System.out.println("Static Method 2");
	}

	// Abstract classes cannot have abstract variables. Instance variables can be
	// declared as abstract, but they are implicitly treated as instance variables
	// with default values. It's recommended to use interfaces for declaring
	// constants.

	// Instance variables
	private int instanceVariable1;
	protected String instanceVariable2;
	final double PI = 3.14;

	// Constructor
	public AbstractExample(int var1, String var2) {
		this.instanceVariable1 = var1;
		this.instanceVariable2 = var2;
	}

	// Concrete method
	public void concreteMethod() {
		System.out.println("Concrete Method");
	}
}

class ConcreteClass extends AbstractExample {
	// Constructor for ConcreteClass
	public ConcreteClass(int var1, String var2) {
		super(var1, var2);
	}

	// Implementation of abstract methods
	@Override
	public void abstractMethod1() {
		System.out.println("Implementation of Abstract Method 1");
	}

	@Override
	public void abstractMethod2() {
		System.out.println("Implementation of Abstract Method 2");
	}
}

public class AbstractMain1 {
	public static void main(String[] args) {
		ConcreteClass obj = new ConcreteClass(42, "Hello");
		obj.abstractMethod1();
		obj.abstractMethod2();
		obj.staticMethod1();
		obj.staticMethod2();
		obj.concreteMethod();

		// Accessing instance variables
		System.out.println("Instance Variable 1: " + obj.instanceVariable1);
		System.out.println("Instance Variable 2: " + obj.instanceVariable2);

		// Accessing final variable
		System.out.println("PI: " + obj.PI);
	}
}

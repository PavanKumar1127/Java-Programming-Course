package objectOrientedProgramming;

//A constructor in Java is a special method used to initialize objects.

/**
 * Constructor is a special type of method that is used to initialize and set up
 * the initial state of an object when it is created. It is called automatically
 * when an object is instantiated using the new keyword. Constructors have the
 * same name as the class and do not have a return type, not even void.
 * 
 * Note: It is not necessary to write a constructor for a class. It is because
 * the java compiler creates a default constructor (constructor with no
 * arguments) if your class doesn’t have any.
 */
public class Constructor {

	private int value;
	private String string;
	// Types of Constructors:

	// Default Constructor:
	// Automatically provided by the compiler if no constructor is explicitly
	// defined in the class. Takes no parameters. Initializes fields to default
	// values.

	public Constructor() {
		// Initialization code goes here
		this(0); //Constructor chaining: Call the parameterized constructor with a default value
		System.out.println("Default constructor is called");
	}

	// Parameterized Constructor:
	// Defined by the programmer and accepts parameters.
	// Used to initialize fields with specific values when the object is created.

	public Constructor(int initValue) {
		this.value = initValue; // Using 'this' to distinguish between the parameter and the instance variable
		System.out.println("Parameterized constructor is called");

	}

	// Copy Constructor
	public Constructor(Constructor obj2) {
		this.value = obj2.value;
		System.out.println("Copy constructor is called");
	}

	private Constructor(Constructor constructor1, int i, String string) {
		// Constructor call must be the first statement in a constructor
		this(constructor1); // Call the Copy constructor
		// this(i); // Call the Parameterized constructor
		// this(); // Call the default constructor
		this.string = string;

	}

	// Constructor Overloading:
	// Like other methods, constructors can be overloaded by defining multiple
	// constructors with different parameter lists.
	// like above

	public static void main(String[] args) {

		Constructor constructor = new Constructor();
		Constructor constructor1 = new Constructor(200);
		Constructor constructor2 = new Constructor(constructor1);
		System.out.println("Copy Constructor used Second Object");
		Constructor constructor3 = new Constructor(constructor1, 300, "private constructor");

	}
}
/**
 * Can a constructor be private or default or protected? 
 * Yes, a constructor can be declared private. A private constructor is used in restricting object
 * creation.
 */


/**
 * Constructor chaining: calling the default constructor from another constructor.
 */ 

package javaLearningBasics.keywords;

/**
 * In Java, the final keyword is used to define constants, make variables
 * unmodifiable, and make methods un-overrideable or classes un-inheritable.
 * Here are several use cases of the final keyword:
 */
public class Final_Keyword {
	// examples:

	// Final Variables (Constants):
	// When a variable is declared as final, its value cannot be changed once it has
	// been assigned. It essentially makes the variable a constant.
	////// Example class

	// Final Methods:
	// When a method is declared as final in a class, it cannot be overridden by
	// subclasses. This is often used to enforce a specific behavior in the
	// subclass.
	////// Parent class Child class

	// Final Classes:
	// When a class is declared as final, it cannot be subclassed. It ensures that
	// the class cannot be extended, providing a level of control over the class
	// hierarchy.
	//////// FinalClass class

	// Final Parameters:
	// When a parameter of a method is declared as final, the method cannot modify
	// the value of that parameter inside its body.
	////Example Class
}

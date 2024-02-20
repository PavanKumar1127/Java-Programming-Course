package objectOrientedProgramming;

/**
 * enum (short for enumeration) is a special data type that represents a fixed
 * set of constants or values. Enums provide a way to create named values that
 * are distinct from each other. They are often used to define a set of related
 * constants.
 */

// Define an enum named Color
enum Color {
	RED, GREEN, BLUE; // Constants or values of the enum
}

//Key Characteristics of Enums:
//
//Fixed Set of Values: Enums define a fixed set of values, and instances of an enum can only be one of those values.
//
//Named Constants: Each value in an enum is a named constant, making the code more readable and maintainable.
//
//Singleton Pattern: Enums are often implemented as singletons, meaning there is only one instance of each value.

public class EnumExample {
	public static void main(String[] args) {
		// Using enum values
		Color myColor = Color.RED;

		// Switch statement with enums
		switch (myColor) {
		case RED:
			System.out.println("The color is red.");
			break;
		case GREEN:
			System.out.println("The color is green.");
			break;
		case BLUE:
			System.out.println("The color is blue.");
			break;
		default:
			System.out.println("Unknown color.");
		}
	}
}

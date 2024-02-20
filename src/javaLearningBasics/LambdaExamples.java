package javaLearningBasics;

/**
 * A lambda function in Java is a concise way to express instances of
 * single-method interfaces (functional interfaces). It allows you to treat
 * functionality as a method argument and create more readable and expressive
 * code.
 */

// A functional interface with a single abstract method
interface MathOperation {
	int operate(int a, int b);
}

public class LambdaExamples {
	public static void main(String[] args) {
		// Example 1: Basic lambda expression
		MathOperation addition = (a, b) -> a + b;
		System.out.println("Addition: " + operate(10, 5, addition));

		// Example 2: Lambda expression with multiple statements
		MathOperation subtraction = (a, b) -> {
			int result = a - b;
			return result;
		};
		System.out.println("Subtraction: " + operate(10, 5, subtraction));

		// Example 3: Lambda expression with a functional interface from Java library
		Runnable runnable = () -> System.out.println("Hello, Lambda!");
		runnable.run();

		// Example 4: Lambda expression in a method reference
		MathOperation multiplication = LambdaExamples::multiply;
		System.out.println("Multiplication: " + operate(10, 5, multiplication));

		// Example 5: Lambda expression with parameters and return type
		StringConcatenation concat = (s1, s2) -> s1 + " " + s2;
		System.out.println("Concatenation: " + concat.concatenate("Hello", "Lambda"));

		// Example 6: Lambda expression as an argument in a method
		processOperation(15, 3, (a, b) -> a / b); // Division
	}

	// Method to perform an operation using the MathOperation functional interface
	private static int operate(int a, int b, MathOperation operation) {
		return operation.operate(a, b);
	}

	// Method to multiply two numbers
	private static int multiply(int a, int b) {
		return a * b;
	}

	// Functional interface for string concatenation
	interface StringConcatenation {
		String concatenate(String s1, String s2);
	}

	// Method to perform an operation using the MathOperation functional interface
	private static void processOperation(int a, int b, MathOperation operation) {
		System.out.println("Result: " + operate(a, b, operation));
	}
}

package javaLearningBasics;

/**
 * Exception handling in Java is a mechanism to deal with runtime errors and
 * exceptional situations that may occur during the execution of a program. It
 * allows programmers to handle errors gracefully, preventing the program from
 * terminating.
 */
class ExceptionHandlingExample {
	public static void main(String[] args) {
		try {
			int result = divide(10, 0);
			System.out.println("Result: " + result);
		} catch (ArithmeticException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			System.out.println("This block always executes.");
		}
	}

	// throw is used to explicitly throw an exception.
	// throws is used in the method signature to declare that a method might throw
	// certain exceptions.

	static int divide(int a, int b) throws ArithmeticException {
		if (b == 0) {
			throw new ArithmeticException("Cannot divide by zero.");
		}
		return a / b;
	}
}

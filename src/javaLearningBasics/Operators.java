package javaLearningBasics;

/**
 * Operators are special symbols or keywords that perform operations on
 * operands, which can be variables, values, or expressions. Operators allow you
 * to manipulate data and perform various computations.
 */
public class Operators {

	public static void main(String[] args) {
		//1. Arithmetic Operators:
	 
		int a = 5, b = 2;
		int sum = a + b;   // Addition
		int difference = a - b;   // Subtraction
		int product = a * b;   // Multiplication
		int quotient = a / b;   // Division
		int remainder = a % b;   // Modulus (remainder)
		
		// 2. Comparison Operators:
		// Compare two values and return a boolean result.
		int x = 5, y = 8;
		boolean isEqual = (x == y); // Equal to
		boolean isNotEqual = (x != y); // Not equal to
		boolean isGreaterThan = (x > y); // Greater than
		boolean isLessThan = (x < y); // Less than
		boolean isGreaterOrEqual = (x >= y); // Greater than or equal to
		boolean isLessOrEqual = (x <= y); // Less than or equal to
		
		//3. Logical Operators:
		//Combine boolean expressions.
		boolean condition1 = true, condition2 = false;
		boolean andResult = (condition1 && condition2);   // Logical AND mul
		boolean orResult = (condition1 || condition2);   // Logical OR add
		boolean notResult = !condition1;   // Logical NOT
		
		//4. Assignment Operators:
		// Assign values to variables.
		int num = 10;
		num += 5;   // Equivalent to: num = num + 5;
		num -= 3;   // Equivalent to: num = num - 3;
		
		//5. Increment and Decrement Operators:
		//Increase or decrease the value of a variable by 1.
		int counter = 0;
		counter++;   // Increment by 1
		counter--;   // Decrement by 1
		
		//6. Bitwise Operators:
		// Perform operations at the bit level.
		int c = 5, d = 3;
		int bitwiseAnd = c & d;   // Bitwise AND
		int bitwiseOr = c | d;   // Bitwise OR
		int bitwiseXor = c ^ d;   // Bitwise XOR
		int bitwiseNot = ~c;   // Bitwise NOT
		
		//7. Conditional (Ternary) Operator:
		// Provides a shorthand way to write an if-else statement.
	
		int e = 5, f = 10;
		int result = (e > f) ? e : f;   // If e > f, result = e; otherwise, result = f;
	}
}

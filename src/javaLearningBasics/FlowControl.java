package javaLearningBasics;

/**
 * 
 * In programming, decision-making is like real-life decision-making. Just as we
 * make choices based on certain conditions, a computer program uses control
 * statements to decide what to do next. These statements guide the program's
 * flow, making it go in different directions depending on specific conditions
 * or situations. It's a way for the program to adapt and respond to different
 * scenarios, similar to how we make decisions in our daily lives.
 */
public class FlowControl {

//	 Java’s Selection statements:
//	 if 
//	 if-else 
//   nested-if 
//	 if-else-if 
//	 switch-case 
//	 jump – break, continue, return

	public static void main(String[] args) {

		// 1. if Statement:
		// The if statement is used for simple decision-making. It executes a block of
		// code if a given condition is true.

		int x = 10;
		if (x > 5) {
			System.out.println("x is greater than 5");
		}
		// Drawback: It doesn't provide an alternative action if the condition is false.

		// 2. if-else Statement:
		// The if-else statement extends if by providing an alternative action if the
		// condition is false.

		int y = 3;
		if (y > 5) {
			System.out.println("x is greater than 5");
		} else {
			System.out.println("x is not greater than 5");
		}
		// Drawback: It may become nested and less readable if multiple conditions need
		// to be checked.

		// 3. Nested if Statement:
		//Nested if statements involve placing one if statement inside another. It is used when a decision depends on multiple conditions.

		int a = 10, b = 5;
		if (a > 5) {
		    if (b > 3) {
		        System.out.println("Both x and y meet the conditions");
		    }
		}
		//Drawback: May lead to complex and hard-to-read code, especially with deeper nesting.
		
		
		
		//4. if-else-if Statement:
		//The if-else-if statement allows checking multiple conditions in sequence until one of them is true.
		
		int z = 7;
		if (z < 5) {
		    System.out.println("x is less than 5");
		} else if (z < 10) {
		    System.out.println("x is less than 10 but not less than 5");
		} else {
		    System.out.println("x is greater than or equal to 10");
		}
		
		//Drawback: Similar to if-else, it can become hard to manage with many conditions.
		
		
		//5. switch-case Statement:
		//The switch-case statement is used when you have multiple possible values for a variable and want to execute different code for each value.
		
		int day = 3;
		switch (day) {
		    case 1:
		        System.out.println("Monday");
		        break;
		    case 2:
		        System.out.println("Tuesday");
		        break;
		    // ... other cases
		    default:
		        System.out.println("Invalid day");
		}
		//Drawback: It only works with certain types (e.g., int, char, String) and has the limitation that cases must be constants
		
		//break: Used to terminate a loop or switch statement prematurely.
		//continue: Skips the rest of the loop's code for the current iteration and moves to the next iteration.
		//return: Used to exit a method and can also return a value.
		
	}
}

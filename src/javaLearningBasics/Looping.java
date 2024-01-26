package javaLearningBasics;

public class Looping {

	/**
	 * In programming, looping is a way to repeat a set of instructions as long as
	 * certain conditions is true.
	 */
	public static void main(String[] args) {

		//1). for Loop:
		//Used when you know how many times you want to repeat the code.
		
		for (int i=0;i<=10;i++)
	       {
	         System.out.println(i);
	       }
		//Drawback: Initialization and Increment in Different Places
		
		
		//2). while Loop:
		//Used when you want to repeat code as long as a condition is true.
		
		int j=0;
	      while (j<=10)
	      {
	        System.out.println(j);
	        j++;
	      }
	      //Drawback: Risk of Infinite Loop
	      
	      
	      //do-while Loop:
	      //Similar to while loop but ensures the code inside is executed at least once.
	      
	      int x=0;
	      do
	      {
	        System.out.println(x);
	        x++;
	      }while(x<=10);
	      //Drawback: Initial Code Execution Even If Condition is False
	      
	      //Example for do-while
//	      Scanner scanner = new Scanner(System.in);
//	        int userInput;
//
//	        do {
//	            System.out.print("Enter a positive number (enter 0 to exit): ");
//	            userInput = scanner.nextInt();
//
//	            if (userInput > 0) {
//	                System.out.println("You entered: " + userInput);
//	            } else if (userInput < 0) {
//	                System.out.println("Please enter a positive number.");
//	            } else {
//	                System.out.println("Exiting the program. Goodbye!");
//	            }
//
//	        } while (userInput != 0);
//
//	        scanner.close();
	}
}

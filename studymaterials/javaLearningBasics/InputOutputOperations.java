package javaLearningBasics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * In Java, input and output operations are performed using the
 * java.util.Scanner class for input and various classes from the java.io
 * package for output.
 */
public class InputOutputOperations {

	public static void main(String[] args) throws IOException {
		
		////Input in Java:
		
		//1. Using java.util.Scanner:
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        
        System.out.println("Hello, " + name + "! You are " + age + " years old.");
        //next(); - It is used to read the next token (usually separated by whitespace) from the input. 
        //nextDouble(); nextFloat(); nextInt();
        
        //2. Using BufferedReader: (BufferedReader from the java.io package)
        // throws IOException
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter your name: ");
        String name_1 = reader.readLine();

        System.out.print("Enter your age: ");
        int age_1 = Integer.parseInt(reader.readLine());

        System.out.println("Hello, " + name_1 + "! You are " + age_1 + " years old.");

        reader.close();
        
        scanner.close();
		// ensure to close the Scanner when you're done with it to avoid resource leaks:


	}
}

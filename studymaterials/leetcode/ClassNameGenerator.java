package leetcode;

import java.util.Scanner;

public class ClassNameGenerator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a string: ");
		//103. Binary Tree zigzag Level order Traversal
		String input = scanner.nextLine();
		String output = "Leetcode_" + removeSpaces(input);
		System.out.println("Output: " + output);
	}

	public static String removeSpaces(String input) {
		StringBuilder output = new StringBuilder();
		char[] inputChars = input.toCharArray();
		int count = 0;
		for (int i = 0; i < inputChars.length; i++) {
			char c = inputChars[i];
			
			if (c == '.') {
				continue;
			}
			if (c != ' ') {
				// Append non-space characters to the output string
				output.append(c);
			} else {
				count++;
				// Replace spaces with underscores
				if (count <= 1) {
					output.append('_');
				}
				if (i + 1 < inputChars.length && Character.isLowerCase(inputChars[i + 1])) {
					inputChars[i + 1] = Character.toUpperCase(inputChars[i + 1]);
					continue;
				}if (i + 1 < inputChars.length && Character.isUpperCase(inputChars[i + 1])) {
					continue;
				}
				output.append(c);
                
			}
		}
		return output.toString();
	}
}

package javaLearningBasics;

public class BitwiseXOR {
	public static void main(String[] args) {
		
	}
/**
 * Swapping Values:

XOR can be used to swap the values of two variables without using a temporary variable. This is based on the property that (a ^ b) ^ b is equal to a.

int a = 5, b = 10;
a = a ^ b;
b = a ^ b;
a = a ^ b;


Detecting Odd Occurrences:

XOR can be used to find an element that occurs an odd number of times in an array. Since XOR of a number with itself is 0, and XOR of a number with 0 is the number itself, the odd-occurring element will remain after XORing all elements.

int[] array = {2, 3, 4, 3, 2, 5, 5};
int result = 0;
for (int num : array) {
    result ^= num;
}
System.out.println("Odd occurring element: " + result);


Flipping Bits:

XOR can be used to flip specific bits in a number. For example, to toggle the nth bit, you can XOR the number with 1 << n.

int number = 12; // Binary: 1100
int n = 2;
number = number ^ (1 << n); // Toggles the 2nd bit


Detecting Duplicates:

XOR can be used to find duplicates in an array. XORing all elements will leave the duplicate element.

int[] array = {1, 2, 3, 4, 3, 2, 1};
int result = 0;
for (int num : array) {
    result ^= num;
}
System.out.println("Duplicate element: " + result);


Encoding and Decoding:

XOR can be used for simple encoding and decoding of data. XORing data with a specific key and then XORing it again with the same key will return the original data.	
 */

}

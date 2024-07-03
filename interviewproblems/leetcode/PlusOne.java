package leetcode;
import java.util.Arrays;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Understanding the problem:
The problem gives an array of digits, return a new array plus one to the number. Note that the digits are stored such that the most significant digit is at the head of the list. We can take several examples to show the problem:

For the input array 123, the new array is 124.
For the input array 99, the new array is 100.
For the input array 9, the new array is 10.
For the empty array [ ], the new array is [1].
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        // Traverse the array from the end
        for (int i = n - 1; i >= 0; i--) {
            // If the current digit is less than 9, just add 1 to it and return the array
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // If the current digit is 9, set it to 0
            digits[i] = 0;
        }

        // If we reach here, it means all digits were 9
        // We need to add an additional digit at the beginning
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1; // Set the first digit to 1

        return newDigits;
    }

    public static void main(String[] args) {
        // Test cases
        int[] digits1 = {1, 2, 3};
        System.out.println("Input: " + Arrays.toString(digits1) + " Output: " + Arrays.toString(plusOne(digits1)));

        int[] digits2 = {9, 9};
        System.out.println("Input: " + Arrays.toString(digits2) + " Output: " + Arrays.toString(plusOne(digits2)));

        int[] digits3 = {0};
        System.out.println("Input: " + Arrays.toString(digits3) + " Output: " + Arrays.toString(plusOne(digits3)));

        int[] digits4 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        System.out.println("Input: " + Arrays.toString(digits4) + " Output: " + Arrays.toString(plusOne(digits4)));
    }
}

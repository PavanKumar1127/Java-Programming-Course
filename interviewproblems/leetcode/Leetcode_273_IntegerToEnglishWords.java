package leetcode;

import java.util.Arrays;

// Convert an integer to its English words representation
// https://leetcode.com/problems/integer-to-english-words/description/
public class Leetcode_273_IntegerToEnglishWords {

	private static final String[] BELOW_20 = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
			"Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
			"Nineteen" };

	private static final String[] BELOW_100 = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
			"Eighty", "Ninety" };

	private static final String[] THOUSANDS = { "", "Thousand", "Million", "Billion" };

	public static String numberToWords(int num) {
		if (num == 0)
			return "Zero";
		return helper(num).trim();
	}

	private static String helper(int num) {
		if (num < 20) {
			return BELOW_20[num];
		} else if (num < 100) {
			return BELOW_100[num / 10] + (num % 10 != 0 ? " " + BELOW_20[num % 10] : "");
		} else if (num < 1000) {
			return BELOW_20[num / 100] + " Hundred" + (num % 100 != 0 ? " " + helper(num % 100) : "");
		} else {
			for (int i = 0; i < THOUSANDS.length; i++) {
				if (num < 1000 * 1000 * 1000) {
					return helper(num / 1000) + " " + THOUSANDS[i] + (num % 1000 != 0 ? " " + helper(num % 1000) : "");
				}
				num /= 1000;
			}
		}
		return "";
	}

	public static void main(String[] args) {
		int num1 = 1234567891;
		int num2 = 1001;
		int num3 = 0;
		System.out.println("Number: " + num1 + " -> " + numberToWords(num1));
		System.out.println("Number: " + num2 + " -> " + numberToWords(num2));
		System.out.println("Number: " + num3 + " -> " + numberToWords(num3));
	}

	class Solution {
		public String numberToWords(int num) {
			if (num == 0) {
				return "Zero";
			}

			// Arrays to handle units, teens, and tens
			String[] bigString = new String[] { "Thousand", "Million", "Billion" };

			// Result to store the final English words representation
			String result = numberToWordsHelper(num % 1000);
			num = num / 1000;

			// Process each chunk and append the corresponding big unit
			int index = 0;
			while (num > 0) {
				if (num % 1000 > 0) {
					result = numberToWordsHelper(num % 1000) + " " + bigString[index] + " " + result;
				}
				num = num / 1000;
				index++;
			}

			return result.trim();
		}

		private String numberToWordsHelper(int num) {
			// Arrays to handle units, teens, and tens
			String[] digitString = new String[] { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
					"Eight", "Nine" };
			String[] teenString = new String[] { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
					"Sixteen", "Seventeen", "Eighteen", "Nineteen" };
			String[] tenString = new String[] { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
					"Eighty", "Ninety" };

			// Result to store the current chunk's English words
			String result = "";

			// Handle numbers in hundreds
			if (num > 99) {
				result += digitString[num / 100] + " Hundred ";
			}
			num = num % 100;

			// Handle numbers in teens
			if (num >= 10 && num < 20) {
				result += teenString[num - 10] + " ";
			} else {
				// Handle tens
				if (num >= 20) {
					result += tenString[num / 10] + " ";
				}
				// Handle units
				num = num % 10;
				if (num > 0) {
					result += digitString[num] + " ";
				}
			}

			return result;
		}
	}
}

// Given a non-negative integer num, convert it to its English words representation.
// Example 1:
//
// Input: num = 1234567891
// Output: "One Billion Two Hundred Thirty-Four Million Five Hundred Sixty-Seven Thousand Eight Hundred Ninety-One"
//
// Example 2:
//
// Input: num = 1001
// Output: "One Thousand One"
//
// Example 3:
//
// Input: num = 0
// Output: "Zero"
//
// Constraints:
//
// - 0 <= num <= 2^31 - 1
//
// Approach:
// The approach is to recursively break down the number into manageable chunks, handle numbers below 1000 first,
// and then combine these chunks with their corresponding units (thousand, million, billion). Helper functions 
// are used to handle numbers below 1000 and to process larger chunks accordingly.
//
// Time Complexity: O(log(N))
// Space Complexity: O(1)

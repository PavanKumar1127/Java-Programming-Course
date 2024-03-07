package leetcode;

//Check If Two String Arrays are Equivalent

//https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/description/?envType=daily-question&envId=2023-12-01

/**
 * Bruteforce approach : take two stringbuilder and append each string in the
 * word1[] then convert to string using .toString() and use .equals() to compare
 * both the word1[] and word2[]
 * 
 * Optimized approach : can remove string builder and use String.join("char
 * seperator", "char sequence") and reduce the code to 1 line
 * return String.join("", word1).equals(String.join("", word2));
 */
public class Leetcode_1662_TwoStringArraysAreEquivalent {

	public static void main(String[] args) {
		String[] word1 = { "a", "bc" };
		String[] word2 = { "ab", "c" };

		System.out.println(arrayStringsAreEqual(word1, word2));
		System.out.println(String.join("", word1));
		System.out.println(String.join("", word1).equals(String.join("", word2)));

	}

	public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		if (concatinated(word1).equals(concatinated(word2)))
			return true;

		return false;
	}

	public static String concatinated(String[] word) {
		String newWord = new String();
		for (String each : word) {
			newWord += each;
		}
		System.out.println(newWord);
		return newWord;
	}

	class Solution {
		public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
			StringBuilder str1 = new StringBuilder();
			StringBuilder str2 = new StringBuilder();

			for (String word : word1) {
				str1.append(word);
			}
			for (String word : word2) {
				str2.append(word);
			}
			String s1 = str1.toString();
			String s2 = str2.toString();

			if (s1.equals(s2)) {
				return true;
			} else {
				return false;
			}
		}
	}

}

//Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
//
//A string is represented by an array if the array elements concatenated in order forms the string.

// 
//
//Example 1:
//
//Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
//Output: true
//Explanation:
//word1 represents string "ab" + "c" -> "abc"
//word2 represents string "a" + "bc" -> "abc"
//The strings are the same, so return true.
//Example 2:
//
//Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
//Output: false
//Example 3:
//
//Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
//Output: true
// 
//
//Constraints:
//
//1 <= word1.length, word2.length <= 103
//1 <= word1[i].length, word2[i].length <= 103
//1 <= sum(word1[i].length), sum(word2[i].length) <= 103
//word1[i] and word2[i] consist of lowercase letters.
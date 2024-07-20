package leetcode;

import java.util.ArrayList;
import java.util.List;

// Count and Say problem
// https://leetcode.com/problems/count-and-say/description/
public class Leetcode_38_CountAndSay {
    
    // Function to generate the nth term of the Count and Say sequence
    public static String countAndSay(int n) {
        // Base case: the first term in the sequence is "1"
        String result = "1";
        
        // Generate the sequence up to the nth term
        for (int k = 1; k < n; k++) {
            result = generateNext(result);
        }
        
        return result;
    }

    // Helper method to generate the next term in the sequence given the current term
    private static String generateNext(String s) {
        StringBuilder nextTerm = new StringBuilder();
        int count = 1;
        
        // Iterate through the string and count occurrences of each character
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                nextTerm.append(count).append(s.charAt(i - 1));
                count = 1;
            }
        }
        
        // Append the last counted group
        nextTerm.append(count).append(s.charAt(s.length() - 1));
        
        return nextTerm.toString();
    }
    
    public static void main(String[] args) {
        // Example inputs
        System.out.println("Term 1: " + countAndSay(1)); // Output: "1"
        System.out.println("Term 4: " + countAndSay(4)); // Output: "1211"
        System.out.println("Term 5: " + countAndSay(5)); // Output: "111221"
    }
}

// Given an integer n, generate the nth term of the Count and Say sequence.
//
// The Count and Say sequence is a sequence of digit strings defined by the recursive formula:
//
// countAndSay(1) = "1"
// countAndSay(n) is the count-and-say description of the number generated in the previous term.
//
// Example 1:
//
// Input: n = 1
// Output: "1"
// Explanation: This is the base case of the sequence.
//
// Example 2:
//
// Input: n = 4
// Output: "1211"
// Explanation: The sequence is as follows: "1", "11", "21", "1211"
//
// Constraints:
//
// - 1 <= n <= 30

// Approach:
// We start with the base case "1" and iteratively generate the next term in the sequence up to the nth term.
// The `generateNext` function processes each character of the current term, counts consecutive occurrences,
// and builds the next term based on these counts and characters.
//
// Algorithm:
// 1. Start with the base term "1".
// 2. For each term from 2 to n, generate the next term by counting consecutive characters in the current term.
// 3. Append the count and character to form the new term.
//
// Time Complexity: O(n * m)
// - Where n is the input number and m is the length of the term in the sequence. The time complexity is mainly 
//   determined by the length of the term generated, which grows exponentially.
//
// Space Complexity: O(m)
// - Space complexity is O(m) due to the space used for the new term generation, where m is the length of the term.

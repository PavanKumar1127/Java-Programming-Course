package blind75;

import java.util.*;

public class Blind75_16_LongestPalindrome409 {

    public static int longestPalindrome(String s) {
        // Create a HashMap to store character frequencies
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        // Count frequencies of characters in the string
        for (char ch : s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }
        
        int length = 0;
        boolean oddFrequencyFound = false;
        
        // Calculate length of the palindrome
        for (int frequency : frequencyMap.values()) {
            if (frequency % 2 == 0) {
                length += frequency;
            } else {
                length += frequency - 1;
                oddFrequencyFound = true;
            }
        }
        
        // Add 1 if at least one character has an odd frequency
        if (oddFrequencyFound) {
            length++;
        }
        
        return length;
    }
    
    public static void main(String[] args) {
        String s = "abccccdd"; // Example input
        System.out.println("Length of the longest palindrome: " + longestPalindrome(s));
    }
}
//////////ALGORITHM

//Count Frequencies: Iterate through the characters in the input string and count the frequency of each character. You can use a HashMap to store the character frequencies.
//Calculate Length: Iterate through the character frequencies:
//For each character frequency:
//If the frequency is even, add it to the length of the palindrome.
//If the frequency is odd, subtract 1 from it and add it to the length of the palindrome.
//Check for Odd Frequencies: If there is at least one character with an odd frequency, add 1 to the length of the palindrome to account for the center character.
//Return Length: Return the calculated length as the length of the longest palindrome.
//Example:
//Let's consider an example input string "abccccdd":
//
//Count the frequencies of characters:
//'a': 1
//'b': 1
//'c': 4
//'d': 2
//Calculate the length of the palindrome:
//For 'a' and 'b', both have odd frequencies, so subtract 1 from each: 1 + 1 = 2
//For 'c', it has an even frequency, so add it as is: 4
//For 'd', it has an even frequency, so add it as is: 2
//Check for odd frequencies: Since 'c' has an odd frequency, add 1 to the length: 2 + 4 + 2 + 1 = 9
//Return the length of the longest palindrome: 9



///////Question
//Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
//
//Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
//
// 
//
//Example 1:
//
//Input: s = "abccccdd"
//Output: 7
//Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
//Example 2:
//
//Input: s = "a"
//Output: 1
//Explanation: The longest palindrome that can be built is "a", whose length is 1.

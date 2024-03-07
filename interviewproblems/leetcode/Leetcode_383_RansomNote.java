package leetcode;

public class Leetcode_383_RansomNote {

	public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];

        // Count the occurrences of each character in the magazine
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }

        // Check if there are enough characters in the magazine to build the ransom note
        for (char c : ransomNote.toCharArray()) {
            if (count[c - 'a'] > 0) {
                count[c - 'a']--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
    	Leetcode_383_RansomNote solution = new Leetcode_383_RansomNote();
        String ransomNote = "aabb";
        String magazine = "aabbc";
        System.out.println(solution.canConstruct(ransomNote, magazine)); // Output: true
    }
}

//Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
//
//Each letter in magazine can only be used once in ransomNote.
//
// 
//
//Example 1:
//
//Input: ransomNote = "a", magazine = "b"
//Output: false
//Example 2:
//
//Input: ransomNote = "aa", magazine = "ab"
//Output: false
//Example 3:
//
//Input: ransomNote = "aa", magazine = "aab"
//Output: true
// 
//
//Constraints:
//
//1 <= ransomNote.length, magazine.length <= 105
//ransomNote and magazine consist of lowercase English letters.

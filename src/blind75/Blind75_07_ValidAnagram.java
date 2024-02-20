package blind75;

import java.util.HashMap;

public class Blind75_07_ValidAnagram {

	public static boolean isAnagram(String s, String t) {
		
		if (s.length() != t.length()) {
			return false;
		}
		
		HashMap<Character, Integer> ans = new HashMap<Character, Integer>();
		char[] input = s.toCharArray();

		for(int i = 0; i<s.length(); i++) {
			ans.put(input[i], ans.getOrDefault(input[i], 0)+1);
		}
		input = t.toCharArray();
		for(int i = 0; i<t.length(); i++) {
			if(ans.get(input[i]) <= 1) {
				ans.remove(input[i]);
			}else {
				ans.put(input[i], ans.getOrDefault(input[i], 0)-1);
			}
		}

		return ans.isEmpty();
	}
	
	//Same approach using array
	class Solution {
	    public boolean isAnagram(String s, String t) {
	        if(s.length()!=t.length()){
	            return false;
	        }
	        int map[]=new int[26];
	        for(char x : s.toCharArray()){
	            map[x-'a']++;
	        }
	        for(char x : t.toCharArray()){
	            map[x-'a']--;
	        }
	        for(int i:map){
	            if (i!=0){
	                return false;
	            }
	        }
	        return true;
	        }
	}
	
	public static void main(String[] args) {
		String s = "anagram";
		String t = "nagaram";
		System.out.println(isAnagram(s, t));
	}

}

//Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//
// 
//
//Example 1:
//
//Input: s = "anagram", t = "nagaram"
//Output: true
//Example 2:
//
//Input: s = "rat", t = "car"
//Output: false
// 
//
//Constraints:
//
//1 <= s.length, t.length <= 5 * 104
//s and t consist of lowercase English letters.
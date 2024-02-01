package concepts.slidingWindow;

import java.util.*;

public class SlidingWindow3Anagram {
	

	// Using map 
    public static int countAnagrams(String text, String word) {
        int n = text.length();
        int m = word.length();
        Map<Character, Integer> freqWord = new HashMap<>();
        Map<Character, Integer> freqText = new HashMap<>();
        int count = 0;
 
        // Create frequency map of characters in the word
        for (char c : word.toCharArray()) {
            freqWord.put(c, freqWord.getOrDefault(c, 0) + 1);
        }
 
        // Sliding window approach
        for (int i = 0; i < n; i++) {
            // Add character to frequency map
            char currentChar = text.charAt(i);
            freqText.put(currentChar, freqText.getOrDefault(currentChar, 0) + 1);
 
            // Remove character that went out of the window
            if (i >= m) {
                char removedChar = text.charAt(i - m);
                if (freqText.get(removedChar) == 1) {
                    freqText.remove(removedChar);
                } else {
                    freqText.put(removedChar, freqText.get(removedChar) - 1);
                }
            }
 
            // Compare frequency maps
            if (i >= m - 1 && freqText.equals(freqWord)) {
                count++;
            }
        }
 
        return count;
    }
	
//	public static int countAnagrams(String s, String p)
//    {
//        // change CHARACTERS to support range of supported
//        // characters
//        int CHARACTERS = 256;
//        int sn = s.length();
//        int pn = p.length();
//        int count = 0;
//        if (sn < 0 || pn < 0 || sn < pn)
//            return 0;
// 
//        char[] pArr = new char[CHARACTERS];
//        char[] sArr = new char[CHARACTERS];
//        int i = 0;
//        // till window size
//        for (; i < pn; i++) {
//            sArr[CHARACTERS - s.charAt(i)]++;
//            pArr[CHARACTERS - p.charAt(i)]++;
//        }
//        if (Arrays.equals(pArr, sArr))
//            count += 1;
//        // next window
//        for (; i < sn; i++) {
//            sArr[CHARACTERS - s.charAt(i)]++;
//            sArr[CHARACTERS - s.charAt(i - pn)]--;
// 
//            if (Arrays.equals(pArr, sArr))
//                count += 1;
//        }
//        return count;
//    }
	
//////////////////////////////////////////////////////////////////////////////////////
//	Simple traverese all possible substring using for
//	// Function to find if two strings are equal
//	static boolean araAnagram(String s1,
//							String s2)
//	{
//		// converting strings to char arrays
//		char[] ch1 = s1.toCharArray();
//		char[] ch2 = s2.toCharArray();
//
//		// sorting both char arrays
//		Arrays.sort(ch1);
//		Arrays.sort(ch2);
//
//		// Check for equality of strings
//		if (Arrays.equals(ch1, ch2))
//			return true;
//		else
//			return false;
//	}
//
//	static int countAnagrams(String text, String word)
//	{
//		int N = text.length();
//		int n = word.length();
//
//		// Initialize result
//		int res = 0;
//
//		for (int i = 0; i <= N - n; i++) {
//
//			String s = text.substring(i, i + n);
//
//			// Check if the word and substring are
//			// anagram of each other.
//			if (araAnagram(word, s))
//				res++;
//		}
//	
//		return res;
//	}

	// Driver code
	public static void main(String args[])
	{
		String text = "forxxorfxdofr";
		String word = "for";
		System.out.print(countAnagrams(text, word));
	}
}

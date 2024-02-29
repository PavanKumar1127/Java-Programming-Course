package blind75;
import java.util.HashMap;

public class Blind75_21_LongestSubstringWithoutRepeatingCharacters3 {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int maxLength = 0;
        int left = 0;
        HashMap<Character, Integer> lastIndexMap = new HashMap<>();
        
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (lastIndexMap.containsKey(ch)) {
                left = Math.max(left, lastIndexMap.get(ch) + 1);
            }
            lastIndexMap.put(ch, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
    
    public static void main(String[] args) {
        String s = "abcabcbb"; // Example input
        System.out.println("Length of the longest substring without repeating characters: " + lengthOfLongestSubstring(s));
    }
}

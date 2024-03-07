package leetcode;

import java.util.*;

//Leetcode 
//backtracking, amazon
//17. Letter Combinations of a Phone Number

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

public class LeetCode17Reccursion2LetterCombination {

	static String keypad[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public static List<String> letterCombinations(String digits) {
		return possibleWords(digits, "");
	}

	private static List<String> possibleWords(String string, String ans) {
		if (string.isEmpty()) {
			ArrayList<String> list = new ArrayList<String>();
			list.add(ans);
			return list;
		}
		ArrayList<String> ansList = new ArrayList<String>();

		String key = keypad[string.charAt(0) - 48];
		for (int i = 0; i < key.length(); i++) {
			ansList.addAll(possibleWords(string.substring(1), ans + key.charAt(i)));
		}
		return ansList;
	}

	public static void main(String[] args) {
		List<String> answer = letterCombinations("62");
		System.out.println(answer);
		System.out.println(answer.size());
	}
	
	// optimized
	/**
	 * class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        List<String> letters = new ArrayList<>(Arrays.asList("","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"));
        StringBuilder sb = new StringBuilder();
        helper(res, sb, digits, 0, letters);
        return res;
    }

    private void helper(List<String> res, StringBuilder sb, String digits, int idx, List<String> letters) {
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }

        int digit = digits.charAt(idx) - '0';
        for (char c : letters.get(digit).toCharArray()) {
            sb.append(c);
            helper(res, sb, digits, idx + 1, letters);
            sb.setLength(sb.length() - 1);
        }
    }
}
	 */
}

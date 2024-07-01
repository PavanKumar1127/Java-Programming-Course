package concepts.slidingWindow;

//Find the longest substring with k unique characters in a given string
//Java program to find the longest substring with k unique characters in a given string

import java.util.*;

public class SlidingWindow7VariableSize {
	public static int longestkSubstr(String S) {
		// code here
		int ans = 0;
		int left = 0;
		Map<Character, Integer> mapVisited = new HashMap<>();

		for (int right = 0; right < S.length(); right++) {
			char currentChar = S.charAt(right);
			if (mapVisited.containsKey(currentChar) && mapVisited.get(currentChar) >= left) {
				left = mapVisited.get(currentChar) + 1;
			}
			ans = Math.max(ans, right - left + 1);
			mapVisited.put(currentChar, right);
		}
		return ans;
	}

	public static void main(String[] args) {
		String s = "aabacbebebe";
		int k = 2;

		// Function Call
		int ans = longestkSubstr1(s);
		System.out.println(ans);
	}

	private static int longestkSubstr1(String S) {
		// code here "aabacbebebe"
		int ans = 0;
		int left = 0;

		for (int right = 0; right < S.length(); right++) {
			int indexOfVisitedChar = S.indexOf(S.charAt(right), left);
			if(indexOfVisitedChar != right) {
				left = indexOfVisitedChar +1;
			}
			ans = Math.max(ans, right - left + 1);
		}
		return ans;
	}
}

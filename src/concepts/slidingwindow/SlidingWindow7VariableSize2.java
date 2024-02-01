package concepts.slidingWindow;

//Find the longest substring with k unique characters in a given string
//Java program to find the longest substring with k unique characters in a given string

import java.util.*;

public class SlidingWindow7VariableSize2 {
	public static int longestkSubstr(String S, int k) {
		// code here
		Map<Character, Integer> map = new HashMap<>();

		int i = -1;
		int j = -1;
		int ans = -1;

		while (true) {
			boolean flag1 = false;
			boolean flag2 = false;
			while (i < S.length() - 1) {
				flag1 = true;
				i++;
				char ch = S.charAt(i);
				map.put(ch, map.getOrDefault(ch, 0) + 1);

				if (map.size() < k)
					continue;
				else if (map.size() == k) {
					int len = i - j;
					ans = Math.max(len, ans);
				} else
					break;
			}
			while (j < i) {
				flag2 = true;
				j++;
				char ch = S.charAt(j);

				if (map.get(ch) == 1)
					map.remove(ch);
				else
					map.put(ch, map.get(ch) - 1);

				if (map.size() == k) {
					int len = i - j;
					ans = Math.max(ans, len);
					break;
				} else if (map.size() > k)
					continue;
			}
			if (flag1 == false && flag2 == false)
				break;
		}
		return ans;
	}

	public static void main(String[] args) {
		String s = "aabacbebebe";
		int k = 2;

		// Function Call
		int ans = longestkSubstr(s, k);
		System.out.println(ans);
	}
}

package leetcode;

import java.util.*;

class Leetcode_49_GroupAnagrams {
	
	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) {
			return new ArrayList<>();
		}

		Map<String, List<String>> map = new HashMap<>();

		for (String s : strs) {
			char[] current = s.toCharArray();
			Arrays.sort(current);
			String curString = String.valueOf(current);

			if (!map.containsKey(curString)) {
				map.put(curString, new ArrayList<>());
			}
			map.get(curString).add(s);
		}

		return new ArrayList<>(map.values());
	}

	public static void main(String[] args) {
		Leetcode_49_GroupAnagrams solution = new Leetcode_49_GroupAnagrams();

		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> result = solution.groupAnagrams(strs);

		System.out.println("Grouped Anagrams:");
		for (List<String> group : result) {
			System.out.println(group);
		}
	}
}

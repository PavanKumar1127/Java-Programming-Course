package amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * You will be given the number of pairs of parenthesis. Find out the total
 * possible valid unique combinations and there should not be any duplicity.
 */

public class ValidParenthesesCombinations {
	
	/**
	 * generateParenthesis method initializes an empty list to store valid
	 * combinations and calls the backtrack method to generate combinations
	 * recursively.
	 */
	public static List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		backtrack(result, "", 0, 0, n);
		return result;
	}

	/**
	 * backtrack method, we keep track of the number of open and close parentheses
	 * used so far. We only add an open parenthesis if there are still available
	 * openings (open < max), and we only add a close parenthesis if it would not
	 * exceed the number of open parentheses (close < open).
	 */
	private static void backtrack(List<String> result, String current, int open, int close, int max) {

		// once length of the current string equals max*2, we add it to the result list.
		if (current.length() == max * 2) {
			result.add(current);
			return;
		}

		if (open < max) {
			backtrack(result, current + "(", open + 1, close, max);
		}
		if (close < open) {
			backtrack(result, current + ")", open, close + 1, max);
		}
	}

	public static void main(String[] args) {
		int n = 3; // Example: for n=3, valid combinations are
					// ["((()))","(()())","(())()","()(())","()()()"]
		List<String> validCombinations = generateParenthesis(n);
		System.out.println("Valid combinations for n=" + n + ": " + validCombinations);
	}
}

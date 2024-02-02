package blind75;

public class Blind75_4_BestTimeToBuyAndSellStock {

	public static int maxProfit(int[] prices) {

		int len = prices.length;
		int i = 0;
		int j = 0;
		int maxProfit = 0;

		while (i < len && j < len) {
			maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
			if (prices[j] >= prices[i]) {
				maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
				j++;
			} else {
				i = j;
			}
		}

		return maxProfit;
	}

	public static int maxProfit1(int[] prices) {
		int buyPrice = Integer.MAX_VALUE;
		int max_profit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (buyPrice < prices[i]) {
				int profit = prices[i] - buyPrice;
				max_profit = Math.max(profit, max_profit);
			} else {
				buyPrice = prices[i];
			}
		}
		return max_profit;
	}

	public static void main(String[] args) {
		int[] prices = { 7, 2, 5, 1, 6, 4 };
		System.out.println(maxProfit1(prices));
	}

}


//A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
//
//Given a string s, return true if it is a palindrome, or false otherwise.
//
// 
//
//Example 1:
//
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
//Example 2:
//
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.
//Example 3:
//
//Input: s = " "
//Output: true
//Explanation: s is an empty string "" after removing non-alphanumeric characters.
//Since an empty string reads the same forward and backward, it is a palindrome.
// 
//
//Constraints:
//
//1 <= s.length <= 2 * 105
//s consists only of printable ASCII characters.
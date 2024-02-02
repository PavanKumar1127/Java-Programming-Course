package blind75;

public class Blind75_5_ValidPalindrome {

	
	private static boolean isPalindrome(String s) {
		
		char[] input = s.toLowerCase().replaceAll("[^a-zA-Z]", "").toCharArray();
		int len = input.length-1;
		int mid = input.length/2;
		int i = 0;
		
		while(i<= mid) {
			if(input[i] == input[len]) {
				len--;
				i++;
				continue;
			}else {
				return false;
			}
		}
		
		return true;
    }

	//optimal solution but uses same approach
	public boolean isPalindrome1(String s) {
        int start = 0;
        int last = s.length() - 1;
        while(start <= last) {
        	char currFirst = s.charAt(start);
        	char currLast = s.charAt(last);
        	if (!Character.isLetterOrDigit(currFirst )) {
        		start++;
        	} else if(!Character.isLetterOrDigit(currLast)) {
        		last--;
        	} else {
        		if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
        			return false;
        		}
        		start++;
        		last--;
        	}
        }
        return true;
    }
	
	
	public static void main(String[] args) {
		String ques = "A man, a plan, a canal: Panama";
		String  s = "race a car";
		System.out.println(isPalindrome(s));
	}

}
//
//You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
//You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//
//Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
//
// 
//
//Example 1:
//
//Input: prices = [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
//Example 2:
//
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transactions are done and the max profit = 0.
// 
//
//Constraints:
//
//1 <= prices.length <= 105
//0 <= prices[i] <= 104
package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode_202_HappyNumber {
	
	//cyclic linkedlist approach
	public boolean isHappy1(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (slow != fast);

        if (slow == 1) {
            return true;
        }
        return false;
    }
    private int findSquare(int number) {
        int ans = 0;
        while (number > 0) {
            int rem = number % 10 ;
            ans += rem * rem;
            number /= 10;
        }
        return ans;
    }


	public boolean isHappy(int n) {
        // Use a HashSet to keep track of previously seen numbers to detect cycles
        Set<Integer> seen = new HashSet<>();
        
        while (n != 1) {
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            // If the sum has been seen before, it's in a cycle and not a happy number
            if (!seen.add(sum)) {
                return false;
            }
            n = sum; // Update n for the next iteration
        }
        
        // If the loop terminates with n == 1, it's a happy number
        return true;
    }
	
//	We use a HashSet to keep track of previously seen numbers to detect cycles.
//	We iterate through the process of replacing the number with the sum of the squares of its digits until we either reach 1 (in which case the number is happy) or encounter a cycle (in which case it's not happy).
//	The time complexity of this solution depends on the number of iterations needed to reach the happy number or detect a cycle, which can vary. In the worst case, the time complexity is O(log n), where n is the given number.
//	The space complexity is also O(log n) due to the HashSet used to store previously seen numbers.
    
    public static void main(String[] args) {
    	Leetcode_202_HappyNumber solution = new Leetcode_202_HappyNumber();
        
        // Example usage
        int n1 = 19;
        System.out.println(solution.isHappy(n1)); // Output: true
        
        int n2 = 2;
        System.out.println(solution.isHappy(n2)); // Output: false
    }
}


//Write an algorithm to determine if a number n is happy.
//
//A happy number is a number defined by the following process:
//
//Starting with any positive integer, replace the number by the sum of the squares of its digits.
//Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
//Those numbers for which this process ends in 1 are happy.
//Return true if n is a happy number, and false if not.
//
//Example 1:
//
//Input: n = 19
//Output: true
//Explanation:
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
//Example 2:
//
//Input: n = 2
//Output: false
// 
//
//Constraints:
//
//1 <= n <= 231 - 1

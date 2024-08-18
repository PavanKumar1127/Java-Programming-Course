package leetcode;

// Determine whether a given number is an ugly number
// https://leetcode.com/problems/ugly-number/description/
public class Leetcode_263_UglyNumber {

    // A number is considered an ugly number if its prime factors only include 2, 3, and/or 5.
    // This function returns true if the given number is an ugly number, otherwise returns false.
    public static boolean isUgly(int n) {
        // If the number is less than or equal to 0, it's not an ugly number
        if (n <= 0) return false;
        
        // Continuously divide n by 2, 3, or 5 if divisible by these numbers
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;
        
        // After dividing, if the remaining number is 1, it was only divisible by 2, 3, or 5, so it's an ugly number
        return n == 1;
    }

    public static void main(String[] args) {
        // Example inputs
        int num1 = 6;
        int num2 = 8;
        int num3 = 14;

        // Outputs
        System.out.println("Is " + num1 + " an Ugly Number? " + isUgly(num1)); // Output: true
        System.out.println("Is " + num2 + " an Ugly Number? " + isUgly(num2)); // Output: true
        System.out.println("Is " + num3 + " an Ugly Number? " + isUgly(num3)); // Output: false
    }
}

/*
Example 1:
Input: n = 6
Output: true
Explanation: 6 = 2 × 3

Example 2:
Input: n = 8
Output: true
Explanation: 8 = 2 × 2 × 2

Example 3:
Input: n = 14
Output: false
Explanation: 14 is not an ugly number since it includes another prime factor 7.

Constraints:
- -2^31 <= n <= 2^31 - 1

Approach:
- The approach involves repeatedly dividing the given number by the prime factors 2, 3, and 5 until it is no longer divisible by these numbers.
- If after all divisions the number reduces to 1, it indicates that the number is an ugly number, as it was composed only of the prime factors 2, 3, and 5.
- If the number doesn't reduce to 1, it means that it includes prime factors other than 2, 3, and 5, and therefore, it is not an ugly number.

Time Complexity:
- The time complexity is O(log n) in the worst case, as the number is repeatedly divided by 2, 3, and 5 until it reduces to 1 or another prime factor.
- Space Complexity: O(1)
- The algorithm uses constant space, making it O(1) in space complexity.
*/

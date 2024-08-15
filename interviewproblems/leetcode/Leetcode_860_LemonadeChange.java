package leetcode;

// Lemonade Change Problem
// https://leetcode.com/problems/lemonade-change/description/
public class Leetcode_860_LemonadeChange {

    public static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        
        // Iterate through each bill in the array
        for (int bill : bills) {
            if (bill == 5) {
                // Increment five-dollar count
                five++;
            } else if (bill == 10) {
                // For a ten-dollar bill, provide one five-dollar bill as change
                if (five == 0) {
                    return false; // Not enough five-dollar bills to give change
                }
                five--;
                ten++;
            } else if (bill == 20) {
                // For a twenty-dollar bill, prefer to give one ten-dollar and one five-dollar bill as change
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    // If no ten-dollar bill is available, give three five-dollar bills as change
                    five -= 3;
                } else {
                    return false; // Not enough change to provide
                }
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        int[] bills1 = {5, 5, 5, 10, 20};
        System.out.println("Can provide change: " + lemonadeChange(bills1)); // Output: true

        int[] bills2 = {5, 5, 10, 10, 20};
        System.out.println("Can provide change: " + lemonadeChange(bills2)); // Output: false

        int[] bills3 = {5, 5, 10};
        System.out.println("Can provide change: " + lemonadeChange(bills3)); // Output: true

        int[] bills4 = {10, 10};
        System.out.println("Can provide change: " + lemonadeChange(bills4)); // Output: false
    }
}

// Given an integer array `bills` where `bills[i]` is the bill a customer gives to the cashier
// in order of arrival, return `true` if you can provide every customer with the correct change,
// or `false` otherwise.
//
// Example 1:
// Input: bills = [5, 5, 5, 10, 20]
// Output: true
//
// Example 2:
// Input: bills = [5, 5, 10, 10, 20]
// Output: false
//
// Example 3:
// Input: bills = [5, 5, 10]
// Output: true
//
// Example 4:
// Input: bills = [10, 10]
// Output: false
//
// Constraints:
// - 1 <= bills.length <= 10^5
// - bills[i] is either 5, 10, or 20.

// Approach:
// - The problem can be solved by simulating the process of giving change.
// - Maintain two counters, `five` and `ten`, to keep track of the number of five-dollar and ten-dollar bills available.
// - For each bill:
//   1. If it's a five-dollar bill, simply increment the five-dollar counter.
//   2. If it's a ten-dollar bill, decrement the five-dollar counter if possible, and increment the ten-dollar counter.
//   3. If it's a twenty-dollar bill, prioritize giving one ten-dollar and one five-dollar bill as change; if that's not possible, give three five-dollar bills. If neither option is possible, return `false`.
// - If we can give change to all customers, return `true`.
//
// Time Complexity: O(n)
// The algorithm processes each bill once, making the time complexity O(n), where `n` is the length of the `bills` array.
//
// Space Complexity: O(1)
// The algorithm uses a constant amount of extra space (for the counters), so the space complexity is O(1).

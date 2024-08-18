package leetcode;

import java.util.PriorityQueue;

// Problem 264: Ugly Number II
// https://leetcode.com/problems/ugly-number-ii/
//
// Given an integer n, return the nth ugly number.
//
// Ugly numbers are positive numbers whose prime factors only include 2, 3, and 5.
//
// Example 1:
// Input: n = 10
// Output: 12
// Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
//
// Example 2:
// Input: n = 1
// Output: 1
// Explanation: 1 has no prime factors, so it is an ugly number by convention.
//
// Constraints:
// - 1 <= n <= 1690

public class Leetcode_264_UglyNumberIIDP {

    // Function to return the nth ugly number
    public static int getNthUglyNumber(int n) {
        int[] ugly = new int[n]; // Array to store the first n ugly numbers
        int i2 = 0, i3 = 0, i5 = 0; // Indices for multiples of 2, 3, and 5
        int next_multiple_of_2 = 2;
        int next_multiple_of_3 = 3;
        int next_multiple_of_5 = 5;
        int next_ugly_number = 1;

        ugly[0] = 1; // First ugly number is always 1

        for (int i = 1; i < n; i++) {
            // Choose the smallest among next multiples of 2, 3, and 5
            next_ugly_number = Math.min(next_multiple_of_2,
                                        Math.min(next_multiple_of_3,
                                                 next_multiple_of_5));
            ugly[i] = next_ugly_number;

            // Increment the index corresponding to the next multiple
            if (next_ugly_number == next_multiple_of_2) {
                i2++;
                next_multiple_of_2 = ugly[i2] * 2;
            }
            if (next_ugly_number == next_multiple_of_3) {
                i3++;
                next_multiple_of_3 = ugly[i3] * 3;
            }
            if (next_ugly_number == next_multiple_of_5) {
                i5++;
                next_multiple_of_5 = ugly[i5] * 5;
            }
        }

        return next_ugly_number; // Return the nth ugly number
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("The " + n + "th ugly number is: " + getNthUglyNumber(n));
    }
}

// Approach:
// The problem is solved using a dynamic programming approach, where we maintain an array
// of the first n ugly numbers. We use three pointers to keep track of the indices for the 
// next multiples of 2, 3, and 5. At each step, the smallest value among the next multiples 
// is selected as the next ugly number. The corresponding pointer is then incremented, and 
// the process is repeated until we find the nth ugly number.

// Time Complexity: O(n)
// The solution involves a single pass through the array to generate the first n ugly numbers.

// Space Complexity: O(n)
// An array of size n is used to store the ugly numbers.
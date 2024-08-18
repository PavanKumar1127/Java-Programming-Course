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

public class Leetcode_264_UglyNumberII {
    
    public static int nthUglyNumber(int n) {
        // Priority Queue (Min-Heap) to store and get the smallest ugly number
        PriorityQueue<Long> heap = new PriorityQueue<>();
        // Array to store prime factors 2, 3, and 5
        int[] primes = {2, 3, 5};
        // Adding the first ugly number to the heap
        heap.add(1L);
        long ugly = 1; // Initialize the first ugly number
        
        // Iterate n times to find the nth ugly number
        for (int i = 1; i <= n; i++) {
            // Extract the smallest element from the heap
            ugly = heap.poll();
            // Generate new ugly numbers by multiplying the smallest ugly number by 2, 3, and 5
            for (int prime : primes) {
                if (!heap.contains(ugly * prime)) {
                    heap.add(ugly * prime);
                }
            }
            // Ensure no duplicates are stored in the heap
            while (!heap.isEmpty() && heap.peek() == ugly) {
                heap.poll();
            }
        }
        // Return the nth ugly number
        return (int) ugly;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("The " + n + "th ugly number is: " + nthUglyNumber(n)); // Output: 12
    }
}

// Approach:
// The problem can be solved using a min-heap (PriorityQueue in Java) to generate ugly numbers in ascending order.
// We start by adding the first ugly number, 1, to the heap. Then, we repeatedly extract the smallest number from the heap,
// generate new ugly numbers by multiplying it by 2, 3, and 5, and add these new numbers back to the heap if they haven't
// been added already. This process continues until we find the nth ugly number.
//
// The while loop ensures that we don't have duplicates in our heap.
//
// Time Complexity: O(n log n)
// Since the heap operations (insertion and extraction) take O(log n) time and we perform these operations n times, the time complexity is O(n log n).
//
// Space Complexity: O(n)
// We maintain a heap of size n, so the space complexity is O(n).

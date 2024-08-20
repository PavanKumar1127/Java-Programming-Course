package reccursion.theory;

import java.util.ArrayList;
import java.util.List;

// 60. Permutation Sequence
// https://leetcode.com/problems/permutation-sequence/description/
// The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
// By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
//
// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
//
// Given n and k, return the k-th permutation sequence.
//
// Example 1:
// Input: n = 3, k = 3
// Output: "213"
//
// Example 2:
// Input: n = 4, k = 9
// Output: "2314"
//
// Example 3:
// Input: n = 3, k = 1
// Output: "123"
//
// Constraints:
// - 1 <= n <= 9
// - 1 <= k <= n!

// Approach:
// To find the k-th permutation, we need to think in terms of factorials. The number of permutations starting with
// each digit in the sorted sequence of digits is (n-1)!.
// We can iteratively determine the first digit, then the second digit, and so on by dividing k by the factorial of
// the remaining digits, adjusting k, and reducing the set of available digits.

// Time Complexity: O(n^2)
// We compute the factorial for each digit and also update the list of available numbers.
// Space Complexity: O(n)
// The space is used to store the list of numbers.

public class Leetcode_60_PermutationSequence {

    public static String getPermutation(int n, int k) {
        // Initialize a list of numbers from 1 to n
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        // Initialize the factorial array and calculate (n-1)! factorial values
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        // Adjust k to be zero-indexed
        k--;

        // Build the k-th permutation sequence
        StringBuilder permutation = new StringBuilder();
        for (int i = n; i > 0; i--) {
            // Determine the index of the next number to append
            int index = k / factorial[i - 1];
            permutation.append(numbers.get(index));

            // Remove the used number from the list
            numbers.remove(index);

            // Update k
            k %= factorial[i - 1];
        }

        return permutation.toString();
    }

    public static void main(String[] args) {
        int n = 4, k = 9;
        System.out.println("The " + k + "-th permutation of the sequence 1 to " + n + " is: " + getPermutation(n, k)); // Output: 2314
    }
}

package strivers.DSA.arrays;

import java.util.HashSet;
import java.util.Set;

// 128. Longest Consecutive Sequence
// https://leetcode.com/problems/longest-consecutive-sequence/

public class Leetcode_128_LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        // Edge case: If the array is empty, return 0
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Use a HashSet to store all numbers in the array
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        // Iterate through each number in the array
        for (int num : nums) {
            // Check if it's the start of a sequence (num - 1 is not in the set)
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Check the consecutive numbers in the sequence
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                // Update the longest streak found so far
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        int[] arr1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest Consecutive Sequence: " + longestConsecutive(arr1)); // Output: 4

        int[] arr2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Longest Consecutive Sequence: " + longestConsecutive(arr2)); // Output: 9
    }
}

// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
// You must write an algorithm that runs in O(n) time.
//
// Example 1:
// Input: nums = [100, 4, 200, 1, 3, 2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
//
// Example 2:
// Input: nums = [0,3,7,2,5,8,4,6,0,1]
// Output: 9
// Explanation: The longest consecutive elements sequence is [0,1,2,3,4,5,6,7,8]. Therefore its length is 9.
//
// Constraints:
// - 0 <= nums.length <= 10^5
// - -10^9 <= nums[i] <= 10^9

// Approach:
// We use a HashSet to efficiently check for the start of a sequence. For each number in the array, we check if it's the
// start of a sequence by verifying if (num - 1) is not in the set. If it's the start, we then count the length of the sequence
// by checking how many consecutive numbers exist in the set starting from that number. We keep track of the longest sequence
// found.
//
// Time Complexity: O(n)
// Each number is inserted and looked up in the set in O(1) time, leading to an overall O(n) time complexity.
// Space Complexity: O(n)
// The HashSet stores all the numbers, requiring O(n) space.

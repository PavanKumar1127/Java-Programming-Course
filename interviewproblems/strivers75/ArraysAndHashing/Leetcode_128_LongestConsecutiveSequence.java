package strivers75.ArraysAndHashing;

import java.util.HashSet;
import java.util.Set;

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
//
// Constraints:
// - 0 <= nums.length <= 10^5
// - -10^9 <= nums[i] <= 10^9

public class Leetcode_128_LongestConsecutiveSequence {
    
    public static int longestConsecutive(int[] nums) {
        // Edge case: if the array is empty, return 0
        if (nums.length == 0) {
            return 0;
        }

        // Step 1: Add all numbers to a set for O(1) lookups
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        // Step 2: Iterate through the array to find the start of sequences
        int longestStreak = 0;
        
        for (int num : nums) {
            // Check if current number is the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Step 3: Count consecutive numbers
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Step 4: Update the longest streak found
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest Consecutive Sequence Length: " + longestConsecutive(nums1)); // Output: 4

        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Longest Consecutive Sequence Length: " + longestConsecutive(nums2)); // Output: 9
    }
}

// Approach:
// The solution uses a HashSet to store all numbers from the array, allowing O(1) time complexity for lookups. 
// For each number in the array, we check if it is the start of a sequence (i.e., if there is no number smaller 
// than it in the set). If it is, we count the length of the consecutive sequence by incrementing the number 
// and checking if the next number exists in the set. We keep track of the longest sequence found during the iteration.

// Time Complexity: O(n)
// The algorithm iterates through the array and performs constant-time operations for each element, 
// making the overall time complexity O(n).

// Space Complexity: O(n)
// The algorithm uses a HashSet to store the elements of the array, leading to an O(n) space complexity.

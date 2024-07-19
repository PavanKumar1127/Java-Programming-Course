package leetcode;

import java.util.Arrays;

// Longest Increasing Subsequence
// https://leetcode.com/problems/longest-increasing-subsequence/description/
public class Leetcode_300_LongestIncreasingSubsequence {
    
    /**
     * Given an integer array nums, return the length of the longest strictly increasing subsequence.
     *
     * Example 1:
     * Input: nums = [10,9,2,5,3,7,101,18]
     * Output: 4
     * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
     *
     * Example 2:
     * Input: nums = [0,1,0,3,2,3]
     * Output: 4
     * 
     * Example 3:
     * Input: nums = [7,7,7,7,7,7,7]
     * Output: 1
     * 
     * Constraints:
     * - 1 <= nums.length <= 2500
     * - -10^4 <= nums[i] <= 10^4
     */

    public static int lengthOfLIS(int[] nums) {
        // Edge case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // dp array where dp[i] represents the length of the longest increasing subsequence 
        // that ends with nums[i]
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1); // Each element itself can be a subsequence, so initialize with 1
        
        int maxLength = 1; // At least each individual number is a subsequence
        
        // Iterate over the array to fill dp array
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // Keep track of the maximum length of LIS found so far
            maxLength = Math.max(maxLength, dp[i]);
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums2 = {0, 1, 0, 3, 2, 3};
        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
        
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Length of Longest Increasing Subsequence: " + lengthOfLIS(nums1)); // Output: 4
        
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Length of Longest Increasing Subsequence: " + lengthOfLIS(nums2)); // Output: 4
        
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Length of Longest Increasing Subsequence: " + lengthOfLIS(nums3)); // Output: 1
    }
}

/**
 * Approach:
 * - This problem can be solved using dynamic programming.
 * - We use a dp array where dp[i] represents the length of the longest increasing subsequence 
 *   that ends with nums[i].
 * - We initialize each element in dp with 1 because the minimum length of LIS ending at each element is 1.
 * - We iterate over the array and for each element nums[i], we check all the previous elements nums[j] 
 *   (where j < i). If nums[i] > nums[j], it means we can extend the subsequence ending at nums[j] by nums[i]. 
 *   Therefore, we update dp[i] as dp[i] = max(dp[i], dp[j] + 1).
 * - Finally, the maximum value in the dp array will be the length of the longest increasing subsequence.
 *
 * Time Complexity: O(n^2)
 * - We have two nested loops, each running up to n times, where n is the length of the input array.
 *
 * Space Complexity: O(n)
 * - We use a dp array of size n to store the lengths of the longest increasing subsequences.
 */

package strivers75.ArraysAndHashing;

import java.util.Arrays;

// Maximum Subarray problem
// https://leetcode.com/problems/maximum-subarray/
public class Leetcode_53_MaximumSubarray {
    
    public static int maxSubArray(int[] nums) {
        // Initialize variables to track the current subarray sum and the maximum subarray sum
        int currentSum = nums[0];
        int maxSum = nums[0];
        
        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Update the current subarray sum
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // Update the maximum subarray sum if the current subarray sum is greater
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
    
    public static void main(String[] args) {
        int[] arr1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] arr2 = {1};
        int[] arr3 = {5, 4, -1, 7, 8};
        
        System.out.println("Maximum Subarray Sum of " + Arrays.toString(arr1) + " is: " + maxSubArray(arr1)); // Output: 6
        System.out.println("Maximum Subarray Sum of " + Arrays.toString(arr2) + " is: " + maxSubArray(arr2)); // Output: 1
        System.out.println("Maximum Subarray Sum of " + Arrays.toString(arr3) + " is: " + maxSubArray(arr3)); // Output: 23
    }
}

// Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
//
// Example 1:
// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: [4,-1,2,1] has the largest sum = 6.
//
// Example 2:
// Input: nums = [1]
// Output: 1
//
// Example 3:
// Input: nums = [5,4,-1,7,8]
// Output: 23
//
// Constraints:
// 1 <= nums.length <= 10^5
// -10^4 <= nums[i] <= 10^4
//
// Approach:
// We use Kadane's Algorithm to solve this problem. The algorithm maintains a running sum of the current subarray and resets it whenever it becomes negative. Simultaneously, it keeps track of the maximum sum encountered so far.
//
// Steps:
// 1. Initialize two variables: currentSum to keep track of the current subarray sum, and maxSum to keep track of the maximum subarray sum found.
// 2. Iterate through the array. For each element, update the currentSum by adding the current element. If currentSum becomes negative, reset it to the current element. Update maxSum to be the maximum of maxSum and currentSum.
//
// Time Complexity: O(n)
// The algorithm makes a single pass through the array, processing each element once, making it O(n) in time complexity.
// Space Complexity: O(1)
// The algorithm uses constant extra space.

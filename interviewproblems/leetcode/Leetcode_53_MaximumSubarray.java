package leetcode;

import java.util.Arrays;

// Maximum Sum Subarray Problem (Kadane’s Algorithm)
// https://leetcode.com/problems/maximum-subarray/
public class Leetcode_53_MaximumSubarray {
    
    // Method to find the maximum sum of a contiguous subarray using Kadane's Algorithm
    public static int maxSubArray(int[] nums) {
        // Initialize the maximum sum to the first element and the current sum to 0
        int maxSum = nums[0], currentSum = 0;
        
        // Iterate through the array
        for (int num : nums) {
            // If the current sum is negative, reset it to 0
            if (currentSum < 0) {
                currentSum = 0;
            }
            // Add the current element to the current sum
            currentSum += num;
            // Update the maximum sum if the current sum is greater
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }

    public static void main(String[] args) {
        // Example 1:
        int[] arr1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        // Output: 6 (subarray [4, -1, 2, 1])
        System.out.println("Example 1 - Maximum Subarray Sum: " + maxSubArray(arr1));
        
        // Example 2:
        int[] arr2 = {1};
        // Output: 1 (subarray [1])
        System.out.println("Example 2 - Maximum Subarray Sum: " + maxSubArray(arr2));
        
        // Example 3:
        int[] arr3 = {5, 4, -1, 7, 8};
        // Output: 23 (subarray [5, 4, -1, 7, 8])
        System.out.println("Example 3 - Maximum Subarray Sum: " + maxSubArray(arr3));
    }
}

// Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
//
// Example 1:
//
// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: [4,-1,2,1] has the largest sum = 6.
// Example 2:
//
// Input: nums = [1]
// Output: 1
// Example 3:
//
// Input: nums = [5,4,-1,7,8]
// Output: 23
//
// Constraints:
//
// - 1 <= nums.length <= 10^5
// - -10^4 <= nums[i] <= 10^4
//
// Approach:
// Kadane's Algorithm is used to find the maximum sum of a contiguous subarray. 
// We maintain a current sum and update it as we iterate through the array. If the current sum becomes negative, 
// we reset it to zero, as a negative current sum would decrease the potential sum of any future subarrays. 
// We keep track of the maximum sum encountered so far and return it at the end.
//
// Time Complexity: O(n)
// We make a single pass through the array, processing each element once, making it O(n) in time complexity.
// Space Complexity: O(1)
// The algorithm uses constant extra space.

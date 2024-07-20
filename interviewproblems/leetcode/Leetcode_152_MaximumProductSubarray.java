package leetcode;

import java.util.Arrays;

// Maximum Product Subarray
// https://leetcode.com/problems/maximum-product-subarray/description/
public class Leetcode_152_MaximumProductSubarray {

    public static int maxProduct(int[] nums) {
        // Initialize the variables to keep track of the maximum and minimum product up to the current index
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Store the current max product before updating
            int tempMax = maxProduct;
            
            // Update the max product to be the maximum of the current element,
            // the product of the current element and the previous max product,
            // and the product of the current element and the previous min product
            maxProduct = Math.max(nums[i], Math.max(nums[i] * maxProduct, nums[i] * minProduct));
            
            // Update the min product similarly
            minProduct = Math.min(nums[i], Math.min(nums[i] * tempMax, nums[i] * minProduct));
            
            // Update the result to be the maximum of the current result and the new max product
            result = Math.max(result, maxProduct);
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, -2, 4};
        System.out.println("Maximum Product of Subarray: " + maxProduct(arr1)); // Output: 6
        
        int[] arr2 = {-2, 0, -1};
        System.out.println("Maximum Product of Subarray: " + maxProduct(arr2)); // Output: 0
        
        int[] arr3 = {-2, 3, -4};
        System.out.println("Maximum Product of Subarray: " + maxProduct(arr3)); // Output: 24
    }
}

// Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
//
// Example 1:
// Input: nums = [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.
//
// Example 2:
// Input: nums = [-2,0,-1]
// Output: 0
// Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
//
// Example 3:
// Input: nums = [-2,3,-4]
// Output: 24
// Explanation: The entire array has the largest product of 24.
//
// Constraints:
// - 1 <= nums.length <= 2 * 10^4
// - -10 <= nums[i] <= 10
// - The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//
// Approach:
// We use two variables, maxProduct and minProduct, to keep track of the maximum and minimum product up to the current index.
// The reason we track the minimum product is because a negative number multiplied by a negative minimum product can become the new maximum product.
// We iterate through the array, updating the maxProduct and minProduct at each step, and keeping track of the global maximum product found so far.
//
// Time Complexity: O(n)
// The algorithm makes a single pass through the array, processing each element once, making it O(n) in time complexity.
//
// Space Complexity: O(1)
// The algorithm uses a constant amount of extra space, making it O(1) in space complexity.

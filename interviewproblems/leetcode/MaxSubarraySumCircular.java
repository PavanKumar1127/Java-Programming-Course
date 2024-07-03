package leetcode;
public class MaxSubarraySumCircular {
    /**
     * Find the maximum sum circular subarray
     * @param nums The input array
     * @return The maximum sum of a circular subarray
     */
    public static int maxSubarraySumCircular(int[] nums) {
        // Function to find maximum subarray sum using Kadane's algorithm
        int kadaneMax = kadane(nums);
        
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            nums[i] = -nums[i]; // Invert the array elements
        }
        
        // Maximum subarray sum of the inverted array gives the minimum subarray sum of the original array
        int invertedKadaneMax = kadane(nums);
        
        // If all elements are negative, kadaneMax will be the answer (single element case)
        if (totalSum + invertedKadaneMax == 0) {
            return kadaneMax;
        }
        
        // Calculate maximum sum with wraparound
        int circularMax = totalSum + invertedKadaneMax;
        
        return Math.max(kadaneMax, circularMax);
    }
    
    /**
     * Kadane's algorithm to find the maximum sum subarray
     * @param nums The input array
     * @return The maximum sum subarray
     */
    private static int kadane(int[] nums) {
        int currentMax = nums[0];
        int globalMax = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            globalMax = Math.max(globalMax, currentMax);
        }
        
        return globalMax;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, -2, 3, -2};
        int[] nums2 = {5, -3, 5};
        int[] nums3 = {-3, -2, -3};
        
        System.out.println("Maximum sum circular subarray is: " + maxSubarraySumCircular(nums1)); // Output: 3
        System.out.println("Maximum sum circular subarray is: " + maxSubarraySumCircular(nums2)); // Output: 10
        System.out.println("Maximum sum circular subarray is: " + maxSubarraySumCircular(nums3)); // Output: -2
    }
}

//Intuition
//Kadane's Algorithm: This is used to find the maximum sum subarray in linear time.
//Wraparound Subarray: By inverting the signs of the array elements, the problem of finding the maximum sum of a circular subarray is converted into finding the minimum sum of a non-circular subarray.


//Step-by-Step Solution
//Compute the Maximum Sum Subarray Using Kadane's Algorithm:
//
//Initialize currentMax and globalMax to the first element of the array.
//Iterate through the array, updating currentMax as the maximum of the current element and currentMax + current element.
//Update globalMax to be the maximum of globalMax and currentMax.
//Compute the Minimum Sum Subarray Using Kadane's Algorithm on Inverted Array:
//
//Invert the signs of all elements in the array.
//Apply Kadane's algorithm to find the maximum sum subarray of this inverted array, which gives the minimum sum subarray of the original array.
//Invert the result back by subtracting it from the total sum of the array.
//Combine Results:
//
//The maximum sum circular subarray is the maximum of the non-circular maximum sum and the wraparound maximum sum.
//Edge Case:
//
//If all elements are negative, the result should be the maximum single element.
//Visual Representation
//Consider the array {5, -3, 5}:
//
//Non-Wraparound Maximum Subarray: 5 + -3 + 5 = 7
//Wraparound Maximum Subarray: 5 + 5 = 10

package leetcode;

import java.util.Arrays;

// Problem: Count Smaller Elements on the Right Side
// https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/

public class Leetcode_315_CountSmaller {
    
    public static int[] countSmaller(int[] nums) {
        // Initialize an array to store the results
        int[] result = new int[nums.length];
        
        // Create an array of indices to keep track of original indices
        Integer[] indices = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indices[i] = i;
        }
        
        // Call the merge sort function to sort indices and populate the result array
        mergeSort(nums, indices, result, 0, nums.length - 1);
        
        return result;
    }

    // Merge sort function with index tracking and counting
    private static void mergeSort(int[] nums, Integer[] indices, int[] result, int left, int right) {
        if (left >= right) {
            return;
        }
        
        int mid = (left + right) / 2;
        mergeSort(nums, indices, result, left, mid);
        mergeSort(nums, indices, result, mid + 1, right);
        merge(nums, indices, result, left, mid, right);
    }

    // Merge function to count smaller elements
    private static void merge(int[] nums, Integer[] indices, int[] result, int left, int mid, int right) {
        Integer[] tempIndices = new Integer[right - left + 1];
        int[] tempCount = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0, count = 0;

        while (i <= mid && j <= right) {
            if (nums[indices[i]] <= nums[indices[j]]) {
                tempCount[k] = count;
                tempIndices[k++] = indices[i++];
            } else {
                count++;
                tempIndices[k++] = indices[j++];
            }
        }
        
        while (i <= mid) {
            tempCount[k] = count;
            tempIndices[k++] = indices[i++];
        }
        
        while (j <= right) {
            tempIndices[k++] = indices[j++];
        }
        
        for (int x = 0; x < tempIndices.length; x++) {
            indices[left + x] = tempIndices[x];
            result[indices[left + x]] = tempCount[x];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 1};
        System.out.println("Original Array: " + Arrays.toString(arr));
        
        int[] result = countSmaller(arr);
        
        System.out.println("Count of Smaller Elements: " + Arrays.toString(result));
    }
}

// Given an integer array nums, return an array of the same length where result[i] is the number of smaller elements to the right of nums[i].
//
// Example 1:
// Input: nums = [5,2,6,1]
// Output: [2,1,1,0]
// Explanation: 
//   - For index 0 (value 5), there are 2 smaller elements (2 and 1) to its right.
//   - For index 1 (value 2), there is 1 smaller element (1) to its right.
//   - For index 2 (value 6), there is 1 smaller element (1) to its right.
//   - For index 3 (value 1), there are no smaller elements to its right.
//
// Example 2:
// Input: nums = [-1]
// Output: [0]
// Explanation: 
//   - For index 0 (value -1), there are no smaller elements to its right.
//
// Example 3:
// Input: nums = [-1,-1]
// Output: [0,0]
// Explanation: 
//   - For index 0 (value -1), there are no smaller elements to its right.
//   - For index 1 (value -1), there are no smaller elements to its right.
//
// Constraints:
// - n == nums.length
// - 1 <= n <= 100,000
// - -10^4 <= nums[i] <= 10^4

// Approach:
// We use a modified merge sort to count smaller elements on the right side efficiently. During the merge process, we count how many
// elements are to the right of the current element that are smaller and use this information to populate the result array.
//
// Time Complexity: O(n log n)
// The algorithm uses merge sort, which divides the array into halves and performs merging, resulting in a time complexity of O(n log n).
//
// Space Complexity: O(n)
// The algorithm uses additional space for temporary arrays to assist in merging and counting, making the space complexity O(n).

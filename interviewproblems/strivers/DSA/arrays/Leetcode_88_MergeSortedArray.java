package strivers.DSA.arrays;

import java.util.Arrays;

// 88. Merge Sorted Array
// https://leetcode.com/problems/merge-sorted-array/description/
public class Leetcode_88_MergeSortedArray {
    
    /**
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
     * 
     * The number of elements initialized in nums1 and nums2 are m and n respectively. 
     * You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
     * 
     * Example 1:
     * 
     * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * Output: [1,2,2,3,5,6]
     * 
     * Example 2:
     * 
     * Input: nums1 = [1], m = 1, nums2 = [], n = 0
     * Output: [1]
     * 
     * Constraints:
     * 
     * - nums1.length == m + n
     * - nums2.length == n
     * - 0 <= m, n <= 200
     * - 1 <= nums1[i], nums2[i] <= 10^9
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // Initialize pointers for nums1 and nums2 from the end of their initialized elements
        int i = m - 1; // Pointer for nums1
        int j = n - 1; // Pointer for nums2
        int k = m + n - 1; // Pointer for the last position in nums1
        
        // Merge in reverse order
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        
        // If there are remaining elements in nums2, copy them
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;
        
        System.out.println("Original nums1: " + Arrays.toString(nums1));
        System.out.println("Original nums2: " + Arrays.toString(nums2));
        
        merge(nums1, m, nums2, n);
        
        System.out.println("Merged nums1: " + Arrays.toString(nums1)); // Output: [1, 2, 2, 3, 5, 6]
    }
}

// Approach:
// The algorithm merges two sorted arrays in-place starting from the end of the arrays. We initialize pointers i and j to point 
// to the last initialized elements in nums1 and nums2, respectively, and k to the last position of nums1. We then compare elements 
// from the back and place the larger element at the end of nums1. This process continues until either all elements of nums2 are 
// placed into nums1 or we exhaust elements in nums1. Any remaining elements in nums2 are then copied over to nums1.
//
// Time Complexity: O(m + n)
// The algorithm processes each element of nums1 and nums2 once, so the time complexity is O(m + n).
// Space Complexity: O(1)
// The algorithm merges the arrays in place, requiring no additional space beyond the input arrays.

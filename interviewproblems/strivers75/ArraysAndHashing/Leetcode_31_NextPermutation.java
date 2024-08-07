package strivers75.ArraysAndHashing;

import java.util.Arrays;

// Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
// If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
// The replacement must be in place and use only constant extra memory.

// Example 1:
//
// Input: nums = [1,2,3]
// Output: [1,3,2]
// Example 2:
//
// Input: nums = [3,2,1]
// Output: [1,2,3]
// Example 3:
//
// Input: nums = [1,1,5]
// Output: [1,5,1]
// Example 4:
//
// Input: nums = [1]
// Output: [1]
//
// Constraints:
//
// - 1 <= nums.length <= 100
// - 0 <= nums[i] <= 100

public class Leetcode_31_NextPermutation {

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        
        // Step 1: Find the first decreasing element from the end
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        // If such element is found, find the element just larger than it to swap
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        
        // Step 3: Reverse the elements after the position of the first decreasing element
        reverse(nums, i + 1, n - 1);
    }
    
    // Helper method to swap two elements in the array
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    // Helper method to reverse elements in the array
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
 
       
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        System.out.println("Original Array 1: " + Arrays.toString(arr1));
        nextPermutation(arr1);
        System.out.println("Next Permutation 1: " + Arrays.toString(arr1));
        
        int[] arr2 = {3, 2, 1};
        System.out.println("Original Array 2: " + Arrays.toString(arr2));
        nextPermutation(arr2);
        System.out.println("Next Permutation 2: " + Arrays.toString(arr2));
        
        int[] arr3 = {1, 1, 5};
        System.out.println("Original Array 3: " + Arrays.toString(arr3));
        nextPermutation(arr3);
        System.out.println("Next Permutation 3: " + Arrays.toString(arr3));
        
        int[] arr4 = {1};
        System.out.println("Original Array 4: " + Arrays.toString(arr4));
        nextPermutation(arr4);
        System.out.println("Next Permutation 4: " + Arrays.toString(arr4));
    }
}

// Approach:
// 1. Find the first decreasing element from the end of the array (let's call it `i`).
// 2. If such an element is found, find the element just larger than `nums[i]` to the right of `i` and swap them.
// 3. Reverse the elements after the position of the first decreasing element to get the next permutation.
//
// Time Complexity: O(n)
// The algorithm makes a single pass through the array to find the first decreasing element, another pass to find the just larger element, and one more pass to reverse the subarray, making it O(n) in time complexity.
// Space Complexity: O(1)
// The algorithm modifies the array in place and uses constant extra space.

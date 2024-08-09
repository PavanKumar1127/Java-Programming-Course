package leetcode;

import java.util.Arrays;

// Sort an array of 0s, 1s, and 2s (Dutch National Flag problem)
// https://leetcode.com/problems/sort-colors/description/
public class Leetcode_75_SortColors {
    
    public static void sortColors(int[] nums) {
        // Initialize pointers for current element (i), 0s boundary (low), and 2s boundary (high)
        int low = 0, high = nums.length - 1, i = 0;
        
        // Iterate through the array
        while (i <= high) {
            if (nums[i] == 0) {
                // Swap the current element with the element at the 0s boundary
                swap(nums, i, low);
                // Move the 0s boundary to the right
                low++;
                // Move to the next element
                i++;
            } else if (nums[i] == 2) {
                // Swap the current element with the element at the 2s boundary
                swap(nums, i, high);
                // Move the 2s boundary to the left
                high--;
                // Do not increment i here to check the swapped element
            } else {
                // If the element is 1, just move to the next element
                i++;
            }
        }
        
    }
    public static void sortColors1(int[] nums) {
        int zero = 0;
        int two = nums.length-1;
        int i =0;
        while(i<nums.length){
            if(nums[i]==0){
                zero++;
                i++;
            }else if(nums[i] == 2){
                int temp = nums[i];
                nums[i] = nums[two];
                nums[two] = temp;
                two--;
            }else{
            	i++;
                continue;
            }
            i++;
        }
    }

    // Helper method to swap two elements in the array
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        System.out.println("Original Array: " + Arrays.toString(arr));
        
        sortColors1(arr);
        
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}

// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, 
// with the colors in the order red, white, and blue. We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
// You must solve this problem without using the library's sort function.
//
// Example 1:
//
// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]
// Example 2:
//
// Input: nums = [2,0,1]
// Output: [0,1,2]
// Example 3:
//
// Input: nums = [0]
// Output: [0]
// Example 4:
//
// Input: nums = [1]
// Output: [1]
//
// Constraints:
//
// - n == nums.length
// - 1 <= n <= 300
// - nums[i] is 0, 1, or 2.
//

// Approach:
// We use three pointers: low, high, and i. The low pointer tracks the boundary for 0s, high tracks the boundary for 2s,
// and i is used to traverse the array. When we encounter a 0, we swap it with the element at the low boundary and move both
// pointers to the right. When we encounter a 2, we swap it with the element at the high boundary and move the high pointer
// to the left, but do not move i to re-evaluate the swapped element. When we encounter a 1, we simply move to the next element.

// Time Complexity: O(n)
// The algorithm makes a single pass through the array, processing each element once, making it O(n) in time complexity.
// Space Complexity: O(1)
// The algorithm sorts the array in place using constant extra space.

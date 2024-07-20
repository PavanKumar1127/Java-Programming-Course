package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicatesInArray {
    
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {
            // Use the value as the index (1-based to 0-based)
            int index = Math.abs(nums[i]) - 1;

            // If the element at this index is already negative, it means we have seen this number before
            if (nums[index] < 0) {
                duplicates.add(index + 1);
            } else {
                // Mark the element at this index as visited by negating it
                nums[index] = -nums[index];
            }
        }

        return duplicates;
    }
    
    public static void main(String[] args) {
        int[] arr1 = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("Input: " + java.util.Arrays.toString(arr1));
        System.out.println("Output: " + findDuplicates(arr1)); // Output: [2, 3]

        int[] arr2 = {1, 1, 2};
        System.out.println("Input: " + java.util.Arrays.toString(arr2));
        System.out.println("Output: " + findDuplicates(arr2)); // Output: [1]

        int[] arr3 = {1};
        System.out.println("Input: " + java.util.Arrays.toString(arr3));
        System.out.println("Output: " + findDuplicates(arr3)); // Output: []
    }
}

// Given an array of n elements, where each element is an integer between 1 and n (inclusive), find all the duplicates in the array 
// in O(n) time and O(1) extra space.
//
// Example 1:
// Input: nums = [4,3,2,7,8,2,3,1]
// Output: [2, 3]
//
// Example 2:
// Input: nums = [1,1,2]
// Output: [1]
//
// Example 3:
// Input: nums = [1]
// Output: []
//
// Approach:
// We can use the array itself to record the occurrences of each number by modifying the sign of the elements at the corresponding indices. 
// Traverse the array, and for each element, consider its absolute value as the index. Negate the element at that index to mark it as visited. 
// If an element at that index is already negative, it indicates that the index (number) has been seen before and is a duplicate. Collect all duplicates.
//
// Time Complexity: O(n)
// We traverse the array once.
//
// Space Complexity: O(1)
// We use the input array itself for marking.

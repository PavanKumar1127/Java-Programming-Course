package leetcode;

import java.util.Arrays;
import java.util.Random;

// 912. Sort an Array
// https://leetcode.com/problems/sort-an-array/description/
// Given an array of integers nums, sort the array in ascending order and return it.
//
// Example 1:
// Input: nums = [5,2,3,1]
// Output: [1,2,3,5]
//
// Example 2:
// Input: nums = [5,1,1,2,0,0]
// Output: [0,0,1,1,2,5]
//
// Constraints:
// - 1 <= nums.length <= 50000
// - -50000 <= nums[i] <= 50000

// Approach:
// We use the Quick Sort algorithm, which is a divide-and-conquer sorting algorithm.
// The algorithm works by selecting a 'pivot' element from the array and partitioning the other elements into two
// sub-arrays, according to whether they are less than or greater than the pivot. The sub-arrays are then sorted recursively.
// The base case of the recursion is an array of zero or one element, which is already sorted.
// We use a random pivot selection to improve performance and avoid worst-case scenarios.
//
// Time Complexity: O(n log n) on average
// The Quick Sort algorithm has an average time complexity of O(n log n) due to partitioning the array into halves and sorting each half.
// The worst-case time complexity is O(n^2), but this is rare with good pivot selection.
// Space Complexity: O(log n) for the recursive stack space used during the sorting process.

public class Leetcode_912_SortAnArray {

    private static final Random RANDOM = new Random();

    public static void sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    // Quick Sort algorithm with random pivot selection
    private static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            // Randomly select a pivot and move it to the end
            int pivotIndex = low + RANDOM.nextInt(high - low + 1);
            swap(nums, pivotIndex, high);
            // Partition the array and get the pivot index
            pivotIndex = partition(nums, low, high);
            // Recursively sort the sub-arrays
            quickSort(nums, low, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, high);
        }
    }

    // Partition method to find the pivot position
    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high]; // Use the last element as pivot
        int i = low - 1; // Index of smaller element
        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        // Swap the pivot element with the element at i+1
        swap(nums, i + 1, high);
        return i + 1; // Return the partition point
    }

    // Helper method to swap two elements in the array
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 2, 3, 1};
        System.out.println("Original Array: " + Arrays.toString(arr1));
        
        sortArray(arr1);
        
        System.out.println("Sorted Array: " + Arrays.toString(arr1));
        
        int[] arr2 = {5, 1, 1, 2, 0, 0};
        System.out.println("Original Array: " + Arrays.toString(arr2));
        
        sortArray(arr2);
        
        System.out.println("Sorted Array: " + Arrays.toString(arr2));
    }
}

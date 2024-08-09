package strivers.DSA.arrays;

import java.util.Arrays;

// Count Inversions in an array
// https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/

// Given an array `arr`, the inversion count indicates how far (or close) the array is from being sorted. If the array is already sorted, the inversion count is 0. If the array is sorted in the reverse order, the inversion count is the maximum.
//
// Inversion Count for an array indicates how far (or close) the array is from being sorted. If the array is already sorted then the inversion count is 0. 
// If an array is sorted in the reverse order then the inversion count is the maximum.
// Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
//
// Example 1:
//
// Input: arr = [8, 4, 2, 1]
// Output: 6
// Explanation: There are 6 inversions in the array: (8, 4), (8, 2), (8, 1), (4, 2), (4, 1), (2, 1)
//
// Example 2:
//
// Input: arr = [3, 1, 2]
// Output: 2
// Explanation: There are 2 inversions in the array: (3, 1), (3, 2)
//
// Constraints:
//
// - 1 <= arr.length <= 100000
// - 1 <= arr[i] <= 10^9
//
// Approach:
// We can solve the problem using a modified merge sort algorithm. The key idea is that during the merge step,
// we can count how many elements from the right half of the array are smaller than the current element from the left half.
// These counts represent the number of inversions. By leveraging the merge sort's divide-and-conquer strategy, we can count
// the inversions efficiently in O(n log n) time complexity.

public class Leetcode_CountInversions {
    
    public static int countInversions(int[] arr) {
        // Create a temporary array for merge process
        int[] temp = new int[arr.length];
        // Call the recursive merge sort and inversion count method
        return mergeSortAndCount(arr, temp, 0, arr.length - 1);
    }

    // Recursive method to divide the array and count inversions
    private static int mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        int inversionCount = 0;
        
        if (left < right) {
            int mid = (left + right) / 2;

            // Count inversions in the left half
            inversionCount += mergeSortAndCount(arr, temp, left, mid);

            // Count inversions in the right half
            inversionCount += mergeSortAndCount(arr, temp, mid + 1, right);

            // Count split inversions while merging the two halves
            inversionCount += mergeAndCount(arr, temp, left, mid, right);
        }

        return inversionCount;
    }

    // Method to merge two halves and count split inversions
    private static int mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left; // Starting index for left subarray
        int j = mid + 1; // Starting index for right subarray
        int k = left; // Starting index to be sorted
        int inversionCount = 0;

        // Merge the two subarrays
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                // All elements left to the current element in the left subarray are greater than arr[j]
                inversionCount += (mid + 1) - i;
            }
        }

        // Copy the remaining elements of left subarray, if any
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy the remaining elements of right subarray, if any
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy the sorted subarray into the original array
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return inversionCount;
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 2, 1};
        System.out.println("Original Array: " + Arrays.toString(arr));
        
        int inversionCount = countInversions(arr);
        
        System.out.println("Number of Inversions: " + inversionCount); // Output: 6
        System.out.println("Sorted Array: " + Arrays.toString(arr)); // Array will be sorted as [1, 2, 4, 8]
    }
}

// Approach:
// The problem can be efficiently solved using a modified merge sort algorithm. The merge sort algorithm works by recursively dividing the array into two halves, sorting them, and then merging them back together. During the merge step, we count the number of inversions by checking how many elements in the right half are smaller than the current element in the left half. This counting gives us the number of inversions that would need to be made to sort the array. 

// Time Complexity: O(n log n)
// The algorithm runs in O(n log n) time complexity due to the divide and conquer strategy of merge sort, which divides the array in half and sorts and merges them in linear time for each division.

// Space Complexity: O(n)
// The space complexity is O(n) because we use a temporary array to store the merged result.

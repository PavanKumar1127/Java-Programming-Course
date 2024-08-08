package strivers75.BinarySearch;

import java.util.Arrays;

// Search in a Rotated Sorted Array with Duplicates
// You are given a rotated sorted array 'a' of length 'n' and a 'key'. 
// You need to determine if the 'key' exists in the array 'a'.
//
// The given sorted array is rotated from an unknown index 'x'. 
// Such that after rotation the array became [a[x], a[x+1]...., a[n-1], a[0]..., a[x-1]], (0-based indexing). 
// For example, if the array is [1, 2, 3, 4, 5] and x = 2 then the rotated array will be [3, 4, 5, 1, 2, 3].
//
// Return True if the 'key' is found in 'a'. Otherwise, return False.
//
// Note: Array ‘a’ may contain duplicate elements.
//
// Example:
//
// Input: a = [6, 10, 1, 3, 5], key = 3
// Output: True
// Explanation: The array 'a' contains the 'key' = 3, so we return True.
//
// Sample Input 1:
// a = [3, 4, 5, 0, 0, 1, 2], key = 4
// Output: True
//
// Sample Input 2:
// a = [31, 44, 56, 0, 10, 13], key = 47
// Output: False
//
// Constraints:
// 1 <= 'n' <= 10^5
// 0 <= 'a[i]', 'key' <= 10^9
// Time Limit: 1 sec

public class Leetcode_SearchRotatedSortedArray {

    public static boolean search(int[] a, int key) {
        int left = 0, right = a.length - 1;

        // Perform binary search with adjustments for the rotated sorted array with duplicates
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If the key is found, return true
            if (a[mid] == key) {
                return true;
            }

            // If the left half is sorted
            if (a[left] < a[mid]) {
                // Check if the key lies in the sorted left half
                if (a[left] <= key && key < a[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // If the right half is sorted
            else if (a[mid] < a[right]) {
                // Check if the key lies in the sorted right half
                if (a[mid] < key && key <= a[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            // If duplicates are found, we can't determine which half is sorted, so we narrow the search range
            else {
                // Move the left pointer one step to the right
                if (a[left] == a[mid]) {
                    left++;
                }
                // Move the right pointer one step to the left
                if (a[right] == a[mid]) {
                    right--;
                }
            }
        }

        // If the key is not found, return false
        return false;
    }

    public static void main(String[] args) {
        int[] a1 = {3, 4, 5, 0, 0, 1, 2};
        int key1 = 4;
        System.out.println("Sample Input 1: " + Arrays.toString(a1) + ", Key: " + key1);
        System.out.println("Output: " + search(a1, key1)); // Output: True

        int[] a2 = {31, 44, 56, 0, 10, 13};
        int key2 = 47;
        System.out.println("Sample Input 2: " + Arrays.toString(a2) + ", Key: " + key2);
        System.out.println("Output: " + search(a2, key2)); // Output: False
    }
}

// Approach:
// We perform a binary search on the rotated sorted array. 
// At each step, we determine whether the left half or the right half of the array is sorted.
// Depending on whether the key lies within the sorted half, we adjust our search range accordingly.
// If duplicates are encountered, we narrow the search range by moving the left or right pointer inward.
// This approach handles the rotation and duplicates efficiently by leveraging the properties of binary search.

// Time Complexity: O(log n) in the average case when the array has no or minimal duplicates. 
// In the worst case, with many duplicates, the time complexity may degrade to O(n), but it still ensures an efficient search.
// Space Complexity: O(1) since the search is performed in place without requiring additional space.

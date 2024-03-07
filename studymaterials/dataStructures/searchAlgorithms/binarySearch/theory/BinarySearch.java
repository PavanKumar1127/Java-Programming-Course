package dataStructures.searchAlgorithms.binarySearch.theory;

/**
 * Binary search is a more efficient search algorithm to find a target element
 * within a sorted list or array. It follows divide-and-conquer strategy,
 * repeatedly dividing the search space in half until the target is found or the
 * search space is empty.
 * 
 * 
 * Efficiency: Binary search has a time complexity of O(log n), where n is the
 * size of the sorted list. This is significantly more efficient than linear
 * search, especially for large datasets.
 * 
 * 
 * Requirements:
 * Binary search requires the list to be sorted. If the list is unsorted, it
 * must be sorted first. 
 * 
 * 
 * Memory Usage:
 * Binary search uses a constant amount of memory (O(1)) because it doesn't need
 * any additional data structures.
 */

//function binarySearch(arr, target):
//    low = 0
//    high = length(arr) - 1
//    
//    while low <= high:
//        mid = (low + high) / 2
//        if arr[mid] equals target:
//            return mid  // Target found at index mid
//        else if arr[mid] < target:
//            low = mid + 1  // Search in the right half
//        else:
//            high = mid - 1  // Search in the left half
//
//    return -1  // Target not found in the array

public class BinarySearch {
	
	public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid; // Target found at index mid
            } else if (arr[mid] < target) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }

        return -1; // Target not found in the array
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 6;
        int result = binarySearch(sortedArray, target);

        if (result != -1) {
            System.out.println("Target " + target + " found at index " + result);
        } else {
            System.out.println("Target " + target + " not found in the array");
        }
    }
}

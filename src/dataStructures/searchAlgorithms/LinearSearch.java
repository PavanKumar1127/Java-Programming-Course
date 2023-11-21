package dataStructures.searchAlgorithms;

/**
 * Linear search is a simple algorithm for finding a target element within a
 * list. It sequentially checks each element of the list until a match is found
 * or the entire list has been searched. Linear search works both on sorted and
 * unsorted lists.
 * 
 * 
 * Efficiency: Linear search has a time complexity of O(n), where n is the size
 * of the list. In the worst case, it may need to check each element in the
 * list.
 * 
 * Memory Usage:
 * Linear search uses a constant amount of memory (O(1)) because it doesn't need
 * any additional data structures.
 */
public class LinearSearch {

	public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Target found at index i
            }
        }
        return -1; // Target not found in the array
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6};
        int target = 9;
        int result = linearSearch(array, target);
        
        if (result != -1) {
            System.out.println("Target " + target + " found at index " + result);
        } else {
            System.out.println("Target " + target + " not found in the array");
        }
    }
}

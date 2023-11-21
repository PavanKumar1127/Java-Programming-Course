package dataStructures.searchAlgorithms;

import java.util.Arrays;

/**
 * 
 * Bubble Sort is a simple sorting algorithm that repeatedly steps through a
 * list of elements, compares adjacent items, and swaps them if they are in the
 * wrong order. This process is repeated until the list is sorted. The algorithm
 * gets its name because smaller elements "bubble" to the top of the list in
 * each pass. While easy to understand, Bubble Sort is not efficient for large
 * datasets and has a time complexity of O(n^2). It is mainly used for
 * educational purposes or when simplicity is more important than efficiency.
 */
public class BubbleSort {

	public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Unsorted Array: " + Arrays.toString(array));

        bubbleSort(array);

        System.out.println("Sorted Array: " + Arrays.toString(array));
    }

	private static void bubbleSort(int[] arr) {
		   int n = arr.length;
	        boolean swapped;

	        for (int i = 0; i < n - 1; i++) {
	            swapped = false;
	            
	            for (int j = 0; j < n - 1 - i; j++) {
	                if (arr[j] > arr[j + 1]) {
	                    // Swap arr[j] and arr[j + 1]
	                    int temp = arr[j];
	                    arr[j] = arr[j + 1];
	                    arr[j + 1] = temp;
	                    swapped = true;
	                }
	            }

	            // If no two elements were swapped in inner loop, the array is sorted
	            if (!swapped) {
	                break;
	            }
	        }
	}
}

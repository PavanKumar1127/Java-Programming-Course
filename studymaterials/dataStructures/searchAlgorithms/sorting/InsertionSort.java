package dataStructures.searchAlgorithms.sorting;

import java.util.Arrays;

/**
 * 
 * Insertion Sort is a simple sorting algorithm that builds the final sorted
 * array one element at a time. It iterates through the input array, comparing
 * each element with its adjacent ones, and inserts it into its correct position
 * in the already sorted part of the array. This process is repeated until the
 * entire array is sorted.
 */
public class InsertionSort {

	public static void insertionSort(int[] arr) {
		int n = arr.length;

		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;

			// Move elements greater than key to one position ahead of their current
			// position
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				System.out.println("While: " + Arrays.toString(arr));

				j = j - 1;
			}
			arr[j + 1] = key;
			System.out.println("for " + ": " + Arrays.toString(arr));

		}
	}

	public static void main(String[] args) {
		int[] array = { 12, 11, 13, 5, 6 };
		System.out.println("Unsorted Array: " + Arrays.toString(array));

		insertionSort(array);

		System.out.println("Sorted Array: " + Arrays.toString(array));
	}
}

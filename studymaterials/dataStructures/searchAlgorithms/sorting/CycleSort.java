package dataStructures.searchAlgorithms.sorting;

import java.util.Arrays;

/**
 * Cycle Sort is an in-place, unstable sorting algorithm that minimizes the
 * number of writes performed during the sorting process. Instead of finding the
 * right place for each element and swapping them, Cycle Sort works by
 * organizing the elements into cycles and then rotating the elements within
 * those cycles to sort the array.
 */
public class CycleSort {
	
	public static void cycleSort(int[] arr) {
		int i = 0;
		while(i<arr.length) {
			int correct = arr[i]-1;
			if(arr[i] != arr[correct]) {
				swap(arr, i, correct);
			}else {
				i++;
			}
		}
	}

	private static void swap(int[] arr, int i, int correct) {
		int temp = arr[i];
		arr[i] = arr[correct];
		arr[correct] = temp;
	}

	public static void main(String[] args) {
	//	int[] arr = { 5, 2, 1, 4, 3 };
		int[] arr = { 3 ,1 ,2 ,5 ,3 };
		

		// Print the original array
		System.out.println("Original Array: " + Arrays.toString(arr));

		// Perform Cycle Sort
		cycleSort(arr);

		// Print the sorted array
		System.out.println("Sorted Array: " + Arrays.toString(arr));
	}
}

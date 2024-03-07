package dataStructures.searchAlgorithms.sorting;

import java.util.Arrays;

public class MergeSort {

	public static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;

			// Recursively sort the first and second halves
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);

			// Merge the sorted halves
			merge(arr, left, mid, right);
		}
	}

	private static void merge(int[] arr, int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;

		// Create temporary arrays
		int[] leftArray = new int[n1];
		int[] rightArray = new int[n2];

		// Copy data to temporary arrays
		for (int i = 0; i < n1; ++i) {
			leftArray[i] = arr[left + i];
		}
		for (int j = 0; j < n2; ++j) {
			rightArray[j] = arr[mid + 1 + j];
		}

		// Merge the temporary arrays
		int i = 0, j = 0, k = left;
		while (i < n1 && j < n2) {
			if (leftArray[i] <= rightArray[j]) {
				arr[k++] = leftArray[i++];
			} else {
				arr[k++] = rightArray[j++];
			}
			System.out.println("Inside 1 while: " + Arrays.toString(arr));

		}

		// Copy remaining elements of leftArray (if any)
		while (i < n1) {
			arr[k++] = leftArray[i++];
			System.out.println("Inside 2 while: " + Arrays.toString(arr));
		}

		// Copy remaining elements of rightArray (if any)
		while (j < n2) {
			arr[k++] = rightArray[j++];
			System.out.println("Inside 3 while: " + Arrays.toString(arr));
		}
	}

	public static void main(String[] args) {
		int[] array = { 64, 34, 25, 12, 22, 11, 90 , 60};
		System.out.println("Unsorted Array: " + Arrays.toString(array));

		mergeSort(array, 0, array.length - 1);

		System.out.println("Sorted Array: " + Arrays.toString(array));
	}
}

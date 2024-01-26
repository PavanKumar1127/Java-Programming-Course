package dataStructures.searchAlgorithms.binarySearch.theory;

public class OrderAgnosticBinarySearch {

	// Order Agnostic Binary Search is a variant of the binary search algorithm that
	// is designed to find an element in a sorted array, regardless of whether the
	// array is sorted in ascending or descending order. In other words, it adapts
	// to the order of the array during the search process.

	public static int orderAgnosticBinarySearch(int[] arr, int target) {
		int start = 0;
		int end = arr.length - 1;

		// Determine the order of the array
		boolean isAscending = arr[start] < arr[end];

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (arr[mid] == target) {
				return mid;
			}

			if (isAscending) {
				if (target < arr[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				if (target < arr[mid]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}

		return -1; // Element not found
	}

	public static void main(String[] args) {
		int[] ascendingArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int target = 5;
		int resultAsc = orderAgnosticBinarySearch(ascendingArray, target);
		System.out.println("Index of " + target + " in ascending array: " + resultAsc);

		int[] descendingArray = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int resultDesc = orderAgnosticBinarySearch(descendingArray, target);
		System.out.println("Index of " + target + " in descending array: " + resultDesc);
	}
}

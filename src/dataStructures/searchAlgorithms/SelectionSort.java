package dataStructures.searchAlgorithms;

import java.util.Arrays;

/**
 * Selection Sort is a simple sorting algorithm that divides the input list into
 * a sorted and an unsorted region. In each iteration, it finds the smallest
 * element in the unsorted region and swaps it with the first unsorted element.
 * This process is repeated until the entire list is sorted. Selection Sort has
 * a time complexity of O(n^2) and is primarily used for educational purposes
 * due to its simplicity.
 */

public class SelectionSort {

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            // Assume the current index is the minimum
            int minIndex = i;

            // Find the minimum element in the unsorted part
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the minimum element with the first element of the unsorted part
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {64, 25, 12, 22, 11};
        System.out.println("Unsorted Array: " + Arrays.toString(array));

        selectionSort(array);

        System.out.println("Sorted Array: " + Arrays.toString(array));
    }
}

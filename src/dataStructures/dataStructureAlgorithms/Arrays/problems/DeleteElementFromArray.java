package dataStructures.dataStructureAlgorithms.Arrays.problems;

import java.util.Arrays;

public class DeleteElementFromArray {

    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50};
        int targetElement = 30;

        // Delete the target element
        array = deleteElement(array, targetElement);

        // Output: [10, 20, 40, 50]
        System.out.println(Arrays.toString(array));
    }

    private static int[] deleteElement(int[] array, int target) {
        int index = -1;

        // Find the index of the target element
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                index = i;
                break;
            }
        }

        // If the target element is found, shift elements to the left
        if (index != -1) {
            for (int i = index; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }

            // Resize the array by creating a new array with one less element
            array = Arrays.copyOf(array, array.length - 1);
        }

        return array;
    }
}


package dataStructures.dataStructureAlgorithms.Arrays;

import java.util.Arrays;

// An array is a sequentially arranged, fixed-size collection of elements of the same data type in memory.
// datatype can be primitive dt, objects, complex dt, etc.
public class Array {
	int[] rollNumber = new int[4];
	int[] rollNumber1 = {3,4,5,6,7,8};
	// should be of same datatype 
	//int[] roll_Number1 = {3,4,5,"name",7,8};
	
	//breakdown of the process
	//int[] ros; // Decleration of array, ros is getting defined in stack
	//ros = new int[4]; // initiallization: actually here object is getting created in the memory(heap)

}

class ArrayExample {
    public static void modifyArray(int[] arr) {
        // Modifying the contents of the array
        arr[0] = 99;
        arr = new int[]{100, 200, 300}; // This does not affect the original array reference as here the ref var is having changes
    }

    public static void main(String[] args) {
        int[] myArray = {1, 2, 3};
        modifyArray(myArray);

        // The contents of the array have been modified
        System.out.println(myArray[0]); // Output: 99

        // The array reference itself has not been modified
        System.out.println(myArray.length); // Output: 3
        
        System.out.println(Arrays.toString(myArray));

    }
}

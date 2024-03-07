package dataStructures.dataStructureAlgorithms.Arrays;

import java.util.Arrays;

public class Array_PassingInFunction {
	
	public static void main(String[] args) {
		int[] arr = {2,3,4,5,6,};
		System.out.println(Arrays.toString(arr));
		change(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void change(int[] array) { // here copy of the actual variable is passed from line 10
		// array is a reference variable that points to the same memory location at heap where arr is pointing
		
		array[0] = 100; // changes made here will also reflect in arr 
		array[3] = 99;
	}
	
	// this is mutable behaviour
// (Strings) objects are immutable
}


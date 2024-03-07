package dataStructures.dataStructureAlgorithms.Arrays.problems;

/**
 * Check for Majority Element in a sorted array
 */

//Given an array arr of N elements,  A majority element in an array arr of size N is an element that appears more than N/2 times in the array. The task is to write a function say isMajority() that takes an array (arr[] ), array’s size (n) and a number to be searched (x) as parameters and returns true if x is a majority element (present more than n/2 times).
//
//Examples: 
//
//Input: arr[] = {1, 2, 3, 3, 3, 3, 10}, x = 3
//Output: True (x appears more than n/2 times in the given array)
//
//Input: arr[] = {1, 1, 2, 4, 4, 4, 6, 6}, x = 4
//Output: False (x doesn't appear more than n/2 times in the given array)
//
//Input: arr[] = {1, 1, 1, 2, 2}, x = 1
//Output: True (x appears more than n/2 times in the given array)

//public class Arrays2 {
//
//	/* Driver function to check for above functions */
//	public static void main(String[] args) {
//		int arr[] = { 1, 1, 2, 4, 4, 4, 4, 4, 4, 8, 12, 18 };
//		int n = arr.length;
//		int x = 4;
//		if (isMajority(arr, n, x) == true) // if (isMajority(arr, n, x))
//			System.out.println(x + " appears more than " + n / 2 + " times in arr[]");
//		else
//			System.out.println(x + " does not appear more than " + n / 2 + " times in arr[]");
//	}
//
//	private static boolean isMajority(int[] arr, int n, int x) {
//		int count = (n % 2 == 0) ? n / 2 : n / 2 + 1;
//		for (int i : arr) {
//			if (x == i)
//				count--;
//
//			/* get last index according to n (even or odd) */
//			/*
//			 * check if x is present and is present more than n/2 times
//			 */
////         if (arr[i] == x && arr[i+n/2] == x)
////	                return true;
//		}
//
//		return count <= 0;
//	}
//	
//	//Time Complexity: O(n)
////	Auxiliary Space: O(1)
//	
//
//}

////////////////////////////////////////////////////////////////////////////
//METHOD 2 (Using Binary Search):
//Use binary search methodology to find the first occurrence of the given number. 
//The criteria for binary search is important here. 

public class Arrays2FindMajority{

	/*
	 * If x is present in arr[low...high] then returns the index of first occurrence
	 * of x, otherwise returns -1
	 */
	static int _binarySearch(int arr[], int low, int high, int x) {
		if (high >= low) {
			int mid = (low + high) / 2; /* low + (high - low)/2; */

			/*
			 * Check if arr[mid] is the first occurrence of x. arr[mid] is first occurrence
			 * if x is one of the following is true: (i) mid == 0 and arr[mid] == x (ii)
			 * arr[mid-1] < x and arr[mid] == x
			 */
			System.out.println(mid);
			System.out.println(arr[mid]);
			System.out.println((mid == 0 || x > arr[mid - 1]));
			if ((mid == 0 || x > arr[mid - 1]) && (arr[mid] == x))
				return mid;
			else if (x > arr[mid]) {
				System.out.println("inside else if");
				System.out.println(mid);
				System.out.println(high);
				System.out.println(x);
				return _binarySearch(arr, (mid + 1), high, x);
			} else
				System.out.println("inside else");
				System.out.println(mid);
				System.out.println(high);
				System.out.println(x);
				return _binarySearch(arr, low, (mid - 1), x);
		}

		return -1;
	}

	/*
	 * This function returns true if the x is present more than n/2 times in arr[]
	 * of size n
	 */
	static boolean isMajority(int arr[], int n, int x) {
		/* Find the index of first occurrence of x in arr[] */
		int i = _binarySearch(arr, 0, n - 1, x);

		/* If element is not present at all, return false */
		if (i == -1)
			return false;

		/* check if the element is present more than n/2 times */
		if (((i + n / 2) <= (n - 1)) && arr[i + n / 2] == x)
			return true;
		else
			return false;
	}

	/* Driver function to check for above functions */
	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 3, 3, 3, 10 };
		int n = arr.length;
		int x = 3;
		if (isMajority(arr, n, x) == true)
			System.out.println(x + " appears more than " + n / 2 + " times in arr[]");
		else
			System.out.println(x + " does not appear more than " + n / 2 + " times in arr[]");
	}
}
//
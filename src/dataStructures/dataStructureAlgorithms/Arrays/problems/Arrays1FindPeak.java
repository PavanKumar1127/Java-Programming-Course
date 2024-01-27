package dataStructures.dataStructureAlgorithms.Arrays.problems;

//Given an array arr of n elements that is first strictly increasing and then maybe strictly decreasing, find the maximum element in the array.
//
//Note: If the array is increasing then just print the last element will be the maximum value.
//
//Example:
//
//Input: array[]= {5, 10, 20, 15}
//Output: 20
//Explanation: The element 20 has neighbors 10 and 15, both of them are less than 20.
//
//Input: array[] = {10, 20, 15, 2, 23, 90, 67}
//Output: 20 or 90
//Explanation: The element 20 has neighbors 10 and 15, both of them are less than 20, similarly 90 has neighbors 23 and 67.

public class Arrays1FindPeak {
	
	public static void main(String[] args) 
  { 
      int arr[] = {10, 20, 15, 2, 23, 90, 67} ;//{ 1, 3, 20, 4, 1, 0 }; 
      int n = arr.length; 
      System.out.print("Index of a peak point is " + findPeak(arr, n)); //arr[findPeak(arr, n)]
  }

	private static int findPeak(int[] arr, int n) {

		if(n==0 || n==1)
			return 0;
		if(arr[0] >=  arr[1])
			return 0;
		if (arr[n - 1] >= arr[n - 2]) 
          return n - 1; 
		
		for(int i =1; i< n-1; i++)
			if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1]) 
              return i;
		return 0;
		
	} 
}

//Time complexity: O(n)

//This algorithm can be made better using Binary Search

//A Java program to find a peak element using divide and
//conquer
//
//class GFG {

	// A binary search based function that returns index of
	// a peak element
//	static int findPeak(int arr[], int n)
//	{
//		int l = 0;
//		int r = n-1;
//		int mid = 0;
//	
//		while (l <= r) {
//
//			// finding mid by binary right shifting.
//			mid = (l + r) >> 1;
//
//			// first case if mid is the answer
//			if ((mid == 0
//				|| arr[mid - 1] <= arr[mid])
//						&& (mid == n - 1
//							|| arr[mid + 1] <= arr[mid]))
//				break;
//
//			// move the right pointer
//			if (mid > 0 && arr[mid - 1] > arr[mid])
//				r = mid - 1;
//
//			// move the left pointer
//			else
//				l = mid + 1;
//		}
//	
//		return mid;
//	}
//
//	// Driver Code
//	public static void main(String args[])
//	{
//		int arr[] = { 1, 3, 20, 4, 1, 0 };
//		int n = arr.length;
//		System.out.println("Index of a peak point is "
//						+ findPeak(arr, n));
//	}
//}

//Time Complexity: O(log N), Where n is the number of elements in the input array. In each step our search becomes half. So it can be compared to Binary search, So the time complexity is O(log N)

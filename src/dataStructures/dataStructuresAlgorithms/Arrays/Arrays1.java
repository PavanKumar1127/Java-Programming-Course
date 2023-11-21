package DataStructures.DataStructuresAlgorithms.Arrays;

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

public class Arrays1 {
	
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

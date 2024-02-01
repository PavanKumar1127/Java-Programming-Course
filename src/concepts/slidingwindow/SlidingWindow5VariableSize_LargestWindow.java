package concepts.slidingWindow;

import java.util.*;

public class SlidingWindow5VariableSize_LargestWindow {

	// Naive Approach: Consider the sum of all the sub-arrays and return the length
	// of the longest sub-array having the sum ‘k’. Time Complexity is of O(n^2).
	// 2 for loops from j=i till N whichever gives max length that sum is == K that
	// value is updated and returned at the end.
	
	
	
	//SlidingWindow Algorithm : This approach won’t work for negative numbers


	// function to find the length of longest
	  // subarray having sum k
	  static int lenOfLongSubarr1(int A[], int N, int K)
	  {
	 
	    int i = 0, j = 0, sum = 0;
	    int maxLen = Integer.MIN_VALUE;
	 
	    while (j < N) {
	      sum += A[j];
	      if (sum < K) {
	        j++;
	      }
	      else if (sum == K) {
	        maxLen = Math.max(maxLen, j-i+1);
	        j++;
	      }
	      else if (sum > K) {
	        while (sum > K) {
	          sum -= A[i];
	          i++;
	        }
	        if(sum == K){
	          maxLen = Math.max(maxLen, j-i+1);
	        }
	        j++;
	      }
	    }
	    return maxLen;
	  }
//	  Time Complexity: O(N), where N is the length of the given array.
//	  Auxiliary Space: O(1), as constant extra space is required.


	
	
	
	
	//Efficient Approach:  hash table having (sum, index) tuples.

	// function to find the length of longest
	// subarray having sum k
	static int lenOfLongSubarr(int[] arr, int n, int k) {
		// HashMap to store (sum, index) tuples
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0, maxLen = 0;

		// traverse the given array
		for (int i = 0; i < n; i++) {

			// accumulate sum
			sum += arr[i];

			// when subarray starts from index '0'
			if (sum == k)
				maxLen = i + 1;

			// make an entry for 'sum' if it is
			// not present in 'map'
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}

			// check if 'sum-k' is present in 'map'
			// or not
			if (map.containsKey(sum - k)) {

				// update maxLength
				if (maxLen < (i - map.get(sum - k)))
					maxLen = i - map.get(sum - k);
			}
		}

		return maxLen;
	}
	//Time Complexity: O(N), where N is the length of the given array.
//	Auxiliary Space: O(N), for storing the maxLength in the HashMap.

	// Driver code
	public static void main(String args[]) {
		int[] arr = { 5, 4, 1, 1, 1, 2, 3, 5, 6 };
//			int[] arr = {10, 5, 2, 7, 1, 9};
		int n = arr.length;
		int k = 5;
		System.out.println("Length = " + lenOfLongSubarr(arr, n, k));
	}
}

// This code is contributed by rachana soma

package concepts.slidingWindow;

//Find maximum (or minimum) sum of a subarray of size k
public class SlidingWindow1 {

	public static void main(String[] args) {
		int arr[] = { 1, 4, 2, 10, 23, 3, 1, 0, 20 };
		int k = 4;
		int n = arr.length;

		// by brute force
		int max_sum = max_sum_of_subarray(arr, n, k);
		System.out.println("Max Sum By Brute Force : " + max_sum);
		// by sliding window
		int max_sum1 = max_sum_of_subarray1(arr, n, k);
		System.out.println("Max Sum By Sliding Window : " + max_sum1);
	}

	private static int max_sum_of_subarray1(int[] arr, int n, int k) {
		int i = 0;
		int j = 0;
		int sum = 0;
		int currentSum = 0;
		for (j = 0; j < k; j++) {
			currentSum += arr[j];
		}

		sum = currentSum;
		for (; j < n; j++) {
			currentSum+= arr[j]-arr[i++];
			sum = Math.max(sum, currentSum);
		}
		return sum;

	}

	private static int max_sum_of_subarray(int[] arr, int n, int k) {
		int max = 0;

		for (int i = 0; i < n - k; i++) {
			int sum = 0;
			for (int j = i; j - i < k; j++) {
				sum += arr[j];
			}
			max = Math.max(max, sum);
		}
		return max;
	}
//	Time Complexity: O(n2)
//	Auxiliary Space: O(1)

}

//Given an array of integers and a number k, find the maximum sum of a subarray of size k. 
//
//Examples: 
//
//Input  : arr[] = {100, 200, 300, 400},  k = 2
//Output : 700
//
//Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}, k = 4 
//Output : 39
//Explanation: We get maximum sum by adding subarray {4, 2, 10, 23} of size 4.
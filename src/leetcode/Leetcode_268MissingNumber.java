package leetcode;

import java.util.Arrays;

//Missing Number
//https://leetcode.com/problems/missing-number/submissions/1107206570/
//optimized approach with XOR
public class Leetcode_268MissingNumber {
	
	public static int cycleSort(int[] arr) {
//		int i = 0;
//		while(i<arr.length) {
//			int correct = arr[i];
//			if(arr[i] < arr.length && correct != arr[correct]) {
//				swap(arr, i, correct);
//			}else {
//				i++;
//			}
//		}
//		System.out.println("Sorted Array: " + Arrays.toString(arr));
//
//		for( int index =0; index < arr.length; index++) {
//			if(arr[index] != index)
//				return index;
//		}
//		return arr.length;
		
		int result = 0;
		
		        // XOR all indices and array elements
		        for (int i = 0; i < arr.length; i++) {
		            result = result ^ i ^ arr[i];
		        }
		
		        // XOR the result with the length of the array
		        return result ^ arr.length;
	}

	private static void swap(int[] arr, int i, int correct) {
		int temp = arr[i];
		arr[i] = arr[correct];
		arr[correct] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 0, 2, 1, 4, 3 };
//		int[] arr = {0,1};
//		int[] arr = { 3,0,1 };
//		int[] arr = { 9,6,4,2,3,5,7,0,1 };
		

		// Print the original array
		System.out.println("Original Array: " + Arrays.toString(arr));

		// Perform Cycle Sort
		// Print the sorted array
		System.out.println("Missing Number: " + cycleSort(arr));
	}

}
//
//Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
//
//		 
//
//Example 1:
//
//Input: nums = [3,0,1]
//Output: 2
//Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
//Example 2:
//
//Input: nums = [0,1]
//Output: 2
//Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
//Example 3:
//
//Input: nums = [9,6,4,2,3,5,7,0,1]
//Output: 8
//Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
// 
//
//Constraints:
//
//n == nums.length
//1 <= n <= 104
//0 <= nums[i] <= n
//All the numbers of nums are unique.



///////////////////////////////////////////////////////
//public class Leetcode_268 {
//    public int missingNumber(int[] nums) {
//        int result = 0;
//
//        // XOR all indices and array elements
//        for (int i = 0; i < nums.length; i++) {
//            result = result ^ i ^ nums[i];
//        }
//
//        // XOR the result with the length of the array
//        return result ^ nums.length;
//    }
//}

//
//Initialization: int result = 0;
//
//result is initialized to 0. This variable will be used to keep track of the XOR of indices and array elements.
//XOR Operation in Loop:
//
//
//for (int i = 0; i < nums.length; i++) {
//    result = result ^ i ^ nums[i];
//}
//The loop iterates through the array nums.
//result is XORed with the current index i.
//result is XORed with the current element of the array nums[i].
//This process is done for every index and element in the array.
//Why XOR?
//
//XORing a number with itself results in 0 (A ^ A = 0).
//XORing a number with 0 results in the same number (A ^ 0 = A).
//XOR is commutative and associative.
//As a result, after XORing all indices and array elements, only the missing number remains in result.
//
//XOR with Array Length:
//
//return result ^ nums.length;
//Finally, XOR the current value of result with the length of the array (nums.length).
//This step cancels out the XOR operation performed on the missing number, leaving only the missing number in the result.
//Return Missing Number:
//
//The function returns the result, which now holds the missing number.
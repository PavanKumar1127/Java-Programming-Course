package leetcode;

import java.util.Arrays;

//First Missing Positive
//https://leetcode.com/problems/first-missing-positive/description/
public class Leetcode_42_FirstMissingPositive {
	public static int firstMissingPositive(int[] nums) {

		// the first two conditions in the if statement take care
		// that negatives and elements greater than the size of
		// the array are ignored, while applying cycle sort, and
		// rest is the similar code of cycle sort

		int i = 0;
		while (i < nums.length) {
			int correct = nums[i] - 1;
			if (nums[i] <= nums.length && nums[i] > 0 && nums[i] != nums[correct]) {

				int temp = nums[i];
				nums[i] = nums[correct];
				nums[correct] = temp;
			} else {
				i++;
			}
		}

		// after cycle sort has been applied, we will find the first element
		// which is not at the correct index, and return that index + 1

		for (int j = 0; j < nums.length; j++) {

			if (nums[j] != j + 1) {
				return j + 1;
			}
		}

		// if every element is at its correct index, then obviously the first
		// missing positive integer is nums.length + 1

		return nums.length + 1;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,0};
//		int[] arr = {3,4,-1,1};
		
		System.out.println("Original Array: " + Arrays.toString(arr));

		System.out.println("Missing Number: " + firstMissingPositive(arr));
	}
}

//Given an unsorted integer array nums, return the smallest missing positive integer.
//
//You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
//
// 
//
//Example 1:
//
//Input: nums = [1,2,0]
//Output: 3
//Explanation: The numbers in the range [1,2] are all in the array.
//Example 2:
//
//Input: nums = [3,4,-1,1]
//Output: 2
//Explanation: 1 is in the array but 2 is missing.
//Example 3:
//
//Input: nums = [7,8,9,11,12]
//Output: 1
//Explanation: The smallest positive integer 1 is missing.
// 
//
//Constraints:
//
//1 <= nums.length <= 105
//-231 <= nums[i] <= 231 - 1
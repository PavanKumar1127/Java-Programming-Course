package leetcode;

import java.util.*;

//Find the Duplicate Number
//https://leetcode.com/problems/find-the-duplicate-number/description/
public class Leetcode_287 {
	
	 public static int findDuplicate(int[] arr) {
		 int[] presence = new int[arr.length];
		 
		 for (int i = 0; i < arr.length; i++) {
				int num = arr[i];
				presence[num]++;
			}
			for (int i = 1; i < presence.length; i++) {
				if (presence[i] >= 2) {
					return i;
				}
			}
			return -1;
	    }
	 
	public static void main(String[] args) {
		int[] arr = { 1,3,4,2,2 };
//		int[] arr = { 2,2,2,2,2 };
	
	System.out.println("Original Array: " + Arrays.toString(arr));

	// Perform Cycle Sort
	// Print the sorted array
	System.out.println("Missing Number: " + findDuplicate(arr));
}

}
//
//Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
//
//There is only one repeated number in nums, return this repeated number.
//
//You must solve the problem without modifying the array nums and uses only constant extra space.
//
// 
//
//Example 1:
//
//Input: nums = [1,3,4,2,2]
//Output: 2
//Example 2:
//
//Input: nums = [3,1,3,4,2]
//Output: 3
// 
//
//Constraints:
//
//1 <= n <= 105
//nums.length == n + 1
//1 <= nums[i] <= n
//All the integers in nums appear only once except for precisely one integer which appears two or more times.
// 
//
//Follow up:
//
//How can we prove that at least one duplicate number must exist in nums?
//Can you solve the problem in linear runtime complexity?

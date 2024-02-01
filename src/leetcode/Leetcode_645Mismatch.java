package leetcode;

import java.util.Arrays;

//Set Mismatch
//https://leetcode.com/problems/set-mismatch/description/

public class Leetcode_645Mismatch {

	 public static int[] findErrorNums(int[] nums) {
		 int[] res = new int[2];
			int[] presence = new int [nums.length+1];
			
			for(int i = 0; i< nums.length; i++) {
				int num = nums[i];
				presence[num]++;
			}
			
			for(int index =1; index<= nums.length; index++) {
				if(presence[index] >= 2) {
					res[0] = index;
				}
				if(presence[index] == 0) {
					res[1] = index;
				}
			}
			return res;
		}
		
		public static void main(String[] args) {
//			int[] arr = {4,3,2,7,8,2,3,1};
			int[] arr = {1,2,2,4};
			
			System.out.println("Original Array: " + Arrays.toString(arr));

			System.out.println("Missing Number: " + Arrays.toString(findErrorNums(arr)));
		}
}

//You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
//
//You are given an integer array nums representing the data status of this set after the error.
//
//Find the number that occurs twice and the number that is missing and return them in the form of an array.
//
// 
//
//Example 1:
//
//Input: nums = [1,2,2,4]
//Output: [2,3]
//Example 2:
//
//Input: nums = [1,1]
//Output: [1,2]
// 
//
//Constraints:
//
//2 <= nums.length <= 104
//1 <= nums[i] <= 104
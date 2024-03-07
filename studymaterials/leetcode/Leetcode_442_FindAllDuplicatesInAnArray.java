package leetcode;

import java.util.*;

//Find All Duplicates in an Array
//https://leetcode.com/problems/find-all-duplicates-in-an-array/description/

public class Leetcode_442_FindAllDuplicatesInAnArray {

	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		int[] presence = new int [nums.length+1];
		
		for(int i = 0; i< nums.length; i++) {
			int num = nums[i];
			presence[num]++;
		}
		
		for(int index =1; index<= nums.length; index++) {
			if(presence[index] >= 2) {
				res.add(index);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
//		int[] arr = {4,3,2,7,8,2,3,1};
		int[] arr = {2,2};
		
		System.out.println("Original Array: " + Arrays.toString(arr));

		System.out.println("Missing Number: " + findDuplicates(arr));
	}
}
//
//Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.
//
//You must write an algorithm that runs in O(n) time and uses only constant extra space.
//
// 
//
//Example 1:
//
//Input: nums = [4,3,2,7,8,2,3,1]
//Output: [2,3]
//Example 2:
//
//Input: nums = [1,1,2]
//Output: [1]
//Example 3:
//
//Input: nums = [1]
//Output: []
// 
//
//Constraints:
//
//n == nums.length
//1 <= n <= 105
//1 <= nums[i] <= n
//Each element in nums appears once or twice.
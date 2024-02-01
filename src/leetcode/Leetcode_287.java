package leetcode;

import java.util.*;

//Find the Duplicate Number
//https://leetcode.com/problems/find-the-duplicate-number/description/
public class Leetcode_287 {
	
	 public static int findDuplicate1(int[] nums) {
	        int tortoise = nums[0];
	        int hare = nums[0];

	        // Phase 1: Tortoise and Hare move until they meet
	        do {
	            tortoise = nums[tortoise];
	            hare = nums[nums[hare]];
	        } while (tortoise != hare);

	        // Phase 2: Reset one pointer to the beginning and find the meeting point
	        tortoise = nums[0];
	        while (tortoise != hare) {
	            tortoise = nums[tortoise];
	            hare = nums[hare];
	        }

	        // The meeting point is the duplicate number
	        return tortoise;
	    }
	 
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

//
//
//Floyd's Tortoise and Hare algorithm is considered an optimized approach for finding a duplicate number in an array due to its efficiency in terms of both time and space complexity.
//
//Time Complexity:
//The algorithm has a time complexity of O(n), where "n" is the number of elements in the array.
//The movement of the tortoise and hare is designed to detect a cycle in the array efficiently.
//The pointers traverse the array at different speeds, with the hare moving faster than the tortoise.
//If there is a duplicate number, the two pointers will eventually meet inside a cycle.
//Space Complexity:
//The algorithm has a space complexity of O(1), indicating constant space usage.
//It doesn't require additional data structures or storage proportional to the size of the input array.
//The pointers traverse the array in-place without using extra memory, making it efficient in terms of space.

//Steps:
//1. Initialization:
//Tortoise and Hare: Initialize both pointers (tortoise and hare) to the first element of the array.
//2. Phase 1: Cycle Detection
//Movement: Move the tortoise one step and the hare two steps at a time.
//Meeting Point: Continue until they meet inside a cycle.
//java
//Copy code
//Initial Array: [1, 3, 4, 2, 2]
//Tortoise: 3
//Hare: 4
//---
//Tortoise: 2
//Hare: 2 (Meeting Point)
//3. Phase 2: Identify Meeting Point
//Reset and Move: Reset one pointer (tortoise) to the beginning and move both pointers one step at a time until they meet again.
//java
//Copy code
//Reset:
//Tortoise: 1
//Hare: 2 (Meeting Point)
//---
//Tortoise: 3
//Hare: 3 (Duplicate Number: 2)
//4. Result
//The meeting point (3) is the index of the duplicate number (2) in the array.
package leetcode;

import java.util.*;

//Find All Numbers Disappeared in an Array
//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
// can also be done using cycle sort algorithm but not as fast as this approach.
//optimized solution below
public class Leetcode_448MissingNumberInArray {

	public static List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int val : nums) {
            set.add(val);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }
	
	public static void main(String[] args) {
		int[] arr = {4,3,2,7,8,2,3,1};
		System.out.println("Original Array: " + Arrays.toString(arr));

		// Perform Cycle Sort
		// Print the sorted array
		System.out.println("Missing Number: " + findDisappearedNumbers(arr));
	}
}

//Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
//
//		 
//
//Example 1:
//
//Input: nums = [4,3,2,7,8,2,3,1]
//Output: [5,6]
//Example 2:
//
//Input: nums = [1,1]
//Output: [2]
// 
//
//Constraints:
//
//n == nums.length
//1 <= n <= 105
//1 <= nums[i] <= n


//
//public class Leetcode_448 {
//
//	public static void main(String[] args) {
//		int[] arr = { 4, 3, 2, 7, 8, 2, 3, 1 };
//		System.out.println("Original Array: " + Arrays.toString(arr));
//
//		// Perform Cycle Sort
//		// Print the sorted array
//		System.out.println("Missing Number: " + findDisappearedNumbers(arr));
//	}
//
//	public static List<Integer> findDisappearedNumbers(int[] nums) {
//		List<Integer> res = new ArrayList<>();
//		int[] presence = new int[nums.length + 1];
//		for (int i = 0; i < nums.length; i++) {
//			int num = nums[i];
//			presence[num]++;
//		}
//		for (int i = 1; i < presence.length; i++) {
//			if (presence[i] == 0) {
//				res.add(i);
//			}
//		}
//		return res;
//	}
//}

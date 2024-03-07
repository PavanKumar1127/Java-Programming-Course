package leetcode;

import java.util.*;

//Maximum Sum of Distinct Subarrays With Length K

public class Leetcode_2461_MaximumSumofDistinctSubarraysWithLengthK {
	public static long maximumSubarraySum(int[] nums, int k) {
		long sum = 0;
		int i = 0;
		int j = 0;
		sum = nums[i];
		long ans = 0;
		HashSet<Integer> set1 = new HashSet<Integer>();
		for (int num : nums) {
			set1.add(num);
		}
		if (set1.size() == 1 && k > 1) {
			return 0;
		} else if (set1.size() == 1 && k == 1) {
			return nums[0];
		}
		HashMap<Integer, Integer> set = new HashMap<Integer, Integer>();
		set.put(nums[i], i);
		while (j < nums.length && i <= j) {
			System.out.println((j - i + 1) + " " + ((j - i + 1) == k));
			if ((j - i + 1) == k) {
				if (set.size() == k) {
					ans = Math.max(ans, sum);
				}
				set.remove(nums[i]);
				sum -= nums[i++];
				if (j + 1 < nums.length) {
					if (set.containsKey(nums[j + 1])) {
						int val = set.get(nums[j + 1]);
						for (int a = i; a <= val; a++) {
							set.remove(nums[a]);
							sum -= nums[a];
						}
						i = val + 1;
					}
					sum += nums[++j];
					set.put(nums[j], j);
				} else {
					++j;
				}
			} else if ((j - i + 1) < k) {
				if (j + 1 < nums.length) {
					if (set.containsKey(nums[j + 1])) {
						int val = set.get(nums[j + 1]);
						for (int a = i; a <= val; a++) {
							set.remove(nums[a]);
							sum -= nums[a];
						}
						i = val + 1;
					}
					sum += nums[++j];
					set.put(nums[j], j);
				} else {
					++j;
				}
			} else {
				set.remove(nums[i]);
				sum -= nums[i++];
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,5,4,2,9,9,9};
		System.out.println(maximumSubarraySum(arr, 3));
	}
}


//
//You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:
//
//The length of the subarray is k, and
//All the elements of the subarray are distinct.
//Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.
//
//A subarray is a contiguous non-empty sequence of elements within an array.
//
// 
//
//Example 1:
//
//Input: nums = [1,5,4,2,9,9,9], k = 3
//Output: 15
//Explanation: The subarrays of nums with length 3 are:
//- [1,5,4] which meets the requirements and has a sum of 10.
//- [5,4,2] which meets the requirements and has a sum of 11.
//- [4,2,9] which meets the requirements and has a sum of 15.
//- [2,9,9] which does not meet the requirements because the element 9 is repeated.
//- [9,9,9] which does not meet the requirements because the element 9 is repeated.
//We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions
//Example 2:
//
//Input: nums = [4,4,4], k = 3
//Output: 0
//Explanation: The subarrays of nums with length 3 are:
//- [4,4,4] which does not meet the requirements because the element 4 is repeated.
//We return 0 because no subarrays meet the conditions.
// 
//
//Constraints:
//
//1 <= k <= nums.length <= 105
//1 <= nums[i] <= 105

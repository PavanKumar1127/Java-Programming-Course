package leetcode;

//Longest Subarray of 1's After Deleting One Element
//https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/?envType=daily-question&envId=2023-12-01

/**
 * Bruteforce approach: use two pointer Sliding window to count no of max
 * elements with one 0. when encountered 0 take max of max and count + previous
 * count, at the end take max of the same again and while
 * returning check for special case where all the elements are 1.
 * 
 */
public class Leetcode_1493_LongestSubarrayOf_1s {
	public static void main(String[] args) {
//		int[] nums = { 1, 1, 0, 1 };
		int[] nums = { 0, 1, 1, 1, 0, 1, 1, 0, 1 };
		System.out.println(longestSubarray1(nums));

	}

	private static int longestSubarray(int[] nums) {
		int n = nums.length;
		int left = 0;
		int zeros = 0;
		int ans = 0;

		for (int right = 0; right < n; right++) {
			if (nums[right] == 0) {
				zeros++;
			}
			while (zeros > 1) {
				if (nums[left] == 0) {
					zeros--;
				}
				left++;
			}
			ans = Math.max(ans, right - left + 1 - zeros);
		}
		return (ans == n) ? ans - 1 : ans;
	}

	public static int longestSubarray1(int[] nums) {
		int prev = 0;
		int current = 0;
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				max = Math.max(current + prev, max);
				prev = current;
				current = 0;
			} else
				current++;
		}
		max = Math.max(current + prev, max);
		return max == nums.length ? max - 1 : max;
	}
}

//Given a binary array nums, you should delete one element from it.
//
//Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
//
// 
//
//Example 1:
//
//Input: nums = [1,1,0,1]
//Output: 3
//Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
//Example 2:
//
//Input: nums = [0,1,1,1,0,1,1,0,1]
//Output: 5
//Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
//Example 3:
//
//Input: nums = [1,1,1]
//Output: 2
//Explanation: You must delete one element.
// 
//
//Constraints:
//
//1 <= nums.length <= 105
//nums[i] is either 0 or 1.
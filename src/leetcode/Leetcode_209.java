package leetcode;

//209. Minimum Size Subarray Sum

//https://leetcode.com/problems/minimum-size-subarray-sum/description/?envType=daily-question&envId=2023-12-01

public class Leetcode_209 {

	public static void main(String[] args) {
		int target = 7;
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		System.out.println(minSubArrayLen1(target, nums));
	}

	public static int minSubArrayLen(int target, int[] nums) {
		int minLength = Integer.MAX_VALUE;
		/**
		 * One straightforward approach is to check all possible subarrays and find the
		 * minimum length that meets the sum condition.
		 */

		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				if (sum >= target) {
					minLength = Math.min(minLength, j - i + 1);
					break; // No need to check longer subarrays starting from the same i
				}
			}
		}

		return minLength == Integer.MAX_VALUE ? 0 : minLength;
	}

	/**
	 * The brute force approach has a time complexity of O(n^2) due to nested loops.
	 * We can optimize this by using a sliding window technique.
	 * 
	 * Sliding Window Approach:
	 * 
	 */
	public static int minSubArrayLen1(int target, int[] nums) {
		int minLength = Integer.MAX_VALUE;
		int left = 0;
		int sum = 0;

		for (int right = 0; right < nums.length; right++) {
			sum += nums[right];

			while (sum >= target) {
				minLength = Math.min(minLength, right - left + 1);
				sum -= nums[left];
				left++;
			}
		}

		return minLength == Integer.MAX_VALUE ? 0 : minLength;
	}
	/**
	 * The optimized approach has a time complexity of O(n) as it only iterates
	 * through the array once with the sliding window technique. The space
	 * complexity is O(1) since it uses only a constant amount of additional space.
	 */
}

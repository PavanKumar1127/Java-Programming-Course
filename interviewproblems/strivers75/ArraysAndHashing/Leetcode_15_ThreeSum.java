package strivers75.ArraysAndHashing;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
// such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must not contain duplicate triplets.

// Example 1:
// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]

// Example 2:
// Input: nums = []
// Output: []

// Example 3:
// Input: nums = [0]
// Output: []

// Constraints:
// - 0 <= nums.length <= 3000
// - -10^5 <= nums[i] <= 10^5

// Approach:
// 1. Sort the array to use the two-pointer technique effectively and avoid duplicates.
// 2. Iterate through the array, for each element, use two pointers to find pairs that sum up to the negative of the current element.
// 3. Skip duplicate elements to avoid duplicate triplets.
// 4. Move the left and right pointers towards each other to find all possible pairs for the current element.
// 5. Collect all unique triplets in the result list.

// Time Complexity: O(n^2)
// The outer loop runs in O(n) and the inner loop (two-pointer technique) runs in O(n), making the overall time complexity O(n^2).
// Space Complexity: O(1)
// We use constant extra space, apart from the space used for the output list.

public class Leetcode_15_ThreeSum {

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();

		// Step 1: Sort the array
		Arrays.sort(nums);

		// Step 2: Iterate through the array
		for (int i = 0; i < nums.length - 2; i++) {
			// Skip duplicate elements
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			// Initialize two pointers
			int left = i + 1;
			int right = nums.length - 1;

			// Step 3: Use two-pointer technique to find pairs
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];

				if (sum == 0) {
					// Found a triplet
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));

					// Skip duplicate elements
					while (left < right && nums[left] == nums[left + 1]) {
						left++;
					}
					while (left < right && nums[right] == nums[right - 1]) {
						right--;
					}

					// Move pointers
					left++;
					right--;
				} else if (sum < 0) {
					// Move left pointer to the right
					left++;
				} else {
					// Move right pointer to the left
					right--;
				}
			}
		}

		return result;
	}

	public static List<List<Integer>> threeSum1(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();

		// Step 1: Sort the array
		Arrays.sort(nums);

		// Step 2: Iterate through the array
		for (int i = 0; i < nums.length - 2; i++) {
			// Skip duplicate elements
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			// Initialize two pointers
			int j = i + 1;
			int k = nums.length - 1;

			// Step 3: Use two-pointer technique to find pairs
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				// Found a triplet
				if (sum == 0) {
					result.add(Arrays.asList(nums[i], nums[j], nums[k]));

					// Skip duplicate elements
					while (j < k && nums[j] == nums[j + 1]) {
						j++;
					}
					while (k > j && nums[k] == nums[k - 1]) {
						k--;
					}

					// Move pointers
					j++;
					k--;
				} else if (sum < 0) {
					// Move left pointer to the right
					j++;
				} else {
					// Move right pointer to the left
					k--;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = { -1, 0, 1, 2, -1, -4 };
		System.out.println("Original Array: " + Arrays.toString(arr));

		List<List<Integer>> triplets = threeSum(arr);

		System.out.println("Triplets that sum to zero: " + triplets);
	}
}

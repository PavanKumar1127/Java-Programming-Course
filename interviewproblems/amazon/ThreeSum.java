package amazon;

import java.util.*;

public class ThreeSum {

//	Given an array A, find all unique triplets in the array whose sum is equal
//	to zero.

	// Soln: first sort the array i.e, { -4, -1, -1, 0, 1, 2 };
	// keep 3 pointers, i=0, j=n-1, k=i+1;
	// use 2 loops outer loop to iterate till n times and inner loop to iterate k
	// from i till j.

	// the time complexity for sorting is O(nlogn) + iterating through array and
	// finding pair is O(n^2)
	// O(nlogn + n^2) so we can take O(n^2)
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length < 3) {
			return result;
		}

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue; // Skip duplicates for the first element
			}

			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == 0) {
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));

					// Skip duplicates for the second element
					while (left < right && nums[left] == nums[left + 1]) {
						left++;
					}

					// Skip duplicates for the third element
					while (left < right && nums[right] == nums[right - 1]) {
						right--;
					}

					left++;
					right--;
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> triplets = threeSum(nums);
		System.out.println("Unique triplets that sum up to zero:");
		for (List<Integer> triplet : triplets) {
			System.out.println(triplet);
		}
	}
}

package dataStructures.dataStructureAlgorithms.Arrays.problems;

//Search in Rotated Sorted Array
//https://leetcode.com/problems/search-in-rotated-sorted-array/description/

public class Arrays8RotatedSortedArray_1 {

	public static void main(String[] args) {
//			int[] arr = {4,5,6,7,0,1,2};
//			int[] arr = {8,9,0,1,2,3,4,5,6,7};
//			int[] arr = {3,4,5,6,7,0,1,2};
		int[] arr = { 3, 5, 1 };

		int target = 3;
		System.out.println(search(arr, target));

	}

	static int search(int[] nums, int target) {
		int pivot = findPivot(nums);
		if (pivot == -1) {
			// just do normal binary search, array is not rotated
			return (binarySearch(nums, target, 0, nums.length - 1));
		}
		if (nums[pivot] == target) {
			return pivot;
		}
		if (target >= nums[0]) {
			return binarySearch(nums, target, 0, pivot - 1);
		} else {
			return binarySearch(nums, target, pivot + 1, nums.length - 1);
		}
	}

	private static int binarySearch(int[] arr, int target, int start, int end) {

		// Determine the order of the array

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (arr[mid] == target) {
				return mid;
			}

			if (target < arr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return -1; // Element not found
	}

	static int findPivot(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (mid < end && arr[mid] > arr[mid + 1]) {
				return mid;
			} else if (mid > start && arr[mid] < arr[mid - 1]) {
				return mid - 1;
			} else if (arr[mid] < arr[start]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;

	}

}

//
//
// There is an integer array nums sorted in ascending order (with distinct
// values).
//
// Prior to being passed to your function, nums is possibly rotated at an
// unknown pivot index k (1 <= k < nums.length) such that the resulting array is
// [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
// (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3
// and become [4,5,6,7,0,1,2].
//
// Given the array nums after the possible rotation and an integer target,
// return the index of target if it is in nums, or -1 if it is not in nums.
//
// You must write an algorithm with O(log n) runtime complexity.
//
//
//
// Example 1:
//
// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4
// Example 2:
//
// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1
// Example 3:
//
// Input: nums = [1], target = 0
// Output: -1
//
//
// Constraints:
//
// 1 <= nums.length <= 5000
// -104 <= nums[i] <= 104
// All values of nums are unique.
// nums is an ascending array that is possibly rotated.
// -104 <= target <= 104
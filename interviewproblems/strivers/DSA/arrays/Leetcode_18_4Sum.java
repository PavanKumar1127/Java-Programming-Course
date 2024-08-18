package strivers.DSA.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 18. 4Sum
// https://leetcode.com/problems/4sum/description/

// Given an array nums of n integers and an integer target, return all the quadruplets [nums[a], nums[b], nums[c], nums[d]]
// such that 0 <= a, b, c, d < n, and a, b, c, and d are distinct integers such that nums[a] + nums[b] + nums[c] + nums[d] == target.
// You may return the answer in any order.
//
// Example 1:
//
// Input: nums = [1,0,-1,0,-2,2], target = 0
// Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//
// Example 2:
//
// Input: nums = [2,2,2,2,2], target = 8
// Output: [[2,2,2,2]]
//
// Constraints:
//
// - n == nums.length
// - 1 <= n <= 200
// - -10^9 <= nums[i] <= 10^9
// - -10^9 <= target <= 10^9

// Approach:
// We solve this problem using a sorted array and the two-pointer technique. First, we sort the array, which makes it easier to avoid duplicates
// and implement the two-pointer strategy. The idea is to fix two numbers and then use the two-pointer approach to find the remaining two numbers
// that sum up to the target value. We iterate through the array with two loops to fix the first two numbers, and for each combination,
// we use two pointers to find the remaining two numbers. To avoid duplicates, we skip the same numbers during iteration and pointer movement.
//
// Time Complexity: O(n^3)
// The array is sorted in O(n log n) time, and the triple nested loops with the two-pointer approach take O(n^3) time in the worst case.
//
// Space Complexity: O(1)
// The algorithm uses constant extra space apart from the space needed to store the output.

public class Leetcode_18_4Sum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Iterate through the array with two loops to fix the first two numbers
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicate elements for the first number
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicate elements for the second number
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // Step 3: Use the two-pointer approach to find the other two numbers
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Skip duplicate elements for the third number
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        // Skip duplicate elements for the fourth number
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        // Move the pointers after finding a valid quadruplet
                        left++;
                        right--;
                    } else if (sum < target) {
                        // Move the left pointer to increase the sum
                        left++;
                    } else {
                        // Move the right pointer to decrease the sum
                        right--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println("Input Array: " + Arrays.toString(nums));
        System.out.println("Target: " + target);

        List<List<Integer>> quadruplets = fourSum(nums, target);
        System.out.println("Quadruplets that sum to target: " + quadruplets);
    }
}

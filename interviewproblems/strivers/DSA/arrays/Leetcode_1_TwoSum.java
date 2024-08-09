package strivers.DSA.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 1. Two Sum
// https://leetcode.com/problems/two-sum/
//
// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.
//
// Example 1:
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//
// Example 2:
// Input: nums = [3,2,4], target = 6
// Output: [1,2]
//
// Example 3:
// Input: nums = [3,3], target = 6
// Output: [0,1]
//
// Constraints:
// - 2 <= nums.length <= 10^4
// - -10^9 <= nums[i] <= 10^9
// - -10^9 <= target <= 10^9
// - Only one valid answer exists.
//
// Approach:
// We use a HashMap to keep track of the numbers we have seen and their corresponding indices. As we iterate through the array,
// for each element nums[i], we check if the complement (target - nums[i]) already exists in the map. If it does, we have found
// the two numbers that sum up to the target, so we return their indices. If the complement does not exist in the map, we add
// the current element and its index to the map and continue to the next element.
//
// Time Complexity: O(n)
// The algorithm makes a single pass through the array, processing each element once. HashMap operations like put() and get()
// have an average time complexity of O(1), making the overall time complexity O(n).
//
// Space Complexity: O(n)
// We store up to n elements in the HashMap, where n is the number of elements in the array, resulting in a space complexity of O(n).

public class Leetcode_1_TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        // HashMap to store the value and its corresponding index
        Map<Integer, Integer> map = new HashMap<>();
        
        // Iterate over the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement of the current element
            int complement = target - nums[i];
            
            // If the complement is found in the map, return the indices
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            
            // Otherwise, add the current element and its index to the map
            map.put(nums[i], i);
        }
        
        // Return an empty array if no solution is found (not expected as per problem constraints)
        return new int[] {};
    }
    
    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Input: " + Arrays.toString(nums1) + ", Target: " + target1);
        System.out.println("Output: " + Arrays.toString(twoSum(nums1, target1))); // Output: [0, 1]

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        System.out.println("Input: " + Arrays.toString(nums2) + ", Target: " + target2);
        System.out.println("Output: " + Arrays.toString(twoSum(nums2, target2))); // Output: [1, 2]

        int[] nums3 = {3, 3};
        int target3 = 6;
        System.out.println("Input: " + Arrays.toString(nums3) + ", Target: " + target3);
        System.out.println("Output: " + Arrays.toString(twoSum(nums3, target3))); // Output: [0, 1]
    }
}

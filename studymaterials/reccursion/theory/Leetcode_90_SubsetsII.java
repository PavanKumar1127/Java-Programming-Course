package reccursion.theory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Subsets II (https://leetcode.com/problems/subsets-ii/description/)
// Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.
//
// Example 1:
// Input: nums = [1,2,2]
// Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
//
// Example 2:
// Input: nums = [0]
// Output: [[],[0]]
//
// Constraints:
// - 1 <= nums.length <= 10
// - -10 <= nums[i] <= 10
//
public class Leetcode_90_SubsetsII {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        // Result list to store all subsets
        List<List<Integer>> result = new ArrayList<>();
        // Sort the array to handle duplicates
        Arrays.sort(nums);
        // Start the backtracking process
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    // Helper method for backtracking
    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        // Add the current subset to the result list
        result.add(new ArrayList<>(tempList));

        // Iterate over the remaining elements
        for (int i = start; i < nums.length; i++) {
            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;

            // Include the current element in the subset
            tempList.add(nums[i]);

            // Recursively call backtrack with the next starting index
            backtrack(result, tempList, nums, i + 1);

            // Backtrack: remove the last added element to explore other subsets
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2};
        System.out.println("Subsets for [1, 2, 2]: " + subsetsWithDup(nums1));

        int[] nums2 = {0};
        System.out.println("Subsets for [0]: " + subsetsWithDup(nums2));
    }
}

// Approach:
// 1. Sort the array to handle duplicates easily.
// 2. Use backtracking to explore all possible subsets. 
//    - At each step, either include or exclude the current element and recursively generate the rest of the subsets.
// 3. To avoid duplicate subsets, skip over any element that is the same as the one before it (except when it's the first element in the recursion level).
//
// Time Complexity: O(2^n)
// The number of subsets of a set with n elements is 2^n. In the worst case, we generate all possible subsets. Sorting the array takes O(n log n), 
// but since the subset generation is more expensive, the overall time complexity is O(2^n).
//
// Space Complexity: O(n)
// The space complexity is O(n) due to the recursion stack and the temporary list used to store subsets.

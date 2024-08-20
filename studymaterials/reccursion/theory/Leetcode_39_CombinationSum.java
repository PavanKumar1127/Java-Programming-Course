package reccursion.theory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 39. Combination Sum
// https://leetcode.com/problems/combination-sum/
//
// Given an array of distinct integers candidates and a target integer target, 
// return a list of all unique combinations of candidates where the chosen numbers sum to target. 
// You may return the combinations in any order.
//
// The same number may be chosen from candidates an unlimited number of times. 
// Two combinations are unique if the frequency of at least one of the chosen numbers is different.
//
// Example 1:
// Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]
// Explanation:
// 2 and 3 are used multiple times.
//
// Example 2:
// Input: candidates = [2,3,5], target = 8
// Output: [[2,2,2,2],[2,3,3],[3,5]]
//
// Example 3:
// Input: candidates = [2], target = 1
// Output: []
//
// Example 4:
// Input: candidates = [1], target = 1
// Output: [[1]]
//
// Constraints:
// - 1 <= candidates.length <= 30
// - 1 <= candidates[i] <= 200
// - All elements of candidates are distinct.
// - 1 <= target <= 500

public class Leetcode_39_CombinationSum {
    
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);  // Sort the candidates to facilitate early stopping
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    // Helper method to perform backtracking
    private static void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            // If we hit the target, add the current combination to the result
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                // If the current candidate exceeds the target, break the loop as further candidates will also be too large
                break;
            }
            // Include the current candidate and continue exploring
            current.add(candidates[i]);
            // Recurse with the updated target and the same start index to allow reusing the candidate
            backtrack(candidates, target - candidates[i], i, current, result);
            // Backtrack by removing the last added element
            current.remove(current.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        System.out.println("Combinations for target " + target1 + ": " + combinationSum(candidates1, target1));
        // Output: [[2, 2, 3], [7]]

        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        System.out.println("Combinations for target " + target2 + ": " + combinationSum(candidates2, target2));
        // Output: [[2, 2, 2, 2], [2, 3, 3], [3, 5]]
    }
}

// Approach:
// We use a backtracking approach to explore all possible combinations that sum to the target. 
// The candidates are first sorted to facilitate early stopping in cases where adding a candidate would exceed the target.
// For each candidate, we recursively explore two possibilities: including the candidate or skipping it. 
// If the target is reached, the current combination is added to the result list. 
// The recursion backtracks by removing the last added candidate to explore other possibilities.
//
// Time Complexity: O(2^T) where T is the target value. 
// In the worst case, the algorithm explores all possible combinations of candidates.
// Space Complexity: O(T) where T is the target value.
// The space complexity is determined by the depth of the recursion, which can go up to the target value.

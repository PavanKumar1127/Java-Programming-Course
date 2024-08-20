package reccursion.theory;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    // Recursive method to generate all permutations
    private static void generatePermutations(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        // Base case: if the current permutation is complete
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));  // Add the current permutation to the result list
            return;
        }

        // Recursive case: try adding each unused number to the current permutation
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {  // Check if the number at index i has already been used
                // Add nums[i] to the current permutation
                current.add(nums[i]);
                used[i] = true;

                // Recursively generate permutations with the current number included
                generatePermutations(nums, current, used, result);

                // Backtrack: remove the last added number and mark it as unused
                used[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }

    // Method to initiate the recursive permutation generation
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();  // List to store all the permutations
        generatePermutations(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }

    public static void main(String[] args) {
        int n = 3;
        int[] nums = {1, 2, 3};  // Generate permutations for numbers 1 to 3

        List<List<Integer>> permutations = permute(nums);

        // Print each permutation
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}

package leetcode;

import java.util.Arrays;

public class Leetcode_MaxSumNoAdjacent {

    // Function to find the maximum sum of non-adjacent elements in the array
    public static int maxSumNoAdjacent(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int incl = nums[0]; // Max sum including the first element
        int excl = 0;       // Max sum excluding the first element

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            int newIncl = excl + nums[i]; // Update incl to be excl + current element
            excl = Math.max(incl, excl);  // Update excl to be the maximum of previous incl and excl
            incl = newIncl;               // Move newIncl to incl for the next iteration
        }

        // The result is the maximum of incl and excl after processing all elements
        return Math.max(incl, excl);
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 5, 10, 7};
        int[] nums2 = {3, 2, 7, 10};
        int[] nums3 = {5, 5, 10, 100, 10, 5};

        System.out.println("Maximum Sum (Example 1): " + maxSumNoAdjacent(nums1)); // Output: 15
        System.out.println("Maximum Sum (Example 2): " + maxSumNoAdjacent(nums2)); // Output: 13
        System.out.println("Maximum Sum (Example 3): " + maxSumNoAdjacent(nums3)); // Output: 110
    }
}

/*
Approach:
We use dynamic programming to keep track of the maximum sum including and excluding the current element.
- `incl` keeps track of the maximum sum including the current element.
- `excl` keeps track of the maximum sum excluding the current element.

At each element, we update:
- `incl` to be the sum of `excl` and the current element.
- `excl` to be the maximum of the previous `incl` and `excl`.

The final result is the maximum of `incl` and `excl` after processing all elements.

Time Complexity: O(n)
We iterate through the array once, making the algorithm O(n) in time complexity.

Space Complexity: O(1)
The algorithm uses constant extra space, O(1).
*/

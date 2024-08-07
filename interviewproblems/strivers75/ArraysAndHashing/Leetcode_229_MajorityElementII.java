package strivers75.ArraysAndHashing;

import java.util.ArrayList;
import java.util.List;

// Majority Element II
// https://leetcode.com/problems/majority-element-ii/description/
public class Leetcode_229_MajorityElementII {

    public static List<Integer> majorityElement(int[] nums) {
        // Boyer-Moore Voting Algorithm
        int candidate1 = 0, candidate2 = 0, count1 = 0, count2 = 0;

        // First pass: Find potential candidates
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Second pass: Verify the candidates
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);

        return result;
    }

    public static void main(String[] args) {
//        int[] nums1 = {3, 2, 3};
        int[] nums2 = {1, 1, 1, 3, 3, 2, 2, 2};
        int[] nums3 = {1};
        int[] nums4 = {1, 2};

//        System.out.println("Majority elements in [3, 2, 3]: " + majorityElement(nums1)); // Output: [3]
        System.out.println("Majority elements in [1, 1, 1, 3, 3, 2, 2, 2]: " + majorityElement(nums2)); // Output: [1, 2]
        System.out.println("Majority elements in [1]: " + majorityElement(nums3)); // Output: [1]
        System.out.println("Majority elements in [1, 2]: " + majorityElement(nums4)); // Output: [1, 2]
    }
}

// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
//
// Example 1:
//
// Input: nums = [3,2,3]
// Output: [3]
// Example 2:
//
// Input: nums = [1,1,1,3,3,2,2,2]
// Output: [1,2]
// Example 3:
//
// Input: nums = [1]
// Output: [1]
// Example 4:
//
// Input: nums = [1,2]
// Output: [1,2]
//
// Constraints:
//
// - n == nums.length
// - 1 <= n <= 5 * 10^4
// - -10^9 <= nums[i] <= 10^9

// Approach:
// We use the Boyer-Moore Voting Algorithm to find the potential candidates for majority elements that appear more than n/3 times.
// The algorithm works in two passes:
// 1. First pass: Find potential candidates using two counters and two candidate variables.
// 2. Second pass: Verify these candidates by counting their occurrences in the array.
// If a candidate occurs more than n/3 times, it is added to the result list.
//
// Time Complexity: O(n)
// The algorithm makes two passes through the array, each pass being O(n) in time complexity.
// Space Complexity: O(1)
// The algorithm uses a constant amount of extra space, making it O(1) in space complexity.

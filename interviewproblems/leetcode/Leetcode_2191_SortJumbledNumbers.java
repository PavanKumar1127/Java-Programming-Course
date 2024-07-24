package leetcode;

import java.util.Arrays;

// Sort the Jumbled Numbers based on a custom digit mapping
// https://leetcode.com/problems/sort-the-jumbled-numbers/
public class Leetcode_2191_SortJumbledNumbers {

    public static int[] sortJumbled(int[] mapping, int[] nums) {
        // Create an array to store the mapped values and their original indices
        int[][] mappedNums = new int[nums.length][2];

        // Convert each number in nums based on the mapping and store with its index
        for (int i = 0; i < nums.length; i++) {
            int mappedValue = getMappedValue(mapping, nums[i]);
            mappedNums[i][0] = mappedValue;
            mappedNums[i][1] = i;
        }

        // Sort based on the mapped values and use original indices to break ties
        Arrays.sort(mappedNums, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        // Extract the sorted numbers using the original indices
        int[] sortedNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sortedNums[i] = nums[mappedNums[i][1]];
        }

        return sortedNums;
    }

    // Helper method to convert a number based on the mapping
    private static int getMappedValue(int[] mapping, int num) {
        StringBuilder mappedValue = new StringBuilder();
        String numStr = String.valueOf(num);
        for (char c : numStr.toCharArray()) {
            mappedValue.append(mapping[c - '0']);
        }
        return Integer.parseInt(mappedValue.toString());
    }

    public static void main(String[] args) {
        int[] nums1 = {990, 332, 981};
        int[] mapping1 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        System.out.println("Original Array 1: " + Arrays.toString(nums1));
        System.out.println("Sorted Array 1: " + Arrays.toString(sortJumbled(mapping1, nums1)));

        int[] nums2 = {12, 3, 10};
        int[] mapping2 = {5, 2, 1, 4, 8, 3, 9, 0, 7, 6};
        System.out.println("Original Array 2: " + Arrays.toString(nums2));
        System.out.println("Sorted Array 2: " + Arrays.toString(sortJumbled(mapping2, nums2)));
    }
}

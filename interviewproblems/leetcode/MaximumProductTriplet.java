package leetcode;
import java.util.Arrays;

public class MaximumProductTriplet {
    /**
     * Function to find the maximum product of a triplet in an array
     *
     * @param nums an array of integers
     * @return the maximum product of any triplet in the array
     */
    public static int maximumProductTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException("Array should have at least three elements");
        }

        // Sort the array
        Arrays.sort(nums);

        int n = nums.length;

        // The maximum product of three numbers will be the maximum of:
        // 1. Product of the three largest numbers
        // 2. Product of the two smallest numbers (which might be negative) and the largest number
        int maxProduct1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int maxProduct2 = nums[0] * nums[1] * nums[n - 1];

        // Return the maximum of the two
        return Math.max(maxProduct1, maxProduct2);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 10, -5, 1, -100};
        int[] nums2 = {1, 2, 3, 4};

        System.out.println("Maximum product of triplet is: " + maximumProductTriplet(nums1)); // Output: 5000
        System.out.println("Maximum product of triplet is: " + maximumProductTriplet(nums2)); // Output: 24
    }
}

package leetcode;

import java.util.Arrays;

// 719. Find K-th Smallest Pair Distance
// https://leetcode.com/problems/find-k-th-smallest-pair-distance/

// Given an integer array nums and an integer k, return the k-th smallest distance among all the pairs nums[i] and nums[j] 
// where 0 <= i < j < nums.length.
//
// The distance of a pair (i, j) is defined as the absolute difference between nums[i] and nums[j].
//
// Example 1:
// Input: nums = [1,3,1], k = 1
// Output: 0
// Explanation: The pairs are (1,3), (1,1), and (3,1), and the distances are 2, 0, and 2 respectively. The answer is 0 since that is the 1st smallest distance.
//
// Example 2:
// Input: nums = [1,1,1], k = 2
// Output: 0
//
// Example 3:
// Input: nums = [1,6,1], k = 3
// Output: 5
//
// Constraints:
// - n == nums.length
// - 2 <= n <= 10^4
// - 0 <= nums[i] <= 10^6
// - 1 <= k <= n * (n - 1) / 2
//
// Approach:
// The problem can be solved optimally using binary search combined with the two-pointer technique.
// 1. First, we sort the array to make it easier to calculate the number of pairs with a specific distance.
// 2. We then use binary search on the possible distances (from 0 to the maximum possible difference).
// 3. For each mid value in the binary search, we count the number of pairs with distance less than or equal to mid using the two-pointer technique.
// 4. If the count is greater than or equal to k, we move the upper bound of the binary search to mid. Otherwise, we move the lower bound to mid + 1.
// 5. The result will be the smallest distance for which there are at least k pairs.
//
// Time Complexity: O(n log(max(nums) - min(nums)) + n log n)
// Sorting the array takes O(n log n). The binary search runs in O(log(max(nums) - min(nums))) and each count operation takes O(n). 
// Therefore, the total time complexity is O(n log n + n log(max(nums) - min(nums))).
// Space Complexity: O(1)
// The algorithm uses constant extra space.

public class Leetcode_719_FindKthSmallestPairDistance {

    public static int smallestDistancePair(int[] nums, int k) {
        // Step 1: Sort the array
        Arrays.sort(nums);
        int n = nums.length;
        int low = 0, high = nums[n - 1] - nums[0];
        
        // Step 2: Perform binary search on the distance
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (countPairs(nums, mid) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    // Helper method to count the number of pairs with distance <= mid
    private static int countPairs(int[] nums, int mid) {
        int count = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > mid) {
                left++;
            }
            count += right - left;
        }
        return count;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 1};
        int k1 = 1;
        System.out.println("K-th Smallest Pair Distance: " + smallestDistancePair(nums1, k1)); // Output: 0
        
        int[] nums2 = {1, 1, 1};
        int k2 = 2;
        System.out.println("K-th Smallest Pair Distance: " + smallestDistancePair(nums2, k2)); // Output: 0
        
        int[] nums3 = {1, 6, 1};
        int k3 = 3;
        System.out.println("K-th Smallest Pair Distance: " + smallestDistancePair(nums3, k3)); // Output: 5
    }
}

package strivers75.ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;

// Find the length of the longest subarray with a given XOR
// https://leetcode.com/problems/subarray-with-given-xor/description/
public class Leetcode_1004_SubarrayWithGivenXor {
    
    public static int longestSubarrayWithXor(int[] nums, int x) {
        Map<Integer, Integer> xorMap = new HashMap<>();
        int currentXor = 0;
        int maxLength = 0;
        
        // Initialize the map with the XOR value 0 at index -1
        xorMap.put(0, -1);
        
        for (int i = 0; i < nums.length; i++) {
            // Compute XOR from start to the current index
            currentXor ^= nums[i];
            
            // Check if the current XOR equals the desired XOR
            if (currentXor == x) {
                maxLength = i + 1;
            }
            
            // Compute the required XOR to find a valid subarray
            int requiredXor = currentXor ^ x;
            if (xorMap.containsKey(requiredXor)) {
                maxLength = Math.max(maxLength, i - xorMap.get(requiredXor));
            }
            
            // Store the first occurrence of the current XOR value
            if (!xorMap.containsKey(currentXor)) {
                xorMap.put(currentXor, i);
            }
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 3, 7, 9};
        int x = 6;
        System.out.println("Original Array: " + java.util.Arrays.toString(arr));
        System.out.println("Length of Longest Subarray with XOR " + x + ": " + longestSubarrayWithXor(arr, x));
        // Example Output: Length of Longest Subarray with XOR 6: 4
    }
}

// Given an array nums and an integer x, find the length of the longest subarray where the XOR of all elements in the subarray equals x.
// Example 1:
//
// Input: nums = [4, 2, 2, 6, 3, 7, 9], x = 6
// Output: 4
// Explanation: The longest subarray with XOR 6 is [2, 2, 6, 3], with length 4.
//
// Example 2:
//
// Input: nums = [1, 2, 3, 4, 5], x = 3
// Output: 2
// Explanation: The longest subarray with XOR 3 is [2, 1] or [3], with length 2.
//
// Constraints:
//
// - 1 <= n <= 1000
// - 0 <= nums[i] <= 1000
// - 0 <= x <= 1000
//
// Approach:
// We use a hashmap to store the first occurrence of each XOR value. For each element, we compute the XOR from the start to the current index,
// check if the current XOR equals the given x, and find the length of the longest subarray with the required XOR using the hashmap.
//
// Time Complexity: O(n)
// Space Complexity: O(n)

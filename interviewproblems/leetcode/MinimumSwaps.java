package leetcode;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Problem: Minimum number of swaps required to sort an array
 *
 * Description:
 * Given an array of integers, find the minimum number of swaps required to sort the array in ascending order. 
 * A swap involves exchanging two elements in the array.
 *
 * Example:
 * Input:  [4, 3, 2, 1]
 * Output: 2
 * Explanation:
 * - Swap 1: Swap 4 with 1, resulting in [1, 3, 2, 4].
 * - Swap 2: Swap 3 with 2, resulting in [1, 2, 3, 4].
 *
 * Approach:
 * 1. Create a pair array where each pair contains the element and its original index.
 * 2. Sort the pair array by the element values.
 * 3. Use a boolean array to track visited elements.
 * 4. For each element, if it has not been visited, trace the cycle of elements that need to be swapped.
 * 5. Count the number of swaps needed for each cycle.
 * 6. Sum up the swaps needed for all cycles to get the minimum number of swaps required to sort the array.
 */

public class MinimumSwaps {
    /**
     * Method to calculate the minimum number of swaps required to sort the array
     */
    public static int minSwaps(int[] nums) {
        int n = nums.length;
        
        // Create an array of pairs where each pair contains the element and its original index
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }
        
        // Sort the pair array based on the element values
        Arrays.sort(arr, Comparator.comparingInt(a -> a.value));
        
        // Initialize visited array
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        
        int swaps = 0;
        
        // Iterate through all elements to find cycles
        for (int i = 0; i < n; i++) {
            // If the element is already visited or it is already in the correct place, skip it
            if (visited[i] || arr[i].index == i) {
                continue;
            }
            
            // Find the size of the cycle
            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = arr[j].index;
                cycleSize++;
            }
            
            // If the cycle size is more than 1, then we need (cycleSize - 1) swaps
            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }
        
        return swaps;
    }

    /**
     * Helper class to store value and its original index
     */
    static class Pair {
        int value;
        int index;
        
        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    /**
     * Main method to test the minSwaps method
     */
    public static void main(String[] args) {
        int[] nums1 = {4, 3, 2, 1};
        System.out.println("Minimum swaps needed: " + minSwaps(nums1)); // Output: 2
        
        int[] nums2 = {1, 5, 4, 3, 2};
        System.out.println("Minimum swaps needed: " + minSwaps(nums2)); // Output: 2
    }
}

/**
 * Visual Representation of the Approach:
 *
 * Example Input: [4, 3, 2, 1]
 *
 * Step 1: Create Pairs with Original Index
 * Pairs: [(4, 0), (3, 1), (2, 2), (1, 3)]
 *
 * Step 2: Sort Pairs by Value
 * Sorted Pairs: [(1, 3), (2, 2), (3, 1), (4, 0)]
 *
 * Step 3: Detect Cycles
 * - Start at index 0:
 *   Cycle: (4 -> 1), (1 -> 4)
 *   Swaps needed: 1
 * - Start at index 1:
 *   Cycle: (3 -> 2), (2 -> 3)
 *   Swaps needed: 1
 *
 * Total Swaps: 1 (cycle 1) + 1 (cycle 2) = 2
 *
 * Example Output: 2
 */

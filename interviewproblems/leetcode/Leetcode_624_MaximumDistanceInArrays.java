package leetcode;

import java.util.List;
import java.util.Arrays;

// 624. Maximum Distance in Arrays
// https://leetcode.com/problems/maximum-distance-in-arrays/description/
public class Leetcode_624_MaximumDistanceInArrays {
    
    public static int maxDistance(List<List<Integer>> arrays) {
        // Initialize variables to track the minimum and maximum elements across arrays
        int minElement = arrays.get(0).get(0);
        int maxElement = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDistance = 0;
        
        // Iterate over the arrays starting from the second array
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> currentArray = arrays.get(i);
            int currentMin = currentArray.get(0);
            int currentMax = currentArray.get(currentArray.size() - 1);
            
            // Calculate potential max distance considering current min and max with global max and min
            maxDistance = Math.max(maxDistance, Math.max(Math.abs(currentMax - minElement), Math.abs(maxElement - currentMin)));
            
            // Update global min and max elements
            minElement = Math.min(minElement, currentMin);
            maxElement = Math.max(maxElement, currentMax);
        }
        
        return maxDistance;
    }
    
    public static void main(String[] args) {
        List<List<Integer>> arrays = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5),
            Arrays.asList(1, 2, 3)
        );
        System.out.println("Maximum Distance: " + maxDistance(arrays)); // Output: 4
    }
}

// Given m sorted arrays, find the maximum distance between any pair of elements such that one element is taken 
// from one array and the other element is taken from a different array.
//
// The distance between two elements a and b is defined as |a - b|.
//
// Example 1:
// 
// Input: arrays = [[1,2,3],[4,5],[1,2,3]]
// Output: 4
// Explanation: One way to obtain the maximum distance 4 is by picking 3 in the first array and 1 in the last array.
//
// Example 2:
// 
// Input: arrays = [[1],[1]]
// Output: 0
//
// Constraints:
// - m == arrays.length
// - 2 <= m <= 10^4
// - 1 <= arrays[i].length <= 500
// - -10^4 <= arrays[i][j] <= 10^4
// - The arrays are sorted in non-decreasing order.
// - There will be at most 10^5 elements in all the arrays combined.
//
// Approach:
// We use two variables to track the minimum and maximum elements seen so far across different arrays. 
// As we iterate through each array, we calculate the potential maximum distance by comparing the current array's 
// minimum and maximum elements with the global minimum and maximum. The idea is to always consider the distance 
// between the smallest element of one array and the largest element of another. After checking the current array, 
// we update the global minimum and maximum for subsequent comparisons.
//
// Time Complexity: O(n)
// The algorithm iterates through each array only once, making it O(n) in time complexity, where n is the total number of arrays.
// Space Complexity: O(1)
// The algorithm uses constant extra space for the global minimum and maximum tracking variables.

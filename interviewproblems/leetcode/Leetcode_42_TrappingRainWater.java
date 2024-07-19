package leetcode;

import java.util.Arrays;

// Trapping Rain Water
// https://leetcode.com/problems/trapping-rain-water/description/
public class Leetcode_42_TrappingRainWater {
    public static int trap(int[] height) {
        // Edge case: If the array is empty or has less than 3 elements,
        // no water can be trapped.
        if (height == null || height.length < 3) {
            return 0;
        }

        // Initialize two pointers and two arrays to store the maximum heights
        // to the left and right of each element.
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        // Fill the leftMax array where leftMax[i] contains the maximum height
        // to the left of the ith index, including itself.
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Fill the rightMax array where rightMax[i] contains the maximum height
        // to the right of the ith index, including itself.
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // Calculate the total trapped water by finding the minimum of the leftMax
        // and rightMax for each index and subtracting the height at that index.
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return totalWater;
    }

    

    public static int trap1(int[] height) {
        // Edge case: If the array is empty or has less than 3 elements,
        // no water can be trapped.
        if (height == null || height.length < 3) {
            return 0;
        }

        // Initialize two pointers and variables to store the maximum heights
        // to the left and right of the current elements.
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        // Use a while loop to move the two pointers towards the center.
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // Update leftMax if current height is greater
                } else {
                    totalWater += leftMax - height[left]; // Calculate trapped water
                }
                left++; // Move the left pointer to the right
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // Update rightMax if current height is greater
                } else {
                    totalWater += rightMax - height[right]; // Calculate trapped water
                }
                right--; // Move the right pointer to the left
            }
        }

        return totalWater;
    }

    
    public static void main(String[] args) {
        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height2 = {4,2,0,3,2,5};

        System.out.println("Height Array 1: " + Arrays.toString(height1));
        System.out.println("Trapped Water 1: " + trap(height1)); // Output: 6
        
        System.out.println("Height Array 2: " + Arrays.toString(height2));
        System.out.println("Trapped Water 2: " + trap(height2)); // Output: 9
    }
}

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The elevation map is represented as [0,1,0,2,1,0,1,3,2,1,2,1], and after raining, 6 units of water are trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9
Explanation: The elevation map is represented as [4,2,0,3,2,5], and after raining, 9 units of water are trapped.

Constraints:
- n == height.length
- 1 <= n <= 2 * 10^4
- 0 <= height[i] <= 10^5
*/

/*
Approach:
1. Use two arrays, leftMax and rightMax, to store the maximum heights to the left and right of each index, respectively.
2. Traverse the height array to fill these two arrays.
3. Calculate the total trapped water by iterating through the height array and finding the minimum of leftMax and rightMax for each index, then subtracting the height at that index.

Algorithm:
1. Initialize leftMax and rightMax arrays.
2. Fill the leftMax array by iterating from left to right.
3. Fill the rightMax array by iterating from right to left.
4. Calculate the trapped water by iterating through the height array.

Time Complexity: O(n)
- Filling the leftMax and rightMax arrays each take O(n) time.
- Calculating the trapped water takes O(n) time.
- Therefore, the overall time complexity is O(n).

Space Complexity: O(n)
- We use two additional arrays, each of size n, leading to an auxiliary space complexity of O(n).
*/

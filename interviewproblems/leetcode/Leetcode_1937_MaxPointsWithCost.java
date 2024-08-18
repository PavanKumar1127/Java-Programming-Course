package leetcode;

// Maximum Number of Points with Cost
// https://leetcode.com/problems/maximum-number-of-points-with-cost/

public class Leetcode_1937_MaxPointsWithCost {
    
    public static long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[] dp = new long[n];
        
        // Initialize dp with the values from the first row
        for (int j = 0; j < n; j++) {
            dp[j] = points[0][j];
        }

        // Iterate over each row to compute the maximum points with cost
        for (int i = 1; i < m; i++) {
            long[] left = new long[n];
            long[] right = new long[n];
            long[] newDp = new long[n];

            // Fill the left array
            left[0] = dp[0];
            for (int j = 1; j < n; j++) {
                left[j] = Math.max(left[j - 1], dp[j] + j);
            }

            // Fill the right array
            right[n - 1] = dp[n - 1] - (n - 1);
            for (int j = n - 2; j >= 0; j--) {
                right[j] = Math.max(right[j + 1], dp[j] - j);
            }

            // Calculate new dp values using the left and right arrays
            for (int j = 0; j < n; j++) {
                newDp[j] = Math.max(left[j] - j, right[j] + j) + points[i][j];
            }

            dp = newDp;
        }

        // Find the maximum value in the last dp array
        long maxPoints = dp[0];
        for (int j = 1; j < n; j++) {
            maxPoints = Math.max(maxPoints, dp[j]);
        }

        return maxPoints;
    }

    public static void main(String[] args) {
        int[][] points1 = {
            {1, 2, 3},
            {1, 5, 1},
            {3, 1, 1}
        };
        System.out.println("Max Points: " + maxPoints(points1)); // Output: 9

        int[][] points2 = {
            {1, 5},
            {2, 3},
            {4, 2}
        };
        System.out.println("Max Points: " + maxPoints(points2)); // Output: 11
    }
}

/*
Problem Description:
Given an m x n matrix points representing the number of points in a grid, return the maximum number of points you can obtain by selecting one element in each row. 
However, the cost of moving from one column to another in the next row is the absolute difference between the column indices multiplied by 1.

You can start from any column in the first row, and you can select any column in each subsequent row. The score is calculated by summing the points and subtracting the cost of moving from one column to the next.

Example 1:
Input: points = [
    [1,2,3],
    [1,5,1],
    [3,1,1]
]
Output: 9
Explanation: 
The optimal path is 3 -> 5 -> 1 (starting at column 2 in the first row, moving to column 1 in the second row, and then column 3 in the third row).

Example 2:
Input: points = [
    [1,5],
    [2,3],
    [4,2]
]
Output: 11
Explanation: 
The optimal path is 5 -> 3 -> 4 (starting at column 2 in the first row, moving to column 2 in the second row, and then column 1 in the third row).

Constraints:
- m == points.length
- n == points[i].length
- 1 <= m, n <= 10^5
- 1 <= points[i][j] <= 10^5

Approach:
1. **Dynamic Programming (DP) with Optimization**:
   - We use a dynamic programming approach where `dp[j]` keeps track of the maximum points obtainable when ending on column `j` of the previous row.
   - To handle the movement cost efficiently, we preprocess two arrays (`left` and `right`):
     - `left[j]`: Max value considering all columns to the left of `j`.
     - `right[j]`: Max value considering all columns to the right of `j`.
   - Finally, for each cell in the current row, we update the DP array with the maximum obtainable points by considering the best transition from the previous row using `left` and `right`.

2. **Time Complexity**:
   - **O(m * n)**: We iterate through each row and column, and compute the necessary values in linear time.

3. **Space Complexity**:
   - **O(n)**: We use additional space proportional to the number of columns to store the DP values, and the `left` and `right` arrays.
*/

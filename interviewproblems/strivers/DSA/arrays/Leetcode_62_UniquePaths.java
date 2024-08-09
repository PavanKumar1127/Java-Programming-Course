package strivers.DSA.arrays;

// Unique Paths
// https://leetcode.com/problems/unique-paths/
//
// A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
// The robot can only move either down or right at any point in time. The robot is trying to reach
// the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
// How many possible unique paths are there?
//
// Example 1:
// Input: m = 3, n = 7
// Output: 28
//
// Example 2:
// Input: m = 3, n = 2
// Output: 3
// Explanation:
// From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
// 1. Right -> Down -> Down
// 2. Down -> Down -> Right
// 3. Down -> Right -> Down
//
// Example 3:
// Input: m = 7, n = 3
// Output: 28
//
// Example 4:
// Input: m = 3, n = 3
// Output: 6
//
// Constraints:
// - 1 <= m, n <= 100
// - It's guaranteed that the answer will be less than or equal to 2 * 10^9.
//

// Approach:
// This problem can be solved using Dynamic Programming. We can create a 2D array dp where dp[i][j] represents
// the number of unique paths to reach the cell (i, j). The value at dp[i][j] is obtained by adding the number
// of ways to reach the cell from the left (dp[i][j-1]) and from above (dp[i-1][j]). The base case is that
// the first row and the first column will have only one unique path to each cell since the robot can only
// move right or down.
//
// Time Complexity: O(m * n)
// We fill up the entire dp array, which takes O(m * n) time.
//
// Space Complexity: O(m * n)
// The space complexity is O(m * n) due to the dp array.

import java.util.Arrays;

public class Leetcode_62_UniquePaths {

    public static int uniquePaths(int m, int n) {
        // Initialize a 2D dp array with dimensions m x n
        int[][] dp = new int[m][n];
        
        // Set base cases for the first row and first column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;  // Only one way to move in the first column (all downward moves)
        }
        
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;  // Only one way to move in the first row (all rightward moves)
        }
        
        // Fill the dp array using the relationship dp[i][j] = dp[i-1][j] + dp[i][j-1]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        // The bottom-right corner of the grid will contain the result
        return dp[m-1][n-1];
    }
    
    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println("Unique paths for a " + m + "x" + n + " grid: " + uniquePaths(m, n));
        
        m = 3; n = 2;
        System.out.println("Unique paths for a " + m + "x" + n + " grid: " + uniquePaths(m, n));
        
        m = 7; n = 3;
        System.out.println("Unique paths for a " + m + "x" + n + " grid: " + uniquePaths(m, n));
        
        m = 3; n = 3;
        System.out.println("Unique paths for a " + m + "x" + n + " grid: " + uniquePaths(m, n));
    }
}

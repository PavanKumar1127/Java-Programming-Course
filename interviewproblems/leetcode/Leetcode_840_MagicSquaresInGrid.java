package leetcode;

import java.util.Arrays;

// 840. Magic Squares In Grid
// https://leetcode.com/problems/magic-squares-in-grid/description/

// A magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum, called the magic constant.
// Given an m x n grid of integers, return the number of 3 x 3 magic square subgrids that exist in the grid.

// Example 1:
//
// Input: grid = [
// [4,3,8,4],
// [9,5,1,9],
// [2,7,6,2]
// ]
// Output: 1
// Explanation: The grid contains only one 3 x 3 magic square:
// 4 3 8
// 9 5 1
// 2 7 6
//
// Example 2:
//
// Input: grid = [
// [8]
// ]
// Output: 0

// Constraints:
//
// - m == grid.length
// - n == grid[i].length
// - 1 <= m, n <= 10
// - 0 <= grid[i][j] <= 15

// Approach:
// To determine if a 3x3 subgrid is a magic square, we need to verify the following:
// 1. All the numbers from 1 to 9 are present.
// 2. The sums of all rows, columns, and both diagonals are equal to 15 (which is the magic constant for a 3x3 magic square).
// We will iterate through the grid and check every possible 3x3 subgrid. For each subgrid, we validate whether it's a magic square.

// Time Complexity: O((m-2) * (n-2) * 1) = O(m * n)
// We iterate over all possible 3x3 subgrids in the grid.
// Space Complexity: O(1)
// We only use constant extra space to check each subgrid.
public class Leetcode_840_MagicSquaresInGrid {
    
    public static int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (isMagicSquare(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    // Helper method to check if a 3x3 grid is a magic square
    private static boolean isMagicSquare(int[][] grid, int row, int col) {
        // Check if the center of the 3x3 grid is 5 (as it's necessary for a valid magic square)
        if (grid[row + 1][col + 1] != 5) {
            return false;
        }

        // Check if all numbers from 1 to 9 are present and each row, column, and diagonal sum to 15
        boolean[] seen = new boolean[10]; // to track the presence of numbers 1 to 9

        for (int i = 0; i < 3; i++) {
            int rowSum = 0, colSum = 0;
            for (int j = 0; j < 3; j++) {
                int r = grid[row + i][col + j];
                int c = grid[row + j][col + i];
                if (r < 1 || r > 9 || c < 1 || c > 9 || seen[r] || seen[c]) {
                    return false; // invalid number or duplicate
                }
                seen[r] = true;
                rowSum += r;
                colSum += c;
            }
            if (rowSum != 15 || colSum != 15) {
                return false; // invalid row or column sum
            }
        }

        // Check the diagonals
        int diagonalSum1 = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
        int diagonalSum2 = grid[row + 2][col] + grid[row + 1][col + 1] + grid[row][col + 2];
        return diagonalSum1 == 15 && diagonalSum2 == 15;
    }

    public static void main(String[] args) {
        int[][] grid1 = {
            {4, 3, 8, 4},
            {9, 5, 1, 9},
            {2, 7, 6, 2}
        };
        System.out.println("Number of Magic Squares in Grid1: " + numMagicSquaresInside(grid1)); // Output: 1

        int[][] grid2 = {
            {8}
        };
        System.out.println("Number of Magic Squares in Grid2: " + numMagicSquaresInside(grid2)); // Output: 0
    }
}

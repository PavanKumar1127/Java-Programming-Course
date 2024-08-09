package strivers.DSA.arrays;

import java.util.Arrays;

// 73. Set Matrix Zeroes
// https://leetcode.com/problems/set-matrix-zeroes/
//
// Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's.
// You must do it in place.
//
// Example 1:
// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]
//
// Example 2:
// Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
//
// Constraints:
// - m == matrix.length
// - n == matrix[0].length
// - 1 <= m, n <= 200
// - -2^31 <= matrix[i][j] <= 2^31 - 1
//
// Approach:
// We use the first row and first column of the matrix to mark whether a particular row or column should be set to zero.
// First, we determine whether the first row or first column should be zeroed out, then we iterate through the matrix 
// and mark the rows and columns that need to be zeroed using the first row and column. Finally, we zero out the marked rows and columns.
//
// Time Complexity: O(m * n)
// The algorithm iterates over the matrix twice, once to mark the rows and columns, and once to set the zeroes.
//
// Space Complexity: O(1)
// The algorithm uses constant extra space by leveraging the matrix itself for marking.

public class Leetcode_73_SetMatrixZeroes {
    
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Determine if the first row and first column should be zeroed
        boolean firstRowZero = false, firstColZero = false;
        
        // Check if the first row has any zeroes
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }
        
        // Check if the first column has any zeroes
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        
        // Use the first row and column to mark zeroes for the rest of the matrix
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // Mark the row
                    matrix[0][j] = 0; // Mark the column
                }
            }
        }
        
        // Zero out the cells based on marks in the first row and column
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // Zero out the first row if necessary
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        
        // Zero out the first column if necessary
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix1 = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        System.out.println("Original Matrix:");
        for (int[] row : matrix1) {
            System.out.println(Arrays.toString(row));
        }
        
        setZeroes(matrix1);
        
        System.out.println("Matrix after setZeroes:");
        for (int[] row : matrix1) {
            System.out.println(Arrays.toString(row));
        }
        
        int[][] matrix2 = {
            {0, 1, 2, 0},
            {3, 4, 5, 2},
            {1, 3, 1, 5}
        };
        System.out.println("\nOriginal Matrix:");
        for (int[] row : matrix2) {
            System.out.println(Arrays.toString(row));
        }
        
        setZeroes(matrix2);
        
        System.out.println("Matrix after setZeroes:");
        for (int[] row : matrix2) {
            System.out.println(Arrays.toString(row));
        }
    }
}

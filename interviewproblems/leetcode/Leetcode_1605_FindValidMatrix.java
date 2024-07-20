package leetcode;

import java.util.Arrays;

// Find Valid Matrix Given Row and Column Sums
// https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/
public class Leetcode_1605_FindValidMatrix {

    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] matrix = new int[m][n];
        
        // Iterate through each cell of the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Determine the value to place in the matrix cell
                int value = Math.min(rowSum[i], colSum[j]);
                matrix[i][j] = value;
                
                // Update rowSum and colSum
                rowSum[i] -= value;
                colSum[j] -= value;
            }
        }
        
        return matrix;
    }
    
    public static int[][] restoreMatrix1(int[] r, int[] c) {
        int m = r.length;
        int n = c.length;
        int[][] a = new int[m][n];
        int i = m-1;
        int j = n-1;
        while(i >= 0 && j >= 0){
            if(r[i] <= c[j]){
                a[i][j] = r[i];
                c[j] -= r[i];
                i--;
            }
            else {
                a[i][j] = c[j];
                r[i] -= c[j];
                j--;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] rowSum = {3, 8};
        int[] colSum = {4, 7};
        int[][] matrix = restoreMatrix1(rowSum, colSum);
        System.out.println("Constructed Matrix: " + Arrays.deepToString(matrix));
    }
}

// Given two integer arrays rowSum and colSum, construct an m x n matrix such that:
// - The sum of elements in each row matches rowSum[i]
// - The sum of elements in each column matches colSum[j]

// Approach:
// We use two pointers to fill the matrix: one for rows and one for columns. For each cell, we place the minimum of the
// remaining row sum and column sum. This ensures that the sums are maintained and the matrix is constructed correctly.
// After placing a value in a cell, update the rowSum and colSum to reflect the remaining sums.

// Time Complexity: O(m * n)
// The algorithm iterates through each cell of the matrix exactly once, making it O(m * n) in time complexity.
// Space Complexity: O(m * n)
// The algorithm uses space for storing the matrix.

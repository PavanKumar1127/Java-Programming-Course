package strivers.DSA.arrays;

import java.util.Arrays;

// Rotate a 2D matrix 90 degrees (Clockwise)
// https://leetcode.com/problems/rotate-image/description/
public class Leetcode_48_RotateImage {
    
    public static void rotate(int[][] matrix) {
        // Step 1: Transpose the matrix (swap rows with columns)
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // Step 2: Reverse each row to get the final rotated matrix
        for (int i = 0; i < n; i++) {
            reverseRow(matrix[i]);
        }
    }

    // Helper method to reverse a single row
    private static void reverseRow(int[] row) {
        int start = 0, end = row.length - 1;
        while (start < end) {
            int temp = row[start];
            row[start] = row[end];
            row[end] = temp;
            start++;
            end--;
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Original Matrix: ");
        printMatrix(matrix);
        
        rotate(matrix);
        
        System.out.println("Rotated Matrix: ");
        printMatrix(matrix);
    }

    // Helper method to print the 2D matrix
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}

// Given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
//
// Example 1:
//
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[7,4,1],[8,5,2],[9,6,3]]
//
// Example 2:
//
// Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
// Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
//
// Example 3:
//
// Input: matrix = [[1]]
// Output: [[1]]
//
// Example 4:
//
// Input: matrix = [[1,2],[3,4]]
// Output: [[3,1],[4,2]]
//
// Constraints:
//
// - n == matrix.length == matrix[i].length
// - 1 <= n <= 20
// - -1000 <= matrix[i][j] <= 1000
//

// Approach:
// The optimal approach to rotate the matrix involves two steps:
// 1. **Transpose the Matrix**: This step involves swapping elements across the diagonal, effectively turning rows into columns and vice versa.
// 2. **Reverse Each Row**: After transposing, each row of the matrix is reversed to complete the 90-degree clockwise rotation.
//
// Algorithm:
// - First, we iterate through the matrix and swap elements at positions (i, j) and (j, i) to transpose the matrix.
// - Then, we iterate through each row of the transposed matrix and reverse it to achieve the final rotated matrix.
//
// Time Complexity: O(n^2)
// The algorithm requires transposing the matrix and then reversing each row. Both operations involve iterating through the entire matrix, making the time complexity O(n^2).
//
// Space Complexity: O(1)
// The rotation is performed in-place, meaning no additional space is required beyond the input matrix.

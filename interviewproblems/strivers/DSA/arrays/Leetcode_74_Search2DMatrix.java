package strivers.DSA.arrays;

import java.util.Arrays;

// 74. Search a 2D Matrix
// https://leetcode.com/problems/search-a-2d-matrix/description/
public class Leetcode_74_Search2DMatrix {
    
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int m = matrix.length;    // Number of rows
        int n = matrix[0].length; // Number of columns
        
        // Perform binary search on the matrix as if it were a flattened array
        int left = 0, right = m * n - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / n][mid % n]; // Convert 1D index to 2D row and column
            
            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false; // Target is not found
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target = 3;
        System.out.println("Target found: " + searchMatrix(matrix, target)); // Output: true
        
        target = 13;
        System.out.println("Target found: " + searchMatrix(matrix, target)); // Output: false
    }
}

// Given an m x n matrix of integers, sorted in ascending order both row-wise and column-wise, and a target integer,
// write a function to search for the target in the matrix. Return true if the target exists in the matrix, otherwise return false.
//
// This matrix has the properties:
// - Integers in each row are sorted from left to right.
// - The first integer of each row is greater than the last integer of the previous row.
//
// Example 1:
//
// Input: matrix = [
//   [1, 3, 5, 7],
//   [10, 11, 16, 20],
//   [23, 30, 34, 60]
// ], target = 3
// Output: true
//
// Example 2:
//
// Input: matrix = [
//   [1, 3, 5, 7],
//   [10, 11, 16, 20],
//   [23, 30, 34, 60]
// ], target = 13
// Output: false
//
// Constraints:
//
// - m == matrix.length
// - n == matrix[0].length
// - 1 <= m, n <= 100
// - -10^4 <= matrix[i][j], target <= 10^4

// Approach:
// Treat the matrix as a flattened sorted array and apply binary search. By converting the 1D index back to a 2D index,
// we can access elements as if the matrix were flattened. This approach works efficiently since both rows and columns are sorted.
//
// Time Complexity: O(log(m * n))
// We perform binary search on the matrix, where m is the number of rows and n is the number of columns. Since the matrix
// can be considered as a flattened sorted array, the time complexity is O(log(m * n)).
//
// Space Complexity: O(1)
// The algorithm uses constant extra space, as it only uses a few variables to perform the search.

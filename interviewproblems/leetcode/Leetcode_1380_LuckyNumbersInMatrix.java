package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Lucky Numbers in a Matrix
// https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/
public class Leetcode_1380_LuckyNumbersInMatrix {
    public static List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        // Step 1: Find minimum values in each row
        int[] minRow = new int[m];
        for (int i = 0; i < m; i++) {
            minRow[i] = matrix[i][0];
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] < minRow[i]) {
                    minRow[i] = matrix[i][j];
                }
            }
        }

        // Step 2: Find maximum values in each column
        int[] maxCol = new int[n];
        for (int j = 0; j < n; j++) {
            maxCol[j] = matrix[0][j];
            for (int i = 1; i < m; i++) {
                if (matrix[i][j] > maxCol[j]) {
                    maxCol[j] = matrix[i][j];
                }
            }
        }

        // Step 3: Find common elements
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == minRow[i] && matrix[i][j] == maxCol[j]) {
                    luckyNumbers.add(matrix[i][j]);
                }
            }
        }

        return luckyNumbers;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
            {3, 7, 8},
            {9, 11, 13},
            {15, 16, 17}
        };
        int[][] matrix2 = {
            {1, 10, 4, 2},
            {9, 3, 8, 7},
            {15, 16, 17, 12}
        };

        System.out.println("Matrix 1:");
        for (int[] row : matrix1) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Lucky Numbers: " + luckyNumbers(matrix1)); // Output: [15]

        System.out.println("\nMatrix 2:");
        for (int[] row : matrix2) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Lucky Numbers: " + luckyNumbers(matrix2)); // Output: [12]
    }
}

// Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
//
// A lucky number is an element of the matrix that is the minimum element in its row and maximum in its column.
//
// Example 1:
//
// Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
// Output: [15]
// Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.
//
// Example 2:
//
// Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
// Output: [12]
// Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
//
// Constraints:
//
// 1 <= matrix.length, matrix[i].length <= 50
// 1 <= matrix[i][j] <= 10^5
// All elements of the matrix are distinct.

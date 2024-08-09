package strivers.DSA.arrays;

import java.util.ArrayList;
import java.util.List;

// 118. Pascal's Triangle
// https://leetcode.com/problems/pascals-triangle/
//
// Given an integer numRows, return the first numRows of Pascal's triangle.
//
// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
//
// Example 1:
// Input: numRows = 5
// Output: [
//     [1],
//     [1,1],
//     [1,2,1],
//     [1,3,3,1],
//     [1,4,6,4,1]
// ]
//
// Example 2:
// Input: numRows = 1
// Output: [
//     [1]
// ]
//
// Constraints:
// - 1 <= numRows <= 30
//
// Approach:
// Pascal's Triangle is a triangular array of the binomial coefficients. The first and last values in each row are 1.
// Each inner value is the sum of the two values directly above it. We start by creating the first row and iteratively
// build each subsequent row using the previous row.
//
// Algorithm:
// 1. Initialize an empty list to store the triangle.
// 2. For each row from 0 to numRows-1:
//    a. Create a new list to represent the current row.
//    b. The first and last elements in the row are always 1.
//    c. For the middle elements, sum the two elements above the current element from the previous row.
//    d. Add the current row to the triangle list.
// 3. Return the triangle.
//
// Time Complexity: O(numRows^2)
// We generate each element in the triangle by iterating over the rows and columns, leading to O(numRows^2) complexity.
//
// Space Complexity: O(numRows^2)
// We store the entire triangle in memory, which requires O(numRows^2) space.

public class Leetcode_118_PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // Base case: first row is always [1]
        if (numRows == 0) {
            return triangle;
        }

        // Add the first row
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        // Generate each row from the second to the numRows-th row
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(i - 1);

            // The first element is always 1
            row.add(1);

            // Each middle element is the sum of the two elements above it
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // The last element is always 1
            row.add(1);

            // Add the current row to the triangle
            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> triangle = generate(numRows);
        System.out.println("Pascal's Triangle with " + numRows + " rows:");
        for (List<Integer> row : triangle) {
            System.out.println(row);
        }
    }
}

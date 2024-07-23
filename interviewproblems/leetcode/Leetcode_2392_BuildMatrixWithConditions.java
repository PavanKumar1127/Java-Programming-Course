package leetcode;

import java.util.*;

// Build a Matrix With Conditions
// https://leetcode.com/problems/build-a-matrix-with-conditions/
public class Leetcode_2392_BuildMatrixWithConditions {
    
    public static int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        // Get topological order for rows and columns
        List<Integer> rowOrder = topologicalSort(k, rowConditions);
        List<Integer> colOrder = topologicalSort(k, colConditions);
        
        // If any order is null, it means there's a cycle and we can't build the matrix
        if (rowOrder == null || colOrder == null) return new int[0][0];
        
        // Create positions maps for quick lookup
        int[] rowPos = new int[k + 1];
        int[] colPos = new int[k + 1];
        for (int i = 0; i < k; i++) {
            rowPos[rowOrder.get(i)] = i;
            colPos[colOrder.get(i)] = i;
        }
        
        // Create the result matrix
        int[][] matrix = new int[k][k];
        for (int i = 1; i <= k; i++) {
            matrix[rowPos[i]][colPos[i]] = i;
        }
        
        return matrix;
    }
    
    // Helper method to perform topological sorting
    private static List<Integer> topologicalSort(int k, int[][] conditions) {
        // Graph representation and in-degree count
        List<Integer>[] graph = new ArrayList[k + 1];
        int[] inDegree = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // Build the graph
        for (int[] condition : conditions) {
            graph[condition[0]].add(condition[1]);
            inDegree[condition[1]]++;
        }
        
        // Topological sorting using Kahn's algorithm
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }	
        }
        
        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);
            for (int neighbor : graph[node]) {
                if (--inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        // If order size is less than k, there was a cycle
        if (order.size() < k) return null;
        return order;
    }
    
    public static void main(String[] args) {
        int k = 3;
        int[][] rowConditions = {{1, 2}, {2, 3}};
        int[][] colConditions = {{2, 1}, {3, 2}};
        
        int[][] result = buildMatrix(k, rowConditions, colConditions);
        System.out.println("Result Matrix:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
        
        // Example 2
        k = 3;
        rowConditions = new int[][]{{1, 2}, {2, 3}};
        colConditions = new int[][]{{3, 1}};
        
        result = buildMatrix(k, rowConditions, colConditions);
        System.out.println("Result Matrix:");
        if (result.length == 0) {
            System.out.println("[]");
        } else {
            for (int[] row : result) {
                System.out.println(Arrays.toString(row));
            }
        }
    }
}

// Given dimensions `k`, row conditions `rowConditions`, and column conditions `colConditions`, we need to build a k x k matrix such that:
// 1. For each pair `[ri, rj]` in `rowConditions`, `ri` must appear before `rj` in its row.
// 2. For each pair `[ci, cj]` in `colConditions`, `ci` must appear before `cj` in its column.
// Return the matrix if it is possible to build such a matrix, otherwise, return an empty matrix.

// Approach:
// 1. Perform topological sorting on `rowConditions` and `colConditions` to determine the correct order for rows and columns.
// 2. If there is a cycle detected during the sorting, return an empty matrix since it is not possible to satisfy the conditions.
// 3. Using the sorted order, place the elements in the k x k matrix accordingly.

// Time Complexity: O(k + E) where E is the number of edges in rowConditions and colConditions.
// Space Complexity: O(k + E) for storing the graph and in-degree counts.

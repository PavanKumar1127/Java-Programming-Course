package leetcode;

// Regions Cut By Slashes
// https://leetcode.com/problems/regions-cut-by-slashes/
/*
   Given an n x n grid composed of '/' and '\' characters, each character divides a square into two right triangles.
   The goal is to return the number of regions in the grid that are completely surrounded by slashes.

   Example 1:
   Input: grid = [" /", "/ "]
   Output: 2

   Example 2:
   Input: grid = [" /", "  "]
   Output: 1

   Example 3:
   Input: grid = ["\\/", "/\\"]
   Output: 4

   Constraints:
   - n == grid.length == grid[i].length
   - 1 <= n <= 30
   - grid[i][j] is either '/' or '\'
*/

public class Leetcode_959_RegionsCutBySlashes {

    public static int regionsBySlashes(String[] grid) {
        int n = grid.length;
        // We treat each cell as 4 sub-cells (0: top-left, 1: top-right, 2: bottom-left, 3: bottom-right)
        int size = n * 3; 
        int[][] graph = new int[size][size];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '/') {
                    graph[i * 3][j * 3 + 2] = 1;
                    graph[i * 3 + 1][j * 3 + 1] = 1;
                    graph[i * 3 + 2][j * 3] = 1;
                } else if (c == '\\') {
                    graph[i * 3][j * 3] = 1;
                    graph[i * 3 + 1][j * 3 + 1] = 1;
                    graph[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }
        
        int regions = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (graph[i][j] == 0) {
                    dfs(graph, i, j);
                    regions++;
                }
            }
        }
        
        return regions;
    }

    private static void dfs(int[][] graph, int i, int j) {
        int n = graph.length;
        if (i < 0 || i >= n || j < 0 || j >= n || graph[i][j] == 1) {
            return;
        }
        graph[i][j] = 1;
        dfs(graph, i - 1, j); // up
        dfs(graph, i + 1, j); // down
        dfs(graph, i, j - 1); // left
        dfs(graph, i, j + 1); // right
    }

    public static void main(String[] args) {
        String[] grid1 = {" /", "/ "};
        System.out.println("Number of regions in grid1: " + regionsBySlashes(grid1)); // Output: 2

        String[] grid2 = {" /", "  "};
        System.out.println("Number of regions in grid2: " + regionsBySlashes(grid2)); // Output: 1

        String[] grid3 = {"\\/", "/\\"};
        System.out.println("Number of regions in grid3: " + regionsBySlashes(grid3)); // Output: 4
    }
}

/*
Approach:
- We use a Depth-First Search (DFS) based approach.
- Each cell in the grid is treated as 3x3 sub-cells, allowing us to handle diagonal slashes by marking which portions of the cell are blocked.
- '/' divides the top-left and bottom-right sub-cells, while '\\' divides the top-right and bottom-left sub-cells.
- We iterate through the entire grid, and for each cell, if it hasn't been visited (graph[i][j] == 0), we perform a DFS to mark all connected components.
- Each DFS call corresponds to discovering a new region, so we increment the region count.

Time Complexity:
- The grid is expanded into a 3n x 3n matrix, so the time complexity is O((3n)^2) = O(9n^2) = O(n^2).
- Each cell is visited once, so the DFS runs in O(n^2) time, where n is the length of the grid.

Space Complexity:
- The space complexity is also O(n^2) due to the use of the graph array.
*/

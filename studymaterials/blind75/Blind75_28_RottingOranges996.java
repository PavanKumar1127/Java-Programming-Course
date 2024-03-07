package blind75;
import java.util.LinkedList;
import java.util.Queue;

public class Blind75_28_RottingOranges996 {
    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshOranges = 0;
        int minutes = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        
        // Count fresh oranges and enqueue coordinates of rotten oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshOranges++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow, newCol});
                        freshOranges--;
                    }
                }
            }
            
            minutes++;
        }
        
        return freshOranges == 0 ? minutes : -1;
    }
    
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println("Minimum number of minutes: " + orangesRotting(grid));
    }
}


//Initialization:
//
//Create a queue to store the coordinates of rotten oranges.
//Count the number of fresh oranges.
//Initialize a variable to count the number of minutes passed.

//BFS Traversal:
//
//Enqueue the coordinates of all rotten oranges onto the queue.
//While the queue is not empty, do the following:
//Increment the number of minutes passed.
//For each orange in the current level (all oranges rotten in the previous minute), do the following:
//Check adjacent cells (up, down, left, right):
//If an adjacent cell contains a fresh orange, change it to rotten and enqueue its coordinates.
//Decrement the count of fresh oranges.
//If there are still fresh oranges remaining, return -1 (impossible to rot all oranges).

//Result:
//
//Return the number of minutes passed.
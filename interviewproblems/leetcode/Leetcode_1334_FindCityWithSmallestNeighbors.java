package leetcode;

import java.util.Arrays;

// Problem: Find the City With the Smallest Number of Neighbors at a Threshold Distance
// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/
public class Leetcode_1334_FindCityWithSmallestNeighbors {
    
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Initialize the distance matrix with maximum values
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE / 2);
            dist[i][i] = 0; // Distance to itself is 0
        }
        
        // Populate the distance matrix with the given edges
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], weight = edge[2];
            dist[u][v] = weight;
            dist[v][u] = weight;
        }
        
        // Apply Floyd-Warshall algorithm to find the shortest paths between all pairs of cities
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        // Find the city with the smallest number of neighbors within the distance threshold
        int minNeighbors = Integer.MAX_VALUE;
        int city = -1;
        for (int i = 0; i < n; i++) {
            int neighbors = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold && i != j) {
                    neighbors++;
                }
            }
            if (neighbors <= minNeighbors) {
                minNeighbors = neighbors;
                city = i;
            }
        }
        
        return city;
    }
    
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {
            {0, 1, 3},
            {1, 2, 1},
            {1, 3, 4},
            {2, 3, 1}
        };
        int distanceThreshold = 4;
        System.out.println("City with the smallest number of neighbors: " + findTheCity(n, edges, distanceThreshold)); // Output: 3
    }
}

// Given a graph of n cities and the edges between them with distances, you are to find the city with the smallest 
// number of neighbors at a distance threshold. The output should be the city with the greatest number if there 
// are multiple cities with the same number of neighbors.
//
// Example 1:
// Input: n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
// Output: 3
//
// Example 2:
// Input: n = 5, edges = [[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]], distanceThreshold = 2
// Output: 0
//
// Constraints:
// - 2 <= n <= 100
// - 1 <= edges.length <= n * (n - 1) / 2
// - edges[i].length == 3
// - 0 <= fromi < toi < n
// - 1 <= weighti, distanceThreshold <= 10^4
// - All pairs (fromi, toi) are distinct.
//
// Approach:
// We use the Floyd-Warshall algorithm to compute the shortest paths between all pairs of cities. After building the distance
// matrix, we count the number of neighbors within the distance threshold for each city. The city with the fewest neighbors
// (or the greatest index in case of a tie) is selected.
//
// Time Complexity: O(n^3)
// The Floyd-Warshall algorithm runs in O(n^3) time, where n is the number of cities. This is due to the three nested loops
// needed to calculate the shortest paths.
//
// Space Complexity: O(n^2)
// The distance matrix takes up O(n^2) space, where n is the number of cities.

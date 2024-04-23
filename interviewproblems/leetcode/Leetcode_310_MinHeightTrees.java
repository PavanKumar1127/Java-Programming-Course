package leetcode;

import java.util.*;

class Leetcode_310_MinHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(0); // Special case: only one node
            return result;
        }
        
        // Build adjacency list
        List<Set<Integer>> adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new HashSet<>());
        }
        int[] degree = new int[n];
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }
        
        // Initialize queue with leaf nodes
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }
        
        // BFS to remove leaf nodes
        while (n > 2) {
            int size = queue.size();
            n -= size;
            for (int i = 0; i < size; i++) {
                int u = queue.poll();
                for (int v : adjList.get(u)) {
                    degree[v]--;
                    if (degree[v] == 1) {
                        queue.offer(v);
                    }
                }
            }
        }
        
        // Remaining nodes in the queue are MHT roots
        result.addAll(queue);
        return result;
    }
    

    public static void main(String[] args) {
    	Leetcode_310_MinHeightTrees solution = new Leetcode_310_MinHeightTrees();
        int n = 4;
        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
        List<Integer> result = solution.findMinHeightTrees(n, edges);
        System.out.println("Minimum Height Trees: " + result); // Output: [1]
    }
}

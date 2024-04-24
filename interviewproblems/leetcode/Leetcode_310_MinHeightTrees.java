package leetcode;

import java.util.*;

class Leetcode_310_MinHeightTrees {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> result = new ArrayList<>();
		if (n == 1) {
			result.add(0); // Special case: only one node
			return result;
		}

		// Construct an adjacency list representation of the undirected graph using the
		// given edges. // Build adjacency list
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

		// Identify the leaf nodes of the graph, i.e., the nodes with only one neighbor.
		// Add these leaf nodes to a queue.
		// Initialize queue with leaf nodes
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (degree[i] == 1) {
				queue.offer(i);
			}
		}

//Step3	// BFS to remove leaf nodes. Remove the leaf nodes from the graph and update the
		// degrees of their neighbors. Repeat this process until only the centroid(s)
		// remain(s) in the graph.
		while (n > 2) {
			int size = queue.size();
			n -= size;
			for (int i = 0; i < size; i++) {
				int u = queue.poll();
				for (int v : adjList.get(u)) {
					degree[v]--;
					if (degree[v] == 1) {
//Step4					// After removing the leaf nodes, the remaining nodes are either centroids (if
						// the graph is a tree) or part of the centroids (if the graph has multiple
						// components). Add these centroids or centroid candidates to the queue.
						queue.offer(v);
					}
				}
			}
			// Perform steps 3 and 4 iteratively until only one or two centroids remain in
			// the graph.
		}

		// Remaining nodes in the queue are MHT roots
		result.addAll(queue);
		return result;
	}

	public static void main(String[] args) {
		Leetcode_310_MinHeightTrees solution = new Leetcode_310_MinHeightTrees();

		int n1 = 6;
		int[][] edges1 = { { 0, 3 }, { 1, 3 }, { 2, 3 }, { 4, 3 }, { 5, 4 } };
		List<Integer> result1 = solution.findMinHeightTrees(n1, edges1);
		System.out.println("Minimum Height Trees: " + result1); // Output: [3, 4]

		int n = 4;
		int[][] edges = { { 1, 0 }, { 1, 2 }, { 1, 3 } };
		List<Integer> result = solution.findMinHeightTrees(n, edges);
		System.out.println("Minimum Height Trees: " + result); // Output: [1]
	}
}

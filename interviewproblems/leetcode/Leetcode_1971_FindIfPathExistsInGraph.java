package leetcode;

import java.util.*;

public class Leetcode_1971_FindIfPathExistsInGraph {

	public boolean validPath(int n, int[][] edges, int start, int target) {

		// We create a list of lists called graph to represent the adjacency list of the
		// graph.
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		// Populating Adjacency List:
		for (int[] edge : edges) {
			int u = edge[0], v = edge[1];
			// For each edge (u, v), we add v to the adjacency list of u and vice versa, as
			// the graph is undirected.
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		boolean[] visited = new boolean[n];
		//Depth-First Search (DFS):
		return dfs(graph, visited, start, target);
	}

	private boolean dfs(List<List<Integer>> graph, boolean[] visited, int current, int target) {
		if (current == target) {
			return true;
		}
		visited[current] = true;
		for (int neighbor : graph.get(current)) {
			if (!visited[neighbor] && dfs(graph, visited, neighbor, target)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Leetcode_1971_FindIfPathExistsInGraph solution = new Leetcode_1971_FindIfPathExistsInGraph();

//		// Example 1
//		int n1 = 5;
//		int[][] edges1 = { { 0, 1 }, { 0, 2 }, { 3, 5 }, { 5, 4 }, { 4, 3 } };
//		int start1 = 0, target1 = 5;
//		System.out.println("Example 1: " + solution.validPath(n1, edges1, start1, target1)); // Output: true

		// Example 2
		int n2 = 3;
		int[][] edges2 = { { 0, 1 }, { 1, 2 }, { 2, 0 } };
		int start2 = 0, target2 = 2;
		System.out.println("Example 2: " + solution.validPath(n2, edges2, start2, target2)); // Output: false
	}
}

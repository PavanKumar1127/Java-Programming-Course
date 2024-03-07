package amazon;
// A Java Program to check whether a graph is tree or not
import java.util.*;

// Class for an undirected graph
class GraphValidTree {
	public static int V; // No. of vertices
	public static int E; // No. of edges
	public static ArrayList<ArrayList<Integer> >
		adj; // Pointer to an array for adjacency lists

	// Constructor
	public GraphValidTree(int V)
	{
		E = 0;
		this.V = V;
		adj = new ArrayList<ArrayList<Integer> >(V);
		for (int i = 0; i < V; i++)
			adj.add(new ArrayList<Integer>());
	}

	// A recursive dfs function that uses visited[] and
	// parent to traverse the graph and mark visited[v] to
	// true for visited nodes
	static void dfsTraversal(int v, boolean[] visited,
							int parent)
	{
		// Mark the current node as visited
		visited[v] = true;

		// Recur for all the vertices adjacent to this
		// vertex
		for (int i : adj.get(v)) {
			// If an adjacent is not visited, then recur for
			// that adjacent
			if (!visited[i]) {
				dfsTraversal(i, visited, v);
			}
		}
	}

	// to add an edge to graph
	public static void addEdge(int v, int w)
	{
		E++; // increase the number of edges
		adj.get(w).add(v); // Add w to v list.
		adj.get(v).add(w); // Add v to w list.
	}

	// Returns true if the graph is connected, else false.
	public static boolean isConnected()
	{
		// Mark all the vertices as not visited and not part
		// of recursion stack
		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++)
			visited[i] = false;

		// Performing DFS traversal of the graph and marking
		// reachable vertices from 0 to true
		dfsTraversal(0, visited, -1);

		// If we find a vertex which is not reachable from 0
		// (not marked by dfsTraversal(), then we return
		// false since graph is not connected
		for (int u = 0; u < V; u++)
			if (!visited[u])
				return false;

		// since all nodes were reachable so we returned
		// true and hence graph is connected
		return true;
	}

	public static boolean isTree()
	{
		// as we proved earlier if a graph is connected and
		// has V - 1 edges then it is a tree i.e. E = V - 1
		return isConnected() && E == V - 1;
	}
}

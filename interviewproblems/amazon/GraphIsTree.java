package amazon;
public class GraphIsTree {

    private int[][] adjacencyMatrix;
    private int numVertices;

    public GraphIsTree(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.numVertices = adjacencyMatrix.length;
    }

    // Depth-first search to check for connectivity and cycles
    private boolean dfs(int vertex, boolean[] visited, int parent) {
        visited[vertex] = true;

        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[vertex][i] == 1) {
                if (!visited[i]) {
                    if (dfs(i, visited, vertex)) {
                        return true; // Cycle detected
                    }
                } else if (i != parent) {
                    return true; // Back edge detected
                }
            }
        }
        return false;
    }

    // Check if the graph is a tree
    public boolean isTree() {
        boolean[] visited = new boolean[numVertices];

        // Check for connectivity
        if (dfs(0, visited, -1)) {
            return false; // Graph is not connected
        }

        // Check for cycles
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                return false; // Graph contains cycles
            }
        }

        // Check for the number of edges
        int numEdges = 0;
        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    numEdges++;
                }
            }
        }

        return numEdges == numVertices - 1; // Graph has n-1 edges
    }

    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
            {0, 1, 0, 1, 0},
            {1, 0, 1, 1, 0},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 0, 1},
            {0, 0, 1, 1, 0}
        };

        GraphIsTree graph = new GraphIsTree(adjacencyMatrix);
        if (graph.isTree()) {
            System.out.println("The graph is a tree.");
        } else {
            System.out.println("The graph is not a tree.");
        }
    }
}

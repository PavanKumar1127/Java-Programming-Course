package amazon;

public class GraphValidTreeMain {
	// Driver program to test above functions
	public static void main(String[] args)
	{
		GraphValidTree g1 = new GraphValidTree(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		if (g1.isTree())
			System.out.println("Graph is Tree");
		else
			System.out.println("Graph is not Tree");

		GraphValidTree g2 = new GraphValidTree(5);
		g2.addEdge(1, 0);
		g2.addEdge(0, 2);
		g2.addEdge(2, 1);
		g2.addEdge(0, 3);
		g2.addEdge(3, 4);
		if (g2.isTree())
			System.out.println("Graph is Tree");
		else
			System.out.println("Graph is not Tree");
	}
}

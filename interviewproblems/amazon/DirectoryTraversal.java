package amazon;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Question :Make a data structure and implement an algorithm to print all the files in a
 * directory. (the root directory can have sub-directories too.)
 */
class TreeNode {
	String name;
	TreeNode[] children;

	public TreeNode(String name) {
		this.name = name;
	}
}
//Approach

//Define the Node Structure: Each node in the tree will have properties to store the name of the file or directory, as well as references to its children (subdirectories or files).
//
//Build the Directory Tree: Traverse the directory structure recursively and construct the tree accordingly. Each directory will be represented as a node, and files within directories will be represented as leaf nodes.
//
//Traverse the Tree: Implement a traversal algorithm to print all files. We can use either breadth-first search (BFS) or depth-first search (DFS) to traverse the tree. BFS ensures that files are printed in a level-wise manner, while DFS explores deeper into the directory structure.
//
//Handle File Printing: When traversing the tree, print the name of each file encountered.
//
//Handle Subdirectories: For each directory encountered during traversal, recursively traverse its subtree to print files within subdirectories.

public class DirectoryTraversal {

	public static TreeNode buildDirectoryTree(String rootPath) {
		File rootDir = new File(rootPath);
		if (!rootDir.isDirectory()) {
			return null;
		}
		TreeNode root = new TreeNode(rootDir.getName());
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode currentNode = queue.poll();
			File currentDir = new File(rootPath + File.separator + currentNode.name);
			File[] files = currentDir.listFiles();
			if (files != null) {
				currentNode.children = new TreeNode[files.length];
				for (int i = 0; i < files.length; i++) {
					if (files[i].isDirectory()) {
						currentNode.children[i] = new TreeNode(files[i].getName());
						queue.add(currentNode.children[i]);
					}
				}
			}
		}
		return root;
	}

	public static void printFiles(TreeNode root) {
		if (root == null) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode currentNode = queue.poll();
			System.out.println(currentNode.name); // Print file or directory name
			if (currentNode.children != null) {
				for (TreeNode child : currentNode.children) {
					queue.add(child);
				}
			}
		}
	}

	public static void main(String[] args) {
		String rootPath = "/path/to/root/directory";
		TreeNode root = buildDirectoryTree(rootPath);
		printFiles(root);
	}
}

package javaCollectionsFramework.trees;

/**
 * A binary search tree (BST) is a hierarchical data structure where each node
 * has at most two children: left and right. In a BST, the value of nodes in the
 * left subtree is less than the node's value, and the value of nodes in the
 * right subtree is greater. This property enables efficient search, insertion,
 * and deletion operations. BSTs are commonly used in computer science for
 * implementing symbol tables, dictionary data structures, and database indexing
 * due to their efficient searching capabilities and ordered structure.
 * 
 * 
 * The time complexity of basic operations on a binary search tree (BST) depends
 * on the height of the tree and its structure. In a balanced BST, where the
 * tree is structured such that the height is logarithmic with respect to the
 * number of nodes, the time complexity for basic operations is as follows:
 * 
 * Search: O(log n) 
 * Insertion: O(log n) 
 * Deletion: O(log n) 
 * 
 * However, in the worst
 * case scenario where the tree is highly unbalanced (e.g., resembling a linked
 * list), the time complexity for search, insertion, and deletion can degrade to
 * O(n), where n is the number of nodes in the tree.
 * 
 * Therefore, maintaining balance in the tree structure is crucial for ensuring
 * optimal time complexity for BST operations.
 */

public class BinarySearchTree {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

	private TreeNode root;

	public BinarySearchTree() {
		this.root = null;
	}

	public void insert(int val) {
		this.root = insertRecursive(this.root, val);
	}

	private TreeNode insertRecursive(TreeNode node, int val) {
		if (node == null) {
			return new TreeNode(val);
		}

		if (val < node.val) {
			node.left = insertRecursive(node.left, val);
		} else if (val > node.val) {
			node.right = insertRecursive(node.right, val);
		}

		return node;
	}

	public boolean search(int val) {
		return searchRecursive(this.root, val);
	}

	private boolean searchRecursive(TreeNode node, int val) {
		if (node == null) {
			return false;
		}

		if (val == node.val) {
			return true;
		} else if (val < node.val) {
			return searchRecursive(node.left, val);
		} else {
			return searchRecursive(node.right, val);
		}
	}

	public void inorder() {
		inorderRecursive(this.root);
	}

	private void inorderRecursive(TreeNode node) {
		if (node != null) {
			inorderRecursive(node.left);
			System.out.print(node.val + " ");
			inorderRecursive(node.right);
		}
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();

		bst.insert(5);
		bst.insert(3);
		bst.insert(7);
		bst.insert(1);
		bst.insert(4);

		System.out.println("Inorder traversal:");
		bst.inorder(); // Output: 1 3 4 5 7

		System.out.println("\nSearch for 4: " + bst.search(4)); // Output: true
		System.out.println("Search for 6: " + bst.search(6)); // Output: false
	}
}

package javaCollectionsFramework.trees;

/**
 * 
 * An AVL tree is a self-balancing binary search tree where the heights of the
 * two child subtrees of any node differ by at most one. This balancing property
 * ensures that the height of the tree remains logarithmic, resulting in
 * efficient search, insertion, and deletion operations.
 */
class AVLNode {
	int data, height;
	AVLNode left, right;

	public AVLNode(int data) {
		this.data = data;
		this.height = 1;
	}
}

public class AVL {
	AVLNode root;

	// Get height of a node
	int height(AVLNode node) {
		if (node == null)
			return 0;
		return node.height;
	}

	// Get balance factor of a node
	int getBalance(AVLNode node) {
		if (node == null)
			return 0;
		return height(node.left) - height(node.right);
	}

	// Right rotate subtree rooted with y
	AVLNode rightRotate(AVLNode y) {
		AVLNode x = y.left;
		AVLNode T2 = x.right;

		// Perform rotation
		x.right = y;
		y.left = T2;

		// Update heights
		y.height = Math.max(height(y.left), height(y.right)) + 1;
		x.height = Math.max(height(x.left), height(x.right)) + 1;

		// Return new root
		return x;
	}

	// Left rotate subtree rooted with x
	AVLNode leftRotate(AVLNode x) {
		AVLNode y = x.right;
		AVLNode T2 = y.left;

		// Perform rotation
		y.left = x;
		x.right = T2;

		// Update heights
		x.height = Math.max(height(x.left), height(x.right)) + 1;
		y.height = Math.max(height(y.left), height(y.right)) + 1;

		// Return new root
		return y;
	}

	// Insert a node
	AVLNode insert(AVLNode node, int data) {
		if (node == null)
			return new AVLNode(data);

		if (data < node.data)
			node.left = insert(node.left, data);
		else if (data > node.data)
			node.right = insert(node.right, data);
		else // Duplicate keys not allowed
			return node;

		// Update height of current node
		node.height = 1 + Math.max(height(node.left), height(node.right));

		// Get balance factor to check if node is unbalanced
		int balance = getBalance(node);

		// Perform rotations if necessary
		// Left Left Case
		/**
		 * This case occurs when a new node is inserted into the left subtree of the
		 * left child of a node, causing the balance factor of the node to become
		 * greater than 1. It is resolved by performing a right rotation on the
		 * unbalanced node. The right rotation moves the left child of the unbalanced
		 * node to its position, making the left child the new root of the subtree.
		 */
		if (balance > 1 && data < node.left.data)
			return rightRotate(node);

		// Right Right Case
		/**
		 * This case occurs when a new node is inserted into the right subtree of the
		 * right child of a node, causing the balance factor of the node to become less
		 * than -1. It is resolved by performing a left rotation on the unbalanced node.
		 * The left rotation moves the right child of the unbalanced node to its
		 * position, making the right child the new root of the subtree.
		 */
		if (balance < -1 && data > node.right.data)
			return leftRotate(node);

		// Left Right Case
		/**
		 * This case occurs when a new node is inserted into the right subtree of the
		 * left child of a node, causing the balance factor of the node to become
		 * greater than 1. It is resolved by performing a left rotation on the left
		 * child followed by a right rotation on the unbalanced node. The left rotation
		 * balances the left child's subtree, and then the right rotation balances the
		 * unbalanced node.
		 */
		if (balance > 1 && data > node.left.data) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// Right Left Case
		/**
		 * This case occurs when a new node is inserted into the left subtree of the
		 * right child of a node, causing the balance factor of the node to become less
		 * than -1. It is resolved by performing a right rotation on the right child
		 * followed by a left rotation on the unbalanced node. The right rotation
		 * balances the right child's subtree, and then the left rotation balances the
		 * unbalanced node.
		 */
		if (balance < -1 && data < node.right.data) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		return node;
	}

	// Print inorder traversal of AVL tree
	void inorder(AVLNode node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
		}
	}

	public static void main(String[] args) {
		AVL tree = new AVL();
		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 20);
		tree.root = tree.insert(tree.root, 30);
		tree.root = tree.insert(tree.root, 40);
		tree.root = tree.insert(tree.root, 50);
		tree.root = tree.insert(tree.root, 25);

		// Print inorder traversal to verify tree
		System.out.println("Inorder traversal of the constructed AVL tree is:");
		tree.inorder(tree.root);
	}
}

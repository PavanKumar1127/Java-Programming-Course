package leetcode;

public class Leetcode_114_FlattenBinaryTreeToLinkedList {

	public void flatten(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return;
		}

		if (root.left != null) {
			flatten(root.left);

			// Store the right subtree
			TreeNode temp = root.right;

			// Move the left subtree to the right
			root.right = root.left;
			root.left = null;

			// Find the rightmost node of the flattened left subtree
			TreeNode rightMost = root.right;
			while (rightMost.right != null) {
				rightMost = rightMost.right;
			}

			// Attach the right subtree to the rightmost node of the flattened left subtree
			rightMost.right = temp;
		}

		// Flatten the right subtree
		flatten(root.right);
	}

	public static void main(String[] args) {
		// Example input: [1,2,5,3,4,null,6]
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(6);

		Leetcode_114_FlattenBinaryTreeToLinkedList solution = new Leetcode_114_FlattenBinaryTreeToLinkedList();
		solution.flatten(root);

		// Printing the flattened tree
		TreeNode current = root;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.right;
		}
	}
}

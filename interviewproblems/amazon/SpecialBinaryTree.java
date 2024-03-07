package amazon;

class TreeNode {
	int val;
	TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

/**
 * User Given an in-order traversal of a special binary tree having property
 * that the node is always greater than its left and right child. Construct the
 * tree and write code
 */
public class SpecialBinaryTree {

	static int index = 0;

	public static TreeNode constructTree(int[] inorder, int start, int end) {
		if (start > end) {
			return null;
		}

		int mid = start + (end - start) / 2;
		TreeNode node = new TreeNode(inorder[index++]);

		node.left = constructTree(inorder, start, mid - 1);
		node.right = constructTree(inorder, mid + 1, end);

		return node;
	}

	public static void inorderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}

		inorderTraversal(root.left);
		System.out.print(root.val + " ");
		inorderTraversal(root.right);
	}

	public static void main(String[] args) {
		int[] inorder = { 1, 2, 3, 4, 5, 6, 7 };

		TreeNode root = constructTree(inorder, 0, inorder.length - 1);

		System.out.println("Inorder traversal of constructed tree:");
		inorderTraversal(root);
	}
}

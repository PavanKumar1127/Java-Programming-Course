package leetcode;

public class Leetcode_104_MaximumDepthOfBinaryTree {

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int leftDepth = maxDepth(root.left);
			int rightDepth = maxDepth(root.right);
			return Math.max(leftDepth, rightDepth) + 1;
		}
	}

	public static void main(String[] args) {
		// Example input: [3,9,20,null,null,15,7]
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		Leetcode_104_MaximumDepthOfBinaryTree solution = new Leetcode_104_MaximumDepthOfBinaryTree();
		int maxDepth = solution.maxDepth(root);
		System.out.println("Maximum depth of the binary tree: " + maxDepth);
	}
}

package leetcode;

public class Leetcode_236_LowestCommonAncestorOfABinaryTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// Base case: if root is null or root matches one of the nodes, return root
		if (root == null || root == p || root == q) {
			return root;
		}

		// Recur for left and right subtrees
		TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
		TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

		// If both left and right LCA exist, return root (common ancestor)
		if (leftLCA != null && rightLCA != null) {
			return root;
		}

		// Otherwise, return the non-null LCA (if any)
		return leftLCA != null ? leftLCA : rightLCA;
	}

	public static void main(String[] args) {
		/*
		 * 3 / \ 5 1 / \ / \ 6 2 0 8 / \ 7 4
		 */
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);

		Leetcode_236_LowestCommonAncestorOfABinaryTree solution = new Leetcode_236_LowestCommonAncestorOfABinaryTree();
		TreeNode p = root.left;
		TreeNode q = root.right;
		TreeNode result = solution.lowestCommonAncestor(root, p, q);
		System.out.println("Lowest Common Ancestor: " + result.val);
	}
}

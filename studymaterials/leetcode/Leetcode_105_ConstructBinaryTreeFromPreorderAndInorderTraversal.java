package leetcode;

public class Leetcode_105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}

		int rootValue = preorder[preStart];
		TreeNode root = new TreeNode(rootValue);

		// Find index of rootValue in inorder traversal
		int rootIndex = 0;
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == rootValue) {
				rootIndex = i;
				break;
			}
		}

		int leftSubtreeSize = rootIndex - inStart;
		root.left = buildTree(preorder, preStart + 1, preStart + leftSubtreeSize, inorder, inStart, rootIndex - 1);
		root.right = buildTree(preorder, preStart + leftSubtreeSize + 1, preEnd, inorder, rootIndex + 1, inEnd);

		return root;
	}

	public static void main(String[] args) {
		Leetcode_105_ConstructBinaryTreeFromPreorderAndInorderTraversal solution = new Leetcode_105_ConstructBinaryTreeFromPreorderAndInorderTraversal();
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };
		TreeNode root = solution.buildTree(preorder, inorder);
		printTree(root);
	}

	private static void printTree(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.val + " ");
		printTree(root.left);
		printTree(root.right);
	}
}

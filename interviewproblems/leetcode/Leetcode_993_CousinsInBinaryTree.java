package leetcode;

public class Leetcode_993_CousinsInBinaryTree {

	private int xDepth = -1;
	private int yDepth = -1;
	private TreeNode xParent = null;
	private TreeNode yParent = null;

	public boolean isCousins(TreeNode root, int x, int y) {
		if (root == null) {
			return false;
		}
		dfs(root, null, 0, x, y);
		return xDepth == yDepth && xParent != yParent;
	}

	private void dfs(TreeNode node, TreeNode parent, int depth, int x, int y) {
		if (node == null) {
			return;
		}
		if (node.val == x) {
			xDepth = depth;
			xParent = parent;
		} else if (node.val == y) {
			yDepth = depth;
			yParent = parent;
		}
		dfs(node.left, node, depth + 1, x, y);
		dfs(node.right, node, depth + 1, x, y);
	}

	public static void main(String[] args) {
		Leetcode_993_CousinsInBinaryTree solution = new Leetcode_993_CousinsInBinaryTree();

		// Example usage
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(5);

		int x = 5;
		int y = 4;

		System.out.println(solution.isCousins(root, x, y)); // Output: true
	}
}

//Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.
//
//Two nodes of a binary tree are cousins if they have the same depth with different parents.
//
//Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.
//
// 
//
//Example 1:
//
//
//Input: root = [1,2,3,4], x = 4, y = 3
//Output: false
//Example 2:
//
//
//Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
//Output: true
//Example 3:
//
//
//Input: root = [1,2,3,null,4], x = 2, y = 3
//Output: false
// 
//
//Constraints:
//
//The number of nodes in the tree is in the range [2, 100].
//1 <= Node.val <= 100
//Each node has a unique value.
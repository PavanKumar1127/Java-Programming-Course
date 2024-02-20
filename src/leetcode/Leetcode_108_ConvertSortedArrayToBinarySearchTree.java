package leetcode;

public class Leetcode_108_ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		return constructBST(nums, 0, nums.length - 1);
	}

	private TreeNode constructBST(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}

		int mid = left + (right - left) / 2;
		TreeNode root = new TreeNode(nums[mid]);

		root.left = constructBST(nums, left, mid - 1);
		root.right = constructBST(nums, mid + 1, right);

		return root;
	}

	public static void main(String[] args) {
		Leetcode_108_ConvertSortedArrayToBinarySearchTree solution = new Leetcode_108_ConvertSortedArrayToBinarySearchTree();

		// Example input: [-10,-3,0,5,9]
		int[] nums = { -10, -3, 0, 5, 9 };

		TreeNode root = solution.sortedArrayToBST(nums);
		printTree(root);
	}

	private static void printTree(TreeNode root) {
		if (root == null) {
			return;
		}
		printTree(root.left);
		System.out.print(root.val + " ");
		printTree(root.right);
	}
}

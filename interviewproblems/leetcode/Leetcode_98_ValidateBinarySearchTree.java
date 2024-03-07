package leetcode;

public class Leetcode_98_ValidateBinarySearchTree {
	public static void main(String[] args) {
		// Example input: [2,1,3]
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(20);
        root.right.right.right = new TreeNode(31);

        Leetcode_98_ValidateBinarySearchTree solution = new Leetcode_98_ValidateBinarySearchTree();
        boolean isValid = solution.isValidBST(root);
        System.out.println("Is the tree a valid BST? " + isValid); // Output: true
    }
	
	public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }
}


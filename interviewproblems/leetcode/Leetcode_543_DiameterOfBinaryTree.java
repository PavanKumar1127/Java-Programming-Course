package leetcode;

public class Leetcode_543_DiameterOfBinaryTree {
	public static void main(String[] args) {
		 // Example input: [1,2,3,4,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Leetcode_543_DiameterOfBinaryTree solution = new Leetcode_543_DiameterOfBinaryTree();
        int diameter = solution.diameterOfBinaryTree(root);
        System.out.println("Diameter of the binary tree: " + diameter);
    }
	
	int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        calculateDepth(root);
        return diameter;
    }

    private int calculateDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = calculateDepth(node.left);
        int rightDepth = calculateDepth(node.right);

        // Update diameter if current node's subtree diameter is greater
        diameter = Math.max(diameter, leftDepth + rightDepth);

        // Return depth of the subtree rooted at current node
        return Math.max(leftDepth, rightDepth) + 1;
    }
}


package leetcode;

public class Leetcode_101_SymmetricTree {
	
	public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode leftSubtree, TreeNode rightSubtree) {
        if (leftSubtree == null && rightSubtree == null) {
            return true;
        }
        if (leftSubtree == null || rightSubtree == null) {
            return false;
        }
        // Check if the values of the nodes are equal and if the subtrees are symmetric
        return (leftSubtree.val == rightSubtree.val)
                && isMirror(leftSubtree.left, rightSubtree.right)
                && isMirror(leftSubtree.right, rightSubtree.left);
    }
    
    public static void main(String[] args) {
        // Example input: [1,2,2,3,4,4,3]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = null;

        Leetcode_101_SymmetricTree solution = new Leetcode_101_SymmetricTree();
        boolean result = solution.isSymmetric(root);
        System.out.println("Is the tree symmetric? " + result); // Expected output: true
    }
}


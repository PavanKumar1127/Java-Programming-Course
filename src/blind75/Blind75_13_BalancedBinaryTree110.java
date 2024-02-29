package blind75;

public class Blind75_13_BalancedBinaryTree110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(height(root.left) - height(root.right)) <= 1
            && isBalanced(root.left)
            && isBalanced(root.right);
    }
    
    private int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);

        Blind75_13_BalancedBinaryTree110 solution = new Blind75_13_BalancedBinaryTree110();
        System.out.println("Is the tree balanced? " + solution.isBalanced(root));
    }
}


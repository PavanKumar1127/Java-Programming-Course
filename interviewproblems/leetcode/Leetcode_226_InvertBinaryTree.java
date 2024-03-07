package leetcode;

public class Leetcode_226_InvertBinaryTree {
	public static void main(String[] args) {
        // Example input: [4,2,7,1,3,6,9]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        printInOrder(root);
        System.out.println("");
        
        Leetcode_226_InvertBinaryTree solution = new Leetcode_226_InvertBinaryTree();
        TreeNode invertedTree = solution.invertTree(root);

        // Print the inverted tree (in-order traversal)
        printInOrder(invertedTree);
    }

    private static void printInOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }
    
    
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
        	return null;
        }
        
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        root.left = right;
        root.right = left;
        
        return root;
    }
}


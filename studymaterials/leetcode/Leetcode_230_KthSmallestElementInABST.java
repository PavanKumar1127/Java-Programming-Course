package leetcode;

import java.util.*;

public class Leetcode_230_KthSmallestElementInABST {
	
	public int kthSmallest(TreeNode root, int k) {
        // Perform inorder traversal to get the elements in ascending order
        List<Integer> inorderList = new ArrayList<>();
        inorderTraversal(root, inorderList);

        // Return the kth element
        return inorderList.get(k - 1);
    }

    private void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left, list);
        list.add(node.val);
        inorderTraversal(node.right, list);
    }
    
    public int kthSmallest1Optimized(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int count = 0;
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            curr = stack.pop();
            count++;
            if(count == k) return curr.val;

            curr = curr.right;
        }
        return 0;
    }
    
    public static void main(String[] args) {
        // Example input: [3,1,4,null,2], k = 1
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        int k = 2;

        Leetcode_230_KthSmallestElementInABST solution = new Leetcode_230_KthSmallestElementInABST();
        int kthSmallestElement = solution.kthSmallest(root, k);
        System.out.println("The " + k + "th smallest element is: " + kthSmallestElement);
    }
}


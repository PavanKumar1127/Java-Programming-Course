package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode_107_BinaryTreeLevelOrderTraversalII {
	
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelNodes.add(node.val);
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            
            result.add(0,levelNodes);
        }
        
        return result;
    }
    


    public static void main(String[] args) {
        // Example tree:       3
        //                   /   \
        //                  9     20
        //                       /  \
        //                      15   7

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(10);
        
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Leetcode_107_BinaryTreeLevelOrderTraversalII solution = new Leetcode_107_BinaryTreeLevelOrderTraversalII();
        List<List<Integer>> result = solution.levelOrderBottom(root);

        // Print the result
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
	
}
//
//Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).
//
//		 
//
//Example 1:
//
//
//Input: root = [3,9,20,null,null,15,7]
//Output: [[15,7],[9,20],[3]]
//Example 2:
//
//Input: root = [1]
//Output: [[1]]
//Example 3:
//
//Input: root = []
//Output: []
// 
//
//Constraints:
//
//The number of nodes in the tree is in the range [0, 2000].
//-1000 <= Node.val <= 1000
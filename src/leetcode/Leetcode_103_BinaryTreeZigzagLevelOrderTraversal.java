package leetcode;

import java.util.*;

public class Leetcode_103_BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> levelNodes = new ArrayDeque<>(); // Use Deque for efficient insertion at front

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    levelNodes.offerLast(node.val); // Insert at end for left to right traversal
                } else {
                    levelNodes.offerFirst(node.val); // Insert at front for right to left traversal
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(new ArrayList<>(levelNodes)); // Convert Deque to List and add to result
            leftToRight = !leftToRight; // Toggle direction for next level
        }

        return result;
    }

	public static void main(String[] args) {
		// Example tree: 3
		// / \
		// 9 20
		// / \
		// 15 7

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(10);

		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		Leetcode_103_BinaryTreeZigzagLevelOrderTraversal solution = new Leetcode_103_BinaryTreeZigzagLevelOrderTraversal();
		List<List<Integer>> result = solution.zigzagLevelOrder(root);

		// Print the result
		for (List<Integer> level : result) {
			System.out.println(level);
		}
	}
}

//Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
//
//		 
//
//Example 1:
//
//
//Input: root = [3,9,20,null,null,15,7]
//Output: [[3],[9,20],[15,7]]
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

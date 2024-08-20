package amazon;
/**
 * Problem: Binary Tree - Special Node Chains
 * 
 * In a binary tree, there are three kinds of nodes:
 * 1. Normal nodes: Nodes with two children.
 * 2. Leaf nodes: Nodes with no children.
 * 3. Special nodes: Nodes with only one child.
 * 
 * The task is to find all unique lengths of "Special Node Chains" in the tree
 * and count how many times each chain length appears.
 * 
 * Approach:
 * - We will traverse the binary tree using Depth-First Search (DFS).
 * - While traversing, we'll track the length of special node chains.
 * - Whenever a special node chain ends, we'll record its length.
 * - We'll use a HashMap to keep track of each unique chain length and its count.
 * 
 * Edge Cases:
 * - The tree is empty (no nodes).
 * - The tree has no special nodes.
 * - The tree is a single long chain of special nodes.
 * 
 * Time Complexity: O(N), where N is the number of nodes in the tree.
 * Space Complexity: O(H), where H is the height of the tree, due to the recursion stack.
 */

import java.util.HashMap;
import java.util.Map;

public class SpecialNodeChains {
    
    // Method to find unique special chain lengths and their counts
    public Map<Integer, Integer> findSpecialNodeChains(TreeNode root) {
        Map<Integer, Integer> chainLengthCount = new HashMap<>();
        findChains(root, 0, chainLengthCount);
        return chainLengthCount;
    }

    // Helper method to perform DFS and track special node chains
    private int findChains(TreeNode node, int currentChainLength, Map<Integer, Integer> chainLengthCount) {
        if (node == null) return currentChainLength;

        boolean isSpecial = (node.left == null && node.right != null) || (node.left != null && node.right == null);

        // If the node is special, increase the chain length
        if (isSpecial) {
            currentChainLength++;
        } else {
            // If the node is not special and there was a chain, record its length
            if (currentChainLength > 0) {
                chainLengthCount.put(currentChainLength, chainLengthCount.getOrDefault(currentChainLength, 0) + 1);
            }
            currentChainLength = 0;  // Reset chain length for the next chain
        }

        // Recursively traverse left and right children
        int leftChain = findChains(node.left, currentChainLength, chainLengthCount);
        int rightChain = findChains(node.right, currentChainLength, chainLengthCount);

        // Return the longer chain (in case of chains extending from left/right children)
        return Math.max(leftChain, rightChain);
    }

    // Driver method for testing
    public static void main(String[] args) {
        // Example tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);
        root.right.left.right.right = new TreeNode(6);

        SpecialNodeChains solution = new SpecialNodeChains();
        Map<Integer, Integer> result = solution.findSpecialNodeChains(root);

        // Output the results
        System.out.println("Unique Special Chain Lengths and Their Counts:");
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            System.out.println("Length: " + entry.getKey() + ", Count: " + entry.getValue());
        }
    }
    
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
}

package leetcode;

import java.util.*;

public class Leetcode_1530_NumberOfGoodLeafNodesPairs {
    
    public int countPairs(TreeNode root, int distance) {
        int[] result = new int[1]; // This will store the count of good leaf node pairs
        dfs(root, distance, result);
        return result[0];
    }

    private List<Integer> dfs(TreeNode node, int distance, int[] result) {
        if (node == null) {
            return new ArrayList<>();
        }

        // If it's a leaf node, return a list with distance 0 (distance to itself)
        if (node.left == null && node.right == null) {
            List<Integer> distances = new ArrayList<>();
            distances.add(0);
            return distances;
        }

        // Get distances from left and right subtrees
        List<Integer> leftDistances = dfs(node.left, distance, result);
        List<Integer> rightDistances = dfs(node.right, distance, result);

        // Calculate distances to ancestors and count good pairs
        for (int l : leftDistances) {
            for (int r : rightDistances) {
                if (l + r + 2 <= distance) {
                    result[0]++;
                }
            }
        }

        // Return distances to current node's ancestors
        List<Integer> currentDistances = new ArrayList<>();
        for (int d : leftDistances) {
            if (d + 1 < distance) {
                currentDistances.add(d + 1);
            }
        }
        for (int d : rightDistances) {
            if (d + 1 < distance) {
                currentDistances.add(d + 1);
            }
        }
        return currentDistances;
    }

    public static void main(String[] args) {
        // Example input: [1,2,3,4,5,6,7], distance = 2
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Leetcode_1530_NumberOfGoodLeafNodesPairs solution = new Leetcode_1530_NumberOfGoodLeafNodesPairs();
        int distance = 2;
        int result = solution.countPairs(root, distance);
        System.out.println("Number of good leaf node pairs: " + result); // Expected output: 2
    }
}

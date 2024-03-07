package leetcode;

class Node {
    int val;
    Node left;
    Node right;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

public class Leetcode_116_PopulatingNextRightPointersInEachNode {
	
	 public Node connect(Node root) {
	        if (root == null || (root.left == null && root.right == null)) {
	            return root;
	        }

	        // Connect children
	        root.left.next = root.right;

	        // Connect across nodes
	        if (root.next != null) {
	            root.right.next = root.next.left;
	        }

	        // Recur for left and right subtrees
	        connect(root.left);
	        connect(root.right);

	        return root;
	    }

    public static void main(String[] args) {
        // Example input: [1,2,3,4,5,6,7]
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Leetcode_116_PopulatingNextRightPointersInEachNode solution = new Leetcode_116_PopulatingNextRightPointersInEachNode();
        Node result = solution.connect(root);

        // Displaying next pointers (level order traversal)
        while (result != null) {
            Node current = result;
            while (current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }
            System.out.println();
            result = result.left; // Moving to the next level
        }
    }
}

//You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
//
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
//Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
//
//Initially, all next pointers are set to NULL.
//
// 
//
//Example 1:
//
//
//Input: root = [1,2,3,4,5,6,7]
//Output: [1,#,2,3,#,4,5,6,7,#]
//Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
//Example 2:
//
//Input: root = []
//Output: []
// 
//
//Constraints:
//
//The number of nodes in the tree is in the range [0, 212 - 1].
//-1000 <= Node.val <= 1000
// 
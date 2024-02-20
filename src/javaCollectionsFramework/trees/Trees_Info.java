package javaCollectionsFramework.trees;

/**
 * trees are a fundamental data structure used to represent hierarchical
 * relationships between elements. They are versatile and find applications in
 * various domains like computer science, database management, file systems, and
 * more. Trees provide efficient searching, insertion, deletion, and traversal
 * operations.
 */
public class Trees_Info {

}
//
//Properties of Trees:
//	
//	
//Root: The topmost node of the tree, from which all other nodes are descendants.
//Node: Each element in the tree is called a node.
//Edge: The connection between two nodes.
//Parent: A node that has child nodes.
//Child: Nodes that are directly connected to another node when moving away from the root.
//Leaf: A node with no children.
//Depth: The length of the path from the root to a node.
//Height: The length of the longest path from a node to a leaf.
//Subtree: A tree rooted at a node and its descendants.
//Binary Tree: A tree in which each node can have at most two children.

//Types

//////Binary Tree:

//A binary tree is a tree data structure in which each node has at most two children, referred to as the left child and the right child.
//Properties:
//Each node has at most two children.
//Each node has a left child and a right child, which may be null.
//Applications:
//Binary search trees (BSTs) for efficient searching, insertion, and deletion of data.
//Expression trees for representing mathematical expressions.
//Example: Binary Search Tree (BST)

//Binary Search Tree (BST):
//
//A binary search tree is a type of binary tree in which the left child of a node contains values less than the node's value, and the right child contains values greater than the node's value.
//Properties:
//In a BST, the value of each node is greater than all values in its left subtree and less than all values in its right subtree.
//Applications:
//Efficient searching, insertion, and deletion of data.
//Implementing associative arrays and dictionaries.
//Example: Implementing a phone book where names are stored in alphabetical order.

//
//AVL Tree:
//
//An AVL tree is a self-balancing binary search tree in which the heights of the two child subtrees of any node differ by at most one.
//Properties:
//In an AVL tree, the balance factor of each node is either -1, 0, or 1.
//After each operation (insertion or deletion), the tree is rebalanced to maintain AVL property.
//Applications:
//Used in database systems for indexing and efficient retrieval of data.
//Implementation of sets and maps.
//Example: Database indexing to speed up search queries.

/**
 * In tree traversal, inorder, preorder, and postorder are three different ways
 * to visit and process each node in a tree.
 * 
 * Inorder Traversal:
 * 
 * In inorder traversal, we visit the left subtree, then the current node, and
 * finally the right subtree. In a binary search tree (BST), inorder traversal
 * visits nodes in non-decreasing order.
 * 
 * 
 * Preorder Traversal:
 * 
 * In preorder traversal, we visit the current node first, then the left
 * subtree, and finally the right subtree.
 * 
 * Postorder Traversal:
 * 
 * In postorder traversal, we visit the left subtree, then the right subtree,
 * and finally the current node.
 *
 */

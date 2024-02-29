package javaCollectionsFramework.trees;
class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26]; // Assuming lowercase English letters only
        isEndOfWord = false;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}

public class PrefixTree {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("banana");
        trie.insert("bat");

        System.out.println(trie.search("app")); // true
        System.out.println(trie.search("apps")); // false
        System.out.println(trie.startsWith("ba")); // true
        System.out.println(trie.startsWith("bat")); // true
    }
}

//Step-by-step algorithm:
//	
//TrieNode class: Define a TrieNode class to represent each node in the Trie. Each node should contain:
//An array of TrieNode children to represent all possible characters (a-z).
//A boolean flag to mark the end of a word.
//Trie class: Define a Trie class to represent the Trie data structure. It should contain the following methods:
//insert(word): Insert a word into the Trie. Traverse the Trie starting from the root and create new nodes as needed.
//search(word): Search for a word in the Trie. Traverse the Trie and return true if the word is found and ends in a valid node.
//startsWith(prefix): Check if there is any word in the Trie that starts with the given prefix. Traverse the Trie and return true if the prefix is found.


//Insert words: Use the insert method to insert each word into the Trie.
//
//Insert "apple": Traverse the Trie from the root, creating nodes for each character ('a', 'p', 'p', 'l', 'e'). Mark the end of the word as true.
//Insert "app": Traverse the Trie, creating nodes for each character ('a', 'p', 'p'). Mark the end of the word as true.
//Insert "banana": Traverse the Trie, creating nodes for each character ('b', 'a', 'n', 'a', 'n', 'a'). Mark the end of the word as true.
//Insert "bat": Traverse the Trie, creating nodes for each character ('b', 'a', 't'). Mark the end of the word as true.
//Search and startsWith operations: Use the search and startsWith methods to perform operations on the Trie.
//
//Search for "app": Traverse the Trie, finding nodes for each character ('a', 'p', 'p'). The search operation should return true.
//Search for "apps": Traverse the Trie, finding nodes for each character ('a', 'p', 'p'). The search operation should return false (as "apps" is not in the Trie).
//Check startsWith "ba": Traverse the Trie, finding nodes for each character ('b', 'a'). The startsWith operation should return true.
//Check startsWith "bat": Traverse the Trie, finding nodes for each character ('b', 'a', 't'). The startsWith operation should return true.
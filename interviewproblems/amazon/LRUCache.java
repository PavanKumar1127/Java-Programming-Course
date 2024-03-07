package amazon;

/**
 * Explain the approach of LRU cache and implement using object oriented
 * language
 */
import java.util.HashMap;
import java.util.Map;

class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            addToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            remove(node);
            addToHead(node);
        } else {
            if (cache.size() == capacity) {
                cache.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 3); // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)
        cache.put(4, 4); // evicts key 1
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
    }
}



//LRU (Least Recently Used) Cache is a type of cache replacement policy where the least recently used items are discarded first when the cache 
//reaches its maximum capacity. The idea behind LRU cache is to keep track of the order in which items are accessed or modified. 
//When a cache miss occurs and the cache is full, the item that was least recently accessed (or modified) is evicted to make space for the new item.
//
//Here's a high-level approach to implement an LRU cache using an object-oriented language like Java:
//
//Data Structure: Use a combination of a doubly linked list and a hash map to store the cache items. The doubly linked list helps maintain the 
//order of items based on their access time, and the hash map allows for fast lookups of items based on their keys.
//
//Cache Entry Class: Create a class to represent each cache entry, containing fields for key, value, and pointers to the previous and next entries in the linked list.
//
//LRU Cache Class: Implement a class to represent the LRU cache, which includes the following methods:
//
//get(key): Retrieve the value associated with the given key from the cache. If the key exists, move the corresponding entry to the front of the linked list (indicating it was most recently accessed). If the key doesn't exist, return null.
//put(key, value): Add or update the key-value pair in the cache. If the key already exists, update the corresponding value and move the entry to the front of the linked list. If the key doesn't exist and the cache is full, remove the least recently used entry from the end of the linked list and add the new entry to the front.
//Other helper methods may include evict() to remove the least recently used entry, update() to update the access time of an existing entry, etc.
//Doubly Linked List: Implement methods to maintain the order of cache entries based on their access time, such as moveToFront() to move an entry to the front of the list, remove() to remove an entry from the list, etc.
//
//Hash Map: Use a hash map to store references to cache entries for fast lookups based on keys.
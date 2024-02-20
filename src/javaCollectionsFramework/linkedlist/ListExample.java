package javaCollectionsFramework.linkedlist;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListExample {

    public static void main(String[] args) {
        // ArrayList Example
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        System.out.println("ArrayList: " + arrayList);

        // LinkedList Example
        List<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        System.out.println("LinkedList: " + linkedList);

        // Vector Example
        List<Double> vector = new Vector<>();
        vector.add(1.5);
        vector.add(2.5);
        vector.add(3.5);
        System.out.println("Vector: " + vector);

        // Common Operations
        System.out.println("Size of ArrayList: " + arrayList.size());
        System.out.println("Size of LinkedList: " + linkedList.size());
        System.out.println("Size of Vector: " + vector.size());

        System.out.println("Element at index 1 in ArrayList: " + arrayList.get(1));
        System.out.println("Element at index 1 in LinkedList: " + linkedList.get(1));
        System.out.println("Element at index 1 in Vector: " + vector.get(1));

        System.out.println("Index of element 'C' in ArrayList: " + arrayList.indexOf(3));
        System.out.println("Index of element 'C' in LinkedList: " + linkedList.indexOf("C"));
        System.out.println("Index of element 3.5 in Vector: " + vector.indexOf(3.5));

        // Additional Operations
        arrayList.remove(1);
        linkedList.remove("B");
        vector.remove(1.5);
        System.out.println("ArrayList after removal: " + arrayList);
        System.out.println("LinkedList after removal: " + linkedList);
        System.out.println("Vector after removal: " + vector);
        
     // ArrayList Example
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        System.out.println("ArrayList: " + arrayList);

        // LinkedList Example
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        System.out.println("LinkedList: " + linkedList);

        // Vector Example
        vector.add(1.5);
        vector.add(2.5);
        vector.add(3.5);
        System.out.println("Vector: " + vector);

        // Adding elements at specific positions
        arrayList.add(1, 10); // Adds 10 at index 1
        linkedList.add(1, "Z"); // Adds "Z" at index 1
        vector.add(1, 4.5); // Adds 4.5 at index 1
        System.out.println("ArrayList after adding at index 1: " + arrayList);
        System.out.println("LinkedList after adding at index 1: " + linkedList);
        System.out.println("Vector after adding at index 1: " + vector);

        // Replacing elements
        arrayList.set(2, 20); // Replaces element at index 2 with 20
        linkedList.set(2, "X"); // Replaces element at index 2 with "X"
        vector.set(2, 5.5); // Replaces element at index 2 with 5.5
        System.out.println("ArrayList after replacing at index 2: " + arrayList);
        System.out.println("LinkedList after replacing at index 2: " + linkedList);
        System.out.println("Vector after replacing at index 2: " + vector);

        // Clearing the lists
        arrayList.clear();
        linkedList.clear();
        vector.clear();
        System.out.println("ArrayList after clearing: " + arrayList);
        System.out.println("LinkedList after clearing: " + linkedList);
        System.out.println("Vector after clearing: " + vector);

        // Performance comparison: ArrayList vs LinkedList vs Vector
        // - ArrayList: Efficient for random access but slower for insertions and removals in the middle.
        // - LinkedList: Efficient for insertions and removals in the middle but slower for random access.
        // - Vector: Similar to ArrayList but thread-safe, which may lead to synchronization overhead.
        // Choose based on specific requirements and performance characteristics needed.
    
    }
}

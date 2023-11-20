package javaCollectionsFramework;

import java.util.*;

/**
 * 
 * The List interface in Java is part of the Java Collections Framework and
 * represents an ordered collection of elements where each element has an index.
 * Lists allow duplicate elements and offer methods for accessing, inserting,
 * updating, and removing elements based on their position in the list. The List
 * interface is part of the java.util package.
 */

//Key characteristics of the List interface:
//
//Ordered Collection:
//
//Elements in a list maintain the order in which they are inserted. The order is determined by the position or index of each element.
//Duplicates Allowed:
//
//Unlike Set, a List allows duplicate elements. Each element in the list has a unique index.
//Indexed Access:
//
//Elements in a list are accessed and manipulated using their index. The index starts from 0 for the first element.

public class ListInterface {

//	1. ArrayList:
//		Implements a dynamic array that can grow or shrink as needed. Offers fast random access but may be slower when inserting or removing elements in the middle of the list.
	List<String> arrayList = new ArrayList<>();
	
//	2. LinkedList:
//		Implements a doubly-linked list. Provides fast insertion and removal of elements, especially in the middle of the list, but may be slower for random access.
	List<String> linkedList = new LinkedList<>();

//	3. Vector:
//		Similar to ArrayList but is synchronized, making it thread-safe. It's less commonly used than ArrayList.
		List<String> vector = new Vector<>();
		
//	4. Stack:
//		Extends Vector and represents a last-in, first-out (LIFO) stack of objects.
		Stack<String> stack = new Stack<>();
		
//		Common Methods of the List Interface:
//			add(E element): Adds an element to the end of the list.
//			add(int index, E element): Inserts an element at the specified index.
//			get(int index): Retrieves the element at the specified index.
//			set(int index, E element): Replaces the element at the specified index with the specified element.
//			remove(int index): Removes the element at the specified index.
//			size(): Returns the number of elements in the list.		
//	
		
		
}

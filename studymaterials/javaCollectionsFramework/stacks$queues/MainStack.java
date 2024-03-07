package javaCollectionsFramework.stacks$queues;

import java.util.EmptyStackException;

/**
 * Both CustomStack and DynamicStack classes implement a stack data structure
 * with common operations such as push, pop, peek, isEmpty, isFull, and size.
 * 
 * CustomStack has a fixed capacity, and when it's full, it throws a
 * StackOverflowError. 
 * 
 * DynamicStack dynamically resizes itself when it's full to
 * accommodate more elements. 
 * 
 * The resize operation in DynamicStack takes O(n)
 * time on average, where n is the number of elements in the stack, because it
 * involves copying elements to a new array. 
 * 
 * Other operations like push, pop,
 * peek, isEmpty, and size take O(1) time complexity.
 * 
 */

// CustomStack class
class CustomStack<T> {
	private Object[] stackArray;
	private int top;
	private int capacity;

	// Constructor
	public CustomStack(int capacity) {
		this.capacity = capacity;
		stackArray = new Object[capacity];
		top = -1;
	}

	// Push operation
	// Time complexity: O(1)
	public void push(T item) {
		if (isFull()) {
			throw new StackOverflowError("Stack is full");
		}
		stackArray[++top] = item;
	}

	// Pop operation
	// Time complexity: O(1)
	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return (T) stackArray[top--];
	}

	// Peek operation
	// Time complexity: O(1)
	public T peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return (T) stackArray[top];
	}

	// Check if the stack is empty
	// Time complexity: O(1)
	public boolean isEmpty() {
		return top == -1;
	}

	// Check if the stack is full
	// Time complexity: O(1)
	public boolean isFull() {
		return top == capacity - 1;
	}

	// Get the size of the stack
	// Time complexity: O(1)
	public int size() {
		return top + 1;
	}
}

// DynamicStack class
class DynamicStack<T> {
	private Object[] stackArray;
	private int top;
	private int capacity;

	// Constructor
	public DynamicStack(int capacity) {
		this.capacity = capacity;
		stackArray = new Object[capacity];
		top = -1;
	}

	// Push operation
	// Time complexity: O(1) average, O(n) worst case (when resizing)
	public void push(T item) {
		if (isFull()) {
			resize();
		}
		stackArray[++top] = item;
	}

	// Pop operation
	// Time complexity: O(1)
	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return (T) stackArray[top--];
	}

	// Peek operation
	// Time complexity: O(1)
	public T peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return (T) stackArray[top];
	}

	// Check if the stack is empty
	// Time complexity: O(1)
	public boolean isEmpty() {
		return top == -1;
	}

	// Check if the stack is full
	// Time complexity: O(1)
	public boolean isFull() {
		return top == capacity - 1;
	}

	// Get the size of the stack
	// Time complexity: O(1)
	public int size() {
		return top + 1;
	}

	// Resize the stack when it's full
	private void resize() {
		capacity *= 2;
		Object[] newArray = new Object[capacity];
		System.arraycopy(stackArray, 0, newArray, 0, size());
		stackArray = newArray;
	}
}

// Main class
public class MainStack {
	public static void main(String[] args) {
		// CustomStack example
		CustomStack<Integer> customStack = new CustomStack<>(3);
		customStack.push(1);
		customStack.push(2);
		customStack.push(3);
		System.out.println("CustomStack: " + customStack.pop()); // Output: 3
		System.out.println("CustomStack size: " + customStack.size()); // Output: 2

		// DynamicStack example
		DynamicStack<String> dynamicStack = new DynamicStack<>(3);
		dynamicStack.push("a");
		dynamicStack.push("b");
		dynamicStack.push("c");
		dynamicStack.push("d"); // Stack will resize to accommodate the new element
		System.out.println("DynamicStack: " + dynamicStack.pop()); // Output: d
		System.out.println("DynamicStack size: " + dynamicStack.size()); // Output: 3
	}
}

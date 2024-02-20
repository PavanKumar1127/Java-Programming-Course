package javaCollectionsFramework.stacks$queues;
import java.util.NoSuchElementException;

//The CircularArray class represents a circular array data structure.
//It uses an Object array to store elements, along with front and rear indices to keep track of the circular structure.
//The add() method adds an element to the rear of the array. It updates the rear index and increments the size.
//The remove() method removes and returns the element from the front of the array. It updates the front index and decrements the size.
//The get() method retrieves the element at a specific index in the array, taking into account the circular nature of the array.
//The print() method prints the elements of the array, ensuring that it displays them in the correct order considering the circular structure.
//The main method demonstrates the usage of the CircularArray class by adding, removing, and printing elements.

public class CircularArray<T> {
    private Object[] array;
    private int size;
    private int front;
    private int rear;

    // Constructor
    public CircularArray(int capacity) {
        array = new Object[capacity];
        size = 0;
        front = 0;
        rear = -1;
    }

    // Check if the array is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the array is full
    public boolean isFull() {
        return size == array.length;
    }

    // Get the size of the array
    public int size() {
        return size;
    }

    // Add an element to the rear of the array
    public void add(T element) {
        if (isFull()) {
            throw new IllegalStateException("Circular array is full");
        }
        rear = (rear + 1) % array.length;
        array[rear] = element;
        size++;
    }

    // Remove and return the element from the front of the array
    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Circular array is empty");
        }
        T element = (T) array[front];
        front = (front + 1) % array.length;
        size--;
        return element;
    }

    // Get the element at a specific index in the array
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        int actualIndex = (front + index) % array.length;
        return (T) array[actualIndex];
    }

    // Print the elements of the array
    public void print() {
        System.out.print("Circular Array: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % array.length;
            System.out.print(array[index] + " ");
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        CircularArray<Integer> circularArray = new CircularArray<>(5);
        circularArray.add(1);
        circularArray.add(2);
        circularArray.add(3);
        circularArray.add(4);
        circularArray.print(); // Output: Circular Array: 1 2 3 4
        circularArray.remove();
        circularArray.add(5);
        circularArray.print(); // Output: Circular Array: 2 3 4 5
    }
}

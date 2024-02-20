package javaCollectionsFramework.stacks$queues;
import java.util.EmptyStackException;

// CustomQueue class
class CustomQueue<T> {
    private Object[] queueArray;
    private int front;
    private int rear;
    private int capacity;

    // Constructor
    public CustomQueue(int capacity) {
        this.capacity = capacity;
        queueArray = new Object[capacity];
        front = 0;
        rear = -1;
    }

    // Enqueue operation
    // Time complexity: O(1)
    public void enqueue(T item) {
        if (isFull()) {
            throw new StackOverflowError("Queue is full");
        }
        rear = (rear + 1) % capacity;
        queueArray[rear] = item;
    }

    // Dequeue operation
    // Time complexity: O(1)
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T item = (T) queueArray[front];
        front = (front + 1) % capacity;
        return item;
    }

    // Peek operation
    // Time complexity: O(1)
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) queueArray[front];
    }

    // Check if the queue is empty
    // Time complexity: O(1)
    public boolean isEmpty() {
        return rear == -1;
    }

    // Check if the queue is full
    // Time complexity: O(1)
    public boolean isFull() {
        return ((rear + 1) % capacity) == front;
    }

    // Get the size of the queue
    // Time complexity: O(1)
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return (capacity - front + rear + 1) % capacity;
    }
}

// Main class
public class MainQueue {
    public static void main(String[] args) {
        // CustomQueue example
        CustomQueue<Integer> customQueue = new CustomQueue<>(3);
        customQueue.enqueue(1);
        customQueue.enqueue(2);
        customQueue.enqueue(3);
        System.out.println("CustomQueue: " + customQueue.dequeue()); // Output: 1
        System.out.println("CustomQueue size: " + customQueue.size()); // Output: 2
    }
}

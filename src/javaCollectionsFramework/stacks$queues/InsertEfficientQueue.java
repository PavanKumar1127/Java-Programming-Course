package javaCollectionsFramework.stacks$queues;
import java.util.Stack;

/**
 * An insert-efficient queue implementation using two stacks.
 * <p>
 * This implementation supports enqueue and dequeue operations.
 * Enqueue operation is efficient, while dequeue operation is less efficient.
 *
 * @param <T> the type of elements stored in the queue
 */
public class InsertEfficientQueue<T> {
    private Stack<T> stack1; // For enqueue operation
    private Stack<T> stack2; // For dequeue operation

    /**
     * Constructs an empty insert-efficient queue.
     */
    public InsertEfficientQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * Adds an item to the queue.
     *
     * @param item the item to enqueue
     */
    public void enqueue(T item) {
        stack1.push(item);
    }

    /**
     * Removes and returns the front element of the queue.
     * Throws IllegalStateException if the queue is empty.
     *
     * @return the front element of the queue
     * @throws IllegalStateException if the queue is empty
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        // If the second stack is empty, transfer elements from the first stack
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    /**
     * Returns the size of the queue.
     *
     * @return the size of the queue
     */
    public int size() {
        return stack1.size() + stack2.size();
    }

    /**
     * Demonstrates the usage of InsertEfficientQueue.
     *
     * @param args the command-line arguments (not used)
     */
    public static void main(String[] args) {
        InsertEfficientQueue<Integer> queue = new InsertEfficientQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Dequeue: " + queue.dequeue()); // Dequeue: 1
        System.out.println("Dequeue: " + queue.dequeue()); // Dequeue: 2

        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println("Size: " + queue.size()); // Size: 3
        System.out.println("Dequeue: " + queue.dequeue()); // Dequeue: 3
        System.out.println("Dequeue: " + queue.dequeue()); // Dequeue: 4
        System.out.println("Dequeue: " + queue.dequeue()); // Dequeue: 5
    }
}

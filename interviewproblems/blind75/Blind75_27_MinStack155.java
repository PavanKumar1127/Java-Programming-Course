package blind75;
import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

public class Blind75_27_MinStack155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(2);
        minStack.push(5);
        minStack.push(1);

        System.out.println("Minimum element: " + minStack.getMin()); // Output: Minimum element: 1
        minStack.pop();
        System.out.println("Minimum element after pop: " + minStack.getMin()); // Output: Minimum element after pop: 2
    }
}

//To solve the "Min Stack" problem (LeetCode Problem 155), we need to design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//Approach:
//Use Two Stacks: We'll use two stacks - one to store the actual elements and another to keep track of the minimum element.
//Min Stack: The min stack will always have the minimum element at the top.
//Push Operation: When pushing a new element onto the stack, we'll also update the min stack if the new element is smaller than or equal to the current minimum.
//Pop Operation: When popping an element, we'll also remove the corresponding element from the min stack if it matches the top element of the main stack.
//Top Operation: Top operation will be the same as the standard stack.
//GetMin Operation: GetMin operation will return the top element of the min stack.
//Example:
//	
//	Push 3: Stack: [3], Min Stack: [3]
//			Push 2: Stack: [3, 2], Min Stack: [3, 2]
//			Push 5: Stack: [3, 2, 5], Min Stack: [3, 2, 2]
//			Push 1: Stack: [3, 2, 5, 1], Min Stack: [3, 2, 2, 1]
//			GetMin: Minimum element is 1
//			Pop: Stack: [3, 2, 5], Min Stack: [3, 2, 2]

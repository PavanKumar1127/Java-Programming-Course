package amazon;

import java.util.Stack;

//Given a stack output a sorted stack.(hint use recursion)
public class SortStack {

	// sortStack method that takes a stack as input and recursively sorts it.
	public static Stack<Integer> sortStack(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return stack;
		}
		// pop elements from the original stack one by one and recursively call the
		// sortStack method on the remaining elements.
		int temp = stack.pop();

		sortStack(stack);

		insertSorted(stack, temp);

		return stack;
	}

	//inserts the given value into the stack while maintaining the sorted order.
	private static void insertSorted(Stack<Integer> stack, int value) {
		if (stack.isEmpty() || value > stack.peek()) {
			stack.push(value);
			return;
		}

		int temp = stack.pop();
		insertSorted(stack, value);
		stack.push(temp);
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(3);
		stack.push(1);
		stack.push(4);
		stack.push(2);

		System.out.println("Original stack: " + stack);

		Stack<Integer> sortedStack = sortStack(stack);

		System.out.println("Sorted stack: " + sortedStack);
	}
}

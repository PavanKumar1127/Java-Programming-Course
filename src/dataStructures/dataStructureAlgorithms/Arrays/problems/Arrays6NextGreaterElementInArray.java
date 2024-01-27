package dataStructures.dataStructureAlgorithms.Arrays.problems;

import java.util.Stack;

public class Arrays6NextGreaterElementInArray {

	public static int[] nextGreaterElement(int[] nums) {
		int[] result = new int[nums.length];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < nums.length; i++) {
			while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
				result[stack.pop()] = nums[i];
			}
			stack.push(i);
		}

		// Remaining elements in the stack don't have a next greater element
		while (!stack.isEmpty()) {
			result[stack.pop()] = -1;
		}

		return result;
	}

	public static void main(String[] args) {
		int[] array = { 2, 3, 4, 5, 6, 3, 5, 2, 6 };
		int[] result = nextGreaterElement(array);

		// Output: {3, 4, 5, 6, -1, 5, 6, 6, -1}
		for (int num : result) {
			System.out.print(num + " ");
		}
	}
}

package dataStructures.dataStructureAlgorithms.Arrays.problems;

import java.util.Arrays;

public class Arrays7ProductExceptSelf {

	public static void main(String[] args) {
		int[] num = { 2, 3, 4, 5, 6 };
		System.out.println(Arrays.toString(productExceptSelf(num)));
	}

	public static int[] productExceptSelf(int[] nums) {
		int[] ans = new int[nums.length];
		int leftprod = 1;
		int rightprod = 1;

		for (int i = 0; i < nums.length; i++) {
			ans[i] = leftprod;
			leftprod *= nums[i];
		}
		for (int i = nums.length - 1; i >= 0; i--) {
			ans[i] = ans[i] * rightprod;
			rightprod *= nums[i];
		}
		return ans;
	}

}

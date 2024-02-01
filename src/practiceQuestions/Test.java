package practiceQuestions;

public class Test {

	public static void main(String[] args) {
		int[] num = { 3, 2, 3};
		int target = 6;
		int[] ans = twoSum(num, target);
		System.out.println(ans);
	}

	public static int[] twoSum(int[] nums, int target) {
		int i = 0;
		int j = 0;
		int sum = 0;
		int[] ans = { 0, 0 };
		int len = nums.length-1;

		while (i <= j && j <=len && i <=len) {

			if (sum == target) {
				ans[0] = i;
				ans[1] = j;
				return ans;
			}
			sum += nums[j];

			if (sum < target) {
				j++;
			} else {

				while (sum > target) {
					sum -= nums[i];
					i++;
				}
				j++;
			}
		}
		ans[1]=j-1;
		return ans;
	}

}

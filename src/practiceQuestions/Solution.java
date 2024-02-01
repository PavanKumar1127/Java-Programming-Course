package practiceQuestions;

import java.util.HashMap;

class Solution {

	public static void main(String[] args) {
		int[] num = { 3, 2, 4 };
		int target = 6;
		int[] ans = twoSum(num, target);
		System.out.println(ans);
	}

	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> ans = new HashMap<Integer, Integer>();

		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int t = target - nums[i];
			if (ans.containsKey(t)) {
				result[0] = ans.get(t);
				result[1] = i;
				break;
			}
			ans.put(nums[i], i);
		}

		return result;
	}
	
	public static int[] twoSum2(int[] nums, int target) {
        for(int i = 1; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                if(nums[j] + nums[j-i] == target){
                    return new int[] {j, j-i};
                }
            }
        }
        System.gc();
        return null;
    }

}
package blind75;

import java.util.HashMap;

public class Blind75_01_TwoSumLeetcode1 {

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

//
//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//You can return the answer in any order.
//
// 
//
//Example 1:
//
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//Example 2:
//
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//Example 3:
//
//Input: nums = [3,3], target = 6
//Output: [0,1]
// 
//
//Constraints:
//
//2 <= nums.length <= 104
//-109 <= nums[i] <= 109
//-109 <= target <= 109
//Only one valid answer exists.
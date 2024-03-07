package blind75;

public class Blind75_18_MaximumSubarray53 {
	
	//Algorithm
//	https://leetcode.com/problems/maximum-subarray/solutions/1595097/java-kadane-s-algorithm-explanation-using-image/
	
	public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = 0;

        for(int i =0; i<nums.length; i++){
            sum += nums[i];
            // if (sum > max) {
            //     max = sum;
            // }
            // if(sum < 0){
            //     sum = 0;
            // }
            max = Math.max(sum , max);
            sum = sum<0 ? 0:sum;
        }
        return max;
    }
}


package leetcode;

//Find Numbers with Even Number of Digits

public class Leetcode_1295EvennumberOfElements {
	
	public static void main(String[] args) {
		int[] nums = {555,901,482,1771};
		System.out.println("No of elements that are even: "+findNumbers(nums));
	}
	
	 public static int findNumbers(int[] nums) {
	        int count=0;
	        for(int num : nums){
	            if(even(num)){
	                count++;
	            }
	        }
	        return count;
	    }

	    public static boolean even(int num){
	        return ((digits(num) % 2) == 0); 
	        // optimised sol: rerturn (num < 0)  ? (int) Math.log10(num * -1)+ 1 : (int) Math.log10(num)+ 1;
	    }

	    public static int digits(int num){
	        int count=0;
	        while(num>0){
	            num =num/10;
	            count++;
	        }
	        return count;
	    }

}

class Solution {
    public int findNumbers(int[] nums) {
        int count=0;
        for(int num : nums){
            int digits = 0;
            while(num>0){
	            digits++;
                num =num/10;
	        }
	        if((digits % 2) == 0){
	            count++;
	        }
	    }
	    return count;
	}  
}



//Given an array nums of integers, return how many of them contain an even number of digits.
//
//		 
//
//Example 1:
//
//Input: nums = [12,345,2,6,7896]
//Output: 2
//Explanation: 
//12 contains 2 digits (even number of digits). 
//345 contains 3 digits (odd number of digits). 
//2 contains 1 digit (odd number of digits). 
//6 contains 1 digit (odd number of digits). 
//7896 contains 4 digits (even number of digits). 
//Therefore only 12 and 7896 contain an even number of digits.

//count the number of digits of each elements
//convert the numbers to String then use .length()


//Example 2:
//
//Input: nums = [555,901,482,1771]
//Output: 1 
//Explanation: 
//Only 1771 contains an even number of digits.
// 
//
//Constraints:
//
//1 <= nums.length <= 500
//1 <= nums[i] <= 105
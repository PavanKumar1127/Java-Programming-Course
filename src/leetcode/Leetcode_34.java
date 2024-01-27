package leetcode;

//Find First and Last Position of Element in Sorted Array
public class Leetcode_34 {
	
    // Driver program
    public static void main(String[] args)
    {
        int arr[] = { 1, 2, 2, 2, 2, 3, 4, 7, 8, 8 };
        int n = arr.length;
        int x = 2;
        int[] ans = { -1, -1 };
        // For first occurrence
        ans[0] = search(arr,x, true);
        if (ans[0] != -1) {
            // For last occurrence
            ans[1] = search(arr, x, false);
        }
        System.out.println("First Occurrence = " + ans[0]);
        System.out.println("Last Occurrence = " + ans[1]);
    }

	private static int search(int[] arr, int x, boolean b) {
		int start = 0;
		int end = arr.length -1;
		int ans = -1;
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(x < arr[mid])
				end = mid -1;
			else if(x > arr[mid])
				start = mid +1;
			else {
				ans = mid;
				if(b)
					end = mid -1;
				else
					start = mid +1;
			}
		}
		return ans;
	}

}

//
//Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
//
//If target is not found in the array, return [-1, -1].
//
//You must write an algorithm with O(log n) runtime complexity.
//
// 
//
//Example 1:
//
//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
//Example 2:
//
//Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
//Example 3:
//
//Input: nums = [], target = 0
//Output: [-1,-1]
// 
//
//Constraints:
//
//0 <= nums.length <= 105
//-109 <= nums[i] <= 109
//nums is a non-decreasing array.
//-109 <= target <= 109
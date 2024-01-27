package dataStructures.dataStructureAlgorithms.Arrays.problems;


	//Ceiling in a sorted array

public class Arrays5FloorAndCieling {
		
		public static void main(String[] args) {
			int[] arr = {1, 2, 8, 10, 10, 12, 19, 32, 41};
			int target = 39;
			int ans = findCeiling(arr, target);
			System.out.println(ans);
		}

		private static int findCeiling(int[] arr, int target) {
			int length = arr.length - 1;
			if(length < 0)
				return -1;
			if(length == 1)
				return arr[0];
			
			int start = 0;
			int end = length;
			while(start <= end) {
				int mid = start + (end - start)/2;
				for(int i = start ; i <= end; i++) {
					System.out.print(arr[i]+ " ");
				}
				System.out.println("");
				if(arr[mid] < target){
					start = mid +1;
				}else if(arr[mid] > target) {
					end = mid -1;
				}else {
					return arr[mid];
				}
			}
			return arr[end];
		}

	}

	//Given a sorted array and a value x, the ceiling of x is the smallest element in an array greater than or equal to x, and the floor is the greatest element smaller than or equal to x. Assume that the array is sorted in non-decreasing order. Write efficient functions to find the floor and ceiling of x. 
	//Examples : 
	//
	//For example, let the input array be {1, 2, 8, 10, 10, 12, 19}
	//For x = 0:    floor doesn't exist in array,  ceil  = 1
	//For x = 1:    floor  = 1,  ceil  = 1
	//For x = 5:    floor  = 2,  ceil  = 8
	//For x = 20:   floor  = 19,  ceil doesn't exist in array

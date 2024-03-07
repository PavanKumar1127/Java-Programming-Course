package dataStructures.dataStructureAlgorithms.Arrays.problems;


	//Find the number of zeroes

	//Given an array of 1s and 0s which has all 1s first followed by all 0s. Find the number of 0s. Count the number of zeroes in the given array.
	//Examples : 
//		Input: arr[] = {1, 1, 1, 1, 0, 0}
//		Output: 2
	//
//		Input: arr[] = {1, 0, 0, 0, 0}
//		Output: 4
	//
//		Input: arr[] = {0, 0, 0}
//		Output: 3
	//
//		Input: arr[] = {1, 1, 1, 1}
//		Output: 0
	//A divide and conquer solution to find count of zeroes in an array
	//where all 1s are present before all 0s

public class Arrays4FirstZeroe {
		/* if 0 is present in arr[] then returns the index of FIRST occurrence
		of 0 in arr[low..high], otherwise returns -1 */
		int firstZero(int arr[], int low, int high) 
		{
			if (high >= low) 
			{
				// Check if mid element is first 0
				int mid = low + (high - low) / 2;
				if ((mid == 0 || arr[mid - 1] == 1) && arr[mid] == 0)
					return mid;

				if (arr[mid] == 1) // If mid element is not 0
					return firstZero(arr, (mid + 1), high);
				else // If mid element is 0, but not first 0
					return firstZero(arr, low, (mid - 1));
			}
			return -1;
		}

		// A wrapper over recursive function firstZero()
		int countZeroes(int arr[], int n) 
		{
			// Find index of first zero in given array
			int first = firstZero(arr, 0, n - 1);

			// If 0 is not present at all, return 0
			if (first == -1)
				return 0;

			return (n - first);
		}

		// Driver program to test above functions
		public static void main(String[] args) 
		{
			Arrays4FirstZeroe count = new Arrays4FirstZeroe();
			int arr[] = {1, 1, 1, 0, 0, 0, 0, 0};
			int n = arr.length;
			System.out.println("Count of zeroes is " + count.countZeroes(arr, n));
		}
	}

package dataStructures.dataStructureAlgorithms.Arrays.problems;


//K-th Element of Two Sorted Arrays

//Given two sorted arrays of size m and n respectively, you are tasked with finding the element that would be at the k’th position of the final sorted array.
//
//Examples: 
//
//Input : Array 1 - 2 3 6 7 9
//      Array 2 - 1 4 8 10
//      k = 5
//Output : 6
//Explanation: The final sorted array would be -
//1, 2, 3, 4, 6, 7, 8, 9, 10
//The 5th element of this array is 6.
//
//Input : Array 1 - 100 112 256 349 770
//      Array 2 - 72 86 113 119 265 445 892
//      k = 7
//Output : 256
//Explanation: Final sorted array is -
//72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892
//7th element of this array is 256.


public class Arrays3KthElementOfTwoSortedArrays {
	// Driver Code
  public static void main (String[] args) 
  {
      int arr1[] = {2, 3, 6, 7, 9};
      int arr2[] = {1, 4, 8, 10};
      int k = 5;
      System.out.print(kth(arr1, arr2, 5, 4, k));
  }

	private static int kth(int arr1[], int arr2[], int m, int n, int k)
  {
      int[] sorted1 = new int[m + n];
      int i = 0, j = 0, d = 0;
      while (i < m && j < n)
      {
      	if (d == k) {
              System.out.println("inside while loop");
              return sorted1[k - 1];
      	}
          if (arr1[i] < arr2[j])
              sorted1[d++] = arr1[i++];
          else
              sorted1[d++] = arr2[j++];
      }
      while (i < m)
          sorted1[d++] = arr1[i++];
      while (j < n)
          sorted1[d++] = arr2[j++];
      return sorted1[k - 1];
  }

}

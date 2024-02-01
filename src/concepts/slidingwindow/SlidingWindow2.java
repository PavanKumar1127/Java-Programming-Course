package concepts.slidingWindow;

import java.util.LinkedList;

//First negative integer in every window of size k

public class SlidingWindow2 {
	
	public static void main(String[] args) {
		long[] input = {-12, -1, -7, 8, -15, 30, 16, 28};
		int N = 8;
		int K = 2;
		System.out.println(printFirstNegativeInteger(input, N, K));
	}
	
	public static long[] printFirstNegativeInteger(long A[], int N, int K)
    {

        int i = 0;
        int j = 0;
        LinkedList<Long> negative = new LinkedList<Long>(); 
        long[] result = new long[N-K+1];
        int k = 0;
        while(j<N){
            if(A[j]<0){
                negative.add(A[j]);
            }
            if(j - i + 1 == K){
                if(negative != null && negative.size()>0){
                    result[k] = (long) negative.getFirst();
                } else {
                    result[k] = 0;
                }
                k++;
                if(A[i]<0 && negative != null){
                    negative.removeFirst();
                }
                i++;
            }
            j++;
        }
        return result;
        
    }

}


//Given an array A[] of size N and a positive integer K, find the first negative integer for each and every window(contiguous subarray) of size K.

//Example 1:
//
//Input : 
//N = 5
//A[] = {-8, 2, 3, -6, 10}
//K = 2
//Output : 
//-8 0 -6 -6
//Explanation :
//First negative integer for each window of size k
//{-8, 2} = -8
//{2, 3} = 0 (does not contain a negative integer)
//{3, -6} = -6
//{-6, 10} = -6
// 
//Example 2:
//Input : 
//N = 8
//A[] = {12, -1, -7, 8, -15, 30, 16, 28}
//K = 3
//Output :
//-1 -1 -7 -15 -15 0 
// 
//
//Your Task:  
//You don't need to read input or print anything. Your task is to complete the function printFirstNegativeInteger() which takes the array A[], its size N and an integer K as inputs and returns the first negative number in every window of size K starting from the first till the end. If a window does not contain a negative integer , then return 0 for that window.
//
//
//Expected Time Complexity: O(N)
//Expected Auxiliary Space: O(K)
//
//Constraints:
//1 <= N <= 105
//-105 <= A[i] <= 105
//1 <= K <= N
package strivers.DSA.arrays;
import java.util.HashMap;
import java.util.Map;

public class GfGLargestSubarrayWith_0_Sum {
    int maxLen(int arr[], int n) {
        // Create a HashMap to store the cumulative sum and its first occurrence index
        Map<Integer, Integer> HMp = new HashMap<>();
        
        // Initialize sum and maxLen
        int sum = 0;
        int maxLen = 0;
        
        // Traverse the array
        for (int i = 0; i < n; i++) {
            // Add the current element to the cumulative sum
            sum += arr[i];
            
            // If the sum is 0, update maxLen to the maximum value between current maxLen and i+1
            if (sum == 0) {
                maxLen = Math.max(maxLen, i + 1);
            }
            // If the sum is found in the map, it means there is a subarray with sum 0
            else if (HMp.containsKey(sum)) {
                maxLen = Math.max(i - HMp.get(sum), maxLen);
            }
            // If the sum is not found, store the sum with its index
            else {
                HMp.put(sum, i);
            }
        }
        
        // Return the length of the largest subarray with sum 0
        return maxLen;
    }

    public static void main(String[] args) {
    	GfGLargestSubarrayWith_0_Sum gfg = new GfGLargestSubarrayWith_0_Sum();
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        int n = arr.length;
        System.out.println("Length of the largest subarray with 0 sum: " + gfg.maxLen(arr, n));
        // Output should be 5
    }
}

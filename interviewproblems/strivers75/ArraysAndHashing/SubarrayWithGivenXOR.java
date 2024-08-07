package strivers75.ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithGivenXOR {
    
    public static int subarrayWithGivenXOR(int[] nums, int X) {
        // Initialize the hashmap to store XOR frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        int xorSum = 0; // Variable to keep the running XOR
        int count = 0;  // Variable to keep the count of subarrays with given XOR
        
        for (int num : nums) {
            // Update xorSum with the current element
            xorSum ^= num;
            
            // If xorSum equals X, increment count
            if (xorSum == X) {
                count++;
            }
            
            // Check if xorSum ^ X exists in the hashmap
            int requiredXor = xorSum ^ X;
            if (freqMap.containsKey(requiredXor)) {
                count += freqMap.get(requiredXor);
            }
            
            // Update the frequency of xorSum in the hashmap
            freqMap.put(xorSum, freqMap.getOrDefault(xorSum, 0) + 1);
        }
        
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 2, 2, 6, 4};
        int X1 = 6;
        System.out.println("Subarrays with XOR " + X1 + ": " + subarrayWithGivenXOR(nums1, X1)); // Output: 4
        
        int[] nums2 = {5, 6, 7, 8, 9};
        int X2 = 5;
        System.out.println("Subarrays with XOR " + X2 + ": " + subarrayWithGivenXOR(nums2, X2)); // Output: 2
        
        int[] nums3 = {1, 2, 3, 4};
        int X3 = 4;
        System.out.println("Subarrays with XOR " + X3 + ": " + subarrayWithGivenXOR(nums3, X3)); // Output: 1
    }
}

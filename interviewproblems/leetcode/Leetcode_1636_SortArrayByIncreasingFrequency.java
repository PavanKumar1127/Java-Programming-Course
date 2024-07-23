package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class Leetcode_1636_SortArrayByIncreasingFrequency {
    
    public static int[] frequencySort(int[] nums) {
        // Step 1: Count the frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Sort the numbers based on the frequency and value
        List<Integer> sortedList = Arrays.stream(nums)
            .boxed()
            .sorted((a, b) -> {
                int freqCompare = Integer.compare(frequencyMap.get(a), frequencyMap.get(b));
                if (freqCompare != 0) {
                    return freqCompare;
                } else {
                    return Integer.compare(b, a); // Sort by value in decreasing order
                }
            })
            .collect(Collectors.toList());
        
        // Step 3: Convert the sorted list back to an array
        int[] sortedArray = sortedList.stream().mapToInt(Integer::intValue).toArray();
        return sortedArray;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 3};
        System.out.println("Original Array: " + Arrays.toString(arr));
        
        int[] sortedArray = frequencySort(arr);
        
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
    }
}

// Approach:
// We use a HashMap to count the frequency of each element in the array. We then sort the array using a custom comparator
// that first sorts by frequency in increasing order and then by value in decreasing order if frequencies are the same.
// The sorted array is then constructed and returned.
//
// Time Complexity: O(n log n)
// Counting the frequency of elements takes O(n), and sorting the array takes O(n log n).
// Space Complexity: O(n)
// We use additional space for the frequency map and for sorting the array.

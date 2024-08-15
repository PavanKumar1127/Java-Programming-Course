package leetcode;

import java.util.PriorityQueue;

// Kth Largest Element in a Stream
// https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
public class Leetcode_703_KthLargestElementInAStream {
    
    // Min-heap to store the K largest elements in the stream
    private PriorityQueue<Integer> minHeap;
    private int k;

    // Constructor initializes the min-heap and adds the initial elements of the stream
    public Leetcode_703_KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(k);
        
        for (int num : nums) {
            add(num);  // Add each element to the stream
        }
    }

    // Adds a new element to the stream and returns the Kth largest element
    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);  // If the heap has less than k elements, add the new element
        } else if (val > minHeap.peek()) {
            minHeap.poll();  // Remove the smallest element
            minHeap.offer(val);  // Add the new element
        }
        
        // The Kth largest element is at the root of the min-heap
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4, 5, 8, 2};
        Leetcode_703_KthLargestElementInAStream kthLargest = new Leetcode_703_KthLargestElementInAStream(k, arr);

        System.out.println(kthLargest.add(3));  // Output: 4
        System.out.println(kthLargest.add(5));  // Output: 5
        System.out.println(kthLargest.add(10)); // Output: 5
        System.out.println(kthLargest.add(9));  // Output: 8
        System.out.println(kthLargest.add(4));  // Output: 8
    }
}

// Given an integer array nums and an integer k, design a class that simulates the process of finding the kth largest 
// element in a stream. The class should have the following functions:
// - Constructor: Initializes the object with the integer k and the stream of integers nums.
// - int add(int val): Adds a new integer to the stream and returns the kth largest element in the stream.
//
// Example 1:
// 
// Input: k = 3, nums = [4,5,8,2], val = 3
// Output: 4
// 
// Input: k = 3, nums = [4,5,8,2], val = 5
// Output: 5
// 
// Input: k = 3, nums = [4,5,8,2], val = 10
// Output: 5
// 
// Input: k = 3, nums = [4,5,8,2], val = 9
// Output: 8
// 
// Input: k = 3, nums = [4,5,8,2], val = 4
// Output: 8
//
// Constraints:
//
// - The number of elements in nums will be in the range [0, 10^4].
// - -10^4 <= nums[i] <= 10^4
// - -10^4 <= val <= 10^4
// - 1 <= k <= 10^4
// - It is guaranteed that there will be at least k elements in the stream when add is called.

// Approach:
// We use a min-heap (priority queue) to maintain the K largest elements from the stream of numbers.
// - The size of the heap is maintained at exactly K.
// - When a new element is added, we compare it with the smallest element in the heap (the root of the heap).
// - If the new element is larger than the smallest element, it replaces the smallest element in the heap.
// - The Kth largest element in the stream will always be the root of the heap.
//
// Time Complexity: O(n log k) where n is the number of initial elements in the stream, and each add operation takes O(log k).
// Space Complexity: O(k) since the heap contains at most K elements.

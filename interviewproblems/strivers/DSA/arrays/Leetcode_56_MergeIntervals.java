package strivers.DSA.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Merge Intervals
// https://leetcode.com/problems/merge-intervals/
//
// Given an array of intervals where intervals[i] = [start_i, end_i], merge all overlapping intervals,
// and return an array of the non-overlapping intervals that cover all the intervals in the input.
//
// Example 1:
// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
//
// Example 2:
// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
//
// Constraints:
// - 1 <= intervals.length <= 10^4
// - intervals[i].length == 2
// - 0 <= start_i <= end_i <= 10^4
//
// Approach:
// 1. First, sort the intervals by their start time. This ensures that every interval is either disjoint from
//    or overlapping with the previous one.
// 2. Initialize an empty list to store merged intervals.
// 3. Iterate through the sorted intervals and merge them if they overlap; otherwise, add the interval to the list.
// 4. Return the list of merged intervals.
//
// Time Complexity: O(n log n)
// The time complexity is dominated by the sorting step, which takes O(n log n) time. The merging process itself is O(n).
// Space Complexity: O(n)
// The additional space complexity is O(n) for storing the merged intervals.

public class Leetcode_56_MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        // Step 1: Sort the intervals by their start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Initialize a list to store merged intervals
        List<int[]> mergedIntervals = new ArrayList<>();

        // Step 3: Iterate through the intervals
        for (int[] interval : intervals) {
            // If the mergedIntervals list is empty or the current interval does not overlap with the previous, add it to the list
            if (mergedIntervals.isEmpty() || mergedIntervals.get(mergedIntervals.size() - 1)[1] < interval[0]) {
                mergedIntervals.add(interval);
            } else {
                // Otherwise, there is overlap, so we merge the current interval with the previous one
                mergedIntervals.get(mergedIntervals.size() - 1)[1] = Math.max(mergedIntervals.get(mergedIntervals.size() - 1)[1], interval[1]);
            }
        }

        // Step 4: Convert the list to an array and return
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("Merged Intervals: " + Arrays.deepToString(merge(intervals1)));
        // Output: [[1, 6], [8, 10], [15, 18]]

        int[][] intervals2 = {{1, 4}, {4, 5}};
        System.out.println("Merged Intervals: " + Arrays.deepToString(merge(intervals2)));
        // Output: [[1, 5]]
    }
}

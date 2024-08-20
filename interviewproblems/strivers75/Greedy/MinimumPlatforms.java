package strivers75.Greedy;

import java.util.Arrays;

// Minimum Platforms problem
public class MinimumPlatforms {

    // Method to find the minimum number of platforms required
    public static int findPlatform(int[] arr, int[] dep, int n) {
        // Sort the arrival and departure times
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        // Initialize variables to keep track of platforms needed and max platforms required
        int platforms_needed = 1;
        int max_platforms = 1;
        int i = 1, j = 0;

        // Traverse arrival and departure arrays
        while (i < n && j < n) {
            // If the next train arrives before the last one departs, we need more platforms
            if (arr[i] <= dep[j]) {
                platforms_needed++;
                i++;
            } 
            // If the next train departs before the new one arrives, we can reduce platforms
            else {
                platforms_needed--;
                j++;
            }
            // Track the maximum number of platforms needed at any time
            max_platforms = Math.max(max_platforms, platforms_needed);
        }

        return max_platforms; // Return the maximum platforms required
    }

    public static void main(String[] args) {
        int n = 6;
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};

        System.out.println("Minimum platforms needed: " + findPlatform(arr, dep, n));
        // Output: 3
    }
}

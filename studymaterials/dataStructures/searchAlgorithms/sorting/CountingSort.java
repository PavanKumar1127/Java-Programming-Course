package dataStructures.searchAlgorithms.sorting;
class CountingSort {
    public int[] sortArray(int[] nums) {
        // Create a counting array large enough to cover the range from -50000 to 50000
        int[] arr = new int[100001];
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        
        // Populate the counting array and track the min and max values
        for (int i : nums) {
            int x = 50000 + i; // Shift value to handle negative indices
            arr[x]++;
            if (min > x)
                min = x;
            if (max < x)
                max = x;
        }
        
        // Reconstruct the sorted array
        int k = nums.length - 1; // Index to place sorted elements
        for (int i = max; i >= min; i--) { // Traverse from max to min for descending order
            if (arr[i] == 0)
                continue;
            int len = arr[i];
            while (len-- > 0)
                nums[k--] = i - 50000; // Place the element in the original array
        }
        
        return nums;
    }

    public static void main(String[] args) {
        CountingSort solution = new CountingSort();
        
        // Example 1
        int[] nums1 = {4, 2, 2, 8, 3, 3, 1};
        System.out.println("Original Array: " + java.util.Arrays.toString(nums1));
        int[] sorted1 = solution.sortArray(nums1);
        System.out.println("Sorted Array: " + java.util.Arrays.toString(sorted1));
        // Expected Output: [1, 2, 2, 3, 3, 4, 8]

        // Example 2
        int[] nums2 = {5, 1, 1, 2, 0, 0};
        System.out.println("Original Array: " + java.util.Arrays.toString(nums2));
        int[] sorted2 = solution.sortArray(nums2);
        System.out.println("Sorted Array: " + java.util.Arrays.toString(sorted2));
        // Expected Output: [0, 0, 1, 1, 2, 5]

        // Example 3
        int[] nums3 = {110, 100, 0, -50000, 50000};
        System.out.println("Original Array: " + java.util.Arrays.toString(nums3));
        int[] sorted3 = solution.sortArray(nums3);
        System.out.println("Sorted Array: " + java.util.Arrays.toString(sorted3));
        // Expected Output: [-50000, 0, 100, 110, 50000]

        // Example 4: Edge Case
        int[] nums4 = {1};
        System.out.println("Original Array: " + java.util.Arrays.toString(nums4));
        int[] sorted4 = solution.sortArray(nums4);
        System.out.println("Sorted Array: " + java.util.Arrays.toString(sorted4));
        // Expected Output: [1]

        // Example 5: Edge Case with Negative and Positive Numbers
        int[] nums5 = {-3, -1, -2, 0, 1, 2, 3};
        System.out.println("Original Array: " + java.util.Arrays.toString(nums5));
        int[] sorted5 = solution.sortArray(nums5);
        System.out.println("Sorted Array: " + java.util.Arrays.toString(sorted5));
        // Expected Output: [-3, -2, -1, 0, 1, 2, 3]
    }
}

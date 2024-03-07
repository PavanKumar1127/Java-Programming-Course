package leetcode;

//Peak Index in a Mountain Array

public class Leetcode_852_PeakIndexInMountainArray {

	// driver class
	public static void main(String[] args) {
		int[] arr = { 0, 10, 5, 2 };
		System.out.println(peakIndexInMountainArray(arr));
	}

	public static int peakIndexInMountainArray(int[] arr) {
		int l = 0, r = arr.length - 1;

		while (l < r) {
			int mid = l + (r - l) / 2;

			// condition 1: when the element at 'mid' is larger than both of its adjacent
			// elements, we return the index 'mid'.
			if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
				return mid;
			}
			// condition 2: when the element at mid is larger than element of the right but
			// not larger than the element on the left, we set l = mid, so the new mid will
			// come from new l and r.
			if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
				l = mid;
			}

			// condition 3: when the element at mid is larger than element of the left but
			// not larger than the element on the right, we set r = mid, so the new mid will
			// come from new r and l.
			if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1]) {
				r = mid;
			}
		}
		return 0;
	}
}

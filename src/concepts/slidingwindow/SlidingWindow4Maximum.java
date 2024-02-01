package concepts.slidingWindow;

import java.util.*;

public class SlidingWindow4Maximum {

	// Driver's code
	public static void main(String args[]) {
		int arr[] = { 1, 2, 3, 4, 2,1,6, 0, 7, 8, 9, 10 };
		int K = 3;

		printMax(arr, arr.length, K);
		System.out.println(maxSlidingWindow1(arr, K));
//        List<Integer> result = maxSlidingWindow(arr, K);
//        
//        // Print the results
//        for (int num : result) {
//            System.out.print(num + " ");
//        }
		// Function call
		System.out.println(printKMax(arr, arr.length, K));
	}
	
	
    // A Dequeue (Double ended queue)
    // based method for printing
    // maximum element of
    // all subarrays of size K
    static void printMax(int arr[], int N, int K)
    {
 
        // Create a Double Ended Queue, Qi
        // that will store indexes of array elements
        // The queue will store indexes of
        // useful elements in every window and it will
        // maintain decreasing order of values
        // from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()]
        // are sorted in decreasing order
        Deque<Integer> Qi = new LinkedList<Integer>();
 
        /* Process first k (or first window)
        elements of array */
        int i;
        for (i = 0; i < K; ++i) {
 
            // For every element, the previous
            // smaller elements are useless so
            // remove them from Qi
            while (!Qi.isEmpty()
                   && arr[i] >= arr[Qi.peekLast()])
 
                // Remove from rear
                Qi.removeLast();
 
            // Add new element at rear of queue
            Qi.addLast(i);
        }
 
        // Process rest of the elements,
        // i.e., from arr[k] to arr[n-1]
        for (; i < N; ++i) {
 
            // The element at the front of the
            // queue is the largest element of
            // previous window, so print it
            System.out.print(arr[Qi.peek()] + " ");
 
            // Remove the elements which
            // are out of this window
            while ((!Qi.isEmpty()) && Qi.peek() <= i - K)
                Qi.removeFirst();
 
            // Remove all elements smaller
            // than the currently
            // being added element (remove
            // useless elements)
            while ((!Qi.isEmpty())
                   && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();
 
            // Add current element at the rear of Qi
            Qi.addLast(i);
        }
 
        // Print the maximum element of last window
        System.out.print(arr[Qi.peek()]);
    }
	
	
	//using Set:
	 // Function to find the maximum element in each sliding
    // window of size k
    static int[] maxSlidingWindow1(int[] arr, int k)
    {
        int n = arr.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> maxInWindow = new ArrayDeque<>();
 
        // Initialize maxInWindow with the first k elements
        for (int i = 0; i < k; i++) {
            while (!maxInWindow.isEmpty()
                   && arr[i]
                          >= arr[maxInWindow.peekLast()]) {
                maxInWindow.removeLast();
            }
            maxInWindow.addLast(i);
        }
 
        // The maximum element in the first window
        ans[0] = arr[maxInWindow.peekFirst()];
 
        // Process the remaining elements
        for (int i = k; i < n; i++) {
            // Remove elements that are out of the current
            // window
            while (!maxInWindow.isEmpty()
                   && maxInWindow.peekFirst() <= i - k) {
                maxInWindow.removeFirst();
            }
 
            // Remove elements that are not needed in the
            // current window
            while (!maxInWindow.isEmpty()
                   && arr[i]
                          >= arr[maxInWindow.peekLast()]) {
                maxInWindow.removeLast();
            }
 
            maxInWindow.addLast(i);
            ans[i - k + 1] = arr[maxInWindow.peekFirst()];
        }
 
        return ans;
    }
	
	
	

	// using Max-Heap:
	public static List<Integer> maxSlidingWindow(int[] arr, int k) {
		List<Integer> ans = new ArrayList<>();
		PriorityQueue<Pair> heap = new PriorityQueue<>((a, b) -> b.value - a.value);

// Initialize the heap with the first k elements
		for (int i = 0; i < k; i++) {
			heap.offer(new Pair(arr[i], i));
		}

// The maximum element in the first window
		ans.add(heap.peek().value);

// Process the remaining elements
		for (int i = k; i < arr.length; i++) {
			heap.offer(new Pair(arr[i], i));

// Remove elements that are outside the current
// window
			while (heap.peek().index <= i - k) {
				heap.poll();
			}

// The maximum element in the current window
			ans.add(heap.peek().value);
		}

		return ans;
	}

	static class Pair {
		int value;
		int index;

		public Pair(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}

	// basic brute force approach
	// the list of elements are iterated till length - k, and the maximum of the K
	// no of elements are taken using inner for loop
	private static LinkedList<Integer> printKMax(int[] arr, int length, int k) {
		int j;
		int max;
		LinkedList<Integer> answer = new LinkedList<Integer>();
		for (int i = 0; i < length - k; i++) {
			max = arr[i];
			for (j = 1; j < k; j++) {
				if (arr[i + j] > max) {
					max = arr[i + j];
				}
			}
			answer.add(max);
		}
		return answer;
	}
	// Time Complexity: O(N * K), The outer loop runs N-K+1 times and the inner loop
	// runs K times for every iteration of the outer loop. So time complexity is
	// O((n-k+1)*k) which can also be written as O(N * K)
//	Auxiliary Space: O(1)
}

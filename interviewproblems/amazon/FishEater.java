package amazon;

import java.util.Stack;

public class FishEater {

    public static int countSurvivingFishes(int[] fishes) {
        Stack<Integer> stack = new Stack<>();
        for (int fish : fishes) {
            while (!stack.isEmpty() && fish > stack.peek()) {
                stack.pop();
            }
            stack.push(fish);
        }
        return stack.size();
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {4, 2, 3, 1, 5},
            {1, 2, 3, 4, 5},
            {5, 4, 3, 2, 1}
        };

        for (int[] testCase : testCases) {
            System.out.println(countSurvivingFishes(testCase));
        }
    }
	
}


//Problem statement
//There is a river which flows in one direction. One day, the river has 'N' number of fishes. You are given an array 'FISHES' of integers representing the size of 'N' fishes. The fishes are present in the river from left to right(0th index represents the size of the leftmost fish). As the river flows from left to right so the fishes also swim from left to right. The fishes are of different sizes and have different speeds. The larger fishes are faster than the smaller fishes. Also, larger fishes can eat smaller fishes but can’t eat fishes of the same size.
//
//Can you find the number of fishes that survive at the end of the day?
//
//Example:
//Let the size of fishes present in the river from left to right be{ 4, 2, 3, 1, 5 }.
//
//1. As fish 4 is faster and bigger than fish 2, so fish 4 will eat fish 2.
//    Remaining fishes: { 4, 3, 1, 5 }
//
//2. As fish 3 is faster and bigger than fish 1, so fish 3 will eat fish 1.
//    Remaining fishes: { 4, 3, 5 }
//
//3. As fish 4 is faster and bigger than fish 3, so fish 4 will eat fish 3.
//    Remaining fishes: { 4, 5 }
//
//Now fish 5 cannot eat fish 4, as fish 5 is faster than fish 4 and they swim from left to right. Thus, fish 4 will never reach fish 5.
//
//Finally, we are left with only 2 fishes.
//Input Format:
//The first line of input contains an integer ‘T’ denoting the number of test cases.
//
//The first line of each test case contains an integer ‘N’ denoting the number of fishes.
//
//The second line of each test case contains 'N' single space-separated integers representing the size of the fishes.
//Output Format :
//For each test case, return the number of fishes that survives till last.
//Note:
//You don't need to print anything, it has already been taken care of. Just implement the given function.
//Constraints:
//1 <= T <= 10
//1 <= N <= 10^4
//1 <= FISHES[i] <= 10^9
//
//Where 'FISHS[i]' denotes the size of the ith fish in the river.
//
//Time limit: 1 sec

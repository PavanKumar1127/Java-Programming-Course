package amazon;
public class CoinChange {

    public static int waysToMakeChange(int[] denominations, int value) {
        int n = denominations.length;
        int[] dp = new int[value + 1];
        dp[0] = 1;

        for (int denom : denominations) {
            for (int i = denom; i <= value; i++) {
                dp[i] += dp[i - denom];
            }
        }

        return dp[value];
    }
    
    public static void main(String[] args) {
        // Test case
        int[] denominations = {1, 2, 5};
        int value = 5;
        System.out.println(waysToMakeChange(denominations, value));
    }

    // Problem Statement:
    /*
    Ways To Make Coin Change
    You are given an infinite supply of coins of each of denominations D = {D0, D1, D2, D3, ...... Dn-1}.
    You need to figure out the total number of ways W, in which you can make a change for value V using coins of denominations from D.
    Print 0, if a change isn't possible.

    Input Format:
    The first line of input contains an integer N, representing the total number of denominations.
    The second line of input contains N integers values separated by a single space.
    Each integer value represents the denomination value.
    The third line of input contains the value of V, representing the value for which the change needs to be generated.

    Output Format:
    For each test case, print an integer denoting the total number of ways W, in which a change for V is possible.

    Note:
    You do not need to print anything, it has already been taken care of. Just implement the given function.

    Constraints :
    1 <= N <= 10
    1 <= D[i] <=10^5
    1 <= V <= 2 * 10^3
    Where 'D[i]' represent the value of ith denomination.
    Time Limit: 1sec
    */

    // Example:
    /*
    Sample Input:
    3
    1 2 5
    5

    Sample Output:
    4

    Explanation:
    The possible ways to make a change for value 5 using coins of denominations {1, 2, 5} are:
    - {1, 1, 1, 1, 1}
    - {1, 1, 1, 2}
    - {1, 2, 2}
    - {5}
    */
}

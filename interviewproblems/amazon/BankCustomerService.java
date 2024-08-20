package amazon;
/**
 * Problem: Bank Customer Service
 * 
 * A bank starts with an initial amount of money. An array represents transactions 
 * from customers, where each transaction is either a deposit (negative value) or 
 * a withdrawal (positive value). The bank can start serving customers from any 
 * transaction index, but once it starts, it must continue serving every subsequent 
 * customer in the array. The goal is to find out the maximum number of customers 
 * the bank can serve without running out of money.
 * 
 * Example 1:
 * Bank has 1 unit of money initially.
 * Customer transactions: [1, -3, 5, -2, 1]
 * Answer = 3 (Serve customers at indices 0, 2, and 3)
 * 
 * Example 2:
 * Bank has 4 units of money initially.
 * Customer transactions: [3, 1, 1, 1, 1]
 * Answer = 5 (Serve all customers)
 * 
 * Approach:
 * 1. Iterate through the transactions array while maintaining a running balance.
 * 2. Track the number of customers served using a counter.
 * 3. If at any point the balance becomes negative, reset the counters and start over 
 *    from the next index.
 * 4. Keep track of the maximum number of customers served during this process.
 * 
 * Time Complexity: O(n)
 * - We iterate through the transactions array once.
 * 
 * Space Complexity: O(1)
 * - Only a few integer variables are used for tracking the balance, counters, and maximum.
 */

public class BankCustomerService {

    /**
     * Function to determine the maximum number of customers that can be served
     * without running out of money.
     *
     * @param initialMoney  The initial amount of money the bank has.
     * @param transactions  The array of customer transactions.
     * @return              The maximum number of customers that can be served.
     */
    public static int maxCustomersServed(int initialMoney, int[] transactions) {
        int maxCustomers = 0;  // To track the maximum customers served
        int currentMoney = initialMoney;  // To track the current balance
        int currentCustomers = 0;  // To track the number of customers served in the current run
        
        // Iterate through each transaction in the array
        for (int i = 0; i < transactions.length; i++) {
            // Update the current balance based on the transaction
            currentMoney += transactions[i];
            
            // Check if the current balance is non-negative
            if (currentMoney >= 0) {
                currentCustomers++;  // Increment the count of customers served
                // Update the maximum customers served if the current count is higher
                maxCustomers = Math.max(maxCustomers, currentCustomers);
            } else {
                // If the balance goes negative, reset the counters and restart
                currentMoney = initialMoney;  // Reset the current balance to the initial money
                currentCustomers = 0;  // Reset the current customer counter
            }
        }
        
        // Return the maximum number of customers served
        return maxCustomers;
    }

    public static void main(String[] args) {
        int initialMoney1 = 1;
        int[] transactions1 = {1, -3, 5, -2, 1};
        System.out.println("Example 1: " + maxCustomersServed(initialMoney1, transactions1)); // Output: 3

        int initialMoney2 = 4;
        int[] transactions2 = {3, 1, 1, 1, 1};
        System.out.println("Example 2: " + maxCustomersServed(initialMoney2, transactions2)); // Output: 5
    }
}

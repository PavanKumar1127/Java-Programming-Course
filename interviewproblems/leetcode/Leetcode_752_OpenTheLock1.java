package leetcode;

import java.util.*;

public class Leetcode_752_OpenTheLock1 {
    public int openLock(String[] deadends, String target) {

        // Create a set to store the deadends to optimize the search process.
        Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));
        if (deadendSet.contains("0000"))
            return -1; // Check if the starting combination is a deadend

        // Create a queue to perform BFS. Initialize it with the starting combination "0000".
        Queue<String> queue = new LinkedList<>();

        // Create a set to store the visited combinations to avoid duplicates.
        Set<String> visited = new HashSet<>();
        queue.offer("0000");
        visited.add("0000");

        int turns = 0;
        // Perform BFS until the queue is empty.
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                // For each combination in the queue, check if it matches the target
                // combination. If yes, return the number of turns.
                if (current.equals(target))
                    return turns;

                // Otherwise, generate all possible combinations reachable from the current
                // combination by rotating each digit up and down. O(k * 2^k)
                for (int j = 0; j < 4; j++) {
                    for (int k = -1; k <= 1; k += 2) {
                        char[] digits = current.toCharArray();
                        digits[j] = (char) (((digits[j] - '0' + k + 10) % 10) + '0'); // Rotate the digit
                        String next = new String(digits);
                        // Check if each generated combination is not a deadend and has not been visited
                        // before. If so, add it to the queue and mark it as visited.
                        if (!deadendSet.contains(next) && !visited.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                }
            }
            // Repeat steps 4-7 until either the target combination is found or all possible
            // combinations are exhausted.
            turns++;
        }
        return -1; // Target combination cannot be reached
    }

    public static void main(String[] args) {
        Leetcode_752_OpenTheLock1 solution = new Leetcode_752_OpenTheLock1();
        String[] deadends = { "0201", "0101", "0102", "1212", "2002" };
        String target = "0202";
        int minTurns = solution.openLock(deadends, target);
        System.out.println("Minimum turns required: " + minTurns); // Output: Minimum turns required: 6
    }

}

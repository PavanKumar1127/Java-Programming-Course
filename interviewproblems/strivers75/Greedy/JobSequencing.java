package strivers75.Greedy;
import java.util.Arrays;
import java.util.Comparator;

// Job class to represent a job with an id, deadline, and profit
class Job {
    int id, deadline, profit;

    // Constructor
    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {

    // Method to find the maximum number of jobs and the maximum profit
    public static int[] jobScheduling(Job[] jobs, int n) {
        // Sort jobs in descending order of profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Find the maximum deadline to create a slots array
        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }

        // Create a slots array to keep track of free time slots
        int[] slots = new int[maxDeadline + 1];
        Arrays.fill(slots, -1); // -1 indicates an empty slot

        int countJobs = 0;
        int totalProfit = 0;

        // Iterate through each job in the sorted order
        for (Job job : jobs) {
            // Find a free slot for this job starting from its deadline
            for (int j = job.deadline; j > 0; j--) {
                // If the slot is free, schedule the job
                if (slots[j] == -1) {
                    slots[j] = job.id; // Assign job id to the slot
                    countJobs++; // Increment the job count
                    totalProfit += job.profit; // Add to total profit
                    break; // Move to the next job after scheduling
                }
            }
        }

        // Return the number of jobs done and the maximum profit
        return new int[] { countJobs, totalProfit };
    }

    public static void main(String[] args) {
        // Example 1
        Job[] jobs1 = { new Job(1, 4, 20), new Job(2, 1, 10), new Job(3, 1, 40), new Job(4, 1, 30) };
        int[] result1 = jobScheduling(jobs1, jobs1.length);
        System.out.println("Number of jobs done: " + result1[0] + ", Total profit: " + result1[1]);
        // Output: Number of jobs done: 2, Total profit: 60

        // Example 2
        Job[] jobs2 = { new Job(1, 2, 100), new Job(2, 1, 19), new Job(3, 2, 27), new Job(4, 1, 25), new Job(5, 1, 15) };
        int[] result2 = jobScheduling(jobs2, jobs2.length);
        System.out.println("Number of jobs done: " + result2[0] + ", Total profit: " + result2[1]);
        // Output: Number of jobs done: 2, Total profit: 127
    }
}

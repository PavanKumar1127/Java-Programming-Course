package strivers75.Greedy;

import java.util.Arrays;
import java.util.Comparator;

// N meetings in one room problem
public class NMeetingsInOneRoom {

    // Method to find the maximum number of meetings that can be held in one room
    public static int maxMeetings(int[] start, int[] end, int n) {
        // Array to hold pairs of (start time, end time) for each meeting
        Meeting[] meetings = new Meeting[n];
        for (int i = 0; i < n; i++) {
            meetings[i] = new Meeting(start[i], end[i]);
        }

        // Sort meetings by their end time
        Arrays.sort(meetings, Comparator.comparingInt(m -> m.end));

        // Initialize variables to keep track of the count of meetings and end time of the last selected meeting
        int count = 1; // At least one meeting can be held
        int lastEndTime = meetings[0].end;

        // Iterate through the sorted meetings
        for (int i = 1; i < n; i++) {
            // If the start time of the current meeting is greater than the end time of the last selected meeting
            if (meetings[i].start > lastEndTime) {
                count++;
                lastEndTime = meetings[i].end;
            }
        }

        return count; // Return the maximum number of meetings that can be held
    }

    // Helper class to store the start and end times of meetings
    static class Meeting {
        int start;
        int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        int n = start.length;

        System.out.println("Maximum meetings that can be held: " + maxMeetings(start, end, n));
        // Output: 4
    }
}

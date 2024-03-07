package blind75;
import java.util.ArrayList;
import java.util.List;

public class Blind75_19_InsertInterval57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int[] interval = newInterval;

        for (int[] currInterval : intervals) {
            if (currInterval[1] < interval[0]) {
                result.add(currInterval);
            } else if (currInterval[0] > interval[1]) {
                result.add(interval);
                interval = currInterval;
            } else {
                interval[0] = Math.min(interval[0], currInterval[0]);
                interval[1] = Math.max(interval[1], currInterval[1]);
            }
        }

        result.add(interval);

        return result.toArray(new int[result.size()][]);
    }
    
    public static void main(String[] args) {
    	Blind75_19_InsertInterval57 solution = new Blind75_19_InsertInterval57();
        int[][] intervals = {{1, 2}, {3,5}, {6, 7},{8, 10}, {12,16}};//[1,2],[3,5],[6,7],[8,10],[12,16]]
        int[] newInterval = {4,8};
        int[][] mergedIntervals = solution.insert(intervals, newInterval);
        for (int[] interval : mergedIntervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}

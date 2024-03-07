package amazon;
import java.util.*;

public class LongestContinuousPatch {
    public static double longestContinuousPatch(List<String> updates) {
        TreeMap<Double, Double> patches = new TreeMap<>();
        for (String update : updates) {
            String[] parts = update.split(" ");
            double start = Double.parseDouble(parts[2]);
            double end = Double.parseDouble(parts[5]);
            patches.put(start, end);
        }

        double longest = 0;
        double current = 0;
        double prevEnd = 0;

        for (Map.Entry<Double, Double> entry : patches.entrySet()) {
            double start = entry.getKey();
            double end = entry.getValue();
            if (current == 0 || start > prevEnd) {
                current += end - start;
            } else {
                longest = Math.max(longest, current);
                current = end - start;
            }
            prevEnd = end;
        }

        return Math.max(longest, current);
    }

    public static void main(String[] args) {
        List<String> updates = Arrays.asList(
            "Road between 3.2 km to 7.9 km repaired",
            "Road between 1.21 km to 3.2 km repaired",
            "Road between 8.5 km to 9.8 km repaired",
            "Road between 7.9 km to 8.5 km repaired"
        );

        double longestPatch = longestContinuousPatch(updates);
        System.out.println("Longest continuous patch length: " + longestPatch + " km");
    }
}

//There is a 12 km road and a contractor who is in-charge of repairing it. Contractor updates you about the work which is done in patches. Like “Road between 3.2 km to 7.9 km repaired ”, “Road between 1.21 km to 3.2 km repaired”. You have a manager who enquires about the longest continuous patch so far. It was a long discussion and I gave solution in O(nlogn) where n is the number of updates by the contractor
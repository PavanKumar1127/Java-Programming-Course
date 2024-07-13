package dataStructures.dataStructureAlgorithms.Arrays;
import java.util.*;

class CountLetters {
    public int countLetters(String S) {
        int n = S.length();
        int[] f = new int[n];
        Arrays.fill(f, 1);

        for (int i = 1; i < n; ++i) {
            if (S.charAt(i) == S.charAt(i - 1)) {
                f[i] = f[i - 1] + 1;
            }
        }

        return Arrays.stream(f).sum();
    }

    public static void main(String[] args) {
    	CountLetters sol = new CountLetters();
        System.out.println(sol.countLetters("aaaba")); // Output: 8
    }
}

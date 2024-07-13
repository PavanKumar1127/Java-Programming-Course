package leetcode;
public class CountAndSaySolution {

    public static String countAndSay(int n) {
        if (n == 1)
            return "1";

        String strToCount = countAndSay(n - 1);
        StringBuilder ret = new StringBuilder();

        int count = 1;
        for (int i = 1; i <= strToCount.length(); ++i) {
            if (i == strToCount.length() || strToCount.charAt(i) != strToCount.charAt(i - 1)) {
                ret.append(count).append(strToCount.charAt(i - 1));
                count = 1;
            } else {
                count++;
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(countAndSay(n)); // Output: 21
    }
}

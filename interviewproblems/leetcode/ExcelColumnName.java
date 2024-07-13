package leetcode;
public class ExcelColumnName {

    public static String getColumnName(int columnNumber) {
        StringBuilder columnName = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--; // Adjust because Excel columns are 1-indexed
            int remainder = columnNumber % 26;
            columnName.insert(0, (char) (remainder + 'A'));
            columnNumber /= 26;
        }

        return columnName.toString();
    }

    public static void main(String[] args) {
        System.out.println(getColumnName(1));    // Output: A
        System.out.println(getColumnName(28));   // Output: AB
        System.out.println(getColumnName(701));  // Output: ZY
        System.out.println(getColumnName(703));  // Output: AAA
    }
}

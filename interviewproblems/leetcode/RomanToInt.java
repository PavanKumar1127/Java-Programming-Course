package leetcode;
import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public int romanToInt(String s) {
        // Map to store Roman numerals and their corresponding integer values
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int total = 0; // Initialize total to store the final integer value
        int n = s.length(); // Get the length of the string

        for (int i = 0; i < n; i++) {
            // Get the integer value of the current Roman numeral
            int value = romanValues.get(s.charAt(i));
            
            // Check if the next Roman numeral exists and is larger than the current one
            if (i < n - 1 && value < romanValues.get(s.charAt(i + 1))) {
                // If yes, subtract the current value
                total -= value;
            } else {
                // Otherwise, add the current value
                total += value;
            }
        }
        return total; // Return the total integer value
    }

    public static void main(String[] args) {
    	RomanToInt sol = new RomanToInt();
        System.out.println(sol.romanToInt("III"));     // Output: 3
        System.out.println(sol.romanToInt("IV"));      // Output: 4
        System.out.println(sol.romanToInt("IX"));      // Output: 9
        System.out.println(sol.romanToInt("LVIII"));   // Output: 58
        System.out.println(sol.romanToInt("MCMXCIV")); // Output: 1994
    }
}

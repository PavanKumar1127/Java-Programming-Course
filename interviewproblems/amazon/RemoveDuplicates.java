package amazon;

/**
 * Remove duplicated from a string in O(n) without using hash
 */
public class RemoveDuplicates {

	public static String removeDuplicates(String str) {
		if (str == null || str.isEmpty()) {
			return str;
		}

		char[] chars = str.toCharArray();
		// We initialize a boolean array seen of size 256 (assuming ASCII characters) to
		// keep track of characters encountered so far.
		boolean[] seen = new boolean[256]; // Assuming ASCII characters

		int newIndex = 0;
		// iterate through each character in the input string str
		for (int i = 0; i < chars.length; i++) {
			// If the character has not been encountered before (i.e., seen[chars[i]] is
			// false), we append it to the result string and mark it as seen by setting
			// seen[chars[i]] to true.
			if (!seen[chars[i]]) {
				chars[newIndex++] = chars[i];
				seen[chars[i]] = true;
			}
		}

		return new String(chars, 0, newIndex);
	}

	public static void main(String[] args) {
		String input = "TimeTakesTime";
		String result = removeDuplicates(input);
		System.out.println("Original string: " + input);
		System.out.println("String after removing duplicates: " + result);
	}
}

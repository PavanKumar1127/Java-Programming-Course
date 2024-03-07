package concepts.slidingWindow;

public class FindUnique {

	public static void main(String[] args) {
		int[] arr = { 2,2,3,3,4,4,5,5,6,6,7,7,8};
		System.out.println(findUniqueNumber(arr));
	}

	private static int findUniqueNumber(int[] arr) {
		int unique=0;
		for(int num : arr) {
			unique ^= num;
		}
		return unique;
	}
}

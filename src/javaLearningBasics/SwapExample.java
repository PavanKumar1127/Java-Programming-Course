package javaLearningBasics;

/**
 * In Java, since primitive types are passed by value, swapping two primitive
 * values directly within a function is not possible using a method like the one
 * you'd use in languages that support pass-by-reference.
 */
public class SwapExample {

	public static void main(String[] args) {
		int a = 5;
		int b = 10;

		System.out.println("Before swap: a = " + a + ", b = " + b);
		swapIntegers(a, b);
		System.out.println("After swap: a = " + a + ", b = " + b);

		Integer a1 = 5;
		Integer b1 = 10;

		System.out.println("Before swap: a = " + a1 + ", b = " + b1);
		swapIntegers1(a1, b1);
		System.out.println("After swap: a = " + a1 + ", b = " + b1);

		// However, for swapping two values inside a function, you can use an array, or
		// a mutable container class like AtomicInteger (for integers) or a custom
		// class:
		
		int[] arr = {5, 10};

        System.out.println("Before swap: a = " + arr[0] + ", b = " + arr[1]);
        swapIntegers(arr);
        System.out.println("After swap: a = " + arr[0] + ", b = " + arr[1]);
        
        
        MutableInt a2 = new MutableInt(5);
        MutableInt b2 = new MutableInt(10);

        System.out.println("Before swap: a = " + a2.getValue() + ", b = " + b2.getValue());
        swapIntegers(a2, b2);
        System.out.println("After swap: a = " + a2.getValue() + ", b = " + b2.getValue());
	}
	
	public static void swapIntegers(MutableInt x, MutableInt y) {
        int temp = x.getValue();
        x.setValue(y.getValue());
        y.setValue(temp);
    }
	
	public static void swapIntegers(int[] arr) {
        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
    }

	public static void swapIntegers(int x, int y) {
		int temp = x;
		x = y;
		y = temp;

		// In this case, the swapIntegers function won't actually swap the values of a
		// and b because primitive types in Java are passed by value
	}

	public static void swapIntegers1(Integer x, Integer y) {
		Integer temp = x;
		x = y;
		y = temp;

		// Even though we are using Integer objects, the result will be the same. The
		// reason is that the swapIntegers function receives references to Integer
		// objects, but it's swapping the references, not the actual objects. The
		// original variables a and b in the main method won't be affected.
	}
}

class MutableInt {
    private int value;

    public MutableInt(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
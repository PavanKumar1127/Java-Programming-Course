package javaLearningBasics.keywords;
public class Example2FinalParameters {
	void processData(final int value) {
        // Attempting to modify the final parameter will result in a compilation error
        // value = 10; // Compilation error
        System.out.println("Processing data with value: " + value);
    }

    public static void main(String[] args) {
    	Example2FinalParameters obj = new Example2FinalParameters();
        obj.processData(5);
    }
}

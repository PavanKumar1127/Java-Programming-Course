package javaLearningBasics.keywords;
public class Example {
    // Constant declaration
    final int MAX_VALUE = 100;

    public static void main(String[] args) {
        Example obj = new Example();
        // Attempting to modify a final variable will result in a compilation error
        // obj.MAX_VALUE = 200; // Compilation error
        System.out.println(obj.MAX_VALUE);
    }
}

package objectOrientedProgramming.polymorphism;
class MathOperations {
    // Method to add two integers
    int add(int a, int b) {
        return a + b;
    }

    // Method to add three integers
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // Method to concatenate two strings
    String add(String str1, String str2) {
        return str1 + str2;
    }
}

public class CompileTimePolymorphism {
    public static void main(String[] args) {
        MathOperations math = new MathOperations();

        // Overloaded methods
        System.out.println(math.add(2, 3));             // Output: 5
        System.out.println(math.add(2, 3, 4));          // Output: 9
        System.out.println(math.add("Hello", "World")); // Output: HelloWorld
    }
}

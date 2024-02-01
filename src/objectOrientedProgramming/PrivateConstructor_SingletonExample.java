package objectOrientedProgramming;
public class PrivateConstructor_SingletonExample {

    // Private constructor to restrict instantiation from outside
    private PrivateConstructor_SingletonExample() {
        // Initialization code, if any
    }

    // Static method to get the instance of the class
    public static PrivateConstructor_SingletonExample getInstance() {
        return new PrivateConstructor_SingletonExample();
    }

    // Other methods of the class
    public void performOperation() {
        System.out.println("Performing an operation in the PrivateConstructor_SingletonExample");
    }

    public static void main(String[] args) {
        // Attempting to create an instance directly will result in a compilation error
        // PrivateConstructor_SingletonExample instance = new PrivateConstructor_SingletonExample(); // Compilation error

        // Getting an instance using the static method
        PrivateConstructor_SingletonExample instance = PrivateConstructor_SingletonExample.getInstance();
        instance.performOperation();
    }
}

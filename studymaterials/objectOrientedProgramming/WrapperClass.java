package objectOrientedProgramming;

public class WrapperClass {

}

/**
 *Wrapper classes in Java are used to represent primitive data types as objects. There are several reasons why wrapper classes are used:

Object-oriented Conversion:

In Java, everything is treated as an object. However, primitive data types (like int, char, float, etc.) are not objects. Wrapper classes provide a way to convert primitive types into objects, allowing them to be used in an object-oriented context.
Null Values:

Wrapper classes can hold null values, whereas primitive types cannot. This can be useful when dealing with situations where an absence of a value needs to be represented.
Collections Framework:

The Java Collections Framework (e.g., ArrayList, HashMap, etc.) works with objects. If you need to store primitive types in these collections, you would use wrapper classes.

ArrayList<Integer> list = new ArrayList<>();
list.add(42); // Uses Integer wrapper class
Generics:

Generics in Java work with objects. If you need to use a generic type with a primitive, you would use the corresponding wrapper class.

List<Double> doubleList = new ArrayList<>();
doubleList.add(3.14); // Uses Double wrapper class
Methods in Collections API:

Some methods in the Collections API expect objects, not primitives. Wrapper classes provide a way to use primitives in such scenarios.

int intValue = Integer.parseInt("42"); // Conversion using wrapper class method
Type Conversion:

Wrapper classes provide methods for converting between primitive types and strings. For example, the parseInt method of the Integer class can be used to convert a String to an int.

String str = "123";
int intValue = Integer.parseInt(str); // Conversion from String to int
Compatibility with APIs:

Some APIs or libraries might require objects rather than primitives, and using wrapper classes allows for seamless integration with such APIs.

// Example using java.util.concurrent.atomic.AtomicInteger
AtomicInteger atomicInteger = new AtomicInteger(42);
atomicInteger.incrementAndGet();
Reflection API:

The Reflection API often works with classes and objects. If you need to reflect on the types of primitive data, wrapper classes provide a solution.

Class<?> intClass = Integer.TYPE; // Gets the Class object for int
While wrapper classes add a layer of abstraction and incur a slight performance overhead compared to primitives, they provide essential functionality for dealing with objects in a more flexible and object-oriented manner in Java.






 */
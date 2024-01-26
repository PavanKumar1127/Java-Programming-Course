package dailyPractice.day1;

//1 what are control flow statements?
/**
 * In Programming, decision making is just like real life decision making. Just like how we make choices on certain conditions,
 * a computer program makes use of control statements to decide what to do next. These statements control the flow of execution
 * based on specific conditions or situation. Its a way to adapt and respond to different scenarios to make decisions just as real life.
 */

//2 List Java’s Selection statements:
/**
 * If 
 * If Else
 * Nested If
 * If Else If
 * Switch
 */
//break: Used to terminate a loop or switch statement prematurely.
//continue: Skips the rest of the loop's code for the current iteration and moves to the next iteration.
//return: Used to exit a method and can also return a value.

//3 What are the different datatypes, list them with their range
/**
 * data types are category of data stored within a variable.
 * Byte    8  bit (-128 to 127)
 * Short   16 bit (-32k to 32k)
 * Int     32 bit(-2billion to 2 billion)
 * Long    64 bit
 * Float   32 bit
 * Double  64 bit
 * Boolean 1  bit
 * Char    16 bit
 */

//4 What are wrapper class, what is the memory range?
/**
 * Wrapper classes in Java are classes that provide an object representation of primitive data types. 
 * They "wrap" primitive data types into objects. There is a wrapper class for each primitive data type:

Byte:

Primitive type: byte
Wrapper class: Byte
Short:

Primitive type: short
Wrapper class: Short
Integer:

Primitive type: int
Wrapper class: Integer
Long:

Primitive type: long
Wrapper class: Long
Float:

Primitive type: float
Wrapper class: Float
Double:

Primitive type: double
Wrapper class: Double
Character:

Primitive type: char
Wrapper class: Character
Boolean:

Primitive type: boolean
Wrapper class: Boolean
These wrapper classes are part of the java.lang package and provide methods to manipulate and convert the wrapped primitive values.
 */


//5 How is the input output operations performed
/**
 * In Java, input and output operations are performed using java.util.Scanner class for input 
 * and various other classes from java.io packages for output. 
 */

//6 What is looping, explain types with syntax 
/**
 * Looping is a way to repeat a set of instructions as long as certain conditions are true.
 * we have: for, while and do-while loops
 */

//7 What are operators, list all operators
/**
 * Operators are special symbols or keywords that perform certain operatios on the operands, that can be expressions, variables or values.
 */

//8 What is type casting in Java.
/**
 * Type casting is the process of converting a variable of one data type to
 * another. This can be done implicitly by the compiler (automatic type
 * conversion) or explicitly by the programmer (explicit type casting).
 */

//9 why is java not completely object oriented programming language
// Because Java supports 8 primitive data types

//10 What is the difference between == and .equals() for comparing strings in Java?

//Answer: The == operator compares object references, checking if they refer to the same object. 
//The .equals() method is used to compare the content of two strings. check StringsInJava class

//11 Explain the concept of multithreading in Java.
/**
 * Answer: Multithreading in Java allows concurrent execution of two or more threads. 
 * It helps in better resource utilization and responsiveness. Java provides built-in support for multithreading through the Thread class and Runnable interface.
 */

//12 What is the NullPointerException in Java? How can it be avoided?
/**
 * Answer: NullPointerException occurs when you try to access an object or call a method on a null reference. 
 * To avoid it, ensure that you perform proper null checks before accessing objects or invoking methods.
 */

//13 What is the purpose of the finalize() method in Java?
/**
 * : The finalize() method is called by the garbage collector before reclaiming the memory occupied by an object. 
 * It gives an opportunity to perform cleanup operations before the object is garbage collected.
 */

//14 What is the difference between ArrayList and LinkedList in Java?
/**
 * : ArrayList is backed by an array and provides fast random access, 
 * while LinkedList is backed by a doubly-linked list and offers fast insertions and deletions. 
 * ArrayList is more suitable for scenarios requiring frequent access, 
 * and LinkedList is better for scenarios requiring frequent modifications.
 */

//15 Explain the concept of method overloading and method overriding in Java.
/**
 * : Method overloading involves defining multiple methods in the same class with the same name but different parameters. 
 * Method overriding occurs when a subclass provides a specific implementation for a method that is already defined 
 * in its superclass.
 */

//16 What is the super keyword in Java?
/**
 * : The super keyword in Java is a reference variable that is used to refer to the immediate parent class object. 
 * It is used to invoke the parent class methods, access parent class fields, and call the parent class constructor.
 */

//17 What is the purpose of the static keyword in Java?
/**
 * : The static keyword is used to create class-level members (fields or methods) that belong to the class rather than instances of the class. 
 * It allows access to the members without creating an instance of the class.
 */

//18 What is the difference between HashMap and HashTable in Java?
/**
 *  Both HashMap and HashTable implement the Map interface, but HashMap is not synchronized and allows null values, 
 *  while HashTable is synchronized and does not allow null values.
 */

//19

public class Questions {

}

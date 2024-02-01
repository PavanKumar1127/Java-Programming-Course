package objectOrientedProgramming;

/**
 * 
 * In Java, the new keyword is used to create an instance of a class, allocate
 * memory on the heap, and return a reference to that memory. It is primarily
 * used for dynamic memory allocation, where the memory for an object is
 * allocated at runtime.
 */

//Memory Allocation:
//
//When you use new to create an object, Java allocates memory for the object on the heap. The heap is a region of the computer's memory space dedicated to the runtime execution of a program.
//The size of the memory block allocated is determined by the size of the object being created.
//
//
//Initialization:
//
//After memory allocation, the constructor of the class is called to initialize the object. The constructor is a special method that is called when an object is created using the new keyword.
//
//
//Reference Assignment:
//
//The new expression returns a reference to the newly created object. This reference is typically assigned to a variable, allowing you to access and manipulate the object.

public class New_Keyword {

	public static void main(String[] args) {
		// Using new to create an instance of MyClass
		MyClass obj = new MyClass(42);

		// new MyClass(42) dynamically allocates memory for an instance of MyClass on
		// the heap, initializes it with the value 42, and returns a reference (obj) to
		// that memory location.

		// Accessing the object's field
		System.out.println(obj.value); // Output: 42
	}
}

class MyClass {
	int value;

	public MyClass(int value) {
		this.value = value;
	}
}

/**
 * Heap and Stack Memory: 
 * 
 * Heap Memory:
 * 
 * The heap is used for the dynamic allocation of memory at runtime. Objects
 * created using new are stored in the heap. Memory in the heap is managed by
 * the Java Virtual Machine (JVM) garbage collector, which automatically frees
 * up memory that is no longer in use. 
 * 
 * Stack Memory:
 * 
 * The stack is used for storing local variables and method call information.
 * When you create a variable inside a method, it is typically stored in the
 * stack. The memory in the stack is automatically reclaimed when the method
 * exits.
 */

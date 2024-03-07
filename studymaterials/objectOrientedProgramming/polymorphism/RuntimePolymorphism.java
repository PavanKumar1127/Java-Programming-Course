package objectOrientedProgramming.polymorphism;

///Important///

// the object created in the heap memory is of type at, but
// the reference in the stack memory is of type Animal. The
// reference type determines which methods and fields can be
// accessed directly, but the actual object type determines the
// behavior at runtime.

class Animal {
	void makeSound() {
		System.out.println("Generic animal sound");
	}
}

class Cat extends Animal {
	// Overriding method
	void makeSound() {
		System.out.println("Meow");
	}
}

class Dog extends Animal {
	// Overriding method
	void makeSound() {
		System.out.println("Woof");
	}
}

public class RuntimePolymorphism {
	public static void main(String[] args) {
		Animal myCat = new Cat();
		Animal myDog = new Dog();

		// Calls overridden methods
		myCat.makeSound(); // Output: Meow
		myDog.makeSound(); // Output: Woof
	}
}

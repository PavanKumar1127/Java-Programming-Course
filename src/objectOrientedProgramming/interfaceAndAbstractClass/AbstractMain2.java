package objectOrientedProgramming.interfaceAndAbstractClass;

//Animal is an abstract class with abstract methods eat() and makeSound().
//Mammal and Bird extend Animal and provide implementations for the abstract methods.
//Mammal has an additional method run(), and Bird has an additional method fly.
//The Main class demonstrates creating instances of Mammal and Bird, and 

abstract class Animal {
	public abstract void eat();

	public abstract void makeSound();
}

class Mammal extends Animal {
	@Override
	public void eat() {
		System.out.println("Mammal is eating");
	}

	@Override
	public void makeSound() {
		System.out.println("Mammal makes a sound");
	}

	public void run() {
		System.out.println("Mammal is running");
	}
}

class Bird extends Animal {
	@Override
	public void eat() {
		System.out.println("Bird is eating");
	}

	@Override
	public void makeSound() {
		System.out.println("Bird makes a sound");
	}

	public void fly() {
		System.out.println("Bird is flying");
	}
}

public class AbstractMain2 {
	public static void main(String[] args) {
		Mammal dog = new Mammal();
		Bird sparrow = new Bird();

		dog.eat();
		dog.makeSound();
		dog.run();

		sparrow.eat();
		sparrow.makeSound();
		sparrow.fly();

		// doesn't support multiple inheritance through classes (i.e., a class cannot
		// extend more than one class). However, it supports multiple inheritance
		// through interfaces. In the given example, Mammal and Bird showcase multilevel
		// inheritance from the abstract class Animal.

		Animal dog1 = new Mammal(); // Reference of type Animal pointing to a Mammal object

		dog1.eat(); // Mammal is eating
		dog1.makeSound(); // Mammal makes a sound

		// The following line will not compile because the reference type (Animal)
		// doesn't have a run method.
		// dog.run(); // Compilation error

		// The following line will not compile because the reference type (Animal)
		// doesn't have a fly method.
		// ((Mammal) dog).fly(); // Compilation error

//       The reference dog can only access methods and fields declared in the Animal class. It cannot directly access methods or fields specific to the Mammal class (e.g., run()).
		
		
		
		///Important///// the object created in the heap memory is of type Mammal, but
		///////////////// the reference in the stack memory is of type Animal. The
		///////////////// reference type determines which methods and fields can be
		///////////////// accessed directly, but the actual object type determines the
		///////////////// behavior at runtime.

	}
}

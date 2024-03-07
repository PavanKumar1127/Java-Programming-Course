package objectOrientedProgramming.inheritance;

//Parent class
class Animal {
	private String sound; // Private variable

	Animal(String sound) {
		this.sound = sound;
	}

	void makeSound() {
		System.out.println("Animal makes a sound: " + sound);
	}

	void sleep() {
		System.out.println("Animal is sleeping");
	}
}

//Single Inheritance: Dog is a subclass of Animal
class Dog extends Animal {
	Dog() {
		// Use of super keyword to call the parent constructor
		super("Woof");
	}

	// Override the makeSound method
	@Override
	void makeSound() {
		System.out.println("Dog barks: Woof");
	}

	// New method specific to Dog
	void wagTail() {
		System.out.println("Dog wags its tail");
	}

	// Additional behavior
	void fetch() {
		System.out.println("Dog fetches a ball");
	}
}

//Multiple Inheritance: Cat inherits from both Animal and Pet
interface Pet {
	void cuddle();

	// Additional behavior
	void play();
}

class Cat extends Animal {
	Cat() {
		super("Meow");
	}

	// Additional behavior
	void climb() {
		System.out.println("Cat climbs on furniture");
	}
}

class PetCat extends Cat implements Pet {
	PetCat() {
		super();
	}

	@Override
	public void cuddle() {
		System.out.println("Cat loves to cuddle");
	}

	@Override
	public void play() {
		System.out.println("Cat plays with its owner");
	}
}

//Hierarchical Inheritance: Lion and Tiger inherit from Animal
class Lion extends Animal {
	Lion() {
		super("Roar");
	}

	// Additional behavior
	void hunt() {
		System.out.println("Lion hunts for prey");
	}
}

class Tiger extends Animal {
	Tiger() {
		super("Growl");
	}

	// Additional behavior
	void swim() {
		System.out.println("Tiger swims in water");
	}
}

//Hybrid Inheritance: Cheetah inherits from Lion and Tiger
class Cheetah extends Lion {
	Cheetah() {
		super();
	}

	// Additional behavior
	void sprint() {
		System.out.println("Cheetah sprints at high speed");
	}
}

public class InheritanceExample2 {
	public static void main(String[] args) {
		// Single Inheritance
		Dog myDog = new Dog();
		myDog.makeSound(); // Output: Dog barks: Woof
		myDog.wagTail(); // Output: Dog wags its tail
		myDog.fetch(); // Output: Dog fetches a ball
		myDog.sleep(); // Output: Animal is sleeping

		// Multiple Inheritance
		PetCat myPetCat = new PetCat();
		myPetCat.makeSound(); // Output: Cat makes a sound: Meow
		myPetCat.cuddle(); // Output: Pet loves to cuddle
		myPetCat.play(); // Output: Pet plays with its owner
		myPetCat.climb(); // Output: Cat climbs on furniture

		// Hierarchical Inheritance
		Lion myLion = new Lion();
		myLion.makeSound(); // Output: Lion makes a sound: Roar
		myLion.hunt(); // Output: Lion hunts for prey
		myLion.sleep(); // Output: Animal is sleeping

		Tiger myTiger = new Tiger();
		myTiger.makeSound(); // Output: Tiger makes a sound: Growl
		myTiger.swim(); // Output: Tiger swims in water
		myTiger.sleep(); // Output: Animal is sleeping

		// Hybrid Inheritance
		Cheetah myCheetah = new Cheetah();
		myCheetah.makeSound(); // Output: Cheetah makes a sound: Roar
		myCheetah.sprint(); // Output: Cheetah sprints at high speed
		myCheetah.hunt(); // Output: Lion hunts for prey
		myCheetah.sleep(); // Output: Animal is sleeping
	}
}

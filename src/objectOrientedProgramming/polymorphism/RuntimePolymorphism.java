package objectOrientedProgramming.polymorphism;
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

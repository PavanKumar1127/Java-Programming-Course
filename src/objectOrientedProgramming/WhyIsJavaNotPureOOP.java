package objectOrientedProgramming;

/**
 * Pure Object Oriented Language or Complete Object Oriented Language are Fully
 * Object Oriented Language which supports or have features which treats
 * everything inside program as objects. It doesn’t support primitive
 * datatype(like int, char, float, bool, etc.). There are seven qualities to be
 * satisfied for a programming language to be pure Object Oriented. They are:
 * 
 * Encapsulation/Data Hiding
 * Inheritance
 * Polymorphism
 * Abstraction
 * All predefined types are objects
 * All user defined types are objects
 * All operations performed on objects must be only through methods exposed at the objects.
 * 
 * Java supports property 1, 2, 3, 4 and 6 but fails to support property 5 and
 * 7 given above. Java language is not a Pure Object Oriented Language as it
 * contain these properties: 
 * 
 * * Primitive Data Type ex. int, long, bool, float, char, etc as Objects:
 * * The static keyword: When we declares a class as static then it can be used without the use of an object in Java. 
 * * Wrapper Class: Wrapper class provides the mechanism to convert primitive into object and object into primitive.
 */

public class WhyIsJavaNotPureOOP {

	public static void main(String[] args) 
    {
            Integer i = new Integer(10);
            Integer j = new Integer(20);
            Integer k = new Integer(i.intValue() + j.intValue());
            System.out.println("Output: "+ k);
    }
	
	//In the above code, there are 2 problems where Java fails to work as pure OOP:
	//While creating Integer class you are using primitive type “int” i.e. numbers 10, 20.
	//While doing addition Java is using primitive type “int”.
}

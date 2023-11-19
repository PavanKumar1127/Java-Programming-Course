package objectOrientedProgramming;

/**
 * this is a reference variable that refers to the current object on which the
 * method or constructor is being invoked. It can be used to access instance
 * variables and methods of the current object.
 */

//Using the ‘this’ keyword to refer to current class instance variables.
//Using this() to invoke the current class constructor
//Using ‘this’ keyword to return the current class instance 
//Using ‘this’ keyword as the method parameter
//Using ‘this’ keyword to invoke the current class method 
//Using ‘this’ keyword as an argument in the constructor call

//https://www.geeksforgeeks.org/this-reference-in-java/?ref=lbp

/**
 * Disadvantages of using ‘this’ reference Although ‘this’ reference comes with
 * many advantages there are certain disadvantages of also:
 * 
 * Overuse of this can make the code harder to read and understand. Using this
 * unnecessarily can add unnecessary overhead to the program. Using this in a
 * static context results in a compile-time error. Overall, this keyword is a
 * useful tool for working with objects in Java, but it should be used
 * judiciously and only when necessary.
 */
public class This {

}

//Java code for using this as an argument in constructor
//call
//Class with object of Class B as its data member
class A {
	B obj;

	// Parameterized constructor with object of B
	// as a parameter
	A(B obj)
	{
		this.obj = obj;

		// calling display method of class B
		obj.display();
	}
}

class B {
	int x = 5;

	// Default Constructor that create an object of A
	// with passing this as an argument in the
	// constructor
	B() { A obj = new A(this); }

	// method to show value of x
	void display()
	{
		System.out.println("Value of x in Class B : " + x);
	}

	public static void main(String[] args)
	{
		B obj = new B();
	}
}

/////////////////////////////////////////////////////////////////////////////////////

//Java code for using 'this'
//keyword as method parameter
class Demo {
	int a;
	int b;

// Default constructor
	Demo() {
		a = 10;
		b = 20;
	}

// Method that receives 'this' keyword as parameter
	void display(Demo obj) {
		System.out.println("a = " + obj.a + " b = " + obj.b);
	}

// Method that returns current class instance
	void get() {
		display(this);
	}

// main function
	public static void main(String[] args) {
		Demo object = new Demo();
		object.get();
	}
}

//////////////////////////////////////////////////////////////////////////////////////

//Java code for using this to invoke current
//class method
class Test1 {

	void display()
	{
		// calling function show()
		this.show();

		System.out.println("Inside display function");
	}

	void show()
	{
		System.out.println("Inside show function");
	}

	public static void main(String args[])
	{
		Test1 t1 = new Test1();
		t1.display();
	}
}


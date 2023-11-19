package objectOrientedProgramming;

public class NestedInterface {

}
class OuterClass {

	// Nested interface
	public interface NestedInterface {
		public void nestedMethod();
	}

	public static void main(String[] args)
	{
		// Implement nested interface
		NestedInterface nested = new NestedInterface() {
			public void nestedMethod()
			{
				System.out.println(
					"Hello from nested interface!");
			}
		};

		// Call nested interface method
		nested.nestedMethod();
	}
}

/////////////////////////////////////////////////////////////////////////
//Java program to demonstrate an interface cannot
//have non-public member interface.

interface Test {
	interface Yes {
		void show();
	}
}

class Testing implements Test.Yes {
	public void show()
	{
		System.out.println("show method of interface");
	}
}

class A {
	public static void main(String[] args)
	{
		Test.Yes obj;
		Testing t = new Testing();
		obj = t;
		obj.show();
	}
}
/**
///////////////////////////////////////////////////////////////////////
//Java program to demonstrate working of
//interface inside another interface.
import java.util.*;
interface Test {
	interface Yes {
		void show();
	}
}

class Testing implements Test.Yes {
	public void show()
	{
		System.out.println("show method of interface");
	}
}

class A {
	public static void main(String[] args)
	{
		Test.Yes obj;
		Testing t = new Testing();
		obj = t;
		obj.show();
	}
}
*/

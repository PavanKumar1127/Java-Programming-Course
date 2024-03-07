package practiceQuestions;

import java.util.ArrayList;

public class ArrayListDemo {
	public static void main(String[] args) {

		// create an empty array list with an initial capacity
		ArrayList<Integer> arrlist = new ArrayList<Integer>(5);

		// use add() method to add elements in the list
		arrlist.add(15);
		arrlist.add(20);
		arrlist.add(25);
		arrlist.add(40);
		System.out.println("ArrayList: " + arrlist);

		// prints all the elements available in list
		for (Integer number : arrlist) {
			System.out.println("Number = " + number);
		}

////////////////////////////////////////////////////////////////
System.out.println("Using index of() "+ arrlist.indexOf(15));
//arr.lastIndexOf(6); 
//arr.isEmpty(); 
//Numbers.removeIf(n -> (n % 3 == 0)); 

/////////////////////////////////////////////////////////////////////////////////
		// adding element 35 at fourth position
		arrlist.add(3, 35);
		// prints all the elements available in list
		for (Integer number : arrlist) {
			System.out.println("Number = " + number);
		}
/////////////////////////////////////////////////////////////////////////////////

		// create an empty array list2 with an initial
		// capacity
		ArrayList<Integer> arrlist2 = new ArrayList<Integer>(5);

		// use add() method to add elements in list2
		arrlist2.add(25);
		arrlist2.add(30);
		arrlist2.add(31);
		arrlist2.add(35);

		// let us print all the elements available in
		// list2
		System.out.println("Printing list2:");
		for (Integer number : arrlist2)
			System.out.println("Number = " + number);

		// inserting all elements, list2 will get printed
		// after list1
		arrlist.addAll(arrlist2);

		System.out.println("Printing all the elements");
		// let us print all the elements available in
		// list1
		for (Integer number : arrlist)
			System.out.println("Number = " + number);
/////////////////////////////////////////////////////////////////////////////////

		// inserting all elements of list2 at third
		// position
		arrlist.addAll(2, arrlist2);

		System.out.println("Printing all the elements");

		// prints all the elements available in list1
		for (Integer number : arrlist)
			System.out.println("Number = " + number);
/////////////////////////////////////////////////////////////////////////////////

		// Clearing off elements
		// using clear() method
		arrlist2.clear();

		// Displaying ArrayList elements
		// after using clear() method
		System.out.println("The list after using clear() method: " + arrlist2);
///////////////////////////////////////////////////////////////////////////////////

		// use contains() to check if the element
		// 2 exits or not
		boolean ans = arrlist.contains(2);

		if (ans)
			System.out.println("The list contains 2");
		else
			System.out.println("The list does not contains 2");
/////////////////////////////////////////////////////////////////////
		// Print the ArrayList
		System.out.println("ArrayList: " + arrlist);

		// ensure that the ArrayList
		// can hold upto 5000 elements
		// using ensureCapacity() method
		arrlist.ensureCapacity(100);

		// Print
		System.out.println("ArrayList can now" + " surely store upto" + " 100 elements.");
///////////////////////////////////////////////////////////
		// forEach method of ArrayList and
		// print numbers
		arrlist.forEach((n) -> System.out.println(n));

	}

}

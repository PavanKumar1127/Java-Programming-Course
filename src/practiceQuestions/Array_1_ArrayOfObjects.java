package practiceQuestions;

//Java program to illustrate creating
//an array of objects

class Student {
	public int roll_no;
	public String name;
	Student(int roll_no, String name)
	{
		this.roll_no = roll_no;
		this.name = name;
	}
}

//Elements of the array are objects of a class Student.
public class Array_1_ArrayOfObjects {
	public static void main(String[] args)
	{
		// declares an Array of Students
		Student[] arr;

		// allocating memory for 5 objects of type Student.
		arr = new Student[5];

		// initialize the first elements of the array
		arr[0] = new Student(1, "aman");

		// initialize the second elements of the array
		arr[1] = new Student(2, "vaibhav");

		// so on...
		arr[2] = new Student(3, "shikar");
		arr[3] = new Student(4, "dharmesh");
		arr[4] = new Student(5, "mohit");

		// accessing the elements of the specified array
		for (int i = 0; i < arr.length; i++)
			System.out.println("Element at " + i + " : "
							+ arr[i].roll_no + " "
							+ arr[i].name);
	}
}

/**
 * // Java program to illustrate creating
// an array of objects

class Student
{
	
	public String name;
	Student(String name)
	{
		this.name = name;
	}
	@Override
	public String toString(){
		return name;
	}
}

// Elements of the array are objects of a class Student.
public class GFG
{
	public static void main (String[] args)
	{
		// declares an Array and initializing the elements of the array
		Student[] myStudents = new Student[]{new Student("Dharma"),new Student("sanvi"),new Student("Rupa"),new Student("Ajay")};

		// accessing the elements of the specified array
		for(Student m:myStudents){ 
			System.out.println(m);
		}
	}
}
 */

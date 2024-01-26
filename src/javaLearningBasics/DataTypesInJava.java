package javaLearningBasics;

/**
 * Data Type: data type is essentially the classification or category of data
 * stored within a variable.
 * 
 * Imagine your computer is like a giant toolbox, and it needs to organize
 * different things. These "things" are pieces of information that your computer
 * uses to do its job.
 * 
 * Now, think of data types as different categories or labels for these pieces
 * of information in the toolbox. Each label tells the computer what kind of
 * information it is and how to handle it.
 *
        // Byte : 8 Bit, 
         * Range: -128 to 127
        // Short : 16 Bit, 
         * Range: -32,768 to 32,767
        // Integer : 32 Bit, 
         * Range: -2^31 to 2^31 - 1
        // Long : 64 Bit, 
         * Range: -2^63 to 2^63 - 1
        // Float : 32 Bit, 
         * Range: Approximately -3.4E+38 to 3.4E+38 with seven significant digits
        // Double : 64 Bit,
         * Range: Approximately -1.7E+308 to 1.7E+308 with 15 significant digits
        // Boolean : 1 Bit,
         * Range: Can only take values true or false
        // Char : 16 Bit,
         * Range: 0 to 65,535 (unsigned) 
 */

public class DataTypesInJava {
	
public static void main(String[] args) {
        int number_1 = 6;
        System.out.println(number_1);
        
        double number_2;
        number_2 = 3.3453;
        System.out.println(number_2);
        
        long a;
        a = 4L;
        System.out.println(a);
        
        int b2 = 6;
        System.out.println("B : " + b2);
        
        char text_1 = 78;
        System.out.println("Unicode : " + text_1);
        
        float pi = 3.14f;
        System.out.println("Pi : " + pi);
        
        String text = "Hello, Java!";
        System.out.println("String : " + text);



        //In Java, you can find the data type of a variable in a few different ways:
        //
        ////1) Using getClass() Method:
        
		// getClass() method cannot be directly used on primitive data types in Java
		// because primitive types are not objects, and the getClass() method is part of
		// the Object class.
        
		// there is a way to get the class of a primitive type indirectly using their
		// wrapper classes. Each primitive type in Java has a corresponding wrapper
		// class that is part of the java.lang package. The wrapper classes are:
        //Integer for int
        //Double for double
        //Character for char
        //Boolean for boolean
        
        Class<?> numberType = Integer.valueOf(number_1).getClass();
        Class<?> textType = text.getClass();

        System.out.println("Data type of number_1: " + numberType);
        System.out.println("Data type of text: " + textType);
        
        ////2) Using instanceof Operator:
        
        //The instanceof operator is meant for use with classes and their instances, not primitive types.
        //Same as above
         
        if (Integer.valueOf(number_1) instanceof Integer) {
            System.out.println("Data type of number_1: Integer");
        }

        if (text instanceof String) {
            System.out.println("Data type of text: String");
        }
        
        //Wrapper class example
        Integer num1 = 100;
        Integer num2 = 100;
        Integer num3 = 500;// wrapper class has a memory range from -127 to 128 so the memory where they are allocated will hv different address.
        Integer num4 = 500;
        
        if(num1 == num2) {
        	System.out.println("num1 == num2");
        }else {
        	System.out.println("num1 != num2");
        }
        if(num3 == num4) {
        	System.out.println("num3 == num4");
        }else {
        	System.out.println("num3 != num4");

        }
    }
}

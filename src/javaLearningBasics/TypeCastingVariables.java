package javaLearningBasics;

/**
 * Type casting is the process of converting a variable of one data type to
 * another. This can be done implicitly by the compiler (automatic type
 * conversion) or explicitly by the programmer (explicit type casting).
 */
public class TypeCastingVariables {
	public static void main(String[] args) {

		//// Implicit Type Casting (Automatic):
		
		// the conversion is done automatically by the compiler when a "smaller" data
		// type is assigned to a "larger" data type variable, 
		// example, assigning an int to a double:
		
		int intValue = 42;
		double doubleValue = intValue; // Implicit casting
		
		////Explicit Type Casting:
		
		// done by the programmer when a "larger" data type needs to be assigned to a
		// "smaller" data type. This process requires the use of parentheses and the
		// target type
		
		double doubleValue_1 = 3.14;
		int intValue_1 = (int) doubleValue; // Explicit casting
		
		//examples
		
		int a;
        float b=3.17f;
        a=(int)b;
        System.out.println(a);
        
        int a_1 = 15;
        double a_2;
        a_2 = (double)a_1;
        System.out.println(a_2);

        byte b_1 = 3;
        int b_2;
        b_2 = (int)b_1;
        System.out.println(b_2);
         
        int x1 = 2290;
        byte y =(byte)x1;
        System.out.println(y);
 
        String s1 = "123";
        int x2 = Integer.valueOf(s1);
        System.out.println(x2-2);
	}
}

package accessModifierDemo;

import defaultAccessModifier.*;

public class DefaultModifierNew {
	
	// Java program to illustrate error while  
	// using class from different package with  
	// default modifier 
	public static void main(String args[])  
    {  
        // Accessing class Geek from package p1  
		DefaultModifier obj = new DefaultModifier();  
  
        obj.display();  

}

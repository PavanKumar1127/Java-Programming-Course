package defaultAccessModifier;

/**
 * The private access modifier is specified using the keyword private. The
 * methods or data members declared as private are accessible only within the
 * class in which they are declared.
 * 
 * Any other class of the same package will not be able to access these members.
 * Top-level classes or interfaces can not be declared as private because
 * private means “only visible within the enclosing class”. 
 * protected means “only visible within the enclosing class and any subclasses”
 */
public class PrivateAccessModifier {

	
}

class A  
{  
private void display()  
    {  
        System.out.println("A class");  
    }  
}  
  
class B  
{  
public static void main(String args[])  
    {  
        A obj = new A();  
        // Trying to access private method 
        // of another class  
        obj.display();  
    }  
} 
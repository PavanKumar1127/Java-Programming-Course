package accessModifierDemo;

//Protected:
//
//The protected keyword is used for protected access.
//Members with protected access are accessible within the same package and by subclasses
//(even if they are in a different package).

public class ProtectedAccessExample {
    protected int variable = 40; // Protected access

    protected void method() {
        System.out.println("Protected access method");
    }
}

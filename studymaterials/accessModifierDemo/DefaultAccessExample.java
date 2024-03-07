package accessModifierDemo;

//Default (Package-Private):
//
//No keyword is used for default access.
//Members with default access are accessible within the same package.

class DefaultAccessExample {
    int variable = 10; // Default access

    void method() {
        System.out.println("Default access method");
    }
}

package accessModifierDemo;
// AccessControlExample.java (in package com.example)

// Default access class (no modifier)
class DefaultAccessClass {
    int defaultVariable = 10; // Default access variable

    void defaultMethod() {
        System.out.println("Default access method");
    }
}

// Public access class
public class PublicAccessClass {
    public int publicVariable = 20; // Public access variable

    public void publicMethod() {
        System.out.println("Public access method");
    }
}

// Private access class
class PrivateAccessClass {
    private int privateVariable = 30; // Private access variable

    private void privateMethod() {
        System.out.println("Private access method");
    }
}

// Protected access class
class ProtectedAccessClass {
    protected int protectedVariable = 40; // Protected access variable

    protected void protectedMethod() {
        System.out.println("Protected access method");
    }
}

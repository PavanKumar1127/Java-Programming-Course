package accessModifierDemo;

//

/**
 * 
 * In Java, access control mechanisms are used to restrict the visibility and
 * accessibility of classes, methods, and variables. There are four types of
 * access control in Java:
 *  Default – No keyword required 
 *  Private 
 *  Protected
 *  Public
 * 
 */


/**
 * +------------------+------------------+-------------------+-------------------+
|   Access \ Item   |   Same Class     |  Same Package     |  Subclass         |  Any Class        |
+------------------+------------------+-------------------+-------------------+
| Public           |       Yes        |        Yes        |        Yes        |        Yes        |
| Protected        |       Yes        |        Yes        |        Yes        |        No         |
| Default (No Mod) |       Yes        |        Yes        |        No         |        No         |
| Private          |       Yes        |        No         |        No         |        No         |
+------------------+------------------+-------------------+-------------------+

 */

//https://www.geeksforgeeks.org/access-modifiers-java/?ref=lbp
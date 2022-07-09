package informal_tests;

import structures.ReversibleStackLL;

/**
 * This class is used to create and test a linked list that accepts generic data types.
 * @author Stephen Allen
 * @version 1.0
 */
public class MyTests {

    /**
     * Main method is used to create and test a linked list using methods created from the
     * ReversibleStackLL.java class.
     * @param args array of String objects
     */
    public static void main(String[] args) {
        //Initialize myReversibleStack with Integer values as type parameter
        ReversibleStackLL<Integer> myReversibleStack = new ReversibleStackLL<>();

        //Test if stack is empty before initialization of elements
        System.out.println("Testing isEmpty() method...");
        System.out.println("Is stack empty?: " + myReversibleStack.isEmpty()); //True
        System.out.println();
        //Add new elements to stack
        System.out.println("Testing add() method...");
        for (int i = -5; i <= 8; i++) {
            myReversibleStack.add(i);
        }
        System.out.println();

        //Print out stack and test isEmpty() method
        System.out.println("Testing initialized stack...");
        System.out.println("{ BOTTOM OF STACK } " + myReversibleStack + " { TOP OF STACK }");
        System.out.println("Current size of stack: " + myReversibleStack.size());
        System.out.println("Is stack empty?: " + myReversibleStack.isEmpty());
        System.out.println();

        //Test contains() method
        System.out.println("Testing contains() method...");
        boolean doesContain = myReversibleStack.contains(4);
        System.out.println("(Expected True) Does stack contain given number?: " + doesContain);
        boolean doesNotContain = myReversibleStack.contains(10);
        System.out.println("(Expected False) Does stack contain given number?: " + doesNotContain);
        System.out.println();

        //Test removed() method
        //Assign removed element to a variable
        System.out.println("Testing remove() method...");
        System.out.println("{ BOTTOM OF STACK } " + myReversibleStack + " { TOP OF STACK }");
        int removed = myReversibleStack.remove();
        //Print the element removed
        System.out.println("Removed element: " + removed);
        System.out.println("Current size of stack after removed element: " + myReversibleStack.size());
        //Print out stack after removing the element
        System.out.println("Full stack after removing element: " + myReversibleStack);
        System.out.println();

        //Test reverse() method
        System.out.println("Testing reverse() method...");
        myReversibleStack.reverse();
        System.out.println("{ BOTTOM OF STACK } " + myReversibleStack + " { TOP OF STACK }");
        System.out.println("Is stack empty?: " + myReversibleStack.isEmpty());
        System.out.println();

        //Test reverse() method again
        System.out.println("Testing reverse() method again...");
        myReversibleStack.reverse();
        System.out.println("{ BOTTOM OF STACK } " + myReversibleStack + " { TOP OF STACK }");
        System.out.println("Is stack empty?: " + myReversibleStack.isEmpty());
        System.out.println();

        //Test clear() method
        System.out.println("Testing clear() method...");
        myReversibleStack.clear();
        System.out.println("{ BOTTOM OF STACK } " + myReversibleStack + " { TOP OF STACK }");
        System.out.println("(Expected Size 0) Current size: " + myReversibleStack.size());
        System.out.println("(Expected True) Is stack empty?: " + myReversibleStack.isEmpty());
    }
}

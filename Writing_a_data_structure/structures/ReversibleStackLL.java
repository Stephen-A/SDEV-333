package structures;

import adts.IReversibleStack;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class is used to create a linked list using generic data types and can be used to:
 * add, remove, find if list has a specific value, get size of the list, check if list is empty,
 * clear the list, reverse the list, and remove an element from the list.
 * @param <T> A generic datatype
 * @author Stephen Allen
 * @version 1.0
 */
public class ReversibleStackLL<T> implements IReversibleStack<T>
{
    private int size;
    private Node head;
    private Node tail;

    /**
     * Constructor for ReversibleStackLL class
     */
    public ReversibleStackLL()
    {
        //Do nothing...
    }

    /**
     * This method adds a given element to the stack in FILO (first in last out) order.
     * Updates the size count of the stack after each method call.
     * @param element the element to add
     */
    @Override
    public void add(T element)
    {
        if(head == null)
        {
            head = new Node(element, null);
            tail = head;
        }
        else
        {
            tail.next = new Node(element, null);
            tail = tail.next;
        }
        size++;
    }

    /**
     * This method is not supported in this structure.
     * Throws UnsupportedOperationException on method call
     * @param element the element to search for
     */
    @Override
    public void remove(T element)
    {
        throw new UnsupportedOperationException("This method is not supported in the structure.");
    }

    /**
     * This method looks for the given element within the stack
     * @param element the element to search for
     * @return True if the element is found inside the stack
     *         False if the element is not found
     */
    @Override
    public boolean contains(T element)
    {

        if (head != null)
        {
            Node current = head;
            while (current.next != null)
            {
                current = current.next;
                if (current.data == element)
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method returns the amount of objects within the stack
     * @return size of the stack
     */
    @Override
    public int size()
    {
        return size;
    }

    /**
     * This method checks to see if the size of the stack is equal to 0
     * @return True if the stack is equal to 0
     *         False if the stack is greater than 0
     */
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * Removes all elements from the stack
     */
    @Override
    public void clear()
    {
        head = null;
        size = 0;
    }

    /**
     * Reverses the order of all elements in the stack.
     * @throws java.util.NoSuchElementException when the stack is empty
     */
    @Override
    public void reverse()
    {
        if (head == null)
        {
            throw new java.util.NoSuchElementException("Stack is empty");
        }

        Node prev = null;
        Node current = head;
        Node next;

        while (current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    /**
     * Removes, and returns, the top element of the stack
     * @return the top element of the stack
     * @throws java.util.NoSuchElementException when the stack is empty
     */
    @Override
    public T remove()
    {
        //Check if head is null
        if (head == null) {
            //If true, throw new exception
            throw new NoSuchElementException("Stack is empty");
        }
        //Create two nodes as placeholders
        Node tail = head;
        Node temp = null;
        //Loop through linked list until the next node is null
            while (tail.next != null)
            {
                temp = tail;
                //Assign the tail node to be null
                tail = tail.next;
            }
            size--;
            temp.next = null;
            return tail.data;
    }
    /**
     * This method will be implemented in part #2 of the assignment
     * @return values within the stack
     * NOTE: This method currently
     */
    @Override
    public Iterator<T> iterator()
    {
        return null;
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();

        Node current = head;
        while (current != null)
        {
            result.append(current.data).append(" --> ");
            current = current.next;
        }
        result.append("null");

        return result.toString();
    }


    private class Node
    {

        public Node(T data, Node next)
        {
            this.data = data;
            this.next = next;
        }

        private T data;
        private Node next;

        public String toString()
        {
            String nextElement = "null";
            if (next != null)
            {
                nextElement = next.data.toString();
            }
            return data + " -- > " + nextElement;
        }
    }
}

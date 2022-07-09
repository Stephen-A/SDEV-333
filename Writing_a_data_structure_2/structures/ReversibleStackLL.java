package structures;

import adts.IReversibleStack;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class is used to create a linked list using generic data types and can be used to:
 * add, remove, find if list has a specific value, get size of the list, check if list is empty,
 * clear the list, reverse the list, and remove an element from the list.
 * @param <T> A generic datatype
 * @author Stephen Allen
 * @version 2.0
 */
public class ReversibleStackLL<T> implements IReversibleStack<T>
{
    private int size;
    private Node head;
    private int modCount = 0;

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
        if (head == null)
        {
            head = new Node(element, null);
        }
        else
        {
            Node current = head;

            while(current.next != null)
            {
                current = current.next;
            }
            current.next = new Node(element,null);
        }
        modCount++;
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

            while (current != null)
            {
                if (current.data == element){
                    return true;
                }
                current = current.next;
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
        modCount++;
    }

    /**
     * Reverses the order of all elements in the stack.
     * @throws java.util.NoSuchElementException when the stack is empty
     */
    @Override
    public void reverse()
    {

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
        if (head == null)
        {
            //If true, throw new exception
            throw new NoSuchElementException("Stack is empty");
        }
        else
        {
            //Create two nodes as placeholders
            Node current = head;
            Node temp = head;
            //Loop through linked list until the next node is null
            while (current.next != null) {
                temp = current;
                //Assign the tail node to be null
                current = current.next;
            }
            temp.next = null;
            size--;
            modCount++;
            return current.data;
        }
    }

    /**
     * This method will be implemented in part #2 of the assignment
     * @return values within the stack
     * NOTE: This method currently
     */
    @Override
    public Iterator<T> iterator()
    {
        return new StackIterator();
    }

    /**
     * This inner class is used to implement an Iterator for our ReversibleStack
     * to iterate through the stack.
     */
    private class StackIterator implements Iterator<T>
    {

        private Node current;
        private int savedModCount;

        /**
         * Constructor for StackIterator
         */
        public StackIterator()
        {
            savedModCount = modCount;
            current = head;
        }

        /**
         * This method is used to check if the current linked list node either holds an element, or is null
         * @return True if the current linked list element has a value
         *         False if the current element is null
         */
        @Override
        public boolean hasNext()
        {
            if (savedModCount != modCount)
            {
                throw new ConcurrentModificationException("The Stack was changed while using the iterator");
            }
            return current != null;
        }

        /**
         * This method is used to iterate through the linked list and update the returned value
         * at the current node
         * @return data of the current node
         */
        @Override
        public T next()
        {
            if (savedModCount != modCount)
            {
                throw new ConcurrentModificationException("The Stack was changed while using the iterator.");
            }
            //Store the data as the current node's data
            T data = current.data;
            //Increment current to the next node
            current = current.next;
            //Return the stored data
            return data;
        }

        @Override
        public String toString()
        {
            return "StackIterator{" +
                    "current=" + current.data +
                    '}';
        }
    }

    /**
     * Inner Node class used to create a new Node object
     * within the ReversibleStack class
     */
    private class Node
    {

        private T data;
        private Node next;

        public Node(T data, Node next)
        {
            this.data = data;
            this.next = next;
        }

        public String toString()
        {
            String nextElement = "null";
            if (next != null)
            {
                nextElement = next.data.toString();
            }
            return data + " --> " + nextElement;
        }
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
}

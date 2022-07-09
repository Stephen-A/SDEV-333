package bst;

/**
 * This interface is used to hold methods that can be used between classes
 * Note: Currently only implemented within the BinarySearchTree class.
 * @author Stephen
 * @version 1.0
 * @param <T> generic type
 */
public interface ITree<T extends Comparable<T>>
{
    /**
     * This method accepts multiple inputs as a parameter and adds them to the tree
     * @param elements given elements to add to the tree
     */
    void add(T[] elements);

    /**
     * This method accepts an input as a parameter and adds it to the tree
     * @param element given elements to add to the tree
     */
    void add(T element);

    /**
     * This method accepts an input as a parameter and searches recursively through the tree for the given element
     * @param element given element to search for within the tree
     * @return contain() method passing the root Node and the element in as parameters
     */
    boolean contains(T element);

    /**
     * This method accepts an input as a parameter and searches recursively through the tree for the given element-
     * removing the element if it is found.
     * @param element given element to be removed from the tree
     * @return True if the stored size variable is not equal to the current size variable
     *         False if the stored size variable is equal to the current size variable
     */
    boolean remove(T element);

    /**
     * @return the size variable that is updated through the add() and remove() methods.
     */
    int size();

    /**
     * @return True if the size variable is 0
     *         False if the size variable is greater than 0
     */
    boolean isEmpty();

    /**
     * This method sets the size variable to 0
     * and sets the root Node to null
     */
    void clear();

    /**
     * This method checks if the root Node is null, returning null-
     * otherwise this method searches recursively through the tree and checks the left-most Node
     * until its next Node is null
     * @return The left-most Node in the tree
     */
    T smallest();

    /**
     * This method checks if the root Node is null, returning null-
     * otherwise this method searches recursively through the tree and checks the right-most Node
     * until its next Node is null
     * @return The right-most Node in the tree
     */
    T largest();

    /**
     * This method checks if the root Node is null, returning null-
     * otherwise this method will return the root Node in the tree
     * @return the root Node in the tree
     */
    T rootValue();

    /**
     * This method creates an ArrayList, passing it into its recursive method-
     * checking if the current Node' left and right Node' are null, if they are
     * then the current Node is added into the ArrayList
     * @return the ArrayList cast to an Array using the Comparable interface
     * of Nodes that are added to the ArrayList
     */
    T[] leafValues();

    /**
     * This method creates an ArrayList, passing it into its recursive method-
     * checking if the current Node' left or right Node' are not equal to null, if they are
     * then the current Node is added into the ArrayList
     * @return the ArrayList cast to an Array using the Comparable interface
     * of Nodes that are added to the ArrayList
     */
    T[] internalValues();

    /**
     * This method recursively loops through the tree and completes these steps:
     * 1. Creates a temporary Node as the current Node' left Node,
     * 2. Saves the current Node' left Node to the current Node' right Node value
     * 3. Saves the current Node' right Node to the previously assigned temporary Node
     * Then calls the invert() method two different times to recursively loop through the tree,
     * passing in the current Node' left and right Node' in as parameters
     */
    void invert();
}
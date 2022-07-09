package bst;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to create a BinarySearchTree with methods that will recursively:
 * add given elements, remove a given element, check if the tree contains an element,
 * return the smallest value, return the largest value, return the root Node,
 * return the leaf Node' in the tree, return the internal Node' in the tree,
 * and invert the tree so the left Node' will be placed on the right and the right Node'
 * will be placed on the left.
 *
 * This class also extends the Comparable interface to allow casting of an ArrayList to an Array
 * and implements the ITree interface to allow access between classes.
 * @author Stephen
 * @version 1.0
 * @param <T> generic type
 */
public class BinarySearchTree<T extends Comparable<T>> implements ITree<T>
{

    private TreeNode root;
    private int size;

    //Suppresses the unsafe operation warnings at compile time
    //https://docs.oracle.com/javase/7/docs/api/java/lang/SafeVarargs.html
    //Note: This is used to clear linter warnings
    @SafeVarargs
    @Override
    public final void add(T... elements)
    {
        for (T element : elements)
        {
            add(element);
        }
    }

    @Override
    public void add(T element)
    {
        root = add(root, element);
    }

    //add() is supported by a private recursive method
    private TreeNode add(TreeNode current, T element)
    {
        //base case (we found a null reference, a place to
        //put our new node)
        if (current == null)
        {
            size++;
            return new TreeNode(element);
        }
        int compare = current.data.compareTo(element);
        if (compare < 0) //search to the right
        {
            current.right = add(current.right, element);
        }
        else if (compare > 0) //search to the left
        {
            current.left = add(current.left, element);
        }

        //return the current node
        return current;
    }

    @Override
    public boolean contains(T element)
    {
       return contains(root, element);
    }

    private boolean contains(TreeNode current, T element)
    {
        //If the current Node is null
        if (current == null)
        {
            return false;
        }

        int compare = current.data.compareTo(element);
        if (compare < 0)
        {
            return contains(current.right, element);
        }
        else if (compare > 0)
        {
            return contains(current.left, element);
        }
        else
        {
            return true;
        }
    }

    @Override
    public boolean remove(T element)
    {
        int oldSize = size;
        root = remove(root, element);
        return oldSize != size;
    }

    private TreeNode remove(TreeNode current, T element)
    {
        //Base case (Didn't find the element in the tree)
        if (current == null)
        {
            return null;
        }

        int comparison = current.data.compareTo(element);
        if(comparison < 0) //Right
        {
            current.right = remove(current.right, element);
        }
        else if (comparison > 0) //Left
        {
            current.left = remove(current.left, element);
        }
        else //If comparison == 0
        {
            //No children
            if (current.left == null && current.right == null) //Checks if there is a lead Node
            {
               size--;
               return null;
            }
            else if (current.right == null) // Left child
            {
                size--;
                return current.left;
            }
            else if (current.left == null) // Right child
            {
                size--;
                return current.right;
            }
            else //Two children
            {
                //Find the largest element in the left subtree
                T largestElement = findMax(current.left);

                //Replace the current node data with that element
                current.data = largestElement;

                //recursively delete the Node with the largest
                //element in the left subtree
                remove(current.left, largestElement);
            }
        }
        return current;
    }

    private T findMax(TreeNode current)
    {
        if(current.right == null) //Base case
        {
            return current.data; //Return the current Node (prior to moving to the right half of tree)
        }
        return findMax(current.right);
    }

    @Override
    public T smallest()
    {
        if(root == null) //Base case
        {
            return null;
        }
        return smallest(root); //Pass root value to the helper method
    }

    private T smallest(TreeNode current)
    {
        if(current.left == null)
        {
            return current.data; //Return the current Node (prior to moving to the left half of the tree)
        }
        return smallest(current.left); //Pass in current' child Node to the method call
    }

    @Override
    public T largest()
    {
        if(root == null) //Base case
        {
            return null;
        }
        return largest(root);
    }

    private T largest(TreeNode current)
    {
        if(current.right == null) //Base case
        {
            return current.data; //Return the current Node (prior to moving to the right half of the tree)
        }
        return largest(current.right); //Pass in current' child Node to the method call
    }

    @Override
    public T rootValue()
    {
        if (root == null) //Base case
        {
            return null;
        }
        return root.data; //Otherwise, return the root value
    }

    @Override
    public T[] leafValues()
    {
        List<T> internalLeaves = new ArrayList<>(); //Create ArrayList to expand as Nodes are added
        leafValues(root, internalLeaves); //
        return internalLeaves.toArray((T[]) new Comparable[0]);
    }

    private void leafValues(TreeNode current, List<T> leaves)
    {
        if (current == null) //Base case
        {
            return;
        }
        if (current.left == null && current.right == null)
        {
            leaves.add(current.data); //Add current.data to the leaves List
        }
        leafValues(current.left, leaves); //Move to the left
        leafValues(current.right, leaves); //Move to the right
    }

    @Override
    public T[] internalValues()
    {
        List<T> internalNode = new ArrayList<>();
        internalValues(root, internalNode);
        return internalNode.toArray((T[]) new Comparable[0]);
    }

    private void internalValues(TreeNode current, List<T> internalNodes)
    {
        if (current == null) //Base case
        {
            return;
        }
        if (current.left != null || current.right!= null) //Check if the current Node' left
                                                            // or right value do not equal null
        {
            internalNodes.add(current.data);
        }
        internalValues(current.left, internalNodes);
        internalValues(current.right, internalNodes);
    }

    @Override
    public void invert()
    {
        invert(root); //Call the invert method using the root Node as a parameter
    }

    private void invert(TreeNode current)
    {
        if (current == null) //Base case
        {
            return;
        }
        TreeNode temp = current.left; //Save the current Node' as its left Node
        current.left = current.right; //Save the left Node as the current Node' right Node
        current.right = temp; //Save the right Node as the previously saved Node

        invert(current.left);
        invert(current.right);
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public void clear()
    {
        size = 0;
        root = null;
    }

    private class TreeNode
    {
        private T data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(T data)
        {
            this.data = data;
        }

        @Override
        public String toString()
        {
            String leftChild = (left == null) ? "null" : left.data.toString();
            String rightChild = (right == null) ? "null" : right.data.toString();

            return leftChild + " <-- " + data.toString() + " --> " + rightChild;
        }
    }

    @Override
    public String toString() {
        return "BinarySearchTree{ " +
                "root= " + root +
                ",size= " + size +
                " }";
    }
}
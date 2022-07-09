package driver;

import bst.BinarySearchTree;
import java.util.Arrays;

/**
 * This class creates a new BinarySearchTree using Integer values as its parameters
 * and tests the created methods as described in ITree.java interface
 * @author Stephen Allen
 * @version 1.0
 */
public class TestBST
{
    /**
     * @param args array of String objects
     */
    public static void main(String[] args)
    {
        BinarySearchTree<Integer> numTree = new BinarySearchTree<>();
        System.out.println("Is tree empty before add() method?: " + numTree.isEmpty());
        numTree.add(10, 5, 3, 7, 6);
        System.out.println("Is tree empty after add() method?: " + numTree.isEmpty());
        System.out.println("Size of tree: " + numTree.size());
        System.out.println("Root Node of tree: " + numTree.rootValue());
        System.out.println("Smallest Node value: " + numTree.smallest());
        System.out.println("Largest Node value: " + numTree.largest());
        System.out.println("Contains 3 (expected true): " + numTree.contains(3));
        System.out.println("Contains 8 (expected false): " + numTree.contains(8));
        System.out.println("Remove 3 successful?: " + numTree.remove(3));
        System.out.println("Internal Node values: " + Arrays.toString(numTree.internalValues()));
        System.out.println("Leaf Node values: " + Arrays.toString(numTree.leafValues()));
        numTree.invert();
        System.out.println("Clearing tree...");
        numTree.clear();
        System.out.println("Is tree empty after clear() method?: " + numTree.isEmpty());
    }
}

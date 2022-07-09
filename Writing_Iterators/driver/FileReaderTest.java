package driver;

import structures.Book;

/**
 * This class is used as the driver for the Book.java class. A new Book object is created and passes a
 * .txt file as a parameter and prints out the contents. Closes the Scanner after printing out all contents.
 * @author Stephen Allen
 * @version 1.0
 */
public class FileReaderTest
{

    /**
     * This is the main method to test creating a new Book object that reads in a .txt file and displays
     * the contents.
     * Will close the file once all the contents are read.
     * @param args array of String objects
     */
    public static void main(String[] args)
    {
        Book book = new Book("src/files/war_and_peace.txt");
        for (String printLine : book)
        {
            System.out.println(printLine);
        }
    }
}

package structures;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

/**
 * This class uses an iterator to accept a .txt file as a parameter and print out the contents of the file
 * @author Stephen Allen
 * @version 1.0
 */
public class Book implements Iterable<String>
{

    private String filePath;

    /**
     * @param filePath given file path for the text document being read
     */
    public Book(String filePath)
    {
        this.filePath = filePath;
    }

    @Override
    public Iterator<String> iterator()
    {
        return new FileIterator();
    }

    private class FileIterator implements Iterator<String>
    {

        private Scanner fileReader;
        PrintWriter writer = null;

        private FileIterator()
        {
            try
            {
                fileReader = new Scanner(new FileInputStream(filePath));
            }
            catch (FileNotFoundException e)
            {
                System.out.println("Issue writing to file: " + e.getMessage());
            }
            finally
            {
                if (writer != null)
                {
                    fileReader.close();
                }
            }
        }

        @Override
        public boolean hasNext()
        {
            return fileReader.hasNext();
        }

        @Override
        public String next()
        {
            return fileReader.nextLine();
        }

        @Override
        public String toString()
        {
            return "FileIterator{" +
                    "reader=" + fileReader +
                    '}';
        }
    }

    @Override
    public String toString()
    {
        return "Book{" +
                "filePath='" + filePath + '\'' +
                '}';
    }
}

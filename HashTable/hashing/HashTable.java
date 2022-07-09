package hashing;

public class HashTable<T>
{

    public static int INITIAL_TABLE_SIZE = 5;
    public static final int RESIZE_RATE = 2;
    public static final double MAX_LOAD_FACTOR = 1.5;

    private HashElement[] table;
    private int size;

    public HashTable()
    {
        table = new HashElement[INITIAL_TABLE_SIZE];
    }

    public boolean add(T element)
    {
        double curLoadFactor = (double) size / table.length;
        if (curLoadFactor > MAX_LOAD_FACTOR)
        {
            resize();
        }

        int index = findIndexOf(element);
        if (table[index] != null)
        {
            return false;
        }

        table[index] = new HashElement(element);
        size++;
        return true;
    }


    private void resize()
    {

        HashElement[] oldTable = table;
        table = new HashElement[oldTable.length * RESIZE_RATE];

        size = 0;

        for (int i = 0; i < oldTable.length; i++)
        {
            if (oldTable[i] != null)
            {
                add((T) oldTable[i].data);
            }
        }
    }

    private int findIndexOf(T element)
    {
        //Step 3: get a positive hash code and index
        int code = Math.abs(element.hashCode());
        int index = code % table.length;

        //insert the element
        //use linear probing to search for a spot in the table
        while (table[index] != null)
        {
            if (table[index].data.equals(element) && !table[index].isRemoved)
            {
                break;
            }

            index = (index + 1) % table.length;
        }
        return index;
    }


    private static class ElementWrapper<T>
    {

        private T element;
        private boolean removed;

        public ElementWrapper(T element)
        {
            this.element = element;
            removed = false;
        }

        public ElementWrapper(T element, boolean removed)
        {
            this.element = element;
            this.removed = removed;
        }

        @Override
        public String toString()
        {
            return element.toString();
        }
    }

    private class HashElement<K>
    {
        private K data;
        private boolean isRemoved;

        public HashElement(K data)
        {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

}

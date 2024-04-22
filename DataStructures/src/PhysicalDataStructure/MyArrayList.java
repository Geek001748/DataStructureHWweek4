package PhysicalDataStructure;

public class MyArrayList<T extends Iterable<T>> implements MyList<T>
{
    private Object[] array;
    private int size = 0;
    private static int capacity = 10;
    private static final int baseCapacity = 10;

    public MyArrayList()
    {
        array = new Object[baseCapacity];
    }

    void increaseBuffer()
    {
        capacity = 2 * capacity;
        Object[] array2 = new Object[capacity];
        for (int i = 0; i < size; i++) {
            array2[i] = array[i];
        }
        array = array2;
    }
    boolean isIndex(int n)
    {
        if (n < 0 || n >= size)
            return false;
        return true;
    }
    void fakeIndex()
    {
        System.out.println("You input wrong index, please repeat in range (0 - " + size + ")");
    }
    @Override
    public void add(T item)
    {
       if (size == capacity)
       {
           increaseBuffer();
       }
       array[size++] = item;
    }

    @Override
    public void set(int index, T item)
    {
        if (!isIndex(index))
        {
            fakeIndex();
        }
        else
        {
            array[index] = item;
        }
    }

    @Override
    public void add(int index, T item)
    {
       if (!isIndex(index))
        {
            fakeIndex();
        }
        else if (size == capacity)
        {
           increaseBuffer();
        }
        else
        {
            for (int i = size; i > index; i--)
            {
                array[i] = array[i - 1];
            }
            array[index] = item;
            size++;
        }
    }

    @Override
    public void addFirst(T item)
    {
        add(0, item);
    }

    @Override
    public void addLast(T item)
    {
        add(item);
    }

    @Override
    public T get(int index)
    {
        if (!isIndex(index))
        {
            fakeIndex();
            return null;
        }
        return (T)array[index];
    }

    @Override
    public T getFirst()
    {
        return get(0);
    }

    @Override
    public T getLast()
    {
        if (size==0)
            return null;
        return get(size - 1);
    }

    @Override
    public void remove(int index) {
        if (size == 0 || !isIndex(index))
        {
            fakeIndex();
        }
        else
        {
            for (int i = index; i < size - 1; i++)
            {
                array[i] = array[i + 1];
            }
            size--;
        }
    }

    @Override
    public void removeFirst()
    {
        remove(0);
    }

    @Override
    public void removeLast()
    {
        if(size == 0)
            fakeIndex();
        else
            remove(size - 1);
    }

    @Override
    public void sort()
    {
        boolean swapped;
        for (int i = 0; i < size - 1; i++)
        {
            swapped = false;
            for (int j = 0; j < size - i - 1; j++)
            {
                Comparable<T> element1 = (Comparable<T>) array[j];
                Comparable<T> element2 = (Comparable<T>) array[j + 1];

                // Check if we need to swap array[j] and array[j + 1]
                if (element1.compareTo((T) element2) > 0)
                {
                    Object temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
        // If no two elements were swapped by inner loop, then break
        if (!swapped) {
            break;
        }
    }
}


    @Override
    public int indexOf(Object object)
    {
       for (int i = 0; i < size; i++) {
        // Check for NullPointerException
            if (object == null && array[i] == null)
            {
                return i;
            }
            if (object != null && object.equals(array[i]))
            {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object)
    {
        for (int i = size; 0 <= size; i--) {
        // Check for NullPointerException
            if (object == null && array[i] == null)
            {
                return i;
            }
            if (object != null && object.equals(array[i]))
            {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object object)
    {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray()
    {
        Object[] resultArray = new Object[size];
        System.arraycopy(array, 0, resultArray, 0, size);
        return resultArray;
    }

    @Override
    public void clear()
    {
       array = new Object[baseCapacity];
       size = 0;
    }

    @Override
    public int size()
    {
        return size;
    }
}

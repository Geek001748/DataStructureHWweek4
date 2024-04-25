package PhysicalDataStructure;
public class MyArrayList<T> implements MyList<T>
{
    private Object[] array;
    private int size = 0;
    private int capacity = 10;
    private static final int BASE_CAPACITY = 10;

    public MyArrayList()
    {
        array = new Object[BASE_CAPACITY];
    }

    private void increaseBuffer()
    {
        capacity = 2 * capacity;
        Object[] newArray = new Object[capacity];
        for (int i = 0; i < size; i++)
        {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    private boolean isValidIndex(int index)
    {
        return index >= 0 && index < size;
    }

    private void checkIndex(int index)
    {
        if (!isValidIndex(index))
        {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void checkSize()
    {
        if (size == 0)
        {
            throw new IndexOutOfBoundsException("Your array is empty!");
        }
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
        checkIndex(index);
        array[index] = item;
    }

    @Override
    public void add(int index, T item)
    {
        checkIndex(index);
        if (size == capacity)
        {
            increaseBuffer();
        }
        for (int i = size; i > index; i--)
        {
            array[i] = array[i - 1];
        }
        array[index] = item;
        size++;
    }

    @Override
    public void addFirst(T item)
    {
        add(0, item);
    }

    @Override
    public void addLast(T item)
    {
        add(size, item);
    }

    @Override
    public T get(int index)
    {
        checkIndex(index);
        return (T) array[index];
    }

    @Override
    public T getFirst()
    {
        checkSize();
        return get(0);
    }

    @Override
    public T getLast()
    {
        checkSize();
        return get(size - 1);
    }

    @Override
    public void remove(int index)
    {
        checkIndex(index);
        for (int i = index; i < size - 1; i++)
        {
            array[i] = array[i + 1];
        }
        array[--size] = null; // clear to let GC do its work
    }

    @Override
    public void removeFirst()
    {
        checkSize();
        remove(0);
    }

    @Override
    public void removeLast()
    {
        checkSize();
        remove(size - 1);
    }

    @Override
    public void sort()
    {
        // Simple insertion sort
        for (int i = 1; i < size; i++)
        {
            Object key = array[i];
            int j = i - 1;

            while (j >= 0 && ((Comparable) array[j]).compareTo(key) > 0)
            {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    @Override
    public int indexOf(Object object)
    {
        for (int i = 0; i < size; i++)
        {
            if (object == null ? array[i] == null : object.equals(array[i]))
            {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object)
    {
        for (int i = size - 1; i >= 0; i--)
        {
            if (object == null ? array[i] == null : object.equals(array[i]))
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
        Object[] newArray = new Object[size];
        for (int i = 0; i < size; i++)
        {
            newArray[i] = array[i];
        }
        return newArray;
    }

    @Override
    public void clear()
    {
        for (int i = 0; i < size; i++)
        {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public int size()
    {
        return size;
    }
}

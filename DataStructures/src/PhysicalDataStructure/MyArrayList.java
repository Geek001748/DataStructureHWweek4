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
        if (n < 0 && n >= size)
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
    public void add(int index, T item) {
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
    public void addFirst(T item) {
        if (size == capacity)
        {
           increaseBuffer();
        }
        else
        {
            for (int i = size; i > 0; i--)
            {
                array[i] = array[i - 1];
            }
            array[0] = item;
            size++;
        }
    }

    @Override
    public void addLast(T item) {
        if (size == capacity)
        {
           increaseBuffer();
        }
        else
        {
            array[size] = item;
            size++;
        }
    }

    @Override
    public T get(int index) {
        if (size == capacity)
        {
           increaseBuffer();
        }
        else
        {
            return array[index];
        }
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object object) {
        return 0;
    }

    @Override
    public boolean exists(Object object) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void clear() {
       Object[] array2 = new Object[baseCapacity];
       array = array2;
    }

    @Override
    public int size() {
        return size;
    }
}

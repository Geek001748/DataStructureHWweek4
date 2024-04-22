package PhysicalDataStructure;

public class MyLinkedList<T extends Iterable<T>> implements MyList<T>
{
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;
    private static int capacity = 10;
    private static final int baseCapacity = 10;
    private class MyNode<E> {
        E data;
            MyNode<E> next;
        MyNode<E> prev;
        MyNode (E data)
        {
            this.data = data;
        }
    }

    public MyLinkedList()
    {
        head = tail = null;
        size = 0;
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
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null)
        {
            head = tail = newNode;
        }
        else
        {
           tail.next = newNode;
           tail = newNode;
        }
        size ++;
    }

    @Override
    public void set(int index, T item)
    {
        if (!isIndex(index)) {
            fakeIndex();
        }
        else {
            MyNode<T> curr = head;
            for (int i = 0; i < index; i++)
            {
                curr = curr.next;
            }
            curr.data = item;
        }
    }

    @Override
    public void add(int index, T item)
    {
        MyNode<T> newNode = new MyNode<>(item);
        if (!isIndex(index)) {
            fakeIndex();
        }
        else if(index == 0)
        {
            newNode.next = head;
            head = newNode;
            if (size == 0)
            {
                tail = newNode;
            }
            size ++;
        }
        else {
            MyNode<T> curr = head;
            for (int i = 0; i < index - 1; i++)
            {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
            if (newNode.next == null)
            {
                tail = newNode;
            }
            size ++;
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

    public void recursionGet(MyNode<T> node, int index)
    {
       if(index == 0)
       {
           return node;
       }
       if (node == null)
       {
           throw new IndexOutOfBoundsException("Index out of bounds");
       }
       return recursionGet(node.next);
    }
    @Override
    public T get(int index)
    {
        if(!isIndex(index))
        {
            fakeIndex();
            return null;
        }
        return recursionGet(head, index);
    }

    @Override
    public T getFirst()
    {
        return get(0);
    }

    @Override
    public T getLast()
    {
        return get(size - 1);
    }

    @Override
    public void remove(int index)
    {
        if(!isIndex(index) || size == 0)
        {
            fakeIndex();
        }
        else if (index == 0)
        {
            head = head.next;
            if(size == 1)
            {
                tail = null;
            }
            size--;
        }
        else
        {
            MyNode<T> curr = head;
            for (int i = 0; i < index - 1; i++)
            {
                curr = curr.next;
            }
            curr.next = curr.next.next;
            if (index == size - 1)
            {
                tail = null;
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
       remove(size - 1);
    }

    @Override
    public void sort()
    {

    }

    @Override
    public int indexOf(Object object)
    {
        return 0;
    }

    @Override
    public int lastIndexOf(Object object)
    {
        return 0;
    }

    @Override
    public boolean exists(Object object)
    {
        MyNode<T> curr = head;
        while (curr.next != null)
        {
            if (curr == null && object == null || curr != null && curr.equals(object))
            {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public Object[] toArray()
    {
        MyNode<T> curr = head;
        Object[] copyArray = new Object[size];
        int i = 0;
        while (curr.next != null)
        {
            copyArray[i++] = curr;
            curr = curr.next;
        }
        return copyArray;
    }

    @Override
    public void clear()
    {
       head = tail = null;
       size = 0;
    }

    @Override
    public int size()
    {
        return size;
    }
}

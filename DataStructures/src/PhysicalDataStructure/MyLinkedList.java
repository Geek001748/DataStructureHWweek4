package PhysicalDataStructure;

public class MyLinkedList<T extends Comparable<T> & Iterable<T>> implements MyList<T>
{
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    private class MyNode<E>
    {
        E data;
        MyNode<E> next;
        MyNode<E> prev;

        MyNode(E data)
        {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public MyLinkedList()
    {
        head = tail = null;
        size = 0;
    }

    private void checkIndex(int index)
    {
        if (index < 0 || index >= size)
        {

            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
        }
    }

    @Override
    public void add(T item)
    {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null)
        {
            head = tail = newNode;
        } else
        {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void set(int index, T item)
    {
        checkIndex(index);
        MyNode<T> curr = head;
        for (int i = 0; i < index; i++)
        {
            curr = curr.next;
        }
        curr.data = item;
    }

    @Override
    public void add(int index, T item)
    {
        MyNode<T> newNode = new MyNode<>(item);
        checkIndex(index);
        if (index == 0)
        {
            newNode.next = head;
            head = newNode;
            if (size == 0)
            {
                tail = newNode;
            }
            size++;
        } else
        {
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
        checkIndex(index);
        MyNode<T> curr = head;
        for (int i = 0; i < index; i++)
        {
            curr = curr.next;
        }
        return curr.data;
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
        checkIndex(index);
        if (index == 0)
        {
            head = head.next;
            if (size == 1)
            {
                tail = null;
            }
            size--;
        } else
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
         if (size > 1)
         {
             boolean wasChanged;
             do
             {
                 MyNode<T> curr = head;
                 MyNode<T> prev = null;
                 MyNode<T> next = (curr != null) ?curr.next :null;
                 wasChanged  = false;

                 while (next != null)
                 {
                     if (curr.data.compareTo(next.data) > 0)
                     {
                         wasChanged = true;

                         if (prev != null)
                         {
                             prev.next = next;
                         } else
                         {
                             head = next;
                         }
                         curr.next = next.next;
                         next.next = curr;

                         prev = next;
                         next = curr.next;
                     }
                     else
                     {
                         prev = curr;
                         curr = next;
                         next = next.next;
                     }

                     if (curr == tail)
                     {
                         tail = prev;
                     }
                 }
             }while (wasChanged);
         }
    }

    @Override
    public int indexOf(Object object)
    {
        MyNode<T> curr = head;
        for (int index = 0;curr != null; curr = curr.next, index++)
        {
            if (object == null ? curr.data == null : object.equals(curr.data))
            {
                return index;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object)
    {
        MyNode<T> curr = tail;
        for (int index = size - 1;curr != null; curr = curr.prev, index--)
        {
            if (object == null ? curr.data == null : object.equals(curr.data))
            {
                return index;
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object object)
    {
        MyNode<T> curr = head;
        while (curr.next != null)
        {
            if (object == null ? curr.data == null : object.equals(curr.data))
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

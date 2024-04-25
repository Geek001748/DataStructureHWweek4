import PhysicalDataStructure.MyLinkedList;

public class Stack <T extends Comparable<T>>
{
    private final MyLinkedList<T> list = new MyLinkedList<T>();
    public boolean isEmpty()
    {
        return list.size() == 0;
    }
    public int size()
    {
        return list.size();
    }
    public void push(T item)
    {
        list.addLast(item);
    }
    public T pop()
    {
        if (isEmpty())
        {
            throw new IndexOutOfBoundsException("Stack is empty!");
        }
        T item = list.getLast();
        list.removeLast();
        return item;
    }
    public T peek()
    {
        if (isEmpty())
        {
            throw new IndexOutOfBoundsException("Stack is empty!");
        }
        return list.getLast();
    }
}

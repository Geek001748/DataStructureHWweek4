import PhysicalDataStructure.MyLinkedList;

public class Queue<T extends Comparable<T>>
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
    public void enqueue(T item)
    {
        list.addLast(item);
    }
    public T dequeue()
    {
        if (isEmpty())
        {
            throw new IndexOutOfBoundsException("Queue is empty!");
        }
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }
    public T peek()
    {
        if (isEmpty())
        {
            throw new IndexOutOfBoundsException("Queue is empty!");
        }
        return list.getFirst();
    }
}

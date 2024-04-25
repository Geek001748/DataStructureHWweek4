import PhysicalDataStructure.MyArrayList;

public class MyMinHeap<T extends Comparable<T>>
{
    private final MyArrayList<T> heap;
    public MyMinHeap()
    {
        this.heap = new MyArrayList<>();
    }
    public int size()
    {
        return heap.size();
    }
    public boolean isEmpty()
    {
        return heap.size() == 0;
    }
    public void swap(int a, int b)
    {
        T temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }
    public void add(T item)
    {
        heap.add(item);
        int i = heap.size() - 1;
        while (i > 0)
        {
            int parent = (i - 1) / 2;
            if (heap.get(i).compareTo(heap.get(parent)) >= 0)
            {
                break;
            }
            swap(i, parent);
            i = parent;
        }
    }
    public T extractMin()
    {
        if (heap.size() == 0)
        {
            throw new IndexOutOfBoundsException("Heap is empty");
        }
        T min = heap.get(0);
        T last = heap.get(heap.size() - 1);
        heap.set(0, last);
        heap.remove(heap.size() - 1);
        if (heap.size() > 0)
        {
            heapify(0);
        }
        return min;
    }

    public T peek()
    {
        if (heap.size() == 0)
        {
            throw new IndexOutOfBoundsException("Heap is empty");
        }
        return heap.get(0);
    }
    private void heapify(int i)
    {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int smallest = i;
        if (l < heap.size() && heap.get(l).compareTo(heap.get(smallest)) < 0)
        {
            smallest = l;
        }
        if (r < heap.size() && heap.get(r).compareTo(heap.get(smallest)) < 0)
        {
            smallest = r;
        }
        if (smallest!= i)
        {
            swap (i, smallest);
            heapify (smallest);
        }
    }

}

import PhysicalDataStructure.MyArrayList;
import PhysicalDataStructure.MyLinkedList;
import PhysicalDataStructure.MyList;

import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        application();
    }
    public static void application() {
        System.out.println("Hello and welcome!");
        Scanner sc = new Scanner(System.in);
        boolean go = true;

        while (go) {
            System.out.println("\nAvailable Operations:");
            System.out.println("0 - Exit the program");
            System.out.println("1 - Manage a linked list (Add, Remove, Sort, etc.)");
            System.out.println("2 - Manage an array list (Add, Remove, Sort, etc.)");
            System.out.println("3 - Operate on a stack (Push, Pop, Peek)");
            System.out.println("4 - Operate on a min heap (Add, Extract Min, Peek)");
            System.out.println("5 - Operate on a queue (Enqueue, Dequeue, Peek)");
            System.out.println("Choose an option (0-5): ");
            int choice = sc.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Bye");
                    go = false;
                    break;
                case 1:
                    myLinkedList();
                    break;
                case 2:
                    myArrayList();
                    break;
                case 3:
                    stack();
                    break;
                case 4:
                    heap();
                    break;
                case 5:
                    queue();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        sc.close();
    }

    public static void myLinkedList() {
        MyLinkedList<String> list = new MyLinkedList<>(); // Change String to your type T if needed
        Scanner scanner = new Scanner(System.in);
        int choice;
        String input;
        int index;

        do {
            System.out.println("\nSelect an operation:");
            System.out.println("1. Add Item");
            System.out.println("2. Add First");
            System.out.println("3. Add Last");
            System.out.println("4. Remove Item by Index");
            System.out.println("5. Get Item by Index");
            System.out.println("6. Sort List");
            System.out.println("7. Clear List");
            System.out.println("8. Check if Item Exists");
            System.out.println("9. Print List");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter an item to add: ");
                    input = scanner.nextLine();
                    list.add(input);
                    break;
                case 2:
                    System.out.print("Enter an item to add first: ");
                    input = scanner.nextLine();
                    list.addFirst(input);
                    break;
                case 3:
                    System.out.print("Enter an item to add last: ");
                    input = scanner.nextLine();
                    list.addLast(input);
                    break;
                case 4:
                    System.out.print("Enter the index of the item to remove: ");
                    index = scanner.nextInt();
                    list.remove(index);
                    break;
                case 5:
                    System.out.print("Enter the index of the item to retrieve: ");
                    index = scanner.nextInt();
                    System.out.println("Item at index " + index + ": " + list.get(index));
                    break;
                case 6:
                    list.sort();
                    System.out.println("List sorted.");
                    break;
                case 7:
                    list.clear();
                    System.out.println("List cleared.");
                    break;
                case 8:
                    System.out.print("Enter an item to check if it exists: ");
                    input = scanner.nextLine();
                    System.out.println("Item exists: " + list.exists(input));
                    break;
                case 9:
                    System.out.println("List items:");
                    for (Object item : list.toArray()) {
                        System.out.println(item);
                    }
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    application();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
    public static void myArrayList() {
        MyArrayList<String> list = new MyArrayList<>(); // Change String to your type T if needed
        Scanner scanner = new Scanner(System.in);
        int choice;
        String input;
        int index;

        do {
            System.out.println("\nSelect an operation:");
            System.out.println("1. Add Item");
            System.out.println("2. Add First");
            System.out.println("3. Add Last");
            System.out.println("4. Remove Item by Index");
            System.out.println("5. Get Item by Index");
            System.out.println("6. Sort List");
            System.out.println("7. Clear List");
            System.out.println("8. Check if Item Exists");
            System.out.println("9. Print List");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter an item to add: ");
                    input = scanner.nextLine();
                    list.add(input);
                    break;
                case 2:
                    System.out.print("Enter an item to add first: ");
                    input = scanner.nextLine();
                    list.addFirst(input);
                    break;
                case 3:
                    System.out.print("Enter an item to add last: ");
                    input = scanner.nextLine();
                    list.addLast(input);
                    break;
                case 4:
                    System.out.print("Enter the index of the item to remove: ");
                    index = scanner.nextInt();
                    list.remove(index);
                    break;
                case 5:
                    System.out.print("Enter the index of the item to retrieve: ");
                    index = scanner.nextInt();
                    System.out.println("Item at index " + index + ": " + list.get(index));
                    break;
                case 6:
                    list.sort();
                    System.out.println("List sorted.");
                    break;
                case 7:
                    list.clear();
                    System.out.println("List cleared.");
                    break;
                case 8:
                    System.out.print("Enter an item to check if it exists: ");
                    input = scanner.nextLine();
                    System.out.println("Item exists: " + list.exists(input));
                    break;
                case 9:
                    System.out.println("List items:");
                    Object[] items = list.toArray();
                    for (Object item : items) {
                        System.out.println(item);
                    }
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    application();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void stack() {
        Stack<String> stack = new Stack<>(); // Assuming the stack holds Strings for this example
        Scanner scanner = new Scanner(System.in);
        int choice;
        String input;

        do {
            System.out.println("\nSelect an operation:");
            System.out.println("1. Push item");
            System.out.println("2. Pop item");
            System.out.println("3. Peek item");
            System.out.println("4. Check if stack is empty");
            System.out.println("5. Get stack size");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter an item to push: ");
                    input = scanner.nextLine();
                    stack.push(input);
                    System.out.println(input + " pushed onto stack.");
                    break;
                case 2:
                    try {
                        String itemPopped = stack.pop();
                        System.out.println(itemPopped + " popped from stack.");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Cannot pop. The stack is empty.");
                    }
                    break;
                case 3:
                    try {
                        String itemPeeked = stack.peek();
                        System.out.println(itemPeeked + " is on top of the stack.");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Cannot peek. The stack is empty.");
                    }
                    break;
                case 4:
                    System.out.println("Is the stack empty? " + stack.isEmpty());
                    break;
                case 5:
                    System.out.println("Stack size: " + stack.size());
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    application();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void heap() {
        MyMinHeap<Integer> minHeap = new MyMinHeap<>(); // Assuming we are working with Integer for simplicity
        Scanner scanner = new Scanner(System.in);
        int choice;
        Integer value;

        do {
            System.out.println("\nSelect an operation:");
            System.out.println("1. Add element");
            System.out.println("2. Extract min");
            System.out.println("3. Peek min");
            System.out.println("4. Check if heap is empty");
            System.out.println("5. Get heap size");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to add: ");
                    value = scanner.nextInt();
                    minHeap.add(value);
                    System.out.println(value + " added to the heap.");
                    break;
                case 2:
                    if (!minHeap.isEmpty()) {
                        value = minHeap.extractMin();
                        System.out.println("Min value " + value + " extracted from the heap.");
                    } else {
                        System.out.println("Heap is empty.");
                    }
                    break;
                case 3:
                    if (!minHeap.isEmpty()) {
                        value = minHeap.peek();
                        System.out.println("Min value on the heap: " + value);
                    } else {
                        System.out.println("Heap is empty.");
                    }
                    break;
                case 4:
                    System.out.println("Is the heap empty? " + minHeap.isEmpty());
                    break;
                case 5:
                    System.out.println("Heap size: " + minHeap.size());
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    application();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void queue() {
        Queue<String> queue = new Queue<>(); // Use String for example purposes
        Scanner scanner = new Scanner(System.in);
        int choice;
        String input;

        do {
            System.out.println("\nSelect an operation:");
            System.out.println("1. Enqueue item");
            System.out.println("2. Dequeue item");
            System.out.println("3. Peek at first item");
            System.out.println("4. Check if queue is empty");
            System.out.println("5. Get queue size");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter an item to enqueue: ");
                    input = scanner.nextLine();
                    queue.enqueue(input);
                    System.out.println("\"" + input + "\" enqueued onto the queue.");
                    break;
                case 2:
                    try {
                        String itemDequeued = queue.dequeue();
                        System.out.println("\"" + itemDequeued + "\" dequeued from the queue.");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Cannot dequeue. The queue is empty.");
                    }
                    break;
                case 3:
                    try {
                        String itemPeeked = queue.peek();
                        System.out.println("\"" + itemPeeked + "\" is at the front of the queue.");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Cannot peek. The queue is empty.");
                    }
                    break;
                case 4:
                    System.out.println("Is the queue empty? " + queue.isEmpty());
                    break;
                case 5:
                    System.out.println("Queue size: " + queue.size());
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    application();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

    public void description() {
        System.out.println();
    }
}
package homework4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private int size = 0;
    private Node head = new Node(null, null, null);
    private Node tail = new Node(null, null, null);

    public Deque() {
        head.setNext(tail);
        tail.setPrev(head);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException();

        // TODO test reference to self-head
        // TODO bug with adding next Node(null,null,null)

        if (size == 0) {
            tail = head;
        }

        Node node = new Node(item, head, null);
        head.setPrev(node);
        head = node;


        size++;
    }

    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();

        // TODO test reference to self-tail
        tail = new Node(item, null, tail);

        if (size == 0) {
            head = tail;
        }

        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node node = head;
        head = head.next;
        return node.value; // TODO next = null?
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node node = tail;
        tail = tail.prev; // TODO prev = null ?

        return node.value;
    }

    public Iterator<Item> iterator() {
        return new NodeIterator();
    }

    private class NodeIterator implements Iterator<Item> {

        Node cursor = head;

        @Override
        public boolean hasNext() {
            return cursor.next != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            cursor = cursor.next;
            return cursor.value;
        }
    }

    private class Node {
        Item value;
        Node next;
        Node prev;

        Node(Item item, Node next, Node prev) {
            this.value = item;
            this.next = next;
            this.prev = prev;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();

        deque.addFirst(20);
        deque.addFirst(10);

        assert deque.size() == 2;
        assert Arrays.compare(getArray(deque), new int[]{10,20}) == 0;

        deque.addLast(30);
        deque.addLast(40);

        assert deque.size() == 4;
        assert Arrays.compare(getArray(deque), new int[]{10,20,30,40}) == 0;



    }

    private static int[] getArray(Deque<Integer> deque) { // TODO generics
        int[] array = new int[deque.size()];

        int index = 0;
        for (Integer item : deque) {
            array[index] = item;
            index++;
        }
        return array;
    }

}
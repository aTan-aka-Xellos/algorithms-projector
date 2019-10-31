package homework4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * https://www.cs.princeton.edu/courses/archive/spring19/cos226/assignments/queues/specification.php
 * https://www.coursera.org/learn/algorithms-part1/programming/zamjZ/deques-and-randomized-queues
 */
public class Deque<Item> implements Iterable<Item> {

    private int size = 0;

    // sentinel nodes
    private final Node head = new Node();
    private final Node tail = new Node();

    public Deque() {
        head.next = tail;
        tail.prev = head;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException();

        Node firstNode = head.next;
        Node node = new Node(item, firstNode, head);
        firstNode.prev = node;
        head.next = node;

        size++;
    }

    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();

        Node lastNode = tail.prev;
        Node node = new Node(item, tail, lastNode);
        lastNode.next = node;
        tail.prev = node;

        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node firstNode = head.next;
        head.next = firstNode.next; // point head to the current second node
        head.next.prev = head;      // point current second node to the head

        size--;
        return firstNode.value;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node lastNode = tail.prev;
        tail.prev = lastNode.prev; // point tail to the current second from the end node
        tail.prev.next = tail;     // point current second node from the end to the tail

        size--;
        return lastNode.value;
    }

    public Iterator<Item> iterator() {
        return new NodeIterator();
    }

    private class NodeIterator implements Iterator<Item> {

        // point to the first node
        Node cursor = head.next;

        @Override
        public boolean hasNext() {
            // tail doesn't have value, so there is no 'next'
            return cursor.value != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item value = cursor.value;
            cursor = cursor.next; // will point to the tail on the last iteration
            return value;
        }
    }

    private class Node {
        Item value;
        Node next;
        Node prev;

        Node() {
        }

        Node(Item item, Node next, Node prev) {
            this.value = item;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * Should be run with -ea flag
     *
     * getArray basically test iterator
     * NPE happens if there is a bug
     * or the number of nodes won't match
     */
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();

        // ===== test iterator =====
        assert deque.isEmpty();
        assert !deque.iterator().hasNext();
        assert Arrays.compare(getArray(deque), new int[]{}) == 0;

        // ===== test addFirst, addLast =====
        deque.addFirst(20);
        assert deque.iterator().hasNext();
        assert deque.size() == 1;
        assert !deque.isEmpty();
        assert Arrays.compare(getArray(deque), new int[]{20}) == 0;

        deque.addFirst(10);
        assert deque.iterator().hasNext();
        assert deque.size() == 2;
        assert Arrays.compare(getArray(deque), new int[]{10,20}) == 0;

        deque.addLast(30);
        assert deque.iterator().hasNext();
        assert deque.size() == 3;
        assert Arrays.compare(getArray(deque), new int[]{10,20,30}) == 0;

        deque.addLast(40);
        assert deque.size() == 4;
        assert deque.iterator().hasNext();
        assert Arrays.compare(getArray(deque), new int[]{10,20,30,40}) == 0;

        System.out.println(Arrays.toString(getArray(deque)));

        // ===== test removeFirst, removeLast =====
        deque.removeFirst();
        assert deque.iterator().hasNext();
        assert deque.size() == 3;
        assert Arrays.compare(getArray(deque), new int[]{20,30,40}) == 0;

        deque.removeLast();
        assert deque.iterator().hasNext();
        assert deque.size() == 2;
        assert Arrays.compare(getArray(deque), new int[]{20,30}) == 0;

        deque.removeLast();
        assert deque.iterator().hasNext();
        assert deque.size() == 1;
        assert Arrays.compare(getArray(deque), new int[]{20}) == 0;

        deque.removeFirst();
        assert !deque.iterator().hasNext();
        assert deque.size() == 0;
        assert deque.isEmpty();
        assert Arrays.compare(getArray(deque), new int[]{}) == 0;


        // ===== test different order of adding/removing items

        deque = new Deque<>();

        deque.addLast(40);
        assert deque.size() == 1;
        assert deque.iterator().hasNext();
        assert Arrays.compare(getArray(deque), new int[]{40}) == 0;

        deque.addFirst(30);
        assert deque.iterator().hasNext();
        assert deque.size() == 2;
        assert Arrays.compare(getArray(deque), new int[]{30, 40}) == 0;

        deque.removeFirst();
        assert deque.iterator().hasNext();
        assert deque.size() == 1;
        assert Arrays.compare(getArray(deque), new int[]{40}) == 0;

        deque.removeLast();
        assert !deque.iterator().hasNext();
        assert deque.size() == 0;
        assert Arrays.compare(getArray(deque), new int[]{}) == 0;
    }

    private static int[] getArray(Deque<Integer> deque) { // TODO generics
        int[] array = new int[deque.size()];

        int index = 0;
        for (Integer item : deque) {
            array[index] = item; // NPE might occur if hasNext() has bug
            index++;
        }

        // ensure that we travers through all nodes
        assert index == deque.size();

        return array;
    }

}
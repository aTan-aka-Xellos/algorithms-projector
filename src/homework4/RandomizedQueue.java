package homework4;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int size = 0;
    private Object[] items;

    public RandomizedQueue() {
        items = new Object[8];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }


    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        if (items.length == size) {
            resize(size * 2);
        }
        items[size++] = item;
    }


    private void resize(int capacity) {
        Object[] temp = new Object[capacity];

        System.arraycopy(items, 0, temp, 0, size);
        items = temp;
    }


    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        int randomIndex = StdRandom.uniform(size); // [0, size)

        size--;
        Object value = items[randomIndex];
        items[randomIndex] = items[size]; // replace randomly chosen element with the last from the array

        if (size > 0 && size == items.length / 2) {
            resize((2 * items.length) / 3);
        }
        return (Item) value;
    }


    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return (Item) items[StdRandom.uniform(size)]; // [0, size)
    }


    // return an independent iterator over items in random order
    @Override
    public Iterator<Item> iterator() {
        return new NodeIterator();
    }

    private class NodeIterator implements Iterator<Item> {

        private final RandomizedQueue<Item> itemsToIterate;

        NodeIterator() {
            itemsToIterate = new RandomizedQueue<>();
            for (int i = 0; i < size; i++) {
                itemsToIterate.enqueue((Item) items[i]);
            }
        }

        @Override
        public boolean hasNext() {
            return !itemsToIterate.isEmpty();
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return itemsToIterate.dequeue();
        }
    }


    // should be run with -ea flag
    public static void main(String[] args) {

        RandomizedQueue<Integer> rq = new RandomizedQueue<>();

        assert rq.isEmpty();
        assert !rq.iterator().hasNext();


        rq.enqueue(10);
        assert rq.size() == 1;
        assert !rq.isEmpty();
        assert rq.iterator().hasNext();
        assert rq.sample() == 10;
        assert rq.dequeue() == 10; // won't be called if -ea is not specified
        assert rq.size() == 0;
        assert rq.isEmpty();

        assert !rq.iterator().hasNext();

        rq.enqueue(10);
        rq.enqueue(20);
        rq.enqueue(30);
        rq.enqueue(40);
        rq.enqueue(50);
        rq.enqueue(60);
        rq.enqueue(70);
        rq.enqueue(80);
        assert rq.size() == 8;

        assert rq.sample() != rq.sample(); // won't always work


        int[] visited = new int[rq.size()];
        int index = 0;
        for (Integer i : rq) {
            // check that no such item has been visited before
            assert Arrays.binarySearch(visited, i) < 0;
            visited[index++] = i;
        }

        rq.dequeue();
        rq.dequeue();
        rq.dequeue();
        assert rq.size() == 5;
    }

}

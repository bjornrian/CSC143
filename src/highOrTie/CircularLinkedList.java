package highOrTie;

import movieProject.ArrayList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularLinkedList<E> {
    private Node<E> front;
    private Node<E> tail;

    public CircularLinkedList() {
        front = null;
        tail = null;
    }

    public int size() {
        int nodeCount = 1;
        Node<E> current = front.next;
        while (current != front) {
            current = current.next;
            nodeCount++;
        }
        return nodeCount;
    }

    public E get(int pos) {
        checkIndex(pos);
        Node<E> current = front;
        while (pos > 0) {
            current = current.next;
            pos--;
        }
        return current.data;
    }

    public void add(E value) {
        Node<E> newNode = new Node<E>(value);
        if (front == null) {
            front = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        tail.next = front;
    }

    public void remove(E value) {
        Node<E> newNode = new Node<E>(value);
        Node<E> current = front.next;
        if (front.equals(newNode)) {
            front = null;
        }
        while (current != front) {
            current = current.next;
        }
    }

    public void remove(int pos) {
        checkIndex(pos);
        Node<E> current = front;
        while (pos > 1) {
            current = current.next;
            pos--;
        }
        current.next = current.next.next;
        current.next = null;
    }

    private void checkIndex(int index) {
        if(index < 0 || index > size()) {
            throw new IllegalArgumentException("Error: Index/position must be " +
                    "more than zero and less than list size");
        }
    }

    private class CircularLinkedListIterator<E> implements Iterator<E> {
        private int position;           // current position within the list
        private boolean removeOK;       // whether it's okay to remove now

        // post: constructs an iterator for the given list
        public CircularLinkedListIterator() {
            position = 0;
            removeOK = false;
        }

        // post: returns true if there are more elements left, false otherwise
        public boolean hasNext() {
            return position < size();
        }

        // pre : hasNext() (throws NoSuchElementException if not)
        // post: returns the next element in the iteration
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = (E) CircularLinkedList.this.get(position);
            position++;
            removeOK = true;
            return result;
        }

        // pre : next() has been called without a call on remove (throws
        //       IllegalStateException if not)
        // post: removes the last element returned by the iterator
        public void remove() {
            if (!removeOK) {
                throw new IllegalStateException();
            }
            CircularLinkedList.this.remove(position - 1);
            position--;
            removeOK = false;
        }
    }

    private static class Node<E> {
        public E data;
        public Node<E> next;
        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }
}


package highOrTie;

import movieProject.ArrayList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularLinkedList<E> {
    private Node<E> front;

    public CircularLinkedList() {
        front = null;
    }

    public int size() {
        int nodeCount = 0;
        Node<E> current = front;
        while(current != null) {
            current = current.next;
            nodeCount++;
        }
        return nodeCount;
    }

    public Node<E> get(int pos) {
        Node<E> current = front;
        while(current != null) {
            current = current.next;
            pos--;
        }
        return current;
    }

    public void add(E value) {
        Node<E> current = front;
        while(current != null) {
            current = current.next;
        }
        current = new Node<E>(value);
    }

    public void remove(E value) {

    }

    public void remove(int pos) {

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


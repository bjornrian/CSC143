package highOrTie;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.xml.soap.Node;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularLinkedList<E> {
    private Node<E> front;
    private Node<E> tail;
    private int nodeCount;

    public CircularLinkedList() {
        front = null;
        tail = null;
        nodeCount = 0;
    }

    public int size() {
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
        nodeCount++;
    }

    public void remove(E valueToDelete) {
        boolean wasRemoved = false;
        Node<E> currentNode = front;
        if (front == null) {
            //empty list
            return;
        }

        do {
            Node<E> nextNode = currentNode.next;
            if (nextNode.data.equals(valueToDelete)) {
                if (tail == front) {
                    //list has only one element
                    front = null;
                    tail = null;
                } else {
                    currentNode.next = nextNode.next;
                    if (front == nextNode) {
                        //delete the front element
                        front = front.next;
                    }
                    if (tail == nextNode) {
                        //delete the tail element
                        tail = currentNode;
                    }
                }
                wasRemoved = true;
                break;
            }
            currentNode = nextNode;
        } while (currentNode != front);

        //update counter
        if (wasRemoved) nodeCount--;
    }

    public void remove(int pos) {
        checkIndex(pos);

        //we want to remove the head element
        if (pos == 0) {
            front = front.next;
            tail.next = front;
        }

        Node<E> currentNode = front;
        while (pos > 1) {
            currentNode = currentNode.next;
            pos--;
        }
        Node<E> nextNode = currentNode.next.next;
        currentNode.next.next = null;
        currentNode.next = nextNode;

        //update counter
        nodeCount--;
    }

    public void addAtFront(E data) {
        Node<E> newNode = new Node<>(data);
        newNode.next = front;
        front = newNode;
    }

    public void addAtEnd(E data) {
        Node<E> newNode = new Node<>(data);
        if (front == null) {
            front = newNode;
        } else {
            Node<E> current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void clear() {
        front = null;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size()) {
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


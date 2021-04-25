package movieProject;

import java.util.ArrayList;
import java.util.Iterator;

public class SortedArrayList<E extends Comparable<E>> {
    private ArrayList<E> list;
    private int numberOfElements = 0;

    public SortedArrayList() {
        list = new ArrayList<>();
    }

    public SortedArrayList(int initialCapacity) {
        list = new ArrayList<>(initialCapacity);
    }

    public void add(E value) {
        if(numberOfElements == 0) {
            list.add(value);
        } else {
            //use binary search to find the index where we want to insert our object
            int targetIndex = binarySearch(value);
            list.add(targetIndex, value);
        }
        numberOfElements++;
    }

    //todo ask Barry if void return type (in UML) is correct
    public int indexOf(E value) {
        return 0;
    }

    public Boolean contains(E value) {
        return null;
    }

    public E[] get(E value, E[] template) {
        return null;
    }

    public int size() {
        return numberOfElements;
    }

    public Boolean isEmpty() {
        return null;
    }

    public void clear() {

    }

    public E get(int index) {
        return list.get(index);
    }

    public void remove(int index) {

    }

    public Iterator<E> iterator() {
        return null;
    }

    //todo ask Barry if this needs to be private (it won't compile)
    public String toString() {
        for(int i = 0; i < list.size(); i++) {
            E movie = list.get(i);
            System.out.println(movie.toString());
        }
        return null;
    }

    /**
     * Search through the list until we find the target index where we want to insert the new element.
     *
     * @param value
     * @return
     */
    private int binarySearch(E value) {
        int min = 0;
        int max = list.size() - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (list.get(mid).compareTo(value) < 0) {
                min = mid + 1;
            } else if (list.get(mid).compareTo(value) > 0) {
                max = mid - 1;
            } else {
                return mid; // target found
            }
        }
        return min; // target not found
    }
}

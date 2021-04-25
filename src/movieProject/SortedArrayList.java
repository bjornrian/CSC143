package movieProject;

import java.util.ArrayList;
import java.util.Iterator;

public class SortedArrayList<E extends Comparable<E>> {
    private ArrayList<E> list;
    private int numberOfMovies = 0;

    public SortedArrayList() {
        list = new ArrayList<>();
    }

    public SortedArrayList(int initialCapacity) {
        list = new ArrayList<>(initialCapacity);
    }

    public void add(E value) {
        if(numberOfMovies == 0) {
            list.add(value);
        } else {
            //use binary search to find the index where we want to insert our object
            int targetIndex = binarySearch(list, value);
            list.add(targetIndex, value);
        }
        numberOfMovies++;
    }

    /**
     * Search through the list until we find the target index where we want to insert the new element.
     *
     * @param list
     * @param value
     * @return
     */
    private int binarySearch(ArrayList<E> list, E value) {
        return 0;
    }

    public void indexOf(E value) {
        
    }

    public Boolean contains(E value) {
        return null;
    }

    public E[] get(E value, E[] template) {
        return null;
    }

    public int size() {
        return numberOfMovies;
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
}

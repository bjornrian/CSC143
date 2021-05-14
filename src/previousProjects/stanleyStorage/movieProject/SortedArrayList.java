package previousProjects.stanleyStorage.movieProject;

import java.util.Iterator;

/**
 * This class represents an ArrayList that is automatically sorted when you add an
 * element to the list. This means that you can't input an element at a specified
 * index, although it does mean that you can utilize a binary search which is very
 * efficient at finding a specified element.
 *
 * @param <E> specified type of SortedArrayList
 */
public class SortedArrayList<E extends Comparable<E>> {
    private previousProjects.stanleyStorage.movieProject.ArrayList<E> list;
    private int numberOfElements = 0;

    /**
     * Constructor initializes an ArrayList
     */
    public SortedArrayList() {
        list = new ArrayList<>();
    }

    /**
     * Constructor initializes an ArrayList but with an initial capacity
     *
     * @param initialCapacity
     */
    public SortedArrayList(int initialCapacity) {
        list = new ArrayList<>(initialCapacity);
    }

    /**
     * This method adds a value to the ArrayList. It utilizes a binary search
     * to put it in the right place in the list.
     *
     * @param value
     */
    public void add(E value) {
        if(numberOfElements == 0) {
            list.add(value);
        } else {
            //use binary search to find the index where we want to insert our object
            int targetIndex = binarySearch(value);
            if(targetIndex < 0) {
                targetIndex = -targetIndex;
            }
            list.add(targetIndex, value);
        }
        numberOfElements++;
    }

    /**
     * This method utilizes binary search to find a value that the user specifies. If
     * the value is not found, a index that is negative will be returned that represents
     * where the value would be if it were in the list.
     *
     * @param value
     * @return index of the specified value
     */
    public int indexOf(E value) {
        return binarySearch(value);
    }

    /**
     * This method will return a Boolean value based of off whether a specified value is
     * found in the list. This method also utilizes binary search.
     *
     * @param value
     * @return
     */
    public Boolean contains(E value) {
        return binarySearch(value) >= 0;
    }

    /**
     * This method takes a value from the user and finds all elements in the list
     * that share this value. These elements are put into the template array.
     *
     * @param value value being searched for in the array
     * @param template array having elements added to
     * @return
     */
    public E[] get(E value, E[] template) {
        int indexOfValue = indexOf(value);
        E e = get(indexOfValue);
        template[0] = e;
        return template;
    }

    /**
     * Pass-through method
     *
     * @return size of list
     */
    public int size() {
        return list.size();
    }

    /**
     * Pass-through method
     *
     * @return true or false whether the list is empty
     */
    public Boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Pass-through method
     *
     */
    public void clear() {
        list.clear();
    }

    /**
     * Pass-through method
     *
     * @return value pointed to at that index in the list
     */
    public E get(int index) {
        return list.get(index);
    }

    /**
     * Pass-through method
     */
    public void remove(int index) {
        list.remove(index);
    }

    /**
     * Pass-through method
     *
     * @return iterator for the list
     */
    public Iterator<E> iterator() {
        return list.iterator();
    }

    /**
     * Pass-through method
     *
     * @return String that represents the list values
     */
    public String toString() {
        return list.toString();
    }

    /**
     * This method searches through the list until we find the target index
     * where we want to insert the new element.
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
        return -min; // target not found
    }
}

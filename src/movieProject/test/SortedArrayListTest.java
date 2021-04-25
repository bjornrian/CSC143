package movieProject.test;

import movieProject.Movie;
import movieProject.SortedArrayList;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortedArrayListTest {
    @Test
    public void testAdd() {
        SortedArrayList list = new SortedArrayList();
        assertEquals(0, list.size());
        Movie aladdin = new Movie("Aladdin");
        list.add(aladdin);
        assertEquals(1, list.size());
        Movie movieAtIndexZero = (Movie) list.get(0);
        assertEquals(aladdin.getTitle(), movieAtIndexZero.getTitle());

        Movie starTrek = new Movie("Star Trek");
        list.add(starTrek);
        assertEquals(2, list.size());

        movieAtIndexZero = (Movie) list.get(0);
        assertEquals(aladdin.getTitle(), movieAtIndexZero.getTitle());
        Movie movieAtIndexOne = (Movie) list.get(1);
        assertEquals(starTrek.getTitle(), movieAtIndexOne.getTitle());

        list.toString();
    }
}

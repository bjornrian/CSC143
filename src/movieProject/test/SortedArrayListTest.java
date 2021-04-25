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
        Movie barTime = new Movie("Bar Time");
        list.add(barTime);
        assertEquals(3, list.size());
        Movie darkSide = new Movie("Dark Side");
        list.add(darkSide);
        assertEquals(4, list.size());


        movieAtIndexZero = (Movie) list.get(0);
        assertEquals(aladdin.getTitle(), movieAtIndexZero.getTitle());
        Movie movieAtIndexOne = (Movie) list.get(1);
        assertEquals(barTime.getTitle(), movieAtIndexOne.getTitle());
        Movie movieAtIndexTwo = (Movie) list.get(2);
        assertEquals(darkSide.getTitle(), movieAtIndexTwo.getTitle());
        Movie movieAtIndexThree = (Movie) list.get(3);
        assertEquals(starTrek.getTitle(), movieAtIndexThree.getTitle());

        list.toString();
    }
}

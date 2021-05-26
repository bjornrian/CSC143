package previousProjects.movieProject.test;

import previousProjects.stanleyStorage.movieProject.Movie;
import previousProjects.stanleyStorage.movieProject.SortedArrayList;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortedArrayListTest {

    private static final String ALADDIN = "Aladdin";
    private static final String STAR_TREK = "Star Trek";
    private static final String BAR_TIME = "Bar Time";
    private static final String DARK_SIDE = "Dark Side";
    private static final String ABRACADABRA = "Abracadabra";
    public static final String DOES_NOT_EXIST = "Does not exist";

    @Test
    public void testAddSingleMovie() {
        SortedArrayList list = new SortedArrayList();
        assertEquals(0, list.size());
        Movie aladdin = new Movie(ALADDIN);
        list.add(aladdin);
        assertEquals(1, list.size());
        Movie movieAtIndexZero = (Movie) list.get(0);
        assertEquals(aladdin.getTitle(), movieAtIndexZero.getTitle());
        list.toString();
    }

    @Test
    public void testAddMultipleMovies() {
        SortedArrayList list = buildListWithMultipleMovies();
        assertEquals(5, list.size());
        assertEquals(ABRACADABRA, ((Movie) list.get(0)).getTitle());
        assertEquals(ALADDIN, ((Movie) list.get(1)).getTitle());
        assertEquals(BAR_TIME, ((Movie) list.get(2)).getTitle());
        assertEquals(DARK_SIDE, ((Movie) list.get(3)).getTitle());
        assertEquals(STAR_TREK, ((Movie) list.get(4)).getTitle());

        list.toString();
    }

    /**
     * Build a list of multiple movies and make sure they are positioned at the correct index
     */
    @Test
    public void testIndexOf() {
        SortedArrayList list = buildListWithMultipleMovies();
        Movie abracadabra = new Movie(ABRACADABRA);
        Movie aladdin = new Movie(ALADDIN);
        Movie barTime = new Movie(BAR_TIME);
        Movie darkSide = new Movie(DARK_SIDE);
        Movie starTrek = new Movie(STAR_TREK);
        Movie doesNotExist = new Movie(DOES_NOT_EXIST);

        assertEquals(0, list.indexOf(abracadabra));
        assertEquals(1, list.indexOf(aladdin));
        assertEquals(2, list.indexOf(barTime));
        assertEquals(3, list.indexOf(darkSide));
        assertEquals(4, list.indexOf(starTrek));
        assertTrue(list.indexOf(doesNotExist) < 0);
    }

    /**
     * Build a list of multiple movies and make sure the contains method works correctly for
     * existing movies as well as non-existing movies
     */
    @Test
    public void testContains() {
        SortedArrayList list = buildListWithMultipleMovies();
        assertTrue(list.contains(new Movie(ABRACADABRA)));
        assertTrue(list.contains(new Movie(ALADDIN)));
        assertTrue(list.contains(new Movie(BAR_TIME)));
        assertTrue(list.contains(new Movie(DARK_SIDE)));
        assertTrue(list.contains(new Movie(STAR_TREK)));
        assertFalse(list.contains(new Movie(DOES_NOT_EXIST)));
    }

    private SortedArrayList buildListWithMultipleMovies() {
        SortedArrayList list = new SortedArrayList();
        Movie aladdin = new Movie(ALADDIN);
        list.add(aladdin);
        Movie starTrek = new Movie(STAR_TREK);
        list.add(starTrek);
        Movie barTime = new Movie(BAR_TIME);
        list.add(barTime);
        Movie darkSide = new Movie(DARK_SIDE);
        list.add(darkSide);
        Movie abracadabra = new Movie(ABRACADABRA);
        list.add(abracadabra);

        return list;
    }
}

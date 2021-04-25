package movieProject;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {
    @Test
    public void testCompareTo() {
        Movie thisMovie = new Movie("aladdin");
        Movie thatMovie = new Movie("aladdin da");
        Movie thatMovie2 = new Movie("balloon");
        Movie thatMovie3 = new Movie("aladdinda");
        assertEquals(1, thisMovie.compareTo(thatMovie));
    }
}

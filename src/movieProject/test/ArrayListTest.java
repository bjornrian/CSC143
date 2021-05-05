package movieProject.test;

import movieProject.ArrayList;
import movieProject.Movie;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayListTest {
    @Test
    public void testAddAtIndex() {
        ArrayList<Movie> list = buildList();
        assertEquals(4, list.size());
        String movieTitle = "Chicken Little";
        list.add(2, new Movie(movieTitle));
        assertEquals(5, list.size());
        assertEquals(movieTitle, list.get(2).getTitle());
    }

    private ArrayList<Movie> buildList() {
        ArrayList<Movie> list = new ArrayList();
        list.add(new Movie("Rocky"));
        list.add(new Movie("Rocky 2"));
        list.add(new Movie("Rocky 3"));
        list.add(new Movie("Rocky 4"));
        return list;
    }
}

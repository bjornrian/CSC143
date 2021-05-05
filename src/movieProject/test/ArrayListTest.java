package movieProject.test;

import movieProject.ArrayList;
import movieProject.Movie;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayListTest {
    @Test
    public void testToArrayWithJavaUtil() {
        //testing a java util arraylist
        java.util.ArrayList utilList = new java.util.ArrayList<String>();
        utilList.add("four");
        utilList.add("five");
        utilList.add("six");
        String[] myStringArray = {"one", "two", "three"};
        Object[] objects = utilList.toArray(myStringArray);
        assertEquals("four", objects[0]);
        assertEquals("five", objects[1]);
        assertEquals("six", objects[2]);
    }

    @Test
    public void testToArray() {
        //testing a java util arraylist
        movieProject.ArrayList list = new movieProject.ArrayList<String>();
        list.add("four");
        list.add("five");
        list.add("six");
        String[] myStringArray = {"one", "two", "three"};
        Object[] objects = list.toArray(myStringArray);
        assertEquals("four", objects[0]);
        assertEquals("five", objects[1]);
        assertEquals("six", objects[2]);
    }

    @Test
    public void testAddAtIndex() {
        ArrayList<Movie> list = buildList();
        assertEquals(4, list.size());
        String movieTitle = "Chicken Little";
        list.add(2, new Movie(movieTitle));
        assertEquals(5, list.size());
        assertEquals(movieTitle, list.get(2).getTitle());
    }

    @Test
    public void testRemoveAtIndex() {
        ArrayList<Movie> list = buildList();
        assertEquals(4, list.size());
        list.remove(2);
        assertEquals(3, list.size());
        assertEquals("Rocky 4", list.get(2).getTitle());
        list.remove(0);
        assertEquals("Rocky 2", list.get(0).getTitle());
        list.remove(1);
        assertEquals("Rocky 2", list.get(0).getTitle());
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

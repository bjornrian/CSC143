package previousProjects.stanleyStorage.movieProject.test;

import previousProjects.stanleyStorage.movieProject.Movie;
import previousProjects.stanleyStorage.movieProject.SortedArrayList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MovieTest {
    @Test
    public void testCompareTo() {
        Movie boy = new Movie("Boy");
        Movie city = new Movie("City");
        Movie equestria = new Movie("Equestria Girls");
        Movie food = new Movie("Food");
        Movie forGood = new Movie("For your own good");
        Movie franca = new Movie("Franca");
        Movie franchHa = new Movie("Franch Ha");
        Movie generation = new Movie("Generation Iron 2");

        assertTrue(boy.compareTo(city) < 0);
        assertTrue(city.compareTo(equestria) < 0);
        assertTrue(equestria.compareTo(food) < 0);
        assertTrue(food.compareTo(forGood) < 0);
        assertTrue(forGood.compareTo(franca) < 0);
        assertTrue(franca.compareTo(franchHa) < 0);
        assertTrue(franchHa.compareTo(generation) < 0);
    }

    @Test
    public void testGetCategory() {
        Movie movie = buildMovie();
        assertEquals(3, movie.getCategoryCount());
        movie.addCategory("Documentaries");
        assertEquals(4, movie.getCategoryCount());
    }

    @Test(expected = RuntimeException.class)
    public void testAddInvalidCategory() {
        buildMovie().addCategory("Invalid Category");
    }

    private Movie buildMovie() {
        SortedArrayList<String> categories = new SortedArrayList<>(3);
        categories.add("Teen TV Shows");
        categories.add("Music & Musicals");
        categories.add("Dramas");
        Movie movie = new Movie("Chicken Run",
                "Bob Ryan",
                "Tom",
                "Documentary",
                "Norway",
                2016,
                "R",
                "90",
                categories,
                "Bad movie from Norway (not surprising).");
        return movie;
    }
}

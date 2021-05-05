package movieProject.test;

import movieProject.ArrayList;
import movieProject.Movie;
import movieProject.MovieManager;
import static org.junit.Assert.*;
import org.junit.Test;

public class MovieManagerTest {
    @Test
    public void testReadingFromFile() {
        MovieManager manager = new MovieManager();
        Movie movie = manager.getMovie(10);
        assertNotNull(movie);
        ArrayList<Movie> dramas = manager.getMoviesByCategory("Dramas");
        assertTrue(dramas.size() > 0);
        ArrayList<Movie> romances = manager.getMoviesByTitle("Manhattan Romance");
        assertTrue(romances.size() > 0);
    }
}

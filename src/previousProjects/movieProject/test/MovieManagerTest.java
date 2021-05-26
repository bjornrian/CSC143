package previousProjects.movieProject.test;

import org.junit.Before;
import org.junit.Test;
import previousProjects.movieProject.ArrayList;
import previousProjects.movieProject.Movie;
import previousProjects.movieProject.MovieManager;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MovieManagerTest {
    private MovieManager manager;

    @Before
    public void initialize() {
        manager = new MovieManager();
    }

    @Test
    public void testGetMovie() {
        Movie movie = manager.getMovie(10);
        assertNotNull(movie);
    }

    @Test
    public void testGetMoviesByCategory() {
        ArrayList<Movie> dramas = manager.getMoviesByCategory("Dramas");
        assertTrue(dramas.size() > 0);
    }

    @Test
    public void testGetMoviesByTitle() {
        ArrayList<Movie> romances = manager.getMoviesByTitle("Manhattan Romance");
        assertTrue(romances.size() > 0);
    }
}

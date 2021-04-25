package movieProject;

public class MovieManager {
    private SortedArrayList<Movie> movies;

    public MovieManager() {
        readMoviesFromFile();
    }

    public Movie getMovie(int index) {
        return null;
    }

    public Movie[] getMoviesByTitle(String movieTitle) {
        return null;
    }

    public Movie[] getMoviesByCategory(String movieCategory) {
        return null;
    }

    private boolean readMoviesFromFile() {
        return true;
    }
}

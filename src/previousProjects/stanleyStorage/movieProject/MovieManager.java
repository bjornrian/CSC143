package previousProjects.stanleyStorage.movieProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * This class represents a manager for a list of movies. It can grab movies from
 * a specified index, title, or category.
 */
public class MovieManager {
    public static final String PATH_MOVIE = "src/previousProjects.stanleyStorage.movieProject/resources/movie.txt";
    public static final int TITLE = 0;
    public static final int DIRECTOR = 1;
    public static final int CAST = 2;
    public static final int TYPE = 3;
    public static final int COUNTRY = 4;
    public static final int RELEASE_YEAR = 5;
    public static final int RATING = 6;
    public static final int DURATION = 7;
    public static final int CATEGORIES = 8;
    public static final int DESCRIPTION = 9;
    private SortedArrayList<Movie> movies;

    /**
     * Initializes a SortedArrayList of movies that will hold the movies read
     * from the file.
     */
    public MovieManager() {
        movies = new SortedArrayList<Movie>(6000);
        readMoviesFromFile();
    }

    /**
     * This method takes a specified index and returns a movie that is pointed
     * to on that index of the movies list.
     *
     * @param index
     * @return
     */
    public Movie getMovie(int index) {
        return movies.get(index);
    }

    /**
     * This method takes a String movie title, and returns an ArrayList of movies
     * that share that name.
     *
     * @param movieTitle
     * @return
     */
    public ArrayList<Movie> getMoviesByTitle(String movieTitle) {
        ArrayList<Movie> desiredMovies = new ArrayList<>(5000);
        int movieListIdx = 0;
        for (int idx = 0; idx < movies.size(); idx++) {
            if (movies.get(idx).getTitle().equals(movieTitle)) {
                desiredMovies.add(movieListIdx, movies.get(idx));
                movieListIdx++;
            }
        }
        return desiredMovies;
    }

    /**
     * This method takes a String movie category, and returns an ArrayList of movies
     * that share that category.
     *
     * @param movieCategory
     * @return
     */
    public ArrayList<Movie> getMoviesByCategory(String movieCategory) {
        int maxSize = 5000;
        ArrayList<Movie> desiredMovies = new ArrayList<>(maxSize);
        int movieListIdx = 0;
        for (int idx = 0; idx < movies.size(); idx++) {
            if(movieListIdx >= maxSize) {
                System.out.println("Maximum size of movies by category reached.");
                break;
            }
            for (int categoryIdx = 0; categoryIdx < movies.get(idx).getCategoryCount(); categoryIdx++) {
                if (movies.get(idx).getCategories().get(categoryIdx).equals(movieCategory)) {
                    desiredMovies.add(movieListIdx++, movies.get(idx));
                }
            }
        }
        return desiredMovies;
    }

    private boolean readMoviesFromFile() {
        try {
            Scanner fileIn = new Scanner(new File(PATH_MOVIE));
            fileIn.nextLine();
            while (fileIn.hasNextLine()) {
                //title~director~cast~type~country~release_year~rating~duration~listed_in~description
                String movieElements = fileIn.nextLine();
                String[] elements = movieElements.split("`");
                String title = elements[TITLE];
                String director = elements[DIRECTOR];
                String cast = elements[CAST];
                String type = elements[TYPE];
                String country = elements[COUNTRY];
                int releaseYear = Integer.parseInt(elements[RELEASE_YEAR]);
                String rating = elements[RATING];
                String duration = elements[DURATION];
                String unsortedCategories = elements[CATEGORIES];
                String description = elements[DESCRIPTION];

                String[] categoryList = unsortedCategories.split(",");
                SortedArrayList<String> sortedCategories = new SortedArrayList<>(categoryList.length);
                for (int idx = 0; idx < categoryList.length; idx++) {
                    sortedCategories.add(categoryList[idx]);
                }

                Movie oneMovie = new Movie(title, director, cast, type, country,
                        releaseYear, rating, duration, sortedCategories, description);
                movies.add(oneMovie);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Movie file not found.");
        }
        return true;
    }
}

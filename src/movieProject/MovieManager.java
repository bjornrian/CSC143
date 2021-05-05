package movieProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MovieManager {
    public static final String PATH_MOVIE = "src/movieProject/resources/category.txt";
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
    public SortedArrayList<Movie> movies;

    public MovieManager() {
        readMoviesFromFile();
    }

    public Movie getMovie(int index) {
        return movies.get(index);
    }

    public Movie[] getMoviesByTitle(String movieTitle) {
        Movie[] desiredMovies = new Movie[50];
        int movieListIdx = 0;
        for (int idx = 0; idx < movies.size(); idx++) {
            if (movies.get(idx).getTitle().equals(movieTitle)) {
                desiredMovies[movieListIdx] = movies.get(idx);
                movieListIdx++;
            }
        }
        return desiredMovies;
    }

    public Movie[] getMoviesByCategory(String movieCategory) {
        Movie[] desiredMovies = new Movie[50];
        int movieListIdx = 0;
        for (int idx = 0; idx < movies.size(); idx++) {
            for (int categoryIdx = 0; categoryIdx < movies.get(idx).getCategoryCount(); categoryIdx++) {
                if (movies.get(idx).getCategories().get(categoryIdx).equals(movieCategory)) {
                    desiredMovies[movieListIdx] = movies.get(idx);
                    movieListIdx++;
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

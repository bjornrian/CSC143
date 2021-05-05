package movieProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MovieManager {
    private SortedArrayList<Movie> movies;

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
            Scanner fileIn = new Scanner(new File("movie.txt"));
            fileIn.nextLine();
            while (fileIn.hasNextLine()) {
                String movieElements = fileIn.nextLine();
                String[] elements = movieElements.split("`");
                String title = elements[0];
                String director = elements[1];
                String cast = elements[2];
                String type = elements[3];
                String country = elements[4];
                int releaseYear = Integer.parseInt(elements[5]);
                String rating = elements[6];
                String duration = elements[7];
                String unsortedCategories = elements[8];
                String description = elements[9];

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

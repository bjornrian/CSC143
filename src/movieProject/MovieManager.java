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
        return null;
    }

    public Movie[] getMoviesByTitle(String movieTitle) {
        return null;
    }

    public Movie[] getMoviesByCategory(String movieCategory) {
        return null;
    }

    private boolean readMoviesFromFile() {
        try {
            Scanner fileIn = new Scanner(new File("movie.txt"));
            fileIn.nextLine();
            while(!fileIn.next().equals("`")) {
                fileIn.next("`");
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Error: Movie file not found.");
        }

        //loop through each line
        //create new Movie object
        //movies.addNew

        return true;
    }
}

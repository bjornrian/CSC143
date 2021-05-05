package movieProject;

public class Main {
    public static void main(String[] args) {
        MovieManager manager = new MovieManager();
        Movie movie = manager.getMovie(10);
        System.out.println("We found a movie titled " + movie.getTitle());
        ArrayList<Movie> dramas = manager.getMoviesByCategory("Dramas");
        System.out.println("We found  " + dramas.size() + " movies in the Dramas category");
        ArrayList<Movie> romances = manager.getMoviesByTitle("Manhattan Romance");
        System.out.println("We found " + romances.size() + " movies called Manhattan Romance");
    }
}


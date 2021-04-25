package movieProject;

public class Movie implements Comparable<Movie>{

    private static SortedArrayList<String> allCategories;

    static {
        allCategories = new SortedArrayList<>();
    }

    private String title;
    private String director;
    private String cast;
    private String type;
    private String country;
    private int releaseYear;
    private String rating;
    private String duration;
    private String description;
    private SortedArrayList<String> categories;

    public Movie(String title, String director, String cast, String type,
                 String country, int releaseYear, String rating, String duration,
                 String description, SortedArrayList<String> categories) {
        this.title = title;
        this.director = director;
        this.cast = cast;
        this.type = type;
        this.country = country;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.duration = duration;
        this.description = description;
        this.categories = categories;
    }

    public Movie(String title) {
        this.title = title;
    }

    public void addCategory(String category) {
        //todo fix SortedArrayList to complete method addCategory
    }

    public int getCategoryCount() {
        return 0;
    }

    public String getCategory(String category) {
        return "incomplete";
    }

    public String getCategories() {
        return "incomplete";
    }

    public int compareTo(Movie otherMovie) {
        if(this.title.equals(otherMovie.title)) {
            return 0;
        }
        else if(this.title.length() == otherMovie.title.length()) {
            for(int charIdx = 0; charIdx < this.title.length(); charIdx++) {
                if(this.title.charAt(charIdx) < otherMovie.title.charAt(charIdx)) {
                    return 1;
                }
            }
        }
        else if(this.title.length() < otherMovie.title.length()) {
            return 1;
        }
        return -1;
    }

    public String toString() {
        return "incomplete";
    }
}

package movieProject;

public class Movie implements Comparable{
    static {
        private SortedArrayList<String> allCategories;
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

    //todo fix compareTo
    @Override
    public int compareTo(Movie otherMovie) {
        return 0;
    }

    public String toString() {
        return "incomplete";
    }
}

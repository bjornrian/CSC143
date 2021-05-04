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
                 SortedArrayList<String> categories, String description) {
        this.title = title;
        this.director = director;
        this.cast = cast;
        this.type = type;
        this.country = country;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.duration = duration;
        this.categories = categories;
        this.description = description;
    }

    public Movie(String title) {
        this.title = title;
    }

    public void addCategory(String category) {
        categories.add(category);
    }

    public int getCategoryCount() {
        return categories.size();
    }

    //todo ask Barry about getCategory method (parameter and/or return type wrong?)
    public String getCategory(String category) {
        return null;
    }

    public SortedArrayList<String> getCategories() {
        return categories;
    }

    public int compareTo(Movie otherMovie) {
        return this.getTitle().toUpperCase().compareTo(otherMovie.getTitle().toUpperCase());
    }

    public String toString() {
        return "Title: " + title + "\n" +
                "Director: " + director + "\n" +
                "Cast: " + cast + "\n" +
                "Type: " + type + "\n" +
                "Country: " + country + "\n" +
                "Release Year: " + releaseYear + "\n" +
                "Rating: " + rating + "\n" +
                "Duration: " + duration + "\n" +
                "Categories: " + categories + "\n" +
                "Description: " + description;
    }

    public String getTitle() {
        return title;
    }
}

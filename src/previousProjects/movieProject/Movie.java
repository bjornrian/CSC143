package previousProjects.movieProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This Movie class represents a movie that has many different properties such as a title,
 * cast, and duration. It maintains an official list of categories.
 *
 */
public class Movie implements Comparable<Movie> {
    public static final String PATH_CATEGORY = "src/previousProjects.stanleyStorage.movieProject/resources/category.txt";
    private static SortedArrayList<String> allCategories = new SortedArrayList<>();

    static {
        readInCategories();
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

    /**
     * The constructor takes in ten different parameters which are the properties
     * of each movie being made.
     *
     * @param title
     * @param director
     * @param cast
     * @param type
     * @param country
     * @param releaseYear
     * @param rating
     * @param duration
     * @param categories
     * @param description
     */
    public Movie(String title, String director, String cast, String type,
                 String country, int releaseYear, String rating, String duration,
                 SortedArrayList<String> categories, String description) {
        this(title);
        this.director = director;
        this.cast = cast;
        this.type = type;
        this.country = country;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.duration = duration;
        this.categories = categories; //change back to getOfficialCategories(categories)
        this.description = description;
    }

    /**
     * This constructor creates a simple Movie object with only a title and reads in the
     * official list of categories. This list is static and quickly accessible without the
     * need to read it again.
     *
     * @param title
     */
    public Movie(String title) {
        this.title = title;
        readInCategories();
    }

    /**
     * This method adds a category to the SortedArrayList of categories that the Movie object
     * holds.
     *
     * @param category type of movie
     */
    public void addCategory(String category) {
        categories.add(getCategory(category));
    }

    /**
     * This method retrieves the number of categories that the movie is listed under.
     *
     * @return
     */
    public int getCategoryCount() {
        return categories.size();
    }

    /**
     * This method takes an arbitrary category string and returns a reference to the official
     * list of categories.
     *
     * @param category normal string that the user inputs
     * @return official category from allCategories list
     */
    public String getCategory(String category) {
        for (int index = 0; index < allCategories.size(); index++) {
            if (allCategories.get(index).equalsIgnoreCase(category)) {
                return allCategories.get(index);
            }
        }
        throw new RuntimeException("Category not found in official category list.");
    }

    /**
     * This returns a SortedArrayList of the categories that the Movie object has.
     *
     * @return
     */
    public SortedArrayList<String> getCategories() {
        return categories;
    }


    /**
     * This method is used to compare two different movies alphabetically based on
     * their titles. It is not case sensitive.
     *
     * @param otherMovie movie being compared to
     * @return 1, 0, or -1 based off of how the titles compare
     */
    public int compareTo(Movie otherMovie) {
        return this.title.toUpperCase().compareTo(otherMovie.getTitle().toUpperCase());
    }

    public String toString() {
        return "Title: " + title +
                ", Director: " + director +
                ", Release Year: " + releaseYear +
                ", Categories: " + categories;
    }

    public String getTitle() {
        return title;
    }

    private static void readInCategories() {
        try {
            Scanner categoryScanner = new Scanner(new File(PATH_CATEGORY));
            while (categoryScanner.hasNextLine()) {
                String oneCategory = categoryScanner.nextLine();
                allCategories.add(oneCategory);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error: Category file not found.");
        }
    }

    private SortedArrayList<String> getOfficialCategories(SortedArrayList<String> categories) {
        SortedArrayList<String> officialCategories = new SortedArrayList<>(50);
        for (int idx = 0; idx < categories.size(); idx++) {
            officialCategories.add(getCategory(categories.get(idx)));
        }
        return officialCategories;
    }
}

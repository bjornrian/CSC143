package movieProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Movie implements Comparable<Movie> {
    public static final String PATH_CATEGORY = "src/movieProject/resources/category.txt";
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
        this.categories = getOfficialCategories(categories);
        this.description = description;
    }

    public Movie(String title) {
        this.title = title;
        readInCategories();
    }

    public void addCategory(String category) {
        categories.add(getCategory(category));
    }

    public int getCategoryCount() {
        return categories.size();
    }

    public String getCategory(String category) {
        for (int index = 0; index < allCategories.size(); index++) {
            if (allCategories.get(index).equalsIgnoreCase(category)) {
                return allCategories.get(index);
            }
        }
        throw new RuntimeException("Category not found in official category list.");
    }

    public SortedArrayList<String> getCategories() {
        return categories;
    }

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

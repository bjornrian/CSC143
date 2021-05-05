package movieProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Movie implements Comparable<Movie>{
    private static SortedArrayList<String> allCategories;

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
        readInCategories();
    }

    public Movie(String title) {
        this.title = title;
        readInCategories(); //does this method need to be run for this constructor?
    }

    public void addCategory(String category) {
        categories.add(category);
    }

    public int getCategoryCount() {
        return categories.size();
    }

    public String getCategory(String category) {
        for(int catIdx = 0; catIdx < allCategories.size(); catIdx++) {
            if(allCategories.get(catIdx).equals(category)) {
                return allCategories.get(catIdx);
            }
        }
        return "Error: Category not found in official category list.";
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

    private void readInCategories() {
        try {
            Scanner categoryScanner = new Scanner(new File("category.txt"));
            while(categoryScanner.hasNextLine()) {
                String oneCategory = categoryScanner.nextLine();
                allCategories.add(oneCategory);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Error: Movie file not found.");
        }
    }
}

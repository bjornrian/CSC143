package movieProject.test;

import movieProject.Movie;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MovieTest {
    @Test
    public void testCompareTo() {
        System.out.println("abc".compareTo("abcd"));//-1
        System.out.println("word".compareTo("apple"));//22
        System.out.println("apple".compareTo("word"));//-22
        System.out.println("apple".compareTo("apple"));//0
        System.out.println("apple".compareTo("Apple"));//32
        System.out.println("Aardwark".compareTo("Xenomorph"));//-23

        Movie boy = new Movie("Boy");
        Movie city = new Movie("City");
        Movie equestria = new Movie("Equestria Girls");
        Movie food = new Movie("Food");
        Movie forGood = new Movie("For your own good");
        Movie franca = new Movie("Franca");
        Movie franchHa = new Movie("Franch Ha");
        Movie generation = new Movie("Generation Iron 2");

        assertTrue(boy.compareTo(city) < 0);
        assertTrue(city.compareTo(equestria) < 0);
        assertTrue(equestria.compareTo(food) < 0);
        assertTrue(food.compareTo(forGood) < 0);
        assertTrue(forGood.compareTo(franca) < 0);
        assertTrue(franca.compareTo(franchHa) < 0);
        assertTrue(franchHa.compareTo(generation) < 0);
    }
}

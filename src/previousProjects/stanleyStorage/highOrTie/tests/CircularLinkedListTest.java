package previousProjects.stanleyStorage.highOrTie.tests;

import previousProjects.stanleyStorage.highOrTie.classes.CircularLinkedList;
import previousProjects.stanleyStorage.highOrTie.classes.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class CircularLinkedListTest {
    @Test
    public void testAddAndGet() {
        CircularLinkedList<Player> playerList = buildList();
        assertEquals("Ildris",((Player) playerList.get(0)).getName());
        assertEquals("Siad",((Player) playerList.get(1)).getName());
        assertEquals("Edward",((Player) playerList.get(2)).getName());
        assertEquals("Drew",((Player) playerList.get(3)).getName());
    }

    @Test
    public void testSize() {
        CircularLinkedList<Player> playerList = buildList();
        assertEquals(4, playerList.size());
        playerList.add(new Player("Adi"));
        assertEquals(5, playerList.size());
    }

    @Test
    public void testRemoveValueFromBeginningOfList() {
        CircularLinkedList<Player> list = buildList();
        list.remove(new Player("Ildris"));
        assertEquals(3, list.size());
        assertEquals("Siad", list.get(0).getName());
    }

    @Test
    public void testRemoveValueFromMiddleOfList() {
        CircularLinkedList<Player> list = buildList();
        list.remove(new Player("Edward"));
        assertEquals(3, list.size());
        assertEquals("Siad", list.get(1).getName());
    }

    @Test
    public void testRemoveValueFromEndOfList() {
        CircularLinkedList<Player> list = buildList();
        list.remove(new Player("Drew"));
        assertEquals(3, list.size());
        assertEquals("Siad", list.get(1).getName());
    }

    @Test
    public void testRemovePositionFromFront() {
        CircularLinkedList<Player> list = buildList();
        assertEquals(4, list.size());
        list.remove(0);
        assertEquals(3, list.size());
        assertEquals("Siad",((Player) list.get(0)).getName());
    }

    /**
     * Remove element from the end of a list
     */

    @Test
    public void testRemovePositionFromTail() {
        CircularLinkedList<Player> list = buildList();
        assertEquals(4, list.size());
        list.remove(3);
        assertEquals(3, list.size());
        assertEquals("Edward",((Player) list.get(2)).getName());
    }

    /**
     * Remove from a list with only one element
     */
    @Test
    public void testRemovePositionWithOneElement() {
        CircularLinkedList<Player> list = buildListWithOneElement();
        assertEquals(1, list.size());
        list.remove(0);
        assertEquals(0, list.size());
    }

    private CircularLinkedList<Player> buildListWithOneElement() {
        CircularLinkedList<Player> playerList = new CircularLinkedList<>();
        Player ildris = new Player("Ildris");
        playerList.add(ildris);
        return playerList;    }

    private CircularLinkedList<Player> buildList() {
        CircularLinkedList<Player> playerList = new CircularLinkedList<>();
        Player ildris = new Player("Ildris");
        Player siad = new Player("Siad");
        Player edward = new Player("Edward");
        Player drew = new Player("Drew");
        playerList.add(ildris);
        playerList.add(siad);
        playerList.add(edward);
        playerList.add(drew);
        return playerList;
    }
}

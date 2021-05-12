package highOrTie;

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
    public void testRemoveValue() {

    }

    @Test
    public void testRemovePosition() {

    }

    public CircularLinkedList<Player> buildList() {
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

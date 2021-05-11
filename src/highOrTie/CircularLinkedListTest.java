package highOrTie;

import org.junit.Test;

import static org.junit.Assert.*;

public class CircularLinkedListTest {
    @Test
    public void testAdd() {
        CircularLinkedList<Player> playerList = new CircularLinkedList<>();
        Player ildris = new Player("Ildris");
        Player siad = new Player("Siad");
        Player edward = new Player("Edward");
        Player drew = new Player("Drew");
        playerList.add(ildris);
        playerList.add(siad);
        playerList.add(edward);
        playerList.add(drew);
        assertEquals("Ildris",((Node) playerList.get(0)).getName());
        System.out.println(playerList.get(0));
    }
}

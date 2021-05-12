package highOrTie;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class Game implements Iterable{
    private int playerCount;
    private int maximumStrikes;
    private int pauseLength;
    private int highestRoll;
    private CircularLinkedList<Player> players;

    public Game(int playerCount, int maximumStrikes, int pauseLength) {
        this.playerCount = playerCount;
        this.maximumStrikes = maximumStrikes;
        this.pauseLength = pauseLength;

        players = new CircularLinkedList<>();
        for(int i = 1; i <= playerCount; i++) {
            String playerName = "Player" + i;
            players.add(new Player(playerName));
        }
    }

    public void play() {
        System.out.println("Start of game");
        while(players.size() > 1) {
            for(int i = 0; i < players.size(); i++) {

            }
            try {
                TimeUnit.SECONDS.sleep(pauseLength);
                players.remove(players.size() - 1);
                System.out.println("I'm removing one");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("remaining winner is " + players.get(0).getName());
        System.out.println("Game over");
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator spliterator() {
        return Iterable.super.spliterator();
    }
}

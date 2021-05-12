package highOrTie;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class Game implements Iterable {
    private int playerCount;
    private int maximumStrikes;
    private int pauseLength;
    private int highestRoll;
    private CircularLinkedList<Player> players;

    public Game(int playerCount, int maximumStrikes, int pauseLength) {
        this.playerCount = playerCount;
        this.maximumStrikes = maximumStrikes;
        this.pauseLength = pauseLength;
        highestRoll = 0;

        players = new CircularLinkedList<>();
        for (int i = 1; i <= playerCount; i++) {
            String playerName = "Player" + i;
            players.add(new Player(playerName));
        }
    }

    public void play() {
        System.out.println("Start of game");
        while (players.size() > 1) {
            Player highRoller = null;
            for (int i = 0; i < players.size(); i++) {
                Player currentPlayer = players.get(i);
                if (currentPlayer.equals(highRoller)) {
                    System.out.println("Current high = " + highestRoll + ", " +
                            currentPlayer.getName() + " passes");
                    continue;
                }
                currentPlayer.rollDice();
                if (currentPlayer.getLastRoll() >= highestRoll) {
                    highRoller = currentPlayer;
                    highestRoll = currentPlayer.getLastRoll();
                    System.out.println("Current high = " + highestRoll + ", " +
                            currentPlayer.getName() + " rolled a " + currentPlayer.getLastRoll());
                } else if (currentPlayer.getLastRoll() < highestRoll) {
                    currentPlayer.addStrike();
                    if (currentPlayer.getNumberOfStrikes() >= maximumStrikes) {
                        System.out.println("Current high = " + highestRoll + ", " +
                                currentPlayer.getName() + " rolled a " + currentPlayer.getLastRoll() +
                                ", strike " + currentPlayer.getNumberOfStrikes() + ", out of the game!");
                        players.remove(i);
                        System.out.println("players.size() = " + players.size());
                    } else {
                        System.out.println("Current high = " + highestRoll + ", " +
                                currentPlayer.getName() + " rolled a " + currentPlayer.getLastRoll() +
                                ", strike " + currentPlayer.getNumberOfStrikes());
                    }
                }
                try {
                    TimeUnit.SECONDS.sleep(pauseLength);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (players.size() > 1) {
                System.out.println();
                System.out.println("New Round");
            }
        }
        System.out.println();
        System.out.println("Winner is " + players.get(0).getName() + " with a roll of " + players.get(0).getLastRoll() + "!");
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

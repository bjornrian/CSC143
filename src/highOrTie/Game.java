package highOrTie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class Game implements Iterable {
    private int playerCount;
    private int maximumStrikes;
    private int pauseLength;
    private CircularLinkedList<Player> players;

    public Game(int playerCount, int maximumStrikes, int pauseLength) {
        this.playerCount = playerCount;
        this.maximumStrikes = maximumStrikes;
        this.pauseLength = pauseLength;

        players = new CircularLinkedList<>();
        for (int i = 1; i <= playerCount; i++) {
            String playerName = "Player" + i;
            players.add(new Player(playerName));
        }
    }

    public void play() {
        System.out.println("Start of game");
        int highestRoll = 0;
        Player highRoller = null;
        ArrayList<Integer> indexToBeRemoved = new ArrayList<>();

        while (players.size() > 1) {
            for (int i = 0; i < players.size(); i++) {
                Player currentPlayer = players.get(i);
                if (currentPlayer.equals(highRoller)) {
                    System.out.println("Current high = " + highestRoll + ", " +
                            currentPlayer.getName() + " passes");
                    continue;
                }

                int currentRoll = currentPlayer.roll();
                if (currentRoll > highestRoll) {
                    highRoller = currentPlayer;
                    highestRoll = currentRoll;
                    System.out.println("Current high = " + highestRoll + ", " +
                            currentPlayer.getName() + " rolled a " + currentRoll);
                } else {
                    currentPlayer.addStrike();
                    if (currentPlayer.getNumberOfStrikes() >= maximumStrikes) {
                        System.out.println("Current high = " + highestRoll + ", " +
                                currentPlayer.getName() + " rolled a " + currentRoll +
                                ", strike " + currentPlayer.getNumberOfStrikes() + ", out of the game!");
                        indexToBeRemoved.add(i);
//                        players.remove(i);
                    } else {
                        System.out.println("Current high = " + highestRoll + ", " +
                                currentPlayer.getName() + " rolled a " + currentRoll +
                                ", strike " + currentPlayer.getNumberOfStrikes());
                    }
                }

                try {
                    TimeUnit.SECONDS.sleep(pauseLength);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }//round ends here
            if(indexToBeRemoved.size() > 0) {
                for(Integer index : indexToBeRemoved) {
                    players.remove(index);
                }
                indexToBeRemoved.clear();
            }

            if (players.size() > 1) {
                System.out.println("\nNew Round");
            }
        }
        System.out.println();
        System.out.println("Winner is " + players.get(0).getName() + " with a roll of " + highestRoll + "!");
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

package previousProjects.stanleyStorage.highOrTie.classes;

import java.util.Objects;
import java.util.Random;

public class Player {
    private String name;
    private int numberOfStrikes;

    public Player(String name) {
        this.name = name;
        numberOfStrikes = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getNumberOfStrikes() {
        return this.numberOfStrikes;
    }

    public int roll() {
        Random rand = new Random();
        return rand.nextInt(100);
    }

    public void addStrike() {
        numberOfStrikes++;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        if(getClass() != o.getClass()) return false;
        Player p = (Player) o;
        return this.name.equals(p.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name + numberOfStrikes);
    }
}

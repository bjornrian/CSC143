package highOrTie;

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

    public void addStrike() {
        numberOfStrikes++;
    }
}

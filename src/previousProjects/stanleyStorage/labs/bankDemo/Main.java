package previousProjects.stanleyStorage.labs.bankDemo;

import java.util.Random;

public class Main {
    public enum Coin {
        HEADS, TAILS
    }

    public static void main(String[] args) {
        flipCoin();
    }

    public static void flipCoin() {
        Random randNum = new Random();
        boolean isHeads = false;
        while(!isHeads) {
            isHeads = randNum.nextBoolean();
            if(isHeads) {
                System.out.println(Coin.HEADS);
            }
            else {
                System.out.println(Coin.TAILS);
            }
        }
    }
}

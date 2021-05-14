package wearableDevices.classes;

import javax.swing.*;

public class WearableManager {
    private Wearable[] wearableList;
    private Index<Integer> rankingPositionData;
    private Index<Double> pricePositionData;
    private Index<String> coNamePositionData;

    public WearableManager() {
        readWearableFile();
    }

    public Wearable getWearableAtIndex(int index) {
        return null;
    }

    public int[] getRankingPositionData() {
        return null;
    }

    public int[] getPricingPositionData() {
        return null;
    }

    public int[] getCoNamePositionData() {
        return null;
    }

    public void generateCsv() {

    }

    private void readWearableFile() {

    }
}

package wearableDevices.classes;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        WearableManager manager = new WearableManager();
        System.out.println(Arrays.toString(manager.getRankingPositionData()));
        System.out.println(Arrays.toString(manager.getPricingPositionData()));
        System.out.println(Arrays.toString(manager.getCoNamePositionData()));
        manager.generateCsv(manager.getPricingPositionData(), "pricingDataCsvFile.csv");
    }
}

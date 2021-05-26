package previousProjects.wearableDevices.classes;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        WearableManager manager = new WearableManager();

        int[] rankingPositionData = manager.getRankingPositionData();
        int[] pricingPositionData = manager.getPricingPositionData();
        int[] companyNamePositionData = manager.getCoNamePositionData();

        System.out.println(Arrays.toString(rankingPositionData));
        System.out.println(Arrays.toString(pricingPositionData));
        System.out.println(Arrays.toString(companyNamePositionData));

        manager.generateCsv(rankingPositionData, "rankingDataCsvFile.csv");
        manager.generateCsv(pricingPositionData, "pricingDataCsvFile.csv");
        manager.generateCsv(companyNamePositionData, "companyNameDataCsvFile.csv");
    }
}

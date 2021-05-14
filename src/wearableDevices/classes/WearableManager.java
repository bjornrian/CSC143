package wearableDevices.classes;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class WearableManager {
    private Wearable[] wearableList;
    private int wearableListLength; //first scan.nextInt value in Wearable.txt
    private Index<Integer> rankingPositionData;
    private Index<Double> pricePositionData;
    private Index<String> coNamePositionData;

    public WearableManager() {
        readWearableFile();
    }

    public Wearable getWearableAtIndex(int index) {
        return wearableList[index];
    }

    public int[] getRankingPositionData() {
        return rankingPositionData.getPositionData();
    }

    public int[] getPricingPositionData() {
        return pricePositionData.getPositionData();
    }

    public int[] getCoNamePositionData() {
        return coNamePositionData.getPositionData();
    }

    public Boolean generateCsv(int[] positions, String filename) throws FileNotFoundException {
        File file = new File(filename);
        PrintStream fileOut = new PrintStream(file);
        for(int position : positions) {
            fileOut.print(wearableList[position].getRanking());
            fileOut.print("\"" + wearableList[position].getName() + "\"");
            fileOut.print(wearableList[position].getPrice());
            fileOut.print("\"" + wearableList[position].getBodyLocation() + "\"");
            fileOut.print("\"" + wearableList[position].getCategory() + "\"");
            fileOut.print("\"" + wearableList[position].getCompanyName() + "\"");
            fileOut.print("\"" + wearableList[position].getCompanyURL() + "\"");
            fileOut.print("\"" + wearableList[position].getCompanyMappingLocation() + "\"");
            fileOut.print("\"" + wearableList[position].getCompanyCity() + "\"");
            fileOut.print("\"" + wearableList[position].getCompanyUSState() + "\"");
            fileOut.print("\"" + wearableList[position].getCompanyCountry() + "\"");
        }
        fileOut.close();
        return true;
    }

    private void readWearableFile() {
        wearableList = new Wearable[wearableListLength];
    }
}

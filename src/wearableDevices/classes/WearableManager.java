package wearableDevices.classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class WearableManager {
    private String PATH_WEARABLES = "src/wearableDevices/resources/Wearables.txt";
    private Wearable[] wearableList;
    private int wearableListLength; //first scan.nextInt value in Wearable.txt
    private Index<Integer> rankingPositionData = new Index<>();
    private Index<Double> pricePositionData = new Index<>();
    private Index<String> coNamePositionData = new Index<>();

    public WearableManager() {
        readWearableFile();
        addPositionData();
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
        for (int position : positions) {
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
        try {
            Scanner fileIn = new Scanner(new File(PATH_WEARABLES));
            wearableListLength = fileIn.nextInt();
            wearableList = new Wearable[wearableListLength];
            fileIn.nextLine();
            fileIn.nextLine();
            for (int lineNum = 0; lineNum < wearableListLength; lineNum++) {
                String line = fileIn.nextLine();
                String[] characteristics = line.split("@");
                Wearable oneWearable = new Wearable(Integer.parseInt(characteristics[0]),
                        characteristics[1], Double.parseDouble(characteristics[2]),
                        characteristics[3], characteristics[4], characteristics[5],
                        characteristics[6], characteristics[7], characteristics[8],
                        characteristics[9], characteristics[10]);
                wearableList[lineNum] = oneWearable;
            }
        } catch (FileNotFoundException e) {
            wearableList = new Wearable[0];
        }
    }

    private void addPositionData() {
        for (int index = 0; index < wearableListLength; index++) {
            rankingPositionData.put(wearableList[index].getRanking(), index);
            pricePositionData.put(wearableList[index].getPrice(), index);
            coNamePositionData.put(wearableList[index].getCompanyName(), index);
        }
    }
}

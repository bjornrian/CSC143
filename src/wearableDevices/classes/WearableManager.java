package wearableDevices.classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class WearableManager {
    private static final String PATH_WEARABLES = "src/wearableDevices/resources/Wearables.txt";
    private Wearable[] wearableList;
    private int wearableListLength; //first scan.nextInt value in Wearable.txt
    private Index<Integer> rankingPositionData = new Index<>();
    private Index<Double> pricePositionData = new Index<>();
    private Index<String> coNamePositionData = new Index<>();

    public WearableManager() {
        this(PATH_WEARABLES);
    }

    public WearableManager(String path) {
        readWearableFile(path);
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
        fileOut.println("Ranking, Name, Price, Body Location, Category, Company Name, " +
                "Company URL, Company Location, Company City, Company US State, Company Country");
        for (int position : positions) {
            fileOut.print(wearableList[position].getRanking() + ",");
            fileOut.print(addQuotationMarks(wearableList[position].getName(), true));
            fileOut.print(wearableList[position].getPrice() + ",");
            fileOut.print(addQuotationMarks(wearableList[position].getBodyLocation(), true));
            fileOut.print(addQuotationMarks(wearableList[position].getCategory(), true));
            fileOut.print(addQuotationMarks(wearableList[position].getCompanyName(), true));
            fileOut.print(addQuotationMarks(wearableList[position].getCompanyURL(), true));
            fileOut.print(addQuotationMarks(wearableList[position].getCompanyMappingLocation(), true));
            fileOut.print(addQuotationMarks(wearableList[position].getCompanyCity(), true));
            fileOut.print(addQuotationMarks(wearableList[position].getCompanyUSState(), true));
            fileOut.print(addQuotationMarks(wearableList[position].getCompanyCountry(), false));
            fileOut.println();
        }
        fileOut.close();
        return true;
    }

    private String addQuotationMarks(String value, boolean addComma) {
        value = value.replace("\"", "\"\"");
        value = "\"" + value.replace(",", "','");
        if(addComma) {
            value = value + "\",";
        } else value = value + "\"";
        return value;
    }

    private void readWearableFile(String path) {
        try {
            Scanner fileIn = new Scanner(new File(path));
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
                rankingPositionData.put(Integer.parseInt(characteristics[0]), lineNum);
                pricePositionData.put(Double.parseDouble(characteristics[2]), lineNum);
                coNamePositionData.put(characteristics[5], lineNum);
                wearableList[lineNum] = oneWearable;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            wearableList = new Wearable[0];
        }
    }
}

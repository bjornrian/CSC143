package previousProjects.wearableDevices.classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class WearableManager {
    private static final String PATH_WEARABLES = "src/previousProjects.wearableDevices/resources/Wearables.txt";
    private static final int RANKING = 0;
    private static final int NAME = 1;
    private static final int PRICE = 2;
    private static final int BODY_LOCATION = 3;
    private static final int CATEGORY = 4;
    private static final int COMPANY_NAME = 5;
    private static final int COMPANY_URL = 6;
    private static final int COMPANY_MAPPING_LOCATION = 7;
    private static final int COMPANY_CITY = 8;
    private static final int COMPANY_US_STATE = 9;
    private static final int COMPANY_COUNTRY = 10;
    private Wearable[] wearableList;
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

    public boolean generateCsv(int[] positions, String filename) throws FileNotFoundException {
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
        if (addComma) {
            value = value + "\",";
        } else {
            value = value + "\"";
        }
        return value;
    }

    private void readWearableFile(String path) {
        try {
            Scanner fileIn = new Scanner(new File(path));
            int wearableListLength = fileIn.nextInt();
            wearableList = new Wearable[wearableListLength];
            fileIn.nextLine();
            fileIn.nextLine();
            for (int lineNum = 0; lineNum < wearableListLength; lineNum++) {
                String line = fileIn.nextLine();
                String[] lineData = line.split("@");
                Wearable oneWearable = new Wearable(Integer.parseInt(lineData[RANKING]),
                        lineData[NAME],
                        Double.parseDouble(lineData[PRICE]),
                        lineData[BODY_LOCATION],
                        lineData[CATEGORY],
                        lineData[COMPANY_NAME],
                        lineData[COMPANY_URL],
                        lineData[COMPANY_MAPPING_LOCATION],
                        lineData[COMPANY_CITY],
                        lineData[COMPANY_US_STATE],
                        lineData[COMPANY_COUNTRY]);
                addPositionData(lineNum, lineData);
                wearableList[lineNum] = oneWearable;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            wearableList = new Wearable[0];
        }
    }

    private void addPositionData(int index, String[] lineData) {
        rankingPositionData.put(Integer.parseInt(lineData[RANKING]), index);
        pricePositionData.put(Double.parseDouble(lineData[PRICE]), index);
        coNamePositionData.put(lineData[COMPANY_NAME], index);
    }
}

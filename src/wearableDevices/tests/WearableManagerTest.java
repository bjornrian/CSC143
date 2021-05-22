package wearableDevices.tests;

import org.junit.Before;
import org.junit.Test;
import wearableDevices.classes.WearableManager;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

/**
 * Testing the main methods:
 * <p>
 * Wearable getWearableAtIndex(int index)
 * int[] getRankingPositionData()
 * int[] getPricePositionData()
 * int[] getCoNamePositionData()
 * boolean generateCsv(int[] positions, String filename)
 */
public class WearableManagerTest {
    private static final String PATH = "src/wearableDevices/tests/WearablesSample.txt";
    private WearableManager manager;

    @Before
    public void setup() {
        manager = new WearableManager(PATH);
    }

    @Test
    public void testGetWearableAtIndex() {
        assertEquals("Kansas", manager.getWearableAtIndex(0).getCompanyUSState());
        assertEquals("Olathe", manager.getWearableAtIndex(1).getCompanyCity());
        assertEquals("Olathe, Kansas, United States", manager.getWearableAtIndex(2).getCompanyMappingLocation());
        assertEquals("http://www.garmin.com/", manager.getWearableAtIndex(3).getCompanyURL());
        assertEquals("Generic", manager.getWearableAtIndex(4).getCompanyName());
        assertEquals("Lifestyle", manager.getWearableAtIndex(5).getCategory());
        assertEquals("Gerbing Men's Battery Heated Fleece Jacket - Black", manager.getWearableAtIndex(6).getName());
        assertEquals(349, manager.getWearableAtIndex(7).getRanking());
        assertEquals("Torso", manager.getWearableAtIndex(8).getBodyLocation());
        assertEquals(new Double(40.52), manager.getWearableAtIndex(9).getPrice());
    }

    @Test
    public void testGetRankingPositionData() {
        int[] rankingPositionData = manager.getRankingPositionData();
        assertEquals(10, rankingPositionData.length);
    }

    @Test
    public void testGetPricingPositionData() {
        //todo
//        int[] pricingPositionData = manager.getPricingPositionData();
    }

    @Test
    public void testGetCoNamePositionData() {
        //todo
//        int[] coNamePositionData = manager.getCoNamePositionData();
    }

    @Test
    public void testGenerateCsvForRanking() throws FileNotFoundException {
        //todo
//        int[] rankingPositionData = manager.getRankingPositionData();
//        Boolean myCsvFile = manager.generateCsv(rankingPositionData, "myCsvFile");
    }

    @Test
    public void testGenerateCsvForPricing() throws FileNotFoundException {
        //todo
//        int[] pricingPositionData = manager.getPricingPositionData();
//        Boolean myCsvFile = manager.generateCsv(pricingPositionData, "myCsvFile");
    }

    @Test
    public void testGenerateCsvForCompanyName() throws FileNotFoundException {
        //todo
//        int[] coNamePositionData = manager.getCoNamePositionData();
//        Boolean myCsvFile = manager.generateCsv(coNamePositionData, "myCsvFile");
    }

}

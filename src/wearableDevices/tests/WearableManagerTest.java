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
        int[] positionList = new int[]{4, 9, 0, 7, 6, 3, 5, 1, 2, 8};
        for (int index = 0; index < rankingPositionData.length; index++) {
            assertEquals(positionList[index], rankingPositionData[index]);
        }
    }

    @Test
    public void testGetPricingPositionData() {
        int[] pricingPositionData = manager.getPricingPositionData();
        assertEquals(10, pricingPositionData.length);
        int[] positionList = new int[]{7, 9, 8, 4, 5, 0, 1, 3, 2, 6};
        for (int index = 0; index < pricingPositionData.length; index++) {
            assertEquals(positionList[index], pricingPositionData[index]);
        }
    }

    @Test
    public void testGetCoNamePositionData() {
        int[] coNamePositionData = manager.getCoNamePositionData();
        assertEquals(10, coNamePositionData.length);
        int[] positionList = new int[]{0, 1, 2, 3, 4, 6, 7, 8, 9, 5};
        for (int index = 0; index < coNamePositionData.length; index++) {
            assertEquals(positionList[index], coNamePositionData[index]);
        }
    }
}

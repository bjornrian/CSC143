package wearableDevices.tests;

import org.junit.Test;
import wearableDevices.classes.Index;
import wearableDevices.classes.Wearable;

import java.util.Arrays;

import static org.junit.Assert.*;

public class IndexTest {
    @Test
    public void testPutNodeAndGetPosition() {
        Index<Integer> integerIndex = new Index<>();
        Wearable testWearable = new Wearable(
                548,
                "Barska GB12166 Fitness Watch with Heart Rate Monitor",
                49.99,
                "Wrist",
                "Fitness",
                "Barska",
                "http://www.barska.com/",
                "Pomona, California, United States",
                "Pomona",
                "California",
                "United States");
        integerIndex.put(testWearable.getRanking(), 21);
        assertEquals(21, integerIndex.get(testWearable.getRanking()));
    }

    @Test
    public void testGetPositionData() {
        Index<Integer> integerIndex = new Index<>();
        Wearable[] testWearableList = buildWearableList();
        for (int index = 0; index < testWearableList.length; index++) {
            integerIndex.put(testWearableList[index].getRanking(), index);
        }
        int[] expectedList = {3, 2, 5, 1, 4, 0, 7, 9, 6, 8};
        for(int index = 0; index < expectedList.length; index++) {
            assertEquals(expectedList[index], integerIndex.getPositionData()[index]);
        }
    }

    public Wearable[] buildWearableList() {
        Wearable[] wearableList = new Wearable[10];
        wearableList[0] = new Wearable(
                528,
                "Barska GB12166 Fitness Watch with Heart Rate Monitor",
                49.99,
                "Wrist",
                "Fitness",
                "Barska",
                "http://www.barska.com/",
                "Pomona, California, United States",
                "Pomona",
                "California",
                "United States");

        wearableList[1] = new Wearable(
                20,
                "Barska GB12166 Fitness Watch with Heart Rate Monitor",
                49.99,
                "Wrist",
                "Fitness",
                "Barska",
                "http://www.barska.com/",
                "Pomona, California, United States",
                "Pomona",
                "California",
                "United States");

        wearableList[2] = new Wearable(
                5,
                "Barska GB12166 Fitness Watch with Heart Rate Monitor",
                49.99,
                "Wrist",
                "Fitness",
                "Barska",
                "http://www.barska.com/",
                "Pomona, California, United States",
                "Pomona",
                "California",
                "United States");

        wearableList[3] = new Wearable(
                2,
                "Barska GB12166 Fitness Watch with Heart Rate Monitor",
                49.99,
                "Wrist",
                "Fitness",
                "Barska",
                "http://www.barska.com/",
                "Pomona, California, United States",
                "Pomona",
                "California",
                "United States");

        wearableList[4] = new Wearable(
                250,
                "Barska GB12166 Fitness Watch with Heart Rate Monitor",
                49.99,
                "Wrist",
                "Fitness",
                "Barska",
                "http://www.barska.com/",
                "Pomona, California, United States",
                "Pomona",
                "California",
                "United States");

        wearableList[5] = new Wearable(
                15,
                "Barska GB12166 Fitness Watch with Heart Rate Monitor",
                49.99,
                "Wrist",
                "Fitness",
                "Barska",
                "http://www.barska.com/",
                "Pomona, California, United States",
                "Pomona",
                "California",
                "United States");

        wearableList[6] = new Wearable(
                1000,
                "Barska GB12166 Fitness Watch with Heart Rate Monitor",
                49.99,
                "Wrist",
                "Fitness",
                "Barska",
                "http://www.barska.com/",
                "Pomona, California, United States",
                "Pomona",
                "California",
                "United States");

        wearableList[7] = new Wearable(
                725,
                "Barska GB12166 Fitness Watch with Heart Rate Monitor",
                49.99,
                "Wrist",
                "Fitness",
                "Barska",
                "http://www.barska.com/",
                "Pomona, California, United States",
                "Pomona",
                "California",
                "United States");

        wearableList[8] = new Wearable(
                1221,
                "Barska GB12166 Fitness Watch with Heart Rate Monitor",
                49.99,
                "Wrist",
                "Fitness",
                "Barska",
                "http://www.barska.com/",
                "Pomona, California, United States",
                "Pomona",
                "California",
                "United States");

        wearableList[9] = new Wearable(
                998,
                "Barska GB12166 Fitness Watch with Heart Rate Monitor",
                49.99,
                "Wrist",
                "Fitness",
                "Barska",
                "http://www.barska.com/",
                "Pomona, California, United States",
                "Pomona",
                "California",
                "United States");
        return wearableList;
    }
}

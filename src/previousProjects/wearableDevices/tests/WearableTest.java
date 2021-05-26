package previousProjects.wearableDevices.tests;

import org.junit.Test;
import previousProjects.wearableDevices.classes.Wearable;

import static org.junit.Assert.*;

public class WearableTest {
    @Test
    public void testAccessors() {
        Wearable testWearable = new Wearable(133, "FitBit", 55.99,
                "Wrist", "Athletics", "Barthas",
                "www.barthas.com/fitbit", "Rabat, Morocco",
                "Rabat", null, "Morocco");
        assertEquals(133, testWearable.getRanking());
        assertEquals("FitBit", testWearable.getName());
        assertEquals(55.99, testWearable.getPrice(), 0.001);
        assertEquals("Wrist", testWearable.getBodyLocation());
        assertEquals("Athletics", testWearable.getCategory());
        assertEquals("Barthas", testWearable.getCompanyName());
        assertEquals("www.barthas.com/fitbit", testWearable.getCompanyURL());
        assertEquals("Rabat, Morocco", testWearable.getCompanyMappingLocation());
        assertEquals("Rabat", testWearable.getCompanyCity());
        assertNull(testWearable.getCompanyUSState());
        assertEquals("Morocco", testWearable.getCompanyCountry());
    }
}

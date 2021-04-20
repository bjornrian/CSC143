package stanleyStorage.tests;

import org.junit.Test;
import stanleyStorage.*;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Storage Units
 * Retrieve each attribute.
 * Price retrieved should be rented or standard price, whichever is applicable
 * Retrieve the rental start date
 * Retrieve the customer associated with the unit
 * Rent the unit to a specified customer, on a specified date
 * Release the unit (make it “unrented”)
 */
public class StorageUnitTest {

    public static final double DELTA = 0.0001;

    @Test
    public void testGetAttributes() {
        StorageUnit standardUnit = buildStandardUnit();
        assertEquals(4, standardUnit.getWidth());
        assertEquals(8, standardUnit.getLength());
        assertEquals(6, standardUnit.getHeight());
    }

    /**
     * Test the price of a standard unit
     */
    @Test
    public void testGetPriceFOrStandardUnit() {
        StorageUnit standardUnit = buildStandardUnit();
        assertEquals(175.0, standardUnit.getPrice(), DELTA);
    }

    /**
     * Test the price for a humidity controlled unit with default humidity
     */
    @Test
    public void testGetPriceForHumidityUnitWithDefaultHumidity() {
        boolean customHumidity = false;
        StorageUnit unit = buildHumidityUnit(customHumidity);
        assertEquals(420, unit.getPrice(), DELTA);
    }

    /**
     * Test the price for a humidity controlled unit with custom humidity
     */
    @Test
    public void testGetPriceForHumidityUnitWithCustomHumidity() {
        boolean customHumidity = true;
        StorageUnit unit = buildHumidityUnit(customHumidity);
        assertEquals(440, unit.getPrice(), DELTA);
    }

    @Test
    public void testGetPriceForTemperatureUnitWithDefaultTemperature() {
        boolean customTemperature = false;
        StorageUnit unit = buildTemperatureUnit(customTemperature);
        assertEquals(612, unit.getPrice(), DELTA);
    }

    @Test
    public void testGetPriceForTemperatureUnitWithCustomTemperature() {
        boolean customTemperature = true;
        StorageUnit unit = buildTemperatureUnit(customTemperature);
        assertEquals(642, unit.getPrice(), DELTA);
    }

    private StorageUnit buildTemperatureUnit(boolean customTemperature) {
        TemperatureControlledUnit unit = new TemperatureControlledUnit(8, 8, 8);
        if(customTemperature) {
            unit.setTemperature(48);
        }
        return unit;
    }

    private StorageUnit buildHumidityUnit(boolean customHumidity) {
        HumidityControlledUnit unit = new HumidityControlledUnit(8, 8, 8);
        if(customHumidity) {
            unit.setHumidity(22);
        }
        return unit;
    }

    @Test
    public void testRentUnitToCustomerOnSpecificDate() {
        StorageUnit unit = buildStandardUnit();
        Customer customer = new Customer("Bob", "1234567890");
        LocalDate date = LocalDate.of(2012, 12, 12);
        unit.rent(customer, date);
        assertEquals(LocalDate.of(2012, 12, 12), unit.getRentalStart());
        assertEquals(customer, unit.getCustomer());
    }

    @Test
    public void testReleaseStorageUnit() {
        StorageUnit unit = buildStandardUnit();
        Customer bob = new Customer("Bob", "1234567890");
        LocalDate date = LocalDate.of(2012, 12, 12);
        unit.release();
        assertNull(unit.getRentalStart());
        assertNull(unit.getCustomer());
        assertEquals(175, unit.getPrice(), 0.0001);
    }

    private StorageUnit buildStandardUnit() {
        return new StandardUnit(4, 8, 6);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testVerifyDimension() {
        StorageUnit testUnit = new StandardUnit(1, 1, 1);
    }
}

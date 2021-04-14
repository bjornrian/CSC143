package stanleyStorage;

import org.junit.Test;

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
    @Test
    public void testGetAttributes() {
        StorageUnit myStorage = getStorageUnit();
        assertEquals(4, myStorage.getWidth());
        assertEquals(8, myStorage.getLength());
        assertEquals(6, myStorage.getHeight());
        assertEquals(StorageUnitInterface.UnitType.STANDARD, myStorage.getType());
    }

    /**
     * Test the price when the unit is not rented
     */
    @Test
    public void testGetStandardPrice() {
        StorageUnit myStorage = getStorageUnit();
        assertEquals(100, myStorage.getPrice(), 0.0001);
    }

    /**
     * Test the price when the unit is rented
     */
    @Test
    public void testGetRentAttributes() {
        StorageUnit myStorage = getStorageUnit();
        Customer myCust = new Customer("Bob", "1234567890");
        LocalDate date = LocalDate.now();
        myStorage.rent(myCust, date, 300);
        assertEquals(300, myStorage.getPrice(), 0.0001);
        assertEquals(LocalDate.now(), myStorage.getRentalStart());
        assertEquals(myCust, myStorage.getCustomer());
    }

    @Test
    public void testRentUnitToCustomerOnSpecificDate() {
        StorageUnit myStorage = getStorageUnit();
        Customer myCust = new Customer("Bob", "1234567890");
        LocalDate date = LocalDate.of(2012, 12, 12);
        myStorage.rent(myCust, date, 300);
        assertEquals(LocalDate.of(2012, 12, 12), myStorage.getRentalStart());
        assertEquals(myCust, myStorage.getCustomer());
    }

    @Test
    public void testReleaseStorageUnit() {
        StorageUnit myStorage = getStorageUnit();
        Customer myCust = new Customer("Bob", "1234567890");
        LocalDate date = LocalDate.of(2012, 12, 12);
        myStorage.release();
        assertNull(myStorage.getRentalStart());
        assertNull(myStorage.getCustomer());
        assertEquals(100, myStorage.getPrice(), 0.0001);
    }

    private StorageUnit getStorageUnit() {
        return new StorageUnit(4, 8, 6, StorageUnitInterface.UnitType.STANDARD);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testVerifyDimension() {
        StorageUnit testUnit = new StorageUnit(1, 1, 1, StorageUnitInterface.UnitType.STANDARD);
    }
}

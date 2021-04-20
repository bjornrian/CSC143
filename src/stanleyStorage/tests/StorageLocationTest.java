package stanleyStorage.tests;

import org.junit.Test;
import stanleyStorage.Customer;
import stanleyStorage.StorageLocation;
import stanleyStorage.StorageUnit;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static stanleyStorage.StorageLocation.ROW_COUNT;
//import static stanleyStorage.StorageLocation.UNITS_PER_ROW_COUNT;

/*
 * Retrieve the storage location’s designation
 * Retrieve a storage unit by index
 * Add a customer to the list
 * retrieve a customer by index
 * retrieve a count of customers
 * Retrieve an array of units rented by specific customer
 * Retrieve an array of empty storage units
 * Retrieve array of empty units of specified type
 * Charge monthly rent, increasing all balances
 */

public class StorageLocationTest {
    public StorageLocation buildStorageLocation() {
        StorageLocation spokane = new StorageLocation("WA23Spokane");
        for (int row_idx = 0; row_idx < spokane.getRowCount(); row_idx++) {
//            for (int col_idx = 0; col_idx < spokane.getUnitsPerRowCount(); col_idx += 2) {
//                spokane.setStorageUnit(new StorageUnit(4, 4, 4), row_idx, col_idx);
//                spokane.setStorageUnit(new StorageUnit(8, 8, 16), row_idx, col_idx + 1);
//            }
        }
        return spokane;
    }

    @Test
    public void testGetDesignation() {
        assertEquals("WA23Spokane", buildStorageLocation().getDesignation());
    }

    //How do you compare objects properly? I forgot
    @Test
    public void testGetStorageUnitByIndex() {
//        StorageUnit oneUnit = new StorageUnit(8, 8, 16);
//        assertEquals(oneUnit.getWidth(), buildStorageLocation().getStorageUnit(4, 1).getWidth());
//        assertEquals(oneUnit.getLength(), buildStorageLocation().getStorageUnit(4, 1).getLength());
//        assertEquals(oneUnit.getHeight(), buildStorageLocation().getStorageUnit(4, 1).getHeight());
//        assertEquals(oneUnit.getType(), buildStorageLocation().getStorageUnit(4, 1).getType());
    }

    @Test
    public void testAddCustomerToList() {
        StorageLocation issaquah = new StorageLocation("WA23Issaquah");
        issaquah.addCustomer(new Customer("Ben", "1234567890"));
        assertEquals("Ben", issaquah.getCustomer(0).getName());
    }

    @Test
    public void testGetCustomerByIndex() {
        StorageLocation issaquah = new StorageLocation("WA23Issaquah");
        Customer bob = new Customer("Bob", "1234567890");
        Customer sue = new Customer("Sue", "8763847655");
        issaquah.addCustomer(bob);
        issaquah.addCustomer(sue);
        assertEquals("Bob", issaquah.getCustomer(0).getName());
        assertEquals("Sue", issaquah.getCustomer(1).getName());
    }

    @Test
    public void testGetCustomerCount() {
        StorageLocation issaquah = new StorageLocation("WA23Issaquah");
        issaquah.addCustomer(new Customer("Bob", "1234567890"));
        issaquah.addCustomer(new Customer("Sue", "8473876876"));
        issaquah.addCustomer(new Customer("Joe", "3543653655"));
        assertEquals(3, issaquah.getCustomerCount());
    }

    @Test
    public void testGetStorageUnitsForCustomer() {
        StorageLocation issaquah = new StorageLocation("WA23Issaquah");
        Customer bob = new Customer("Bob", "1234567890");
        issaquah.addCustomer(bob);
        Customer ben = new Customer("Ben", "1234562332");
        issaquah.addCustomer(ben);
//        issaquah.setStorageUnit(new StorageUnit(4, 4, 4), 0, 1);
//        issaquah.setStorageUnit(new StorageUnit(12, 12, 8), 2, 2);
//        issaquah.setStorageUnit(new StorageUnit(8, 8, 16), 3, 4);

        issaquah.getStorageUnit(0, 1).rent(bob, LocalDate.now());
        issaquah.getStorageUnit(2, 2).rent(bob, LocalDate.now());
        issaquah.getStorageUnit(3, 4).rent(ben, LocalDate.now());
        Customer customerZero = issaquah.getCustomer(0);
        assertEquals("Bob", customerZero.getName());
        StorageUnit[] unitsForCustomerZero = issaquah.getCustomerUnits(customerZero);
        assertEquals(2, unitsForCustomerZero.length);
    }

    @Test
    public void testGetAllEmptyStorageUnits() {
        StorageLocation issaquah = new StorageLocation("WA23Issaquah");
        Customer bob = new Customer("Bob", "1234567890");
        issaquah.addCustomer(bob);
        Customer ben = new Customer("Ben", "1234562332");
        issaquah.addCustomer(ben);
//        issaquah.setStorageUnit(new StorageUnit(4, 4, 4), 0, 1);
//        issaquah.setStorageUnit(new StorageUnit(12, 12, 8), 2, 2);
//        issaquah.setStorageUnit(new StorageUnit(8, 8, 16), 3, 4);

        issaquah.getStorageUnit(0, 1).rent(bob, LocalDate.now());
        issaquah.getStorageUnit(2, 2).rent(bob, LocalDate.now());
        issaquah.getStorageUnit(3, 4).rent(ben, LocalDate.now());

//        int expectedNumberOfEmptyUnits = (ROW_COUNT * UNITS_PER_ROW_COUNT) - 3;
//        assertEquals(expectedNumberOfEmptyUnits, issaquah.getEmptyUnits().length);
    }

    @Test
    public void testGetAllEmptyStorageUnitsByType() {
        StorageLocation issaquah = new StorageLocation("WA23Issaquah");
        Customer bob = new Customer("Bob", "1234567890");
        issaquah.addCustomer(bob);
        Customer ben = new Customer("Ben", "1234562332");
        issaquah.addCustomer(ben);
//        issaquah.setStorageUnit(new StorageUnit(4, 4, 4), 0, 1);
//        issaquah.setStorageUnit(new StorageUnit(12, 12, 8), 2, 2);
//        issaquah.setStorageUnit(new StorageUnit(8, 8, 16), 3, 4);

        issaquah.getStorageUnit(0, 1).rent(bob, LocalDate.now());
        issaquah.getStorageUnit(2, 2).rent(bob, LocalDate.now());
        issaquah.getStorageUnit(3, 4).rent(ben, LocalDate.now());

//        assertEquals(144, issaquah.getEmptyUnits(StorageUnitInterface.UnitType.TEMPERATURE).length);

        issaquah.getStorageUnit(0, 1).release();
        issaquah.getStorageUnit(2, 2).release();
        issaquah.getStorageUnit(3, 4).release();

//        assertEquals(146, issaquah.getEmptyUnits(StorageUnitInterface.UnitType.TEMPERATURE).length);
//        assertEquals(48, issaquah.getEmptyUnits(StorageUnitInterface.UnitType.HUMIDITY).length);
    }

    @Test
    public void testChargeMonthlyRent() {
        StorageLocation issaquah = new StorageLocation("WA23Issaquah");
        Customer bob = new Customer("Bob", "1234567890");
        issaquah.addCustomer(bob);
        Customer ben = new Customer("Ben", "1234562332");
        issaquah.addCustomer(ben);
        Customer billyJoe = new Customer("Billy Joe", "1092813232");
        issaquah.addCustomer(billyJoe);
//        issaquah.setStorageUnit(new StorageUnit(4, 4, 4), 0, 1);
//        issaquah.setStorageUnit(new StorageUnit(12, 12, 8), 2, 2);
//        issaquah.setStorageUnit(new StorageUnit(8, 8, 16), 3, 4);
//        issaquah.setStorageUnit(new StorageUnit(8, 8, 16), 6, 1);

        issaquah.getStorageUnit(0, 1).rent(bob, LocalDate.now());
        issaquah.getStorageUnit(2, 2).rent(bob, LocalDate.now());
        issaquah.getStorageUnit(3, 4).rent(ben, LocalDate.now());
        issaquah.getStorageUnit(6, 1).rent(billyJoe, LocalDate.now());

        issaquah.chargeMonthlyRent();

        assertEquals(103, issaquah.getCustomer(1).getBalance(), 0.0001);
        assertEquals(200, issaquah.getCustomer(0).getBalance(), 0.0001);
        assertEquals(1030000, issaquah.getCustomer(2).getBalance(), 0.0001);

        issaquah.chargeMonthlyRent();

        assertEquals(206, issaquah.getCustomer(1).getBalance(), 0.0001);
        assertEquals(400, issaquah.getCustomer(0).getBalance(), 0.0001);
        assertEquals(2060000, issaquah.getCustomer(2).getBalance(), 0.0001);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testVerifyString() {
        StorageLocation testLocation = new StorageLocation("");
    }
}

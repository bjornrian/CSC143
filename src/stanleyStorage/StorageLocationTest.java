package stanleyStorage;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

/*
 * Retrieve the storage location’s designation
 * Retrieve a storage unit by index
 * Add a customer to the list
 * retrieve a customer by index
 * retrieve a count of customers
 * Retrieve an array of units rented by specific customer
 * Retrieve an  array of empty storage units
 * Retrieve array of empty units of specified type
 * Charge monthly rent, increasing all balances
 */

public class StorageLocationTest {
    public StorageLocation buildStorageLocation() {
        StorageLocation spokane = new StorageLocation("WA23Spokane");
        for (int row_idx = 0; row_idx < spokane.getRowCount(); row_idx++) {
            for (int col_idx = 0; col_idx < spokane.getUnitsPerRowCount(); col_idx += 2) {
                spokane.setStorageUnit(new StorageUnit(4, 4, 4, StorageUnitInterface.UnitType.STANDARD), row_idx, col_idx);
                spokane.setStorageUnit(new StorageUnit(8, 8, 16, StorageUnitInterface.UnitType.TEMPERATURE), row_idx, col_idx + 1);
            }
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
        StorageUnit oneUnit = new StorageUnit(8, 8, 16, StorageUnitInterface.UnitType.TEMPERATURE);
        assertEquals(oneUnit.getWidth(), buildStorageLocation().getStorageUnit(4, 1).getWidth());
        assertEquals(oneUnit.getLength(), buildStorageLocation().getStorageUnit(4, 1).getLength());
        assertEquals(oneUnit.getHeight(), buildStorageLocation().getStorageUnit(4, 1).getHeight());
        assertEquals(oneUnit.getType(), buildStorageLocation().getStorageUnit(4, 1).getType());
    }

    @Test
    public void testAddCustomerToList() {
        StorageLocation issaquah = new StorageLocation("WA23Issaquah");
        issaquah.addCustomer(new Customer("Bob", "1234567890"));
        assertEquals("Bob", buildStorageLocation().getCustomer(0).getName());
    }

    @Test
    public void testGetCustomerByIndex() {
        StorageLocation issaquah = new StorageLocation("WA23Issaquah");
        Customer testCust = new Customer("Bob", "1234567890");
        issaquah.addCustomer(testCust);
        issaquah.addCustomer(testCust);
        assertEquals("Bob", buildStorageLocation().getCustomer(0).getName());
        assertEquals("1234567890", buildStorageLocation().getCustomer(0).getPhone());
    }

    @Test
    public void testGetCustomerCount() {
        StorageLocation issaquah = new StorageLocation("WA23Issaquah");
        issaquah.addCustomer(new Customer("Bob", "1234567890"));
        issaquah.addCustomer(new Customer("Bob", "1234567890"));
        assertEquals(2, issaquah.getCustomerCount());
    }

    @Test
    public void testGetStorageUnitsForCustomer() {

    }

    @Test
    public void testGetAllEmptyStorageUnits() {

    }

    @Test
    public void testGetAllEmptyStorageUnitsByType() {

    }

    @Test
    public void testChargeMonthlyRent() {

    }

}

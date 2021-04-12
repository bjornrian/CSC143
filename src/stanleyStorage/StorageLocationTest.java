package stanleyStorage;

import org.junit.Test;

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
    @Test public void testGetDesignation() {
        StorageLocation spokane = new StorageLocation("WA23Spokane");
        assertEquals("WA23Spokane", spokane.getDesignation());
    }

    @Test public void testGetStorageUnitByIndex() {
        StorageLocation spokane = new StorageLocation("WA23Spokane");
        spokane.
    }

    @Test public void testAddCustomerToList() {

    }

    @Test public void testGetCustomerByIndex() {

    }

    @Test public void testGetCustomerCount() {

    }

    @Test public void testGetStorageUnitsForCustomer() {

    }

    @Test public void testGetAllEmptyStorageUnits() {

    }

    @Test public void testGetAllEmptyStorageUnitsByType() {

    }

    @Test public void testChargeMonthlyRent() {

    }

}

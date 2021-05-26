package previousProjects.tests;

import org.junit.Test;
import previousProjects.stanleyStorage.stanleyStorage.*;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
    @Test
    public void testGetDesignation() {
        assertEquals("WA23Spokane", buildStorageLocation().getDesignation());
    }

    @Test
    public void testGetStorageUnitByIndex() {
        StorageLocation testLocation = buildStorageLocation();
        StorageUnit standardUnit = testLocation.getStorageUnit(4, 1);
        assertEquals(StandardUnit.class, standardUnit.getClass());
        assertEquals(HumidityControlledUnit.class, testLocation.getStorageUnit(8, 1).getClass());
        assertEquals(TemperatureControlledUnit.class, testLocation.getStorageUnit(11, 1).getClass());
    }

    @Test
    public void testAddCustomerToList() {
        StorageLocation testLocation = buildStorageLocation();
        testLocation.addCustomer(new Customer("Ben", "1234567890"));
        assertEquals("Ben", testLocation.getCustomer(0).getName());
    }

    @Test
    public void testGetCustomerByIndex() {
        StorageLocation testLocation = buildStorageLocation();
        Customer bob = new Customer("Bob", "1234567890");
        Customer sue = new Customer("Sue", "8763847655");
        testLocation.addCustomer(bob);
        testLocation.addCustomer(sue);
        assertEquals("Bob", testLocation.getCustomer(0).getName());
        assertEquals("Sue", testLocation.getCustomer(1).getName());
    }

    @Test
    public void testGetCustomerCount() {
        StorageLocation testLocation = buildStorageLocation();
        testLocation.addCustomer(new Customer("Bob", "1234567890"));
        testLocation.addCustomer(new Customer("Sue", "8473876876"));
        testLocation.addCustomer(new Customer("Joe", "3543653655"));
        assertEquals(3, testLocation.getCustomerCount());
    }

    @Test
    public void testGetStorageUnitsForCustomer() {
        StorageLocation testLocation = buildStorageLocation();
        Customer bob = new Customer("Bob", "1234567890");
        testLocation.addCustomer(bob);
        Customer ben = new Customer("Ben", "1234562332");
        testLocation.addCustomer(ben);

        testLocation.getStorageUnit(0, 1).rent(bob, LocalDate.now());
        testLocation.getStorageUnit(8, 2).rent(bob, LocalDate.now());
        testLocation.getStorageUnit(11, 4).rent(ben, LocalDate.now());
        Customer customerBob = testLocation.getCustomer(0);
        assertEquals("Bob", customerBob.getName());
        StorageUnit[] unitsForCustomerBob = testLocation.getCustomerUnits(customerBob);
        assertEquals(2, unitsForCustomerBob.length);
    }

    @Test
    public void testGetAllEmptyStorageUnits() {
        StorageLocation testLocation = buildStorageLocation();
        Customer bob = new Customer("Bob", "1234567890");
        testLocation.addCustomer(bob);
        Customer ben = new Customer("Ben", "1234562332");
        testLocation.addCustomer(ben);

        testLocation.getStorageUnit(0, 1).rent(bob, LocalDate.now());
        testLocation.getStorageUnit(2, 2).rent(bob, LocalDate.now());
        testLocation.getStorageUnit(3, 4).rent(ben, LocalDate.now());
        assertEquals(103, testLocation.getEmptyUnits().length);
    }

    @Test
    public void testGetAllEmptyStorageUnitsByType() {
        StorageLocation testLocation = buildStorageLocation();
        assertEquals(70, testLocation.getEmptyUnits(StandardUnit.class).length);
        assertEquals(24, testLocation.getEmptyUnits(HumidityControlledUnit.class).length);
        assertEquals(12, testLocation.getEmptyUnits(TemperatureControlledUnit.class).length);
        testLocation.getStorageUnit(4, 1).rent(new Customer("Sheep", "10980375"), LocalDate.now());
        testLocation.getStorageUnit(9, 6).rent(new Customer("Cow", "10135175"), LocalDate.now());
        testLocation.getStorageUnit(11, 3).rent(new Customer("Moo", "10246675"), LocalDate.now());
        assertEquals(69, testLocation.getEmptyUnits(StandardUnit.class).length);
        assertEquals(23, testLocation.getEmptyUnits(HumidityControlledUnit.class).length);
        assertEquals(11, testLocation.getEmptyUnits(TemperatureControlledUnit.class).length);
    }

    @Test
    public void testChargeMonthlyRent() {
        StorageLocation testLocation = buildStorageLocation();
        Customer horse = new Customer("Horse", "1234567890");
        testLocation.addCustomer(horse);
        Customer chicken = new Customer("Chicken", "1234562332");
        testLocation.addCustomer(chicken);
        Customer sheep = new Customer("Sheep", "1092813232");
        testLocation.addCustomer(sheep);

        //Customer rents two standard units.
        testLocation.getStorageUnit(2, 7).rent(horse, LocalDate.now());
        testLocation.getStorageUnit(5, 6).rent(horse, LocalDate.now());
        //Customer rents a humidity controlled unit.
        testLocation.getStorageUnit(8, 1).rent(chicken, LocalDate.now());
        //Customer rents a temperature controlled unit.
        testLocation.getStorageUnit(11, 3).rent(sheep, LocalDate.now());

        testLocation.chargeMonthlyRent();

        assertEquals(332.5, testLocation.getCustomer(0).getBalance(), 0.0001);
        assertEquals(420, testLocation.getCustomer(1).getBalance(), 0.0001);
        assertEquals(612, testLocation.getCustomer(2).getBalance(), 0.0001);

        testLocation.chargeMonthlyRent();

        assertEquals(665, testLocation.getCustomer(0).getBalance(), 0.0001);
        assertEquals(840, testLocation.getCustomer(1).getBalance(), 0.0001);
        assertEquals(1224, testLocation.getCustomer(2).getBalance(), 0.0001);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testVerifyString() {
        StorageLocation testLocation = new StorageLocation("");
    }

    private StorageLocation buildStorageLocation() {
        StorageLocation spokane = new StorageLocation("WA23Spokane");
        return spokane;
    }
}

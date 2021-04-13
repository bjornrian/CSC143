package stanleyStorage;

import labs.stanleyOld.StorageLocationOld;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Main {
    public static void main(String[] args) {
        StorageLocation issaquah = new StorageLocation("WA23Issaquah");
        Customer bob = new Customer("Bob", "1234567890");
        Customer ben = new Customer("Ben", "1234562332");
        issaquah.setStorageUnit(new StorageUnit(4, 4, 4, StorageUnitInterface.UnitType.STANDARD), 0, 1);
        issaquah.setStorageUnit(new StorageUnit(12, 12, 8, StorageUnitInterface.UnitType.HUMIDITY), 2, 2);
        issaquah.setStorageUnit(new StorageUnit(8, 8, 16, StorageUnitInterface.UnitType.TEMPERATURE), 3, 4);

        issaquah.getStorageUnit(0, 1).rent(bob, LocalDate.now(), 100);
        issaquah.getStorageUnit(2, 2).rent(bob, LocalDate.now(), 100);
        issaquah.getStorageUnit(3, 4).rent(ben, LocalDate.now(), 103);
        System.out.println(Arrays.toString(issaquah.getCustomerUnits(bob)));
    }
}

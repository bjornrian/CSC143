package stanleyStorage;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //We have a new storage location in Issaquah
        StorageLocationInterface issaquah = new StorageLocation("WA23Issaquah");
        //A customer named Bob walks in
        Customer bob = new Customer("Bob", "1234567890");
        //Ben wants to rent a temperature controlled unit
        StorageUnit[] emptyUnits = issaquah.getEmptyUnits(StorageUnitInterface.UnitType.TEMPERATURE);
        int numberOfTempControlledUnits = emptyUnits.length;
        System.out.println("numberOfTempControlledUnits = " + numberOfTempControlledUnits);
        //We found some available. Let's see what they cost
        StorageUnit emptyUnit = emptyUnits[0];
        double price = emptyUnit.getPrice();
        System.out.println("price = " + price);
        //Bob says he has a coupon for $10 off
        emptyUnit.rent(bob, LocalDate.now(), price - 10);
        String bobStatusBeforeChargingRent = issaquah.getCustomerUnits(bob)[0].getCustomer().toString();
        System.out.println("bobStatusBeforeChargingRent = " + bobStatusBeforeChargingRent);
        //Charge monthly rent
        issaquah.chargeMonthlyRent();
        //How much is Bob's new balance?
        String bobStatusAfterChargingRent = issaquah.getCustomerUnits(bob)[0].getCustomer().toString();
        System.out.println("bobStatusAfterChargingRent = " + bobStatusAfterChargingRent);
    }
}

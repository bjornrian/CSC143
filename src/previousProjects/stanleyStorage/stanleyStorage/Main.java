package previousProjects.stanleyStorage.stanleyStorage;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //We have a new storage location in Issaquah
        StorageLocation issaquah = new StorageLocation("WA23Issaquah");
        System.out.println(issaquah);
        //A customer named Bob walks in
        Customer bob = new Customer("Bob", "1234567890");
        issaquah.addCustomer(bob);
        System.out.println(bob);
        StorageUnit[] emptyUnits = issaquah.getEmptyUnits(TemperatureControlledUnit.class);
        System.out.println("Number of available temperature controlled units: " + emptyUnits.length);
        //We found some available. Let's see what they cost
        TemperatureControlledUnit emptyUnit = (TemperatureControlledUnit) emptyUnits[0];
        emptyUnit.rent(bob, LocalDate.now());
        //Bob wants the temperature to be 68 degrees in order to cultivate crops
        emptyUnit.setTemperature(68);
        double price = emptyUnit.getPrice();
        System.out.println("Price of temperature controlled unit: $" + price);
        //Charge monthly rent
        issaquah.chargeMonthlyRent();
        //How much is Bob's balance?
        System.out.println("Bob's balance after one month of rent: $" + bob.getBalance());
        //Second month of rent
        issaquah.chargeMonthlyRent();
        //How much is Bob's new balance?
        System.out.println("Bob's balance after two months of rent: $" + bob.getBalance());
    }
}

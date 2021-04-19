package stanleyStoragePartTwo;

import java.time.LocalDate;

/**
 * Requirements for the StorageUnit class
 *
 * @author      Bill Barry
 * @version     2020-04-30
 */
public interface  StorageUnitInterface {
    // note: constructor take width, length, height, and type parameters, in that order
    public enum UnitType { STANDARD, HUMIDITY, TEMPERATURE }
    public int getWidth();
    public int getLength();
    public int getHeight();
    public UnitType getType();
    public double getPrice();
    public Customer getCustomer();
    public LocalDate getRentalStart();
    public boolean rent(Customer customer, LocalDate rentalStart, double price);
    public boolean release();
    public String toString();

}

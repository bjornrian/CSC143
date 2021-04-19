package stanleyStoragePartTwo;

import java.time.LocalDate;

/**
 * Represents one of many units in a storage location.
 * Each unit has one customer.
 * Each unit has a standard price, and an actual price.
 * Storage units come in different types, such as temperature controlled, humidity controlled, and standard.
 */
public class StorageUnit implements StorageUnitInterface {
    private int width;
    private int length;
    private int height;
    private Customer customer;
    private LocalDate rentalStart;
    private double price;
    private double standardPrice = 100;
    private UnitType unitType;

    /**
     * Constructor
     *
     * @param width the width of the storage unit
     * @param length the length of the storage unit
     * @param height the height of the storage unit
     * @param unitType the type of storage unit
     */
    public StorageUnit(int width, int length, int height, UnitType unitType) {
        verifyDimension(width, 4);
        verifyDimension(length, 4);
        verifyDimension(height, 2);
        this.width = width;
        this.length = length;
        this.height = height;
        this.unitType = unitType;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public UnitType getType() {
        return this.unitType;
    }

    /**
     * Retrieves the monthly price of the storage unit, in USD
     * @return standard price, or special price in the customer's contract
     */
    public double getPrice() {
        if(null == customer) {
            return standardPrice;
        }
        else {
            return price;
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    /**
     * Gets the start date of the rental
     * @return the date that the rental agreement took effect
     */
    public LocalDate getRentalStart() {
        return rentalStart;
    }

    /**
     * Rent a storage unit to a customer
     *
     * @param customer
     * @param rentalStart
     * @param price
     * @return
     */
    public boolean rent(Customer customer, LocalDate rentalStart, double price) {
        this.customer = customer;
        this.rentalStart = rentalStart;
        this.price = price;
        return true;
    }

    /**
     * End the rental agreement for this storage unit.
     *
     * @return true to indicate successful release
     */
    public boolean release() {
        this.customer = null;
        this.rentalStart = null;
        return true;
    }

    public String toString() {
        return "StorageUnit{" + "width=" + width + ", length=" + length + ", height=" + height
                + ", customer=" + customer + ", rentalStart=" + rentalStart + ", price=" + price
                + ", unitType=" + unitType + '}';
    }

    private void verifyDimension(int sideLength, int divisor) {
        if(sideLength % divisor != 0 || sideLength < 1) {
            throw new IllegalArgumentException("Error: distance must be greater than zero and divisible by " + divisor);
        }
    }
}

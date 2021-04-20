package stanleyStorage;

import java.time.LocalDate;

/**
 * Represents one of many units in a storage location.
 * Each unit has one customer.
 * Each unit has a standard price, and an actual price.
 * Storage units come in different types, such as temperature controlled, humidity controlled, and standard.
 */
public abstract class StorageUnit {
    private int width;
    private int length;
    private int height;
    private Customer customer;
    private LocalDate rentalStart;
    private double basePrice = 100;

    /**
     * Constructor
     *  @param width the width of the storage unit
     * @param length the length of the storage unit
     * @param height the height of the storage unit
     */
    public StorageUnit(int width, int length, int height) {
        verifyDimension(width, 4);
        verifyDimension(length, 4);
        verifyDimension(height, 2);
        this.width = width;
        this.length = length;
        this.height = height;
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

    /**
     * Retrieves the monthly price of the storage unit, in USD
     * @return standard price, or special price in the customer's contract
     */
    public double getPrice() {
        return basePrice;
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
     * @return
     */
    public boolean rent(Customer customer, LocalDate rentalStart) {
        this.customer = customer;
        this.rentalStart = rentalStart;
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
                + ", customer=" + customer + ", rentalStart=" + rentalStart + ", price=" + basePrice
                + ", unitType=" +'}';
    }

    private void verifyDimension(int sideLength, int divisor) {
        if(sideLength % divisor != 0 || sideLength < 1) {
            throw new IllegalArgumentException("Error: distance must be greater than zero and divisible by " + divisor);
        }
    }
}

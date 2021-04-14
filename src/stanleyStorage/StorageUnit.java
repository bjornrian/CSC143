package stanleyStorage;

import java.time.LocalDate;

public class StorageUnit implements StorageUnitInterface {
    private int width;
    private int length;
    private int height;
    private Customer customer;
    private LocalDate rentalStart;
    private double price;
    private double standardPrice = 100;
    private UnitType unitType;

    public StorageUnit(int width, int length, int height, UnitType unitType) {
        verifyDimension(width, 4);
        verifyDimension(length, 4);
        verifyDimension(height, 2);
        this.width = width;
        this.length = length;
        this.height = height;
        this.unitType = unitType;
    }

    private void verifyDimension(int distance, int divisor) {
        if(distance % divisor != 0 || distance < 1) {
            throw new IllegalArgumentException("Error: distance must be greater than zero and divisible by " + divisor);
        }
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

    public StorageUnitInterface.UnitType getType() {
        return this.unitType;
    }

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

    public LocalDate getRentalStart() {
        return rentalStart;
    }

    public boolean rent(Customer customer, LocalDate rentalStart, double price) {
        this.customer = customer;
        this.rentalStart = rentalStart;
        this.price = price;
        return true;
    }

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
}

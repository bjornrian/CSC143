package stanleyStorage;

import java.time.LocalDate;

public class StorageUnit implements StorageUnitInterface {
    private int width;
    private int length;
    private int height;
    public Customer customer;
    public LocalDate rentalStart;
    public double price;
    public UnitType unitType;

    public StorageUnit(int width, int length, int height, UnitType unitType) {
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

    public StorageUnitInterface.UnitType getType() {
        return null;
    }

    public double getPrice() {
        return price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getRentalStart() {
        return rentalStart;
    }

    public boolean rent(Customer customer, LocalDate rentalStart, double price) {
        return false;
    }

    public boolean release() {
        return false;
    }

    public String toString() {
        return "StorageUnit{" + "width=" + width + ", length=" + length + ", height=" + height
                + ", customer=" + customer + ", rentalStart=" + rentalStart + ", price=" + price
                + ", unitType=" + unitType + '}';
    }
}

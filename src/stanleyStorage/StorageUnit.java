package stanleyStorage;

import java.time.LocalDate;

public class StorageUnit implements StorageUnitInterface {
    private int width;
    private int length;
    private int height;
    public Customer customer;
    public LocalDate rentalStart;
    public double price;
    public double standardPrice = 100;
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

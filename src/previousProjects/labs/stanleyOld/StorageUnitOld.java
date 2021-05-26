package previousProjects.labs.stanleyOld;

public class StorageUnitOld {

    private int width;
    private int length;
    private int height;
    private CustomerOld customer;
    private double price;
    private Enum<UnitType> unitType;
    private String startDate;
    enum UnitType {
        STANDARD, HUMIDITY_CHECKED, TEMPERATURE_CHECKED
    }

    public StorageUnitOld(int width, int length, int height, CustomerOld customer,
            double price, Enum<UnitType> unitType, String startDate) {
        this.width = width;
        this.length = width;
        this.height = height;
        this.customer = customer;
        this.price = price;
        this.unitType = unitType;
        this.startDate = startDate;
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

    public CustomerOld getCustomer() {
        return customer;
    }

    public double getPrice() {
        return price;
    }

    public Enum<UnitType> getUnitType() {
        return unitType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setNewCust(CustomerOld customer, String startDate) {
        this.customer = customer;
        this.startDate = startDate;
    }

    public void releaseUnit() {
        this.customer = null;
        this.startDate = null;
    }
}

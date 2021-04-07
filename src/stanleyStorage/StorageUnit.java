package stanleyStorage;

public class StorageUnit {

    private int width;
    private int length;
    private int height;
    private CustConf customer;
    private double price;
    private Enum<unitType> unitType;
    private String startDate;
    enum unitType {
        STANDARD, HUMIDITY_CHECKED, TEMPERATURE_CHECKED
    }

    public StorageUnit(int width, int length, int height, CustConf customer,
            double price, Enum<unitType> unitType, String startDate) {
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

    public CustConf getCustomer() {
        return customer;
    }

    public double getPrice() {
        return price;
    }

    public Enum<StorageUnit.unitType> getUnitType() {
        return unitType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setNewCustomer(CustConf customer, String startDate) {
        this.customer = customer;
        this.startDate = startDate;
    }

    public void releaseUnit() {
        this.customer = null;
        this.startDate = null;
    }
}

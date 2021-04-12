package stanleyStorage;

public class StorageLocation implements StorageLocationInterface{
    private String designation;
    private final int rowCount = 12;
    private final int unitsPerUnitCount = 20;
    private Customer[] customerList = new Customer[100];


    public StorageLocation(String designation) {
        this.designation = designation;
    }

    @Override public String getDesignation() {
        return null;
    }

    @Override public int getRowCount() {
        return rowCount;
    }

    @Override public int getUnitsPerRowCount() {
        return unitsPerUnitCount;
    }

    @Override public StorageUnit getStorageUnit(int rowIdx, int spaceIdx) {
        return null;
    }

    @Override public Customer getCustomer(int custIdx) {
        return null;
    }

    @Override public int getCustomerCount() {
        return 0;
    }

    @Override public int addCustomer(Customer customer) {
        return 0;
    }

    @Override public StorageUnit[] getCustomerUnits(Customer customer) {
        return new StorageUnit[0];
    }

    @Override public StorageUnit[] getEmptyUnits() {
        return new StorageUnit[0];
    }

    @Override public StorageUnit[] getEmptyUnits(StorageUnit.UnitType unitType) {
        return new StorageUnit[0];
    }

    @Override public double chargeMonthlyRent() {
        return 0;
    }
}

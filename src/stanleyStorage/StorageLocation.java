package stanleyStorage;

public class StorageLocation implements StorageLocationInterface{
    private String designation;
    private final int rowCount = 12;
    private final int unitsPerUnitCount = 20;
    private StorageUnit[][] storageUnitList = new StorageUnit[rowCount][unitsPerUnitCount];
    private Customer[] customerList = new Customer[100];
    private int custIdx = 0;

    public StorageLocation(String designation) {
        this.designation = designation;
    }

    public void setStorageUnit(StorageUnit oneUnit, int row_idx, int col_idx) {
        storageUnitList[row_idx][col_idx] = oneUnit;
    }

    public String getDesignation() {
        return this.designation;
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getUnitsPerRowCount() {
        return unitsPerUnitCount;
    }

    public StorageUnit getStorageUnit(int rowIdx, int spaceIdx) {
        return storageUnitList[rowIdx][spaceIdx];
    }

    public Customer getCustomer(int custIdx) {
        return null;
    }

    public int getCustomerCount() {
        int custCount = 0;
        for(int idx = 0; idx < customerList.length; idx++) {
            if(customerList[idx] != null) {
                custCount++;
            }
        }
        return custCount;
    }

    public int addCustomer(Customer customer) {
        customerList[custIdx] = customer;
        custIdx += 1;
        return 1;
    }

    public StorageUnit[] getCustomerUnits(Customer customer) {
        return new StorageUnit[0];
    }

    public StorageUnit[] getEmptyUnits() {
        return new StorageUnit[0];
    }

    public StorageUnit[] getEmptyUnits(StorageUnit.UnitType unitType) {
        return new StorageUnit[0];
    }

    public double chargeMonthlyRent() {
        return 0;
    }
}

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
        return customerList[custIdx];
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
        StorageUnit[] custUnitsInitial = new StorageUnit[100];
        int custUnitsIdx = 0;
        for(int row_idx = 0; row_idx < rowCount; row_idx++) {
            for(int col_idx = 0; col_idx < unitsPerUnitCount; col_idx++) {
                if(storageUnitList[row_idx][col_idx].getCustomer().getName() != null
                        && storageUnitList[row_idx][col_idx].getCustomer().getName().equals(customer.getName())
                && storageUnitList[row_idx][col_idx].getCustomer().getPhone().equals(customer.getPhone())) {
                    custUnitsInitial[custUnitsIdx] = storageUnitList[row_idx][col_idx];
                    custUnitsIdx++;
                }
            }
        }
        StorageUnit[] custUnitsShortened = new StorageUnit[custUnitsIdx];
        for(int idx = 0; idx < custUnitsIdx; idx++) {
            custUnitsShortened[idx]= custUnitsInitial[idx];
        }
        return custUnitsShortened;
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

package stanleyStorage;

public class StorageLocation implements StorageLocationInterface{
    public static final int ROW_COUNT = 12;
    public static final int UNITS_PER_ROW_COUNT = 20;

    private String designation;
    private StorageUnit[][] storageUnitList = new StorageUnit[ROW_COUNT][UNITS_PER_ROW_COUNT];
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
        return ROW_COUNT;
    }

    public int getUnitsPerRowCount() {
        return UNITS_PER_ROW_COUNT;
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
        StorageUnit[] initialListOfUnits = new StorageUnit[ROW_COUNT * UNITS_PER_ROW_COUNT];
        int numberOfUnits = 0;
        for(int row_idx = 0; row_idx < ROW_COUNT; row_idx++) {
            for(int col_idx = 0; col_idx < UNITS_PER_ROW_COUNT; col_idx++) {
                StorageUnit storageUnit = storageUnitList[row_idx][col_idx];
                if(null != storageUnit) {
                    Customer customerFromList = storageUnit.getCustomer();
                    if(customerFromList != null && customerFromList.getName().equals(customer.getName())
                            && customerFromList.getPhone().equals(customer.getPhone())) {
                        initialListOfUnits[numberOfUnits] = storageUnit;
                        numberOfUnits++;
                    }
                }
            }
        }

        StorageUnit[] shortListOfUnits = new StorageUnit[numberOfUnits];
        for(int idx = 0; idx < numberOfUnits; idx++) {
            shortListOfUnits[idx]= initialListOfUnits[idx];
        }

        return shortListOfUnits;
    }

    /**
     *
     * @return
     */
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

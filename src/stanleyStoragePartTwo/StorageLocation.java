package stanleyStoragePartTwo;

public class StorageLocation implements StorageLocationInterface {
    public static final int ROW_COUNT = 12;
    public static final int UNITS_PER_ROW_COUNT = 20;

    private String designation;
    private StorageUnit[][] storageUnitList = new StorageUnit[ROW_COUNT][UNITS_PER_ROW_COUNT];
    private Customer[] customerList = new Customer[100];
    private int custIdx = 0;

    public StorageLocation(String designation) {
        verifyString(designation);
        this.designation = designation;
        initializeEmptyUnits();
    }

    private void initializeEmptyUnits() {
        for(int row_idx = 0; row_idx < ROW_COUNT; row_idx++) {
            for(int col_idx = 0; col_idx < UNITS_PER_ROW_COUNT; col_idx++) {
                if(col_idx < 4) {
                    storageUnitList[row_idx][col_idx] = new StorageUnit(4, 4, 4, StorageUnitInterface.UnitType.STANDARD);
                } else if(col_idx < 8) {
                    storageUnitList[row_idx][col_idx] = new StorageUnit(4, 4, 4, StorageUnitInterface.UnitType.HUMIDITY);
                }
                else {
                    storageUnitList[row_idx][col_idx] = new StorageUnit(4, 4, 4, StorageUnitInterface.UnitType.TEMPERATURE);
                }
            }
        }
    }

    public void setStorageUnit(StorageUnit oneUnit, int row_idx, int col_idx) {
        verifyObject(oneUnit);
        verifyInt(row_idx, ROW_COUNT);
        verifyInt(col_idx, UNITS_PER_ROW_COUNT);
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

    public StorageUnit getStorageUnit(int rowIdx, int colIdx) {
        verifyInt(rowIdx, ROW_COUNT);
        verifyInt(colIdx, UNITS_PER_ROW_COUNT);
        return storageUnitList[rowIdx][colIdx];
    }

    public Customer getCustomer(int custIdx) {
        verifyInt(custIdx, ROW_COUNT * UNITS_PER_ROW_COUNT);
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
        verifyObject(customer);
        customerList[custIdx] = customer;
        custIdx += 1;
        return 1;
    }

    public StorageUnit[] getCustomerUnits(Customer customer) {
        verifyObject(customer);
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
     * @return all non-rented units
     */
    public StorageUnit[] getEmptyUnits() {
        StorageUnit[] initialListOfUnits = new StorageUnit[ROW_COUNT * UNITS_PER_ROW_COUNT];
        int numberOfUnits = 0;
        for(int row_idx = 0; row_idx < ROW_COUNT; row_idx++) {
            for(int col_idx = 0; col_idx < UNITS_PER_ROW_COUNT; col_idx++) {
                StorageUnit storageUnit = storageUnitList[row_idx][col_idx];
                if(null != storageUnit) {
                    if(storageUnit.getCustomer() == null) {
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

    public StorageUnit[] getEmptyUnits(StorageUnit.UnitType unitType) {
        StorageUnit[] initialListOfUnits = new StorageUnit[ROW_COUNT * UNITS_PER_ROW_COUNT];
        int numberOfUnits = 0;
        for(int row_idx = 0; row_idx < ROW_COUNT; row_idx++) {
            for(int col_idx = 0; col_idx < UNITS_PER_ROW_COUNT; col_idx++) {
                StorageUnit storageUnit = storageUnitList[row_idx][col_idx];
                if(null != storageUnit) {
                    if(storageUnit.getCustomer() == null && storageUnit.getType() == unitType) {
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

    public double chargeMonthlyRent() {
        for(int row_idx = 0; row_idx < ROW_COUNT; row_idx++) {
            for(int col_idx = 0; col_idx < UNITS_PER_ROW_COUNT; col_idx++) {
                StorageUnit storageUnit = storageUnitList[row_idx][col_idx];
                if(null != storageUnit) {
                    if(storageUnit.getCustomer() != null) {
                        storageUnit.getCustomer().charge(storageUnit.getPrice());
                    }
                }
            }
        }
        return 0;
    }

    private void verifyString(String str) {
        if(str == null || str.equals("")) {
            throw new IllegalArgumentException("Error: String cannot be empty or equal to null.");
        }
    }

    private void verifyObject(Object obj) {
        if(obj == null) {
            throw new IllegalArgumentException("Error: Object cannot be equal to null.");
        }
    }

    private void verifyInt(int num, int max) {
        if(num < 0 || num >= max) {
            throw new IllegalArgumentException("Error: Customer list index is required to be between 0 and 239.");
        }
    }
}

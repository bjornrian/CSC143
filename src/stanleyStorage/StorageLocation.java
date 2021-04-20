package stanleyStorage;

public class StorageLocation {
    public static final int ROW_COUNT = 12;
    public static final int ROW_COUNT_STANDARD = 7;
    public static final int ROW_COUNT_HUMIDITY = 3;
    public static final int ROW_COUNT_TEMPERATURE = 2;
    public static final int UNITS_PER_ROW_COUNT_STANDARD = 10;
    public static final int UNITS_PER_ROW_COUNT_HUMIDITY = 8;
    public static final int UNITS_PER_ROW_COUNT_TEMPERATURE = 6;

    private String designation;
    private StorageUnit[][] storageUnitList = new StorageUnit[ROW_COUNT][];
    private Customer[] customerList = new Customer[100];
    private int customerIdx = 0;
    private double basePrice;

    public StorageLocation(String designation) {
        verifyString(designation);
        this.designation = designation;
        initializeEmptyUnits();
    }

    private void initializeEmptyUnits() {
        for(int rowIdx = 0; rowIdx < ROW_COUNT_STANDARD; rowIdx++) {
            for(int colIdx = 0; colIdx < UNITS_PER_ROW_COUNT_STANDARD; colIdx++) {
                storageUnitList[rowIdx][colIdx] = new StandardUnit(8, 8, 8);
            }
        }
        for(int rowIdx = 7; rowIdx < ROW_COUNT_HUMIDITY + 7; rowIdx++) {
            for(int colIdx = 0; colIdx < UNITS_PER_ROW_COUNT_HUMIDITY; colIdx++) {
                storageUnitList[rowIdx][colIdx] = new HumidityControlledUnit(8, 8, 8);
            }
        }
        for(int rowIdx = 10; rowIdx < ROW_COUNT_TEMPERATURE + 10; rowIdx++) {
            for(int colIdx = 0; colIdx < UNITS_PER_ROW_COUNT_TEMPERATURE; colIdx++) {
                storageUnitList[rowIdx][colIdx] = new TemperatureControlledUnit(8, 8, 8);
            }
        }
    }

    public String getDesignation() {
        return this.designation;
    }

    public int getRowCount() {
        return ROW_COUNT;
    }

    public int getUnitsPerRowCount(int rowIdx) {
        return storageUnitList[rowIdx].length;
    }

//    public StorageUnitInterface getStorageUnit(int rowIdx, int colIdx) {
//        verifyInt(rowIdx, ROW_COUNT);
//        return storageUnitList[rowIdx][colIdx];
//    }

    public StorageUnit getStorageUnit(int rowIdx, int spaceIdx) {
        return null;
    }

    public Customer getCustomer(int custIdx) {
        //verifyInt(custIdx, ROW_COUNT * UNITS_PER_ROW_COUNT);
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
        customerList[customerIdx] = customer;
        customerIdx += 1;
        return 1;
    }

    public StorageUnit[] getCustomerUnits(Customer customer) {
        verifyObject(customer);
        StorageUnit[] initialListOfUnits = new StorageUnit[ROW_COUNT * UNITS_PER_ROW_COUNT_STANDARD];
        int numberOfUnits = 0;
        for(int row_idx = 0; row_idx < ROW_COUNT; row_idx++) {
            for(int col_idx = 0; col_idx < storageUnitList[row_idx].length; col_idx++) {
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
        StorageUnit[] initialListOfUnits = new StorageUnit[ROW_COUNT * UNITS_PER_ROW_COUNT_STANDARD];
        int numberOfUnits = 0;
        for(int row_idx = 0; row_idx < ROW_COUNT; row_idx++) {
            for(int col_idx = 0; col_idx < UNITS_PER_ROW_COUNT_STANDARD; col_idx++) {//todo check logic
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

    public StorageUnit[] getEmptyUnits(Class<? extends StorageUnit> soughtClass) {
        StorageUnit[] initialListOfUnits = new StorageUnit[100]; //todo find suitable number
        int numberOfUnits = 0;
        if(soughtClass == StandardUnit.class) {
            for(int rowIdx = 0; rowIdx < ROW_COUNT_STANDARD; rowIdx++) {
                for(int colIdx = 0; colIdx < UNITS_PER_ROW_COUNT_STANDARD; colIdx++) {
                    if(storageUnitList[rowIdx][colIdx].getCustomer() == null) {
                        initialListOfUnits[numberOfUnits] = storageUnitList[rowIdx][colIdx];
                        numberOfUnits++;
                    }
                }
            }
        }

        if(soughtClass == HumidityControlledUnit.class) {
            for(int rowIdx = 7; rowIdx < ROW_COUNT_HUMIDITY + 7; rowIdx++) {
                for(int colIdx = 0; colIdx < UNITS_PER_ROW_COUNT_HUMIDITY; colIdx++) {
                    if(storageUnitList[rowIdx][colIdx].getCustomer() == null) {
                        initialListOfUnits[numberOfUnits] = storageUnitList[rowIdx][colIdx];
                        numberOfUnits++;
                    }
                }
            }
        }

        if(soughtClass == TemperatureControlledUnit.class) {
            for(int rowIdx = 10; rowIdx < ROW_COUNT_TEMPERATURE + 10; rowIdx++) {
                for(int colIdx = 0; colIdx < UNITS_PER_ROW_COUNT_TEMPERATURE; colIdx++) {
                    if(storageUnitList[rowIdx][colIdx].getCustomer() == null) {
                        initialListOfUnits[numberOfUnits] = storageUnitList[rowIdx][colIdx];
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
            for(int col_idx = 0; col_idx < UNITS_PER_ROW_COUNT_STANDARD; col_idx++) {
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

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
}

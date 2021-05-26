package previousProjects.stanleyStorage.stanleyStorage;

/**
 * Represents a storage location with many storage units.
 * Each location has a designation.
 * Each location has a double array that holds all of the storage units.
 * Each location has a list of customers that are renting the units.
 * Each location has a base price for the units.
 * Storage units come in different types, such as temperature controlled, humidity controlled, and standard.
 */
public class StorageLocation {
    private static final int ROW_COUNT = 12;
    private static final int ROW_COUNT_STANDARD = 7;
    private static final int ROW_COUNT_HUMIDITY = 3;
    private static final int ROW_COUNT_TEMPERATURE = 2;
    private static final int UNITS_PER_ROW_COUNT_STANDARD = 10;
    private static final int UNITS_PER_ROW_COUNT_HUMIDITY = 8;
    private static final int UNITS_PER_ROW_COUNT_TEMPERATURE = 6;
    private static final double DISCOUNT_FACTOR = 0.95;

    private String designation;
    private StorageUnit[][] storageUnitList = new StorageUnit[ROW_COUNT][];
    private Customer[] customerList = new Customer[106];
    private int customerIdx = 0;
    private double basePrice = 100;

    /**
     * Constructor
     *
     * @param designation The name of the location
     */
    public StorageLocation(String designation) {
        verifyString(designation);
        this.designation = designation;
        initializeEmptyUnits();
    }

    /**
     * Initializes all of the rows of units with sections that have different unit types.
     */
    private void initializeEmptyUnits() {
        for(int rowIdx = 0; rowIdx < ROW_COUNT_STANDARD; rowIdx++) {
            storageUnitList[rowIdx] = new StandardUnit[UNITS_PER_ROW_COUNT_STANDARD];
            for(int colIdx = 0; colIdx < UNITS_PER_ROW_COUNT_STANDARD; colIdx++) {
                storageUnitList[rowIdx][colIdx] = new StandardUnit(8, 8, 8, basePrice);
            }
        }
        for(int rowIdx = 7; rowIdx < ROW_COUNT_HUMIDITY + 7; rowIdx++) {
            storageUnitList[rowIdx] = new HumidityControlledUnit[UNITS_PER_ROW_COUNT_HUMIDITY];
            for(int colIdx = 0; colIdx < UNITS_PER_ROW_COUNT_HUMIDITY; colIdx++) {
                storageUnitList[rowIdx][colIdx] = new HumidityControlledUnit(8, 8, 8, basePrice);
            }
        }
        for(int rowIdx = 10; rowIdx < ROW_COUNT_TEMPERATURE + 10; rowIdx++) {
            storageUnitList[rowIdx] = new TemperatureControlledUnit[UNITS_PER_ROW_COUNT_TEMPERATURE];
            for(int colIdx = 0; colIdx < UNITS_PER_ROW_COUNT_TEMPERATURE; colIdx++) {
                storageUnitList[rowIdx][colIdx] = new TemperatureControlledUnit(8, 8, 8, basePrice);
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

    public StorageUnit getStorageUnit(int rowIdx, int spaceIdx) {
        return storageUnitList[rowIdx][spaceIdx];
    }

    public Customer getCustomer(int custIdx) {
        verifyInt(custIdx, customerList.length);
        return customerList[custIdx];
    }

    /**
     * @return Length of customer list.
     */
    public int getCustomerCount() {
        int custCount = 0;
        for(int idx = 0; idx < customerList.length; idx++) {
            if(customerList[idx] != null) {
                custCount++;
            }
        }
        return custCount;
    }

    /**
     * Adds a customer to the main customer list.
     *
     * @param customer
     * @return
     */
    public int addCustomer(Customer customer) {
        verifyObject(customer);
        customerList[customerIdx] = customer;
        customerIdx += 1;
        return 1;
    }

    /**
     *
     * Retrieves a list of storage units that are rented by one specific customer.
     * @param customer
     * @return Array of storage units
     */
    public StorageUnit[] getCustomerUnits(Customer customer) {
        if(customer == null) {
            return new StorageUnit[0];
        }
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
        int totalNumberOfUnits = getTotalNumberOfUnits();
        StorageUnit[] initialListOfUnits = new StorageUnit[totalNumberOfUnits];
        int numberOfEmptyUnits = 0;
        for(int row_idx = 0; row_idx < ROW_COUNT; row_idx++) {
            for(int col_idx = 0; col_idx < storageUnitList[row_idx].length; col_idx++) {
                StorageUnit storageUnit = storageUnitList[row_idx][col_idx];
                if(null != storageUnit) {
                    if(storageUnit.getCustomer() == null) {
                        initialListOfUnits[numberOfEmptyUnits] = storageUnit;
                        numberOfEmptyUnits++;
                    }
                }
            }
        }

        StorageUnit[] shortListOfUnits = new StorageUnit[numberOfEmptyUnits];
        for(int idx = 0; idx < numberOfEmptyUnits; idx++) {
            shortListOfUnits[idx]= initialListOfUnits[idx];
        }

        return shortListOfUnits;
    }

    private int getTotalNumberOfUnits() {
        return ROW_COUNT_STANDARD * UNITS_PER_ROW_COUNT_STANDARD + ROW_COUNT_HUMIDITY * UNITS_PER_ROW_COUNT_HUMIDITY + ROW_COUNT_TEMPERATURE * UNITS_PER_ROW_COUNT_TEMPERATURE;
    }

    /**
     * Gets all empty units of a specific unit type.
     *
     * @param soughtClass Specific unit type
     * @return Array of empty units
     */
    public StorageUnit[] getEmptyUnits(Class<? extends StorageUnit> soughtClass) {
        StorageUnit[] initialListOfUnits = new StorageUnit[getTotalNumberOfUnits()];
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

    /**
     * Charges all customers on the location's customer list based on the base
     * price and additional fees for the different unit types.
     *
     * @return
     */
    public double chargeMonthlyRent() {
        for(int idx = 0; idx < customerList.length; idx++) {
            double charge = 0;
            StorageUnit[] customerUnits = getCustomerUnits(customerList[idx]);
            for(int listIdx = 0; listIdx < customerUnits.length; listIdx++) {
                charge += customerUnits[listIdx].getPrice();
            }
            Customer customer = customerList[idx];
            if(customer != null) {
                if (customerUnits.length > 1) {
                    customer.charge(charge * DISCOUNT_FACTOR);
                } else {
                    customer.charge(charge);
                }
            }
        }
        return 0.0;
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
            throw new IllegalArgumentException("Error: Customer list index is required to be between 0 and " + max + ".");
        }
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public String toString() {
        return "Storage Location: " + designation;
    }
}

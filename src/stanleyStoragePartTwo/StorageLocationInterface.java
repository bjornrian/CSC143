package stanleyStoragePartTwo;

/**
 * Requirements for the StorageLocation class
 *
 * @author      Bill Barry
 * @version     2020-04-30
 */
public interface StorageLocationInterface {
    //note: constructor should take storage location designation parameter
    public String getDesignation();
    public int getRowCount();
    public int getUnitsPerRowCount();
    public StorageUnit getStorageUnit(int rowIdx, int spaceIdx);
    public Customer getCustomer(int custIdx);
    public int getCustomerCount();
    public int addCustomer(Customer customer);
    public StorageUnit[] getCustomerUnits(Customer customer);
    public StorageUnit[] getEmptyUnits();
    public StorageUnit[] getEmptyUnits(StorageUnit.UnitType unitType);
    public double chargeMonthlyRent();
}

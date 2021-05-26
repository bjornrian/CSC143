package previousProjects.labs.stanleyOld;

import java.util.ArrayList;

public class StorageLocationOld {
    private String name;
    private final int ROW_LENGTH = 12;
    private final int COLUMN_LENGTH = 20;
    private StorageUnitOld[][] storageUnitList = new StorageUnitOld[ROW_LENGTH][COLUMN_LENGTH];
    private ArrayList<CustomerOld> custList = new ArrayList<CustomerOld>(100);
    private int currentCust = 0;

    public StorageLocationOld(String name) {
        this.name = name;
    }

    public String getLocation() {
        return this.name.substring(3); //check for correct index to cut name out
    }

    public StorageUnitOld getStorageUnit(int row_idx, int col_idx) {
        return storageUnitList[row_idx][col_idx];
    }

    public void addCust(CustomerOld oneCust) {
        custList.add(currentCust, oneCust);
        currentCust++;
    }

    public CustomerOld getCust(int idx) {
        return custList.get(idx);
    }

    public int getCustCount() {
        return custList.size();
    }

    //
    // CAN THESE STORAGE UNIT LOOP LOCATORS BE SHORTENED INTO ONE LOOP WITH MORE PARAMETERS?
    //

    public StorageUnitOld[] findCustUnits(CustomerOld oneCust) {
        StorageUnitOld[] oneCustStorageList = new StorageUnitOld[100];
        int storageListIdx = 0;
        for (int row_idx = 0; row_idx < ROW_LENGTH; row_idx++) {
            for (int col_idx = 0; col_idx < COLUMN_LENGTH; col_idx++) {
                if (getStorageUnit(row_idx, col_idx).getCustomer() == oneCust) {
                    oneCustStorageList[storageListIdx] = storageUnitList[row_idx][col_idx];
                    storageListIdx++;
                }
            }
        }
        return oneCustStorageList;
    }

    public StorageUnitOld[] findEmptyUnits() {
        StorageUnitOld[] emptyStorageList = new StorageUnitOld[100];
        int storageListIdx = 0;
        for (int row_idx = 0; row_idx < ROW_LENGTH; row_idx++) {
            for (int col_idx = 0; col_idx < COLUMN_LENGTH; col_idx++) {
                if (getStorageUnit(row_idx, col_idx).getCustomer() == null) {
                    emptyStorageList[storageListIdx] = storageUnitList[row_idx][col_idx];
                    storageListIdx++;
                }
            }
        }
        return emptyStorageList;
    }

    public StorageUnitOld[] findTypeEmptyUnits(Enum<StorageUnitOld.UnitType> unitType) {
        StorageUnitOld[] emptyStorageList = new StorageUnitOld[100];
        int storageListIdx = 0;
        for (int row_idx = 0; row_idx < ROW_LENGTH; row_idx++) {
            for (int col_idx = 0; col_idx < COLUMN_LENGTH; col_idx++) {
                if (getStorageUnit(row_idx, col_idx).getUnitType() == unitType) {
                    emptyStorageList[storageListIdx] = storageUnitList[row_idx][col_idx];
                    storageListIdx++;
                }
            }
        }
        return emptyStorageList;
    }

    public void chargeRent(double rentAmount) {
        for (CustomerOld oneCust : custList) {
            oneCust.chargeCust(rentAmount);
        }
    }
}

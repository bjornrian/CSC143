package stanleyStorage;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StorageLocation {
    private String name;
    private final int ROW_LENGTH = 12;
    private final int COLUMN_LENGTH = 20;
    private StorageUnit[][] storageUnitList = new StorageUnit[ROW_LENGTH][COLUMN_LENGTH];
    private ArrayList<CustConf> custList = new ArrayList<CustConf>(100);
    private int currentCust = 0;

    public StorageLocation(String name) {
        this.name = name;
    }

    public String getLocation() {
        return this.name.substring(3); //check for correct index to cut name out
    }

    public StorageUnit getStorageUnit(int row_idx, int col_idx) {
        return storageUnitList[row_idx][col_idx];
    }

    public void addCust(CustConf oneCust) {
        custList.add(currentCust, oneCust);
        currentCust++;
    }

    public CustConf getCust(int idx) {
        return custList.get(idx);
    }

    public int getCustCount() {
        return custList.size();
    }

    //
    // CAN THESE STORAGE UNIT LOOP LOCATORS BE SHORTENED INTO ONE LOOP WITH MORE PARAMETERS?
    //

    public StorageUnit[] findCustStorageUnits(CustConf oneCust) {
        StorageUnit[] oneCustStorageList = new StorageUnit[100];
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

    public StorageUnit[] findEmptyStorageUnits() {
        StorageUnit[] emptyStorageList = new StorageUnit[100];
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

    public StorageUnit[] findSpecificEmptyStorageUnits(Enum<StorageUnit.unitType> unitType) {
        StorageUnit[] emptyStorageList = new StorageUnit[100];
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

    public void chargeRent(int rentAmount) {
        for (CustConf oneCust : custList) {
            oneCust.chargeCust(rentAmount);
        }
    }
}

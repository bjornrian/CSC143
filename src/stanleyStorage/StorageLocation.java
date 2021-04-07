package stanleyStorage;

import java.lang.reflect.Array;

public class StorageLocation {
    private String name;
    private final int ROW_LENGTH = 12;
    private final int COLUMN_LENGTH = 20;
    private StorageUnit[][] storageUnitList = new StorageUnit[ROW_LENGTH][COLUMN_LENGTH];
    private Array[] custList = new Array[100];

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

    }
}

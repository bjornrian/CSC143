package stanleyStorage;

public class StandardUnit extends StorageUnit {

    public static final int STANDARD_UNIT_PRICE = 75;

    public StandardUnit(int length, int width, int height) {
        super(length, width, height);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + STANDARD_UNIT_PRICE;
    }
}

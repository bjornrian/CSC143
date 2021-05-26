package previousProjects.stanleyStorage.stanleyStorage;

public class StandardUnit extends StorageUnit {

    private static final int STANDARD_UNIT_PRICE = 75;

    public StandardUnit(int length, int width, int height, double basePrice) {
        super(length, width, height, basePrice);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + STANDARD_UNIT_PRICE;
    }
}

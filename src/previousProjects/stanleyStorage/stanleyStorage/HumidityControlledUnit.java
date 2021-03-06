package previousProjects.stanleyStorage.stanleyStorage;

public class HumidityControlledUnit extends StorageUnit {
    private static final int PRICE_PER_SQUARE_FOOT = 5;
    private static final int PRICE_FOR_CUSTOM_HUMIDITY = 20;
    private Integer humidity;

    public HumidityControlledUnit(int length, int width, int height, double basePrice) {
        super(length, width, height, basePrice);
    }

    @Override
    public double getPrice() {
        double basePrice = super.getPrice();
        int squareFootage = getLength() * getWidth();
        double areaPrice = squareFootage * PRICE_PER_SQUARE_FOOT;
        double finalPrice = basePrice + areaPrice;
        if(null != humidity && humidity <= 29) {
            finalPrice += PRICE_FOR_CUSTOM_HUMIDITY;
        }
        return finalPrice;
    }

    public void setHumidity(Integer humidity) {
        verifyHumidity(humidity);
        this.humidity = humidity;
    }

    public Integer getHumidity() {
        return humidity;
    }

    private void verifyHumidity(Integer humidity) {
        if (humidity < 20 || humidity > 60) {
            throw new IllegalArgumentException("Error: Humidity percentage must be between 20 and 60%.");
        }
    }
}

package previousProjects.stanleyStorage.stanleyStorage;

public class TemperatureControlledUnit extends StorageUnit {
    private static final double PRICE_PER_CUBIC_FOOT = 1;
    private static final double PRICE_FOR_CUSTOM_TEMPERATURE = 30;
    private Integer temperature;

    public TemperatureControlledUnit(int length, int width, int height, double basePrice) {
        super(length, width, height, basePrice);
    }

    @Override
    public double getPrice() {
        double basePrice = super.getPrice();
        int volume = getLength() * getWidth() * getHeight();
        double volumePrice = volume * PRICE_PER_CUBIC_FOOT;
        double finalPrice = basePrice + volumePrice;
        if(null != temperature && (temperature <= 49 || temperature >= 65)) {
            finalPrice += PRICE_FOR_CUSTOM_TEMPERATURE;
        }
        return finalPrice;
    }

    public void setTemperature(Integer temperature) {
        verifyTemperature(temperature);
        this.temperature = temperature;
    }

    public Integer getTemperature() {
        return temperature;
    }

    private void verifyTemperature(Integer temperature) {
        if (temperature < 45 || temperature > 70) {
            throw new IllegalArgumentException("Error: Temperature input must be between 45 and 70 degrees.");
        }
    }
}

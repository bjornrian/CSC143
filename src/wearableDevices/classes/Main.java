package wearableDevices.classes;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        WearableManager manager = new WearableManager();
        System.out.println(Arrays.toString(manager.getRankingPositionData()));
        System.out.println(Arrays.toString(manager.getPricingPositionData()));
        System.out.println(Arrays.toString(manager.getCoNamePositionData()));
    }
}

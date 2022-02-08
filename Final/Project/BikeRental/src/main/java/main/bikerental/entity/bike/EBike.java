package main.bikerental.entity.bike;

public class EBike extends Bike {
    private int battery;
    private int estimatedUsageTimeRemaining;
    private int loadCycle;

    public EBike(String id) {
        super(id);
        type = BikeType.E_BIKE;
    }
}

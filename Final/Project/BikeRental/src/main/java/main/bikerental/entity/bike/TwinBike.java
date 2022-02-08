package main.bikerental.entity.bike;

public class TwinBike extends Bike {

    public TwinBike(String id) {
        super(id);
        type = BikeType.TWIN_BIKE;
    }
}

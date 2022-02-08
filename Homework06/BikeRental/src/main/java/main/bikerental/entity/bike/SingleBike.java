package main.bikerental.entity.bike;

public class SingleBike extends Bike{
    public SingleBike(String id) {
        super(id);
        type = BikeType.SINGLE_BIKE;
    }
}

package main.bikerental.RentBike;


import main.bikerental.controller.RentBikeController;
import main.bikerental.entity.bike.BikeType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RentBikeTest {
    private RentBikeController rentBikeController = new RentBikeController();

    @Test
    void test1() {
        int result = rentBikeController.calculateFee(BikeType.E_BIKE);
        Assertions.assertEquals(700000, result);
    }
    @Test
    void test2() {
        int result = rentBikeController.calculateFee(BikeType.TWIN_BIKE);
        Assertions.assertEquals(550000, result);
    }
    @Test
    void test3() {
        int result = rentBikeController.calculateFee(BikeType.SINGLE_BIKE);
        Assertions.assertEquals(400000, result);
    }
}

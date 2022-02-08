package main.bikerental.RentBike;

import main.bikerental.controller.ChooseBikeToGiveBackController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class CheckStationToReturn {
    private ChooseBikeToGiveBackController chooseBikeToGiveBackController = new ChooseBikeToGiveBackController();

    @Test
    void test4() throws SQLException {
        boolean result = chooseBikeToGiveBackController.checkStationIsValid("-1");
        Assertions.assertEquals(false, result);
    }

    @Test
    void test5() throws SQLException {
        boolean result = chooseBikeToGiveBackController.checkStationIsValid("");
        Assertions.assertEquals(false, result);
    }

    @Test
    void test6() throws SQLException {
        boolean result = chooseBikeToGiveBackController.checkStationIsValid("abc");
        Assertions.assertEquals(false, result);
    }

    @Test
    void test7() throws SQLException {
        boolean result = chooseBikeToGiveBackController.checkStationIsValid("1");
        Assertions.assertEquals(true, result);
    }

}

package main.bikerental.RentBike;

import main.bikerental.controller.ChooseBikeToGiveBackController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class CheckBikeToReturnTest {
    private ChooseBikeToGiveBackController chooseBikeToGiveBackController = new ChooseBikeToGiveBackController();

    @Test
    void test1() throws SQLException {
        boolean result = chooseBikeToGiveBackController.checkBikeIsValid("-1");
        Assertions.assertEquals(false, result);
    }

    @Test
    void test2() throws SQLException {
        boolean result = chooseBikeToGiveBackController.checkBikeIsValid("");
        Assertions.assertEquals(false, result);
    }

    @Test
    void test3() throws SQLException {
        boolean result = chooseBikeToGiveBackController.checkBikeIsValid("abc");
        Assertions.assertEquals(false, result);
    }


}

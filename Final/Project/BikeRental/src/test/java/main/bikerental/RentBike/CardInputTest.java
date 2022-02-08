package main.bikerental.RentBike;

import main.bikerental.views.screen.payment.PaymentScreenHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CardInputTest {
    private PaymentScreenHandler paymentScreenHandler = new PaymentScreenHandler();

    @Test
    void test1() {
        boolean result = paymentScreenHandler.validateInput("", "", "1", "12");
        Assertions.assertEquals(false, result);
    }
    @Test
    void test2() {
        boolean result = paymentScreenHandler.validateInput("a", "b", "12", "+12");
        Assertions.assertEquals(false, result);
    }
    @Test
    void test3() {
        boolean result = paymentScreenHandler.validateInput("bb", "cc", "1", "1245");
        Assertions.assertEquals(false, result);
    }
    @Test
    void test4() {
        boolean result = paymentScreenHandler.validateInput("dd", "aa", "1", "123");
        Assertions.assertEquals(true, result);
    }
}

package main.bikerental.RentBike;

import main.bikerental.controller.PaymentController;
import main.bikerental.entity.payment.CreditCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Hashtable;

public class PaymentTest {
    PaymentController paymentController = new PaymentController();
    CreditCard creditCard = new CreditCard("kscq2_group18_2021", "Group 18", 227, "1125");

    @Test
    public void test1() {
        Hashtable<String, String> result = paymentController.pay(creditCard, 20000000, "pay");
        Assertions.assertEquals("PAYMENT FAILED", result.get("RESULT"));
    }

    @Test
    public void test2() {
        Hashtable<String, String> result = paymentController.pay(creditCard, 200, "pay");
        Assertions.assertEquals("PAYMENT SUCCESSFUL", result.get("RESULT"));
    }
}

package main.bikerental.common.exception.payment;

public class NotEnoughBalanceException extends PaymentException {
    public NotEnoughBalanceException() {
        super("ERROR: Not enough balance in card!");
    }
}

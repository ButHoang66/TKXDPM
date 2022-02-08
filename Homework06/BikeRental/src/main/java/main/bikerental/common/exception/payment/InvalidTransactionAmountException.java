package main.bikerental.common.exception.payment;

public class InvalidTransactionAmountException extends PaymentException {
    public InvalidTransactionAmountException() {
        super("ERROR: Invalid Transaction Amount!");
    }
}

package main.bikerental.common.exception.payment;

public class SuspiciousTransactionException extends PaymentException {
    public SuspiciousTransactionException() {
        super("ERROR: Suspicious Transaction Report!");
    }
}

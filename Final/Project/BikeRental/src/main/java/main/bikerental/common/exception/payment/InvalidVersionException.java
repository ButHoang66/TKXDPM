package main.bikerental.common.exception.payment;

public class InvalidVersionException extends PaymentException {
    public InvalidVersionException() {
        super("ERROR: Invalid Version Information!");
    }
}

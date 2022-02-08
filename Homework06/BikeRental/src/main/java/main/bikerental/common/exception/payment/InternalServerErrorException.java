package main.bikerental.common.exception.payment;

public class InternalServerErrorException extends PaymentException {
    public InternalServerErrorException() {
        super("ERROR: Internal Server Error!");
    }
}

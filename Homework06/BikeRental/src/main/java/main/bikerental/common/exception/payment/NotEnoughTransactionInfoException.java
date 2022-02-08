package main.bikerental.common.exception.payment;

public class NotEnoughTransactionInfoException extends PaymentException {
    public NotEnoughTransactionInfoException() {
        super("ERROR: Not Enough Transcation Information");
    }
}

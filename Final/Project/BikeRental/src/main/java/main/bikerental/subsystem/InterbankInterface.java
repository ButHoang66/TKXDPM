package main.bikerental.subsystem;

import main.bikerental.entity.payment.CreditCard;
import main.bikerental.entity.payment.PaymentTransaction;

public interface InterbankInterface {

    /**
     *
     * @param card
     * @param amount
     * @param contents
     * @return
     */
    public abstract PaymentTransaction pay(CreditCard card, int amount, String contents);


    public abstract PaymentTransaction refund(CreditCard card, int amount, String contents);
}

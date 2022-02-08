package main.bikerental.controller;

import main.bikerental.entity.payment.CreditCard;
import main.bikerental.entity.payment.PaymentTransaction;
import main.bikerental.common.exception.UnrecognizedException;
import main.bikerental.common.exception.payment.PaymentException;
import main.bikerental.subsystem.InterbankInterface;
import main.bikerental.subsystem.interbank.InterbankSubsystemController;

import java.util.Hashtable;

/**
 * This class control the flow of the payment process
 * @author nguyentuananh
 */
public class PaymentController extends BaseController{
    /**
     * Represent the Interbank subsystem
     */
    private InterbankInterface interbank;


    /**
     * @param creditCard the credit card is used for payment
     * @param amount amount to pay
     * @param contents transaction contents
     * @return
     */
    public Hashtable<String, String> pay(CreditCard creditCard, int amount, String contents) {
        Hashtable<String, String> result = new Hashtable<String, String>();
        result.put("RESULT", "PAYMENT FAILED");
        try {
            this.interbank = new InterbankSubsystemController();
            PaymentTransaction transaction = interbank.pay(creditCard, amount, contents);
            result.put("RESULT", "PAYMENT SUCCESSFUL");
        } catch (PaymentException | UnrecognizedException ex) {
            result.put("MESSAGE", ex.getMessage());
        }
        return result;
    }

}

package main.bikerental.RentBike;

import main.bikerental.entity.payment.CreditCard;
import main.bikerental.common.exception.UnrecognizedException;
import main.bikerental.common.exception.payment.*;
import main.bikerental.subsystem.interbank.InterbankBoundary;
import main.bikerental.utils.Configs;
import main.bikerental.utils.MyMap;

import java.util.Hashtable;
import java.util.Map;

public class ResetBalance {
    public static void main(String[] args) {
        CreditCard creditCard = new CreditCard("kscq2_group18_2021", "Group 18", 227, "1125");
        Map<String, String> result = new Hashtable<String, String>();
        result.put("RESULT", "PAYMENT FAILED!");
        try {
            resetBalance();
            result.put("RESULT", "PAYMENT SUCCESSFUL!");
        } catch (PaymentException | UnrecognizedException ex) {
            result.put("MESSAGE", ex.getMessage());
        }
        System.out.println(result.get("RESULT"));
    }

    public static void resetBalance() {
        Map<String, Object> requestMap = new MyMap();
        requestMap.put("cardCode", "kscq2_group18_2021");
        requestMap.put("owner", "Group 18");
        requestMap.put("cvvCode", 227);
        requestMap.put("dateExpired", "1125");

        String responseText = new InterbankBoundary().query(Configs.RESET_BALANCE_URL, generateData(requestMap));
    }


    private static String generateData(Map<String, Object> data) {
        return ((MyMap) data).toJSON();
    }
}

package main.bikerental.common;

public enum BikeStatus {
    AVAILABLE("Available"),
    NOT_AVAILABLE("NotAvailable");
    public String value;
    BikeStatus(String value){
        this.value = value;
    }

    public static Boolean isAvailable(String status){
        return AVAILABLE.value.equals(status);
    }
}

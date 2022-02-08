package main.bikerental.controller;

import main.bikerental.entity.bike.BikeType;

/**
 * @author nguyentuananh
 */
public class DepositCalculatorImpl implements IDepositCalculator{
    @Override
    public int calculateFee(BikeType type) {
        switch (type) {
            case SINGLE_BIKE: return 400000;
            case E_BIKE: return 700000;
            case TWIN_BIKE: return 550000;
            default: return 0;
        }
    }
}

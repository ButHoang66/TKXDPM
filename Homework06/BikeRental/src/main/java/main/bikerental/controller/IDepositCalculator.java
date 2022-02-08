package main.bikerental.controller;

import main.bikerental.entity.bike.BikeType;

/**
 * This interface is used to calculate initial deposit
 * @author nguyentuananh
 */
public interface IDepositCalculator {
    public int calculateFee(BikeType type);
}

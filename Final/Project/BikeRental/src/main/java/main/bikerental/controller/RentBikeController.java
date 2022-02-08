package main.bikerental.controller;

import main.bikerental.common.BikeStatus;
import main.bikerental.entity.RentInfo;
import main.bikerental.entity.bike.Bike;
import main.bikerental.entity.bike.BikeType;

import java.time.LocalDateTime;

/**
 * This class controls the flow of events when user rents bike
 * @author nguyentuananh
 */
public class RentBikeController extends BaseController {
    IDepositCalculator depositCalculator;

    public RentBikeController() {
        depositCalculator = new DepositCalculatorImpl();
    }

    /**
     * Check bike available to rent or not
     * @param id
     * @return
     */
    public boolean checkBikeAvailable(String id) {
        return new Bike(id).checkBikeAvailable();
    }

    public int calculateFee(BikeType type) {
        return depositCalculator.calculateFee(type);
    }

    /**
     * Update bike and rent info after successful rental
     * @param bike
     * @param account
     */
    public void updateRentInfo(Bike bike, String account) {
        bike.setAvailable(BikeStatus.NOT_AVAILABLE);
        RentInfo rentInfo = new RentInfo(account, bike.getId(), bike.getStation(), LocalDateTime.now());
        rentInfo.setRentInfo();
    }
}

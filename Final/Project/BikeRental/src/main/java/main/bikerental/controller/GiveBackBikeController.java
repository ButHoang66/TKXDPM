package main.bikerental.controller;

import main.bikerental.entity.database.EcoBikeDB;

import java.io.SyncFailedException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GiveBackBikeController extends BaseController implements IFeeRentBikeCaculator{

    private String bikeId;

    private int moneyDeposit;
    private int timeRent;
    private String rentStationId;

    public GiveBackBikeController(String bikeId){
        this.bikeId = bikeId;
        }

    public GiveBackBikeController(){
        System.out.println("Controller2");
    }

    public int getTimeRent(){
        try {
            Statement statement = EcoBikeDB.getConnection().createStatement();
            String query = "select * from rental where bikeId = " + bikeId;
            ResultSet rs = statement.executeQuery(query);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String str = "";
            LocalDateTime dateTime;
            int hour;
            int hour_now = LocalDateTime.now().getHour();
            while (rs.next()) {
                str = rs.getString(3);
                dateTime = LocalDateTime.parse(str, formatter);
                hour = dateTime.getHour();
                if(hour_now >= hour){
                    timeRent = hour_now - hour;
                }else{
                    timeRent = hour_now + 24 - hour;
                }
                rentStationId = rs.getString(6);
                return timeRent;
            }
            return 0;
        } catch (SQLException e) {
            System.out.println("Thất bại!");
            e.printStackTrace();
            return 0;
        }
    }

    public int getPriceBike(){
        try {
            Statement statement = EcoBikeDB.getConnection().createStatement();
            String query = "select price from bike where id = " + bikeId;
            ResultSet rs = statement.executeQuery(query);
            int res = 0;
            while (rs.next()) {
                res = rs.getInt(1);
                return res;
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void updateDB(String stationId){
        deleteRental();
        updateStation(stationId);
        updateBike(stationId);
        updateRentStation();
    }

    public void deleteRental(){
        try {
            Statement statement = EcoBikeDB.getConnection().createStatement();
            int bike = Integer.parseInt(bikeId);
            String query = "delete from ecobikerental.rental where bikeId = " + bike;
            int rs = statement.executeUpdate(query);
            if(rs == 1){
                System.out.println("Xóa bản ghi thuê xe thành công!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Xóa thất bại!");
        }
    }

    public void updateStation(String stationId){
        try {
            Statement statement = EcoBikeDB.getConnection().createStatement();
            int numberBike = 0;
            int numberOfAvailable = 0;
            String query = "select  * from station where id = " + stationId;
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                numberBike = rs.getInt(4);
                numberOfAvailable = rs.getInt(5);
                break;
            }
            numberBike++;
            numberOfAvailable++;
            query = "update ecobikerental.station set numberOfBike = " + numberBike + ", numberOfBikeAvailable = " + numberOfAvailable + " where id = " + stationId;
            int result = statement.executeUpdate(query);
            if(result == 1){
                System.out.println("Cập nhật thành công!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cập nhật thất bại");
        }
    }

    public void updateRentStation(){
        try {
            Statement statement = EcoBikeDB.getConnection().createStatement();
            int numberBike = 0;
            String query = "select  * from station where id = " + rentStationId;
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                numberBike = rs.getInt(4);
                break;
            }
            numberBike--;
            query = "update ecobikerental.station set numberOfBike = " + numberBike + " where id = " + rentStationId;
            int result = statement.executeUpdate(query);
            if(result == 1){
                System.out.println("Cập nhật bãi thuê thành công!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cập nhật bãi thuê thất bại");
        }
    }

    public void updateBike(String stationId){
        try {
            Statement statement = EcoBikeDB.getConnection().createStatement();
            String query = "update ecobikerental.bike set status = 'Available', stationId = " + stationId + " where id = " + bikeId;
            int rs = statement.executeUpdate(query);
            if(rs == 1){
                System.out.println("Cập nhật trạng thái xe thành công!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cập nhật trạng thái xe bại!");
        }
    }


    @Override
    public int calculateFee(int timeRent) {
        int fee = 0;
        if(timeRent <= 12){
            fee = timeRent * 10000;
            return fee;
        }else{
            fee = 120000 + (timeRent - 12) * 8000;
            return fee;
        }
    }
}

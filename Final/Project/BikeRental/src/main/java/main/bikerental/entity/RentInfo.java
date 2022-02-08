package main.bikerental.entity;

import main.bikerental.entity.database.EcoBikeDB;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RentInfo {
    private String account;
    LocalDateTime startTime;

    private String startTime2;
    private String id;
    private int bikeId;
    private int rentStationId;
    private String status;

    public RentInfo(String account, String id, LocalDateTime startTime) {
        this.account = account;
        this.id = id;
        this.startTime = startTime;
    }

    public RentInfo() {
    }

    public RentInfo(String account, String id, int station, LocalDateTime now) {
        this.account = account;
        this.id = id;
        this.rentStationId = station;
        this.startTime = now;
    }

    public String getStartTime2() {
        return startTime2;
    }

    public void setStartTime2(String startTime2) {
        this.startTime2 = startTime2;
    }

    public RentInfo(String startTime2, String id, int bikeId, int rentStationId, String status) {
        this.startTime2 = startTime2;
        this.id = id;
        this.bikeId = bikeId;
        this.rentStationId = rentStationId;
        this.status = status;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBikeId() {
        return bikeId;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }

    public int getRentStationId() {
        return rentStationId;
    }

    public void setRentStationId(int rentStationId) {
        this.rentStationId = rentStationId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRentInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String now = formatter.format(startTime);

        try {
            String query = "insert into rental (status, timeStart, bikeId, rentStationId) values (?, ?, ?, ?)";
            PreparedStatement preparedStatement =  EcoBikeDB.getConnection().prepareStatement(query);
            preparedStatement.setString(1, "đang thuê xe");
            preparedStatement.setString(2, now);
            preparedStatement.setString(3, id);
            preparedStatement.setInt(4, rentStationId);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

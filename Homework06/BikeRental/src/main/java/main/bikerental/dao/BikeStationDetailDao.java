package main.bikerental.dao;

import main.bikerental.entity.bike.Bike;
import main.bikerental.entity.bikestation.BikeStation;

import java.sql.SQLException;
import java.util.List;

public interface BikeStationDetailDao {
    List<Bike> getAll(int id) throws SQLException;

    BikeStation getBikeStation(int id) throws SQLException;

}

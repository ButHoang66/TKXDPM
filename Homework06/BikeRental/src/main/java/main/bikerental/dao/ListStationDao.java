package main.bikerental.dao;

import main.bikerental.entity.bikestation.BikeStation;

import java.sql.SQLException;
import java.util.List;

public interface ListStationDao {
    List<BikeStation> getAll() throws SQLException;
    List<BikeStation> searchBikeStation(String keyword) throws SQLException;
}

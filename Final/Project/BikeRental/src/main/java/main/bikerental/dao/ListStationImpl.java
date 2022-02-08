package main.bikerental.dao;

import main.bikerental.dao.ListStationDao;
import main.bikerental.entity.bikestation.BikeStation;
import main.bikerental.entity.database.EcoBikeDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListStationImpl implements ListStationDao {
    @Override
    public List<BikeStation> getAll() throws SQLException {
        String SQL_QUERY = "select * from station";
        List<BikeStation> stations = new ArrayList<>();
        Connection con = EcoBikeDB.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement(SQL_QUERY);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            int numberBike = rs.getInt(4);
            int numberBikeAvailable = rs.getInt(5);
            BikeStation bikeStation = new BikeStation();
            bikeStation.setId(rs.getInt(1));
            bikeStation.setName(rs.getString(2));
            bikeStation.setAddress(rs.getString(3));
            bikeStation.setNumberOfBike(numberBike);
            bikeStation.setNumberOfBikeAvailable(numberBikeAvailable);
            stations.add(bikeStation);
        }
        return stations;
    }

    @Override
    public List<BikeStation> searchBikeStation(String keyword) throws SQLException {
        String SQL_QUERY = "select * from station";
        List<BikeStation> stations = new ArrayList<>();
        Connection con = EcoBikeDB.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement(SQL_QUERY);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            if (rs.getString("name").contains(keyword)) {
                BikeStation bikeStation = new BikeStation();
                bikeStation.setId(rs.getInt("id"));
                bikeStation.setName(rs.getString("name"));
                bikeStation.setAddress(rs.getString("address"));
                bikeStation.setNumberOfBike(rs.getInt("numberOfBike"));
                bikeStation.setNumberOfBikeAvailable(rs.getInt("numberOfBikeAvailable"));
                stations.add(bikeStation);
            }
        }

        return stations;
    }
}

package main.bikerental.dao;

import main.bikerental.dao.BikeStationDetailDao;
import main.bikerental.entity.bike.Bike;
import main.bikerental.entity.bike.BikeType;
import main.bikerental.entity.bikestation.BikeStation;
import main.bikerental.entity.database.EcoBikeDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BikeStationDetailImpl implements BikeStationDetailDao {
    @Override
    public List<Bike> getAll(int id) throws SQLException {
        String SQL_QUERY = "select * from bike where stationId = " + id;
        List<Bike> bikes = new ArrayList<>();
        Connection con = EcoBikeDB.getConnection();
        PreparedStatement pst = con.prepareStatement(SQL_QUERY);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            Bike bike = new Bike();
            bike.setId(rs.getString("id"));
            bike.setName(rs.getString("name"));
            bike.setStatus(rs.getString("status"));
            bike.setStation(id);
            switch (rs.getString("type")) {
                case "Bike": {
                    bike.setType(BikeType.SINGLE_BIKE);
                    break;
                }
                case "E-Bike": {
                    bike.setType(BikeType.E_BIKE);
                    break;
                }
                case "Twin Bike": {
                    bike.setType(BikeType.TWIN_BIKE);
                    break;
                }
            }
            if (bike.getType() != null)
                bikes.add(bike);
        }
        return bikes;
    }

    @Override
    public BikeStation getBikeStation(int id) throws SQLException {
        String SQL_QUERY = "select * from station where id = " + id;
        BikeStation bikeStation = new BikeStation();
        Connection con = EcoBikeDB.getConnection();
        PreparedStatement pst = con.prepareStatement(SQL_QUERY);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            bikeStation.setName(rs.getString("id"));
            bikeStation.setAddress(rs.getString("address"));
            bikeStation.setNumberOfBike(rs.getInt("numberOfBike"));
        }
        System.out.println(bikeStation);
        return bikeStation;
    }


}

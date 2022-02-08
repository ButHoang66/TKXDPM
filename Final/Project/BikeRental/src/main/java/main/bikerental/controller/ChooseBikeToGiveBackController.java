package main.bikerental.controller;

import main.bikerental.entity.database.EcoBikeDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChooseBikeToGiveBackController extends BaseController{

    public boolean checkBikeIsValid(String bikeId) throws SQLException {
        try{
            Statement statement = EcoBikeDB.getConnection().createStatement();
            String query = "select * from rental where bikeId = " + bikeId;
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                return true;
            }
            return false;
        }catch(SQLException e) {
            return false;
        }
    }

    public boolean checkStationIsValid(String stationId) throws SQLException {
        try{
            Statement statement = EcoBikeDB.getConnection().createStatement();
            String query = "select * from station where id = " + stationId;
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                return true;
            }
            return false;
        }catch(SQLException e) {
            return false;
        }
    }
}

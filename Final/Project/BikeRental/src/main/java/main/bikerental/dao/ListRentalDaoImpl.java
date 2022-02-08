package main.bikerental.dao;

import main.bikerental.dao.ListRentalDao;
import main.bikerental.entity.RentInfo;
import main.bikerental.entity.database.EcoBikeDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListRentalDaoImpl implements ListRentalDao {

    public ListRentalDaoImpl() {

    }

    @Override
    public List<RentInfo> getAll() throws SQLException {
        String query = "select * from rental";
        List<RentInfo> list = new ArrayList<>();
        Connection con = EcoBikeDB.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            RentInfo rentInfo = new RentInfo();
            rentInfo.setId(rs.getString("id"));
            rentInfo.setStatus(rs.getString("status"));
            rentInfo.setStartTime2(new String(rs.getString("timeStart")));
            rentInfo.setBikeId(rs.getInt("bikeId"));
            rentInfo.setRentStationId(rs.getInt("rentStationId"));
            list.add(rentInfo);
        }

        return list;
    }
}

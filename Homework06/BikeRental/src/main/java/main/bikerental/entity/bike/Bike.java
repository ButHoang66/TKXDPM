package main.bikerental.entity.bike;

import main.bikerental.common.BikeStatus;
import main.bikerental.entity.database.EcoBikeDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bike {
    private String id;
    protected int station;
    protected BikeType type;
    protected float price;
    protected String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Bike() {

    }

    public Bike(String id) {
        this.id = id;
    }

    public boolean checkBikeAvailable() {
        try {
            Statement statement = EcoBikeDB.getConnection().createStatement();
            String query = "select status from bike where id = " + id;
            ResultSet rs = statement.executeQuery(query);
            String status = "";
            while (rs.next()) {
                status = rs.getString(1);
                break;
            }
            if (status.equals(BikeStatus.AVAILABLE.value))
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void setAvailable(BikeStatus status) {
        String set;
        if (status == BikeStatus.AVAILABLE)
            set = BikeStatus.AVAILABLE.value;
        else
            set = BikeStatus.NOT_AVAILABLE.value;
        try {
            Statement statement = EcoBikeDB.getConnection().createStatement();
            String query = "update bike set status = '" + set + "'" + " where id = " + id;
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getStation() {
        return station;
    }

    public BikeType getType() {
        return type;
    }

    public void setType(BikeType type) {
        this.type = type;
    }

    public void setStation(int station) {
        this.station = station;
    }

    @Override
    public String toString() {
        return " " + name;
    }
}

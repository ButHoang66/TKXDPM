package main.bikerental.dao;

import main.bikerental.entity.RentInfo;

import java.sql.SQLException;
import java.util.List;

public interface ListRentalDao {
    List<RentInfo> getAll() throws SQLException;
}

package main.bikerental.controller;

import main.bikerental.dao.ListStationDao;
import main.bikerental.entity.bikestation.BikeStation;

import java.sql.SQLException;
import java.util.List;

public class FindBikeStationController extends BaseController{

    private final ListStationDao listStationDao;

    public FindBikeStationController(ListStationDao listStationDao) {
        this.listStationDao = listStationDao;
    }

    public List<BikeStation> searchBikeStation(String name) throws SQLException {
        return listStationDao.searchBikeStation(name);
    }
}

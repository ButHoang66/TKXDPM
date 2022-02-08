package main.bikerental.RentBike;

import main.bikerental.dao.ListStationDao;
import main.bikerental.dao.ListStationImpl;
import main.bikerental.entity.bikestation.BikeStation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

public class SearchStationTest {

    Boolean res = true;

    private ListStationDao listStationDao;

    @BeforeEach
    void setUp() {
        listStationDao = new ListStationImpl();
    }

    @Test
    public void FindSuccessTest() throws SQLException {
        List<BikeStation> bikeStations = listStationDao.searchBikeStation("TC");
        if (bikeStations.size() == 0) res = false;
        Assertions.assertEquals(true, res);
    }

    @Test
    public void FindFailedTest() throws SQLException {
        List<BikeStation> bikeStations = listStationDao.searchBikeStation("Tc");
        if (bikeStations.size() > 0) res = false;
        Assertions.assertEquals(true, res);
    }

}

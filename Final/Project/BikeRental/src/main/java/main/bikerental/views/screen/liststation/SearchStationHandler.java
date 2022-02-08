package main.bikerental.views.screen.liststation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.bikerental.App;
import main.bikerental.controller.FindBikeStationController;
import main.bikerental.dao.ListStationDao;
import main.bikerental.dao.ListStationImpl;
import main.bikerental.entity.bikestation.BikeStation;
import main.bikerental.utils.Configs;
import main.bikerental.views.BaseScreenHandler;
import main.bikerental.views.screen.home.HomeScreenHandler;
import main.bikerental.views.screen.station.BikeStationScreenDetailHandler;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class SearchStationHandler extends BaseScreenHandler implements Initializable {

    @FXML
    private TableView<BikeStation> table;
    @FXML
    private TableColumn<BikeStation, Integer> colSTT;
    @FXML
    private TableColumn<BikeStation, String> colTenBai;
    @FXML
    private TableColumn<BikeStation, String> colDiaChi;
    @FXML
    private TableColumn<BikeStation, Integer> colSoXe;
    @FXML
    private TableColumn<BikeStation, Integer> colXeTrong;
    @FXML
    private Button back;
    @FXML
    private TableRow<BikeStation> tableRow;

    private FindBikeStationController findBikeStationController;

    private String keyword;

    public SearchStationHandler() {

    }

    public SearchStationHandler(Stage stage, String screenPath, String keyword) throws IOException {
        super(stage, screenPath);
        this.keyword = keyword;
        ListStationDao dao = new ListStationImpl();
        findBikeStationController = new FindBikeStationController(dao);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            HomeScreenHandler homeScreenHandler = new HomeScreenHandler(App.mainStage, Configs.HOME_SCREEN_PATH);
            searchStation(keyword);
            setOnRowListener();
            setPreviousScreen(homeScreenHandler);
            back.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    //stage.close();
                    try {
                        getPreviousScreen().show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private void setOnRowListener() {
        table.setOnMouseClicked(event -> {
            // Make sure the user clicked on a populated item
            if (table.getSelectionModel().getSelectedItem() != null) {
                try {
                    BikeStation bikeStation = table.getSelectionModel().getSelectedItem();
                    int id = bikeStation.getId();
                    BikeStationScreenDetailHandler screen = new BikeStationScreenDetailHandler(stage, Configs.BIKE_STATION_DETAIL_PATH,id);
                    screen.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void searchStation(String keyword) throws SQLException {
        List<BikeStation> stationList = findBikeStationController.searchBikeStation(keyword);
        ObservableList<BikeStation> list = FXCollections.observableArrayList(stationList);
        colSTT.setCellValueFactory(new PropertyValueFactory<BikeStation, Integer>("id"));
        colTenBai.setCellValueFactory(new PropertyValueFactory<BikeStation, String>("name"));
        colDiaChi.setCellValueFactory(new PropertyValueFactory<BikeStation, String>("address"));
        colSoXe.setCellValueFactory(new PropertyValueFactory<BikeStation, Integer>("numberOfBike"));
        colXeTrong.setCellValueFactory(new PropertyValueFactory<BikeStation, Integer>("numberOfBikeAvailable"));
        table.setItems(list);
    }


}


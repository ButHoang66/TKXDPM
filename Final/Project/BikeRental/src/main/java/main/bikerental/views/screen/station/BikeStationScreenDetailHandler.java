package main.bikerental.views.screen.station;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import main.bikerental.App;
import main.bikerental.controller.RentBikeController;
import main.bikerental.dao.BikeStationDetailDao;
import main.bikerental.dao.BikeStationDetailImpl;
import main.bikerental.entity.bike.Bike;
import main.bikerental.entity.bikestation.BikeStation;
import main.bikerental.utils.Configs;
import main.bikerental.views.BaseScreenHandler;
import main.bikerental.views.screen.bike.RentBikeScreenHandler;
import main.bikerental.views.screen.liststation.ListStationHandler;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class BikeStationScreenDetailHandler extends BaseScreenHandler implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private Label txtNameStation;
    @FXML
    private Label txtNumberBike;
    @FXML
    private Label txtAddress;

    @FXML
    private TableView<Bike> table;
    @FXML
    private TableColumn<Bike, String> colIdBike;
    @FXML
    private TableColumn<Bike, String> colNameBike;
    @FXML
    private TableColumn<Bike, String> colStatus;
    @FXML
    private TableColumn<Bike, String> colTypeBike;
    @FXML
    private ImageView imgLogo;

    private BikeStationDetailDao dao;
    private int id;

    public BikeStationScreenDetailHandler(Stage stage,String screenPath,int id) throws IOException {
        super(stage, screenPath);
        dao = new BikeStationDetailImpl();
        this.id = id;
    }

    public BikeStationScreenDetailHandler(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
        dao = new BikeStationDetailImpl();
    }

    public BikeStationScreenDetailHandler() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            setImage(imgLogo, "/images/Logo1.png");
            setBikeList();
            setBikeStation();
            requestRentBike();
            ListStationHandler listStationHandler = new ListStationHandler(App.mainStage, Configs.LIST_STATION_PATH);
            setPreviousScreen(listStationHandler);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private void setBikeList() throws SQLException {
        List<Bike> bikes = dao.getAll(id);
        ObservableList<Bike> list = FXCollections.observableArrayList(bikes);
        colIdBike.setCellValueFactory(new PropertyValueFactory<Bike, String>("id"));
        colNameBike.setCellValueFactory(new PropertyValueFactory<Bike, String>("name"));
        colStatus.setCellValueFactory(new PropertyValueFactory<Bike,String>("status"));
        colTypeBike.setCellValueFactory(new PropertyValueFactory<Bike,String>("type"));
        table.setItems(list);
    }


    @FXML
    void back(ActionEvent event) throws IOException {
        //stage.close();

        getPreviousScreen().show();
    }

    private void setBikeStation() throws SQLException {
        BikeStation bikeStation = dao.getBikeStation(id);
        txtNameStation.setText(bikeStation.getName());
        txtAddress.setText(bikeStation.getAddress());
        txtNumberBike.setText(String.valueOf(bikeStation.getNumberOfBike()));
    }

    private void requestRentBike() {
        table.setOnMouseClicked(event -> {
            if (table.getSelectionModel().getSelectedItem() != null) {
                try {
                    Bike bike = table.getSelectionModel().getSelectedItem();
                    RentBikeController rentBikeController = new RentBikeController();
                    if (rentBikeController.checkBikeAvailable(bike.getId())) {
                        RentBikeScreenHandler screen = new RentBikeScreenHandler(stage, Configs.RENTBIKE_SCREEN_PATH, bike, txtAddress.getText());
                        screen.setPreviousScene(getScene());
                        screen.setBController(rentBikeController);
                        screen.setPreviousScreen(this);
                        screen.show();
                    }
                    else {
                        showAlertDialog(Alert.AlertType.ERROR, "Xe hiện tại không thể thuê, vùi lòng chọn xe khác");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

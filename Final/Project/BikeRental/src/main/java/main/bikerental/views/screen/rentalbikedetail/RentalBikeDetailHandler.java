package main.bikerental.views.screen.rentalbikedetail;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import main.bikerental.App;
import main.bikerental.dao.ListRentalDao;
import main.bikerental.dao.ListRentalDaoImpl;
import main.bikerental.entity.RentInfo;
import main.bikerental.utils.Configs;
import main.bikerental.views.BaseScreenHandler;
import main.bikerental.views.screen.home.HomeScreenHandler;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class RentalBikeDetailHandler extends BaseScreenHandler implements Initializable {

    @FXML
    private TableView<RentInfo> table;
    @FXML
    private TableColumn<RentInfo, Integer> colIdRent;
    @FXML
    private TableColumn<RentInfo, String> colStatus;
    @FXML
    private TableColumn<RentInfo, String> colTimeStart;
    @FXML
    private TableColumn<RentInfo, Integer> colIdBike;
    @FXML
    private TableColumn<RentInfo, Integer> colIdStation;
    @FXML
    private ImageView imgLogo;

    private ListRentalDao dao;

    @FXML
    private Button back;

    public RentalBikeDetailHandler() {

    }

    public RentalBikeDetailHandler(Stage stage, String screenPath) throws IOException {
        super(stage,screenPath);
        dao = new ListRentalDaoImpl();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            setImage(imgLogo, "/images/Logo1.png");
            HomeScreenHandler homeScreenHandler = new HomeScreenHandler(App.mainStage, Configs.HOME_SCREEN_PATH);
            setPreviousScreen(homeScreenHandler);
            setTableRentalBike();
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

    private void setTableRentalBike() throws SQLException {
        List<RentInfo> list = dao.getAll();

        ObservableList<RentInfo> observableList = FXCollections.observableArrayList(list);
        colIdRent.setCellValueFactory(new PropertyValueFactory<RentInfo, Integer>("id"));
        colStatus.setCellValueFactory(new PropertyValueFactory<RentInfo, String>("status"));
        colTimeStart.setCellValueFactory(new PropertyValueFactory<RentInfo, String>("startTime2"));
        colIdBike.setCellValueFactory(new PropertyValueFactory<RentInfo, Integer>("bikeId"));
        colIdStation.setCellValueFactory(new PropertyValueFactory<RentInfo, Integer>("rentStationId"));
        table.setItems(observableList);
    }
}

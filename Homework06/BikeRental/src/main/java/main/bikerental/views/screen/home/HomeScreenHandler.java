package main.bikerental.views.screen.home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;
import main.bikerental.App;
import main.bikerental.controller.ChooseBikeToGiveBackController;
import main.bikerental.utils.Configs;
import main.bikerental.views.BaseScreenHandler;
import main.bikerental.views.screen.bike.ChooseBikeToGiveBackScreenHandler;
import main.bikerental.views.screen.liststation.ListStationHandler;
import main.bikerental.views.screen.liststation.SearchStationHandler;
import main.bikerental.views.screen.rentalbikedetail.RentalBikeDetailHandler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeScreenHandler extends BaseScreenHandler implements Initializable {

    @FXML
    private TextField search_bar;

    public HomeScreenHandler(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        App.previousScene = null;
    }

    @FXML
    public void search(ActionEvent event) throws IOException {
        String search_text = search_bar.getText();
        //showAlertDialog(Alert.AlertType.INFORMATION, search_text);
        SearchStationHandler searchStationHandler = new SearchStationHandler(App.mainStage, Configs.LIST_STATION_PATH, search_text);
        searchStationHandler.show();
    }

    @FXML
    public void stationInfo(ActionEvent event) throws IOException {
        ListStationHandler listStationHandler = new ListStationHandler(App.mainStage, Configs.LIST_STATION_PATH);
        listStationHandler.show();
    }

    @FXML
    public void rentedBike(ActionEvent event) throws IOException {
        RentalBikeDetailHandler rentalBikeDetailHandler = new RentalBikeDetailHandler(App.mainStage, Configs.LIST_RENTAL_BIKE);
        rentalBikeDetailHandler.show();
    }

    @FXML
    public void returnBike(ActionEvent event) throws IOException {
        ChooseBikeToGiveBackScreenHandler chooseBikeToGiveBackScreenHandler = new ChooseBikeToGiveBackScreenHandler(new Stage(), Configs.CHOOSE_BIKE_TO_GIVE_BACK_SCREEN_PATH);
        chooseBikeToGiveBackScreenHandler.setBController(new ChooseBikeToGiveBackController());
        chooseBikeToGiveBackScreenHandler.show();
    }
}

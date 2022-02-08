package main.bikerental.views.screen.bike;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.bikerental.controller.ChooseBikeToGiveBackController;
import main.bikerental.controller.GiveBackBikeController;
import main.bikerental.entity.bike.Bike;
import main.bikerental.utils.Configs;
import main.bikerental.views.BaseScreenHandler;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ChooseBikeToGiveBackScreenHandler extends BaseScreenHandler implements Initializable {

    @FXML
    TextField tfBikeId;

    @FXML
    TextField tfStationId;

    @FXML
    ImageView logo;

    @FXML
    Button btnOk;

    public ChooseBikeToGiveBackScreenHandler(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setImage(logo, "/images/Logo1.png");
    }

    @FXML
    void clickOk(ActionEvent event) throws IOException, SQLException {
        String bikeId = tfBikeId.getText();
        String stationId = tfStationId.getText();
        boolean isValid = ((ChooseBikeToGiveBackController)getBController()).checkBikeIsValid(bikeId);
        if(isValid){
            isValid = ((ChooseBikeToGiveBackController)getBController()).checkStationIsValid(stationId);
            if(isValid){
                GiveBackBikeScreenHandler giveBackBikeScreenHandler = new GiveBackBikeScreenHandler(new Stage(), Configs.GIVE_BACK_BIKE_SCREEN_PATH, bikeId, stationId);
                giveBackBikeScreenHandler.setBController(new GiveBackBikeController(bikeId));
                giveBackBikeScreenHandler.show();
                stage.close();
            }else{
                showAlertDialog(Alert.AlertType.ERROR, "Mã bãi xe không hợp lệ!");
            }
        }else{
            showAlertDialog(Alert.AlertType.ERROR, "Xe chưa được thuê hoặc không tồn tại!");
        }

    }
}

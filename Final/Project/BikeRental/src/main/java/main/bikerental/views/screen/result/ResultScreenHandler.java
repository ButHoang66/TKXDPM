package main.bikerental.views.screen.result;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.bikerental.App;
import main.bikerental.utils.Configs;
import main.bikerental.views.BaseScreenHandler;
import main.bikerental.views.screen.home.HomeScreenHandler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ResultScreenHandler extends BaseScreenHandler implements Initializable {

    @FXML
    ImageView logo;

    public ResultScreenHandler(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setImage(logo, "/images/Logo1.png");
    }

    @FXML
    void clickOK(ActionEvent event) throws IOException {
        getStage().close();
    }
}

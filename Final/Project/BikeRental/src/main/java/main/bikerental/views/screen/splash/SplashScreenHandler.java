package main.bikerental.views.screen.splash;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import main.bikerental.App;
import main.bikerental.utils.Configs;
import main.bikerental.views.screen.home.HomeScreenHandler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SplashScreenHandler implements Initializable {

    @FXML
    ImageView logo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        File file = new File("images/Logo.jpg");
//        Image image = new Image(file.toURI().toString());
//        logo.setImage(image);
    }

    @FXML
    public void startHomeScreen(ActionEvent event) throws IOException {
        HomeScreenHandler homeScreenHandler = new HomeScreenHandler(App.mainStage, Configs.HOME_SCREEN_PATH);
        homeScreenHandler.show();

    }
}

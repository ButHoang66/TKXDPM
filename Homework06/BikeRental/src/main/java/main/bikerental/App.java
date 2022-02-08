package main.bikerental;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    public static FXMLLoader splashLoader;
    public static Scene splashScene;
    public static Stage mainStage;
    public static Scene currentScene = null;
    public static Scene previousScene = null;
    public static Scene nextScene = null;

    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        splashLoader = new FXMLLoader(getClass().getResource("splash.fxml"));
        splashScene = new Scene(splashLoader.load());
        mainStage.setScene(splashScene);
        currentScene = splashScene;
        mainStage.setTitle("EcoBikeRental");
        mainStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
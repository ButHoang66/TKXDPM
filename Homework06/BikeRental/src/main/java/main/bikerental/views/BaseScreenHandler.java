package main.bikerental.views;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.bikerental.controller.BaseController;
import main.bikerental.views.screen.home.HomeScreenHandler;

import java.io.IOException;
import java.util.Hashtable;

public class BaseScreenHandler extends FXMLScreenHandler {
    private Scene scene;
    private BaseScreenHandler prev;
    protected Stage stage;
    protected HomeScreenHandler homeScreenHandler;
    protected Hashtable<String, String> messages;
    private BaseController bController;
    private Scene previousScene;

    public BaseScreenHandler() {
    }

    public BaseScreenHandler(String screenPath) throws IOException {
        super(screenPath);
        this.stage = new Stage();
    }

    public BaseScreenHandler(Stage stage, String screenPath) throws IOException {
        super(screenPath);
        this.stage = stage;
    }

    public void setPreviousScreen(BaseScreenHandler prev) {
        this.prev = prev;
    }

    public BaseScreenHandler getPreviousScreen() {
        return this.prev;
    }

    public void setHomeScreenHandler(HomeScreenHandler HomeScreenHandler) {
        this.homeScreenHandler = HomeScreenHandler;
    }

    public void show() throws IOException {
        if (this.scene == null) {
            setScene();
        }
        this.stage.show();
    }

    public void showAndWait() throws IOException {
        if (this.scene == null) {
            setScene();
        }
        this.stage.showAndWait();
    }

    private void setScene() throws IOException {
        this.scene = new Scene(loader.load());
        this.stage.setScene(this.scene);
    }

    public Scene getPreviousScene() {
        return previousScene;
    }

    public void setPreviousScene(Scene scene) {
        this.previousScene = scene;
    }

    public void setScreenTitle(String string) {
        this.stage.setTitle(string);
    }

    public void setBController(BaseController bController){
        this.bController = bController;
    }

    public BaseController getBController(){
        return this.bController;
    }

    public Stage getStage() {
        return stage;
    }

    public void forward(Hashtable messages) {
        this.messages = messages;
    }

    public void showAlertDialog(Alert.AlertType alertType, String content) {
        Alert alert = new Alert(alertType, "");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.getDialogPane().setContentText(content);
        alert.showAndWait();
    }

    public Scene getScene() {
        return scene;
    }
}

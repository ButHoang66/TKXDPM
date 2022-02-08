package main.bikerental.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.bikerental.App;

import java.io.File;
import java.io.IOException;

public class FXMLScreenHandler {
    protected FXMLLoader loader;

    public FXMLScreenHandler(String screenPath) throws IOException {
        this.loader = new FXMLLoader(getClass().getResource(screenPath));
        this.loader.setController(this);
    }

    public FXMLScreenHandler() {
    }

    public FXMLLoader getLoader() {
        return this.loader;
    }

    public void setImage(ImageView imv, String path){
        imv.setImage(new Image(getClass().getResourceAsStream(path)));
    }
}

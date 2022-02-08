package main.bikerental.views.screen.bike;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import main.bikerental.controller.*;
import main.bikerental.entity.bike.Bike;
import main.bikerental.entity.database.EcoBikeDB;
import main.bikerental.entity.payment.CreditCard;
import main.bikerental.utils.Configs;
import main.bikerental.views.BaseScreenHandler;
import main.bikerental.views.screen.result.ResultScreenHandler;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.ResourceBundle;

public class GiveBackBikeScreenHandler extends BaseScreenHandler implements Initializable {

    @FXML
    Label lbDeposit;

    @FXML
    Label lbTimeRent;

    @FXML
    Label lbMoneyRent;

    @FXML
    Label lbMoneyRefund;

    @FXML
    ImageView logo;

    private String bikeId;
    private String stationId;
    int moneyRent;

    public GiveBackBikeScreenHandler(Stage stage, String screenPath, String bikeId, String stationId) throws IOException {
        super(stage, screenPath);
        this.bikeId = bikeId;
        this.stationId = stationId;

    }

    public GiveBackBikeScreenHandler() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setImage(logo, "/images/Logo1.png");
        String priceBike = Integer.toString(((GiveBackBikeController)getBController()).getPriceBike());
        lbDeposit.setText(priceBike);
        int timeRent = ((GiveBackBikeController)getBController()).getTimeRent();
        lbTimeRent.setText(Integer.toString(timeRent));
        moneyRent = ((GiveBackBikeController) getBController()).calculateFee(timeRent);
        lbMoneyRent.setText(Integer.toString(moneyRent));
        int moneyDeposit = ((GiveBackBikeController) getBController()).getPriceBike();
        int refund = moneyDeposit - moneyRent;
        lbMoneyRefund.setText(Integer.toString(refund));
    }

    @FXML
    void clickPayment(ActionEvent event) throws IOException {
        PaymentController paymentController = new PaymentController();
        CreditCard creditCard = new CreditCard("kscq2_group18_2021", "Group 18", 227, "1125");
        Hashtable<String, String> result = paymentController.pay(creditCard, moneyRent, "abc");
        System.out.println(result.get("RESULT"));
        if(result.get("RESULT") == "PAYMENT SUCCESSFUL"){
            ((GiveBackBikeController) getBController()).updateDB(stationId);
            ResultScreenHandler resultScreenHandler = new ResultScreenHandler(stage, Configs.RESULT_SCREEN_PATH);
            resultScreenHandler.setBController(new ResultScreenController());
            resultScreenHandler.show();
        }else if(result.get("RESULT") == "PAYMENT FAILED!"){
            showAlertDialog(Alert.AlertType.ERROR, "Số dư không đủ!");
        }
    }
}
